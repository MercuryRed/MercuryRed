package com.mercuryred.facehugger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProjectMorpher
{
    static final String PROJECT_PATH = "c:\\12\\Android\\MercuryRed\\";
    static final String JAVA_LIBS_SRC_PATH = "c:\\12\\Android\\JavaLibsSrc\\";

    static final String MERCURY_RED_RENDER_ENGINE_PATH = PROJECT_PATH + "MercuryRedUI\\src\\main\\java\\com\\mercuryred\\render\\";
    static final String MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "interfaces\\";
    static final String MERCURY_RED_RENDER_ENGINE_DEVNULL_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "devnull\\";
    static final String MERCURY_RED_RENDER_ENGINE_SWING_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "swing\\";
    static final String MERCURY_RED_RENDER_ENGINE_SKIJA_PATH = MERCURY_RED_RENDER_ENGINE_PATH + "skija\\";

    public static void main(String[] args) {
        //two passes, to import only used methods, and remove any unused methods to limit amount of boilerplate generated
        // ? usage = VisitDirectory(args[0], args[1]);
        try {
            MorphDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // todo ... call with a tool on *.java files recursively
    }

    static void MorphDirectory() throws IOException {

        Path dir = Paths.get(PROJECT_PATH);
        Path[] filePaths = Files.walk(dir).toArray(Path[]::new);

        for (Path filePath: filePaths)
        {
            if (!filePath.toString().endsWith(".java")) continue;
            // e.g. \.git
            if (filePath.toAbsolutePath().toString().contains("\\.")) continue;
            // e.g. /.git
            if (filePath.toAbsolutePath().toString().contains("/.")) continue;

            System.out.println(filePath.toAbsolutePath().toString());

            ProcessJavaFile(filePath);
        }
    }

    static void ProcessJavaFile(Path filePath) throws IOException {
        String code = new String(Files.readAllBytes(filePath), StandardCharsets.UTF_8);

        char[] newCode = new char[code.length() * 2 + 100];
        int len = 0;

        char[] codeChars = code.toCharArray();

        String line = "";
        for (char ch: codeChars)
        {
            if (ch == '\r' || ch == '\n')
            {
                line = rebuildLineImports(line);
                line = rebuildLineNews(line);
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
    private static String rebuildLineImports(String line) throws FileNotFoundException {
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

                /// todo .. subpackage structure maintain ...
                // remove package
                String[] parts = importFullName.split("\\.");
                String className = parts[parts.length - 1];

                String from = JAVA_LIBS_SRC_PATH + importFullName.replace(".", "\\") + ".java";

                String to = MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH + dest.replace(".", "\\") + "\\" + subImport.replace(".", "\\") + ".java";

                String dir = MERCURY_RED_RENDER_ENGINE_INTERFACES_PATH + dest.replace(".", "\\") + "\\" + subPackage.replace(".", "\\");

                System.err.println("Rebuilding " + from + " " + to);

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

                Refactor.ProcessLibFile(from.toString());

                // todo ... create interface
                // call refactor ...

                return line; // todo modify
            }
        }



        return line;
    }

}