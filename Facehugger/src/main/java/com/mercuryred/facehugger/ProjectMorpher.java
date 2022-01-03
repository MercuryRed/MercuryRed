package com.mercuryred.facehugger;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ProjectMorpher
{
    static final String PROJECT_PATH = "c:\\12\\Android\\MercuryRed\\";
    static final String JAVA_LIBS_SRC_PATH = "c:\\12\\Android\\JavaLibsSrc\\";

    static final String MERCURY_RED_RENDER_ENGINE_PATH = PROJECT_PATH + "MercuryRedUI\\src\\main\\java\\com\\mercuryred\\render\\";
    static final String MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "interfaces\\";
    static final String MERCURY_RED_RENDER_ENGINE_DEVNULL_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "devnull\\";
    static final String MERCURY_RED_RENDER_ENGINE_SWING_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "swing\\";
    static final String MERCURY_RED_RENDER_ENGINE_SKIJA_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "skija\\";

    static String factoryInterfaces = "";
    static String factoryDevnull = "";
    static String factorySkija = "";
    static String factorySwing = "";


    public static void main(String[] args) {
        //two passes, to import only used methods, and remove any unused methods to limit amount of boilerplate generated
        try {
            HashMap<String, HashSet<String>> usage = ExtractUsageFromProjectSource();
            MorphDirectory(usage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(factoryInterfaces);
        System.out.println(factoryDevnull);
        System.out.println(factorySkija);
        System.out.println(factorySwing);

    }

    private static HashMap<String, HashSet<String>> ExtractUsageFromProjectSource() throws IOException {
        Path dir = Paths.get(PROJECT_PATH);
        Path[] filePaths = Files.walk(dir).toArray(Path[]::new);

        HashMap<String, HashSet<String>> usage = new HashMap<String, HashSet<String>>();

        for (Path filePath: filePaths)
        {
            if (!filePath.toString().endsWith(".java")) continue;
            // e.g. \.git
            if (filePath.toAbsolutePath().toString().contains("\\.")) continue;
            // e.g. /.git
            if (filePath.toAbsolutePath().toString().contains("/.")) continue;

            AddProjectSourceFileUsage(filePath, usage);
        }

        return usage;
    }

    private static void AddProjectSourceFileUsage(Path filePath, HashMap<String, HashSet<String>> usage) throws IOException {
        JavaParser jp = new JavaParser();

        ParseResult<CompilationUnit> cu = jp.parse(filePath);

        CompilationUnit cls = cu.getResult().get();

        VisitCodeNode(cls, usage, new HashMap<String, String>());

        // todo .. go over all methods and their bodies,
        // for method call foo.bar(...), where type of foo is Foo
        // add usage[Foo].add(bar)
    }

    private static void VisitCodeNode(Node node, HashMap<String, HashSet<String>> usage, HashMap<String, String> parentStack) {
        if (node instanceof MethodCallExpr) {
            MethodCallExpr mc = (MethodCallExpr) node;
            Optional<Expression> scope = mc.getScope();
            if (scope.isPresent()) {
                String type = parentStack.get(scope.get().toString());
                if (type != null) {
                    type = type.split("<")[0];  // e.g. JComboBox<String>

                    if (!usage.containsKey(type)) {
                        usage.put(type, new HashSet<String>());
                    }
                    usage.get(type).add(mc.getNameAsString()); // todo ... support overloading, probably not worth it. We could let compiler list unused
                }
            }
        }

        HashMap<String, String> stack = new HashMap<String, String>(parentStack);

        NodeList<Parameter> params = null;

        if (node instanceof MethodDeclaration) {
            MethodDeclaration md = (MethodDeclaration) node;
            params = md.getParameters();
        }
        if (node instanceof ConstructorDeclaration) {
            ConstructorDeclaration cd = (ConstructorDeclaration) node;
            params = cd.getParameters();
        }

        if (params != null) {

            for (Parameter param: params) {
                stack.put(param.getNameAsString(), param.getTypeAsString());
            }
        }

        for (Node child : node.getChildNodes()) {
            if (child instanceof FieldDeclaration) {
                StoreVaribleDeclarations(child.getChildNodes(), stack);
            } else if (child instanceof VariableDeclarationExpr) {
                StoreVaribleDeclarations(child.getChildNodes(), stack);
            }
            else if (child instanceof VariableDeclarator) {
                VariableDeclarator vd = (VariableDeclarator) child;

                StoreVaribleDeclaration(child, stack);

                stack.put(vd.getTypeAsString(), vd.getTypeAsString());
            }
        }

        for (Node child : node.getChildNodes()) {
            VisitCodeNode(child, usage, stack);
        }
    }

    private static void StoreVaribleDeclaration(Node node, HashMap<String, String> stack) {
        if (node instanceof VariableDeclarator) {
            VariableDeclarator vd = (VariableDeclarator) node;

            stack.put(vd.getTypeAsString(), vd.getTypeAsString());
        }
    }

    private static void StoreVaribleDeclarations(List<Node> nodes, HashMap<String, String> stack) {
        for (Node node : nodes) {
            StoreVaribleDeclaration(node, stack);
        }
    }

    static void MorphDirectory(HashMap<String, HashSet<String>> usage) throws IOException {

        Path dir = Paths.get(PROJECT_PATH);
        Path[] filePaths = Files.walk(dir).toArray(Path[]::new);

        for (Path filePath: filePaths)
        {
            if (!filePath.toString().endsWith(".java")) continue;
            // e.g. \.git
            if (filePath.toAbsolutePath().toString().contains("\\.")) continue;
            // e.g. /.git
            if (filePath.toAbsolutePath().toString().contains("/.")) continue;

            ProcessJavaFile(filePath, usage);
        }
    }

    static void ProcessJavaFile(Path filePath, HashMap<String, HashSet<String>> usage) throws IOException {
        String code = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);

        char[] newCode = new char[code.length() * 2 + 100];
        int len = 0;

        char[] codeChars = code.toCharArray();

        String line = "";
        for (char ch: codeChars)
        {
            if (ch == '\r' || ch == '\n')
            {
                line = rebuildLineImports(line, usage);
                line = rebuildLineNews(line);  // todo ... minimize contructors to created? we could just manually remove also
                for (char x: line.toCharArray())
                {
                    newCode[len++] = x;
                }
                line = "";
                newCode[len++] = ch;
            } else
            {
                line = line + ch;
            }
        }

        // flush last line
        for (char x: line.toCharArray())
        {
            newCode[len++] = x;
        }

        // rewrite file - todo
        // File.WriteAllText(filename, new string(newCode, 0, len));
    }

    private static String rebuildLineNews(String line) {
        // todo NYI
        return line;
    }


    static String[] packages = new String[]
            {
                    "java.awt",
                    "javax.swing",
                    "javax.imageio",
            };

    static String[] dests = new String[]
            {
                    "ui",
                    "uiplus",
                    "imageio",
            };


    // rebuilds line, also copied the target file from source folder to dest folder
    private static String rebuildLineImports(String line, HashMap<String, HashSet<String>> usage) throws FileNotFoundException, UnsupportedEncodingException {
        if (line.length() == 0) return line;
        if (!line.startsWith("import ")) {
            // todo ... line replace new foo(...) with ... factory create
            return line;
        }

        String importFullName = line.substring("import ".length());
        importFullName = importFullName.trim();
        importFullName = importFullName.replaceAll(";$", "");
        importFullName = importFullName.trim();

        // special case, importing static constants, will handle manually
        if (importFullName.endsWith("*")) return line;

        int i = -1;
        for (String pkg: packages)
        {
            i++;
            String dest = dests[i];

            if (importFullName.startsWith(pkg + "."))
            {
                String subImport = importFullName.substring(pkg.length() + 1);
                int index = subImport.lastIndexOf(".");
                String subPackage = index > 0 ? subImport.substring(0, index) : "";
                String importName = subImport.substring(index >= 0 ? index + 1 : 0);

                /// todo .. subpackage structure maintain ...
                // remove package
                String[] parts = importFullName.split("\\.");
                String className = parts[parts.length - 1];

                String from = JAVA_LIBS_SRC_PATH + importFullName.replace(".", "\\") + ".java";

                String relPath = dest.replace(".", "\\") + "\\" + subImport.replace(".", "\\") + ".java";
                String to = MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH + relPath;

                String dir = MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH + dest.replace(".", "\\") + "\\" + subPackage.replace(".", "\\");

                // todo
                new File(dir).mkdirs();


                if (!new File(from).exists())
                {
                    System.err.println("MISSING " + importFullName);
                    // ERROR
                    return line;
                }

                // todo multiple tos ...
                if (new File(to).exists())
                {
                    return line;
                }

                HashSet<String> clsUsage = usage.get(importName);
                if (clsUsage == null) {
                    // TODO from this class we only need to extract constant, we do not need an interface?
                    System.err.println("NO INTERFACE? " + importName);
                }

                Egg egg = Refactor.ProcessLibFile(from.toString(), clsUsage);

                if (egg != null) {
                    ImplantEgg(egg, relPath);

                    factoryInterfaces = factoryInterfaces + egg.renderEngineInterface;
                    factoryDevnull = factoryDevnull + egg.renderEngineDevnull;
                    factorySkija = factorySkija + egg.renderEngineSkija;
                    factorySwing = factorySwing + egg.renderEngineSwing;
                }


                return line; // todo modify
            }
        }



        return line;
    }

    private static String mapPkg(String importFullName) {
        int i = -1;
        for (String pkg: packages) {
            i++;
            String dest = dests[i];

            if (importFullName.equals(pkg)) {
                return dest;
            }

            if (importFullName.startsWith(pkg + ".")) {
                String subImport = importFullName.substring(pkg.length() + 1);
                return dest + "." + subImport;
            }
        }
        return null;
    }

    private static void ImplantEgg(Egg egg, String relPath) throws FileNotFoundException, UnsupportedEncodingException {
        String pkg = mapPkg(egg.pkg);

        ImplantCode(egg.newInterface, true, "interfaces", pkg, MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH, relPath);
        ImplantCode(egg.devnull, false, "devnull", pkg, MERCURY_RED_RENDER_ENGINE_DEVNULL_PATH, relPath);
        ImplantCode(egg.swingWrapper, false, "swing", pkg, MERCURY_RED_RENDER_ENGINE_SWING_PATH, relPath);
        ImplantCode(egg.skija, false, "skija", pkg, MERCURY_RED_RENDER_ENGINE_SKIJA_PATH, relPath);
    }

    // TODO determine minimum amount of methods to be generated, remove unused ones!
    private static void ImplantCode(TypeDeclaration type, boolean isInterface, String pkgBase, String pkg, String host, String relPath) throws FileNotFoundException, UnsupportedEncodingException {
        if (type == null) return;

        String code = type.toString();

        new File(new File(host + relPath).getParent()).mkdirs();

        PrintWriter writer = new PrintWriter(host + relPath, "UTF-8");
        writer.println("package com.mercuryred.render." + pkgBase + "." + pkg + ";");
        writer.println();

        // todo the egg should list classes imported, along with packages

        writer.println();
        writer.println();
        writer.println(code);
        writer.close();
    }

}