package com.mercuryred.facehugger;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;

import static com.github.javaparser.ast.Modifier.createModifierList;

public class Refactor {
    static HashMap<String, TypeDeclaration> originalDepCUs = new HashMap<String, TypeDeclaration> ();
    static HashMap<String, TypeDeclaration> generatedDepInterfaces = new HashMap<String, TypeDeclaration> ();

    static String chestbuster = "";

    // todo factory imports
    // todo Chestbuster.createFoo() -> constructors
    // Facehugger .... generates what ...

    public static void main(String[] args) {
        try {
            ProcessFile(args[0]);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void ProcessFile(String name) throws FileNotFoundException {

        System.out.println(name);
        JavaParser jp = new JavaParser();

        ParseResult<CompilationUnit> cu = jp.parse(new File(name));

        CompilationUnit cls = cu.getResult().get();
        String clsName = cls.getPrimaryType().get().getNameAsString();

        if (originalDepCUs.containsKey(clsName)) {
            if (cls.getPrimaryType().get().getFullyQualifiedName().get().equals(
                    originalDepCUs.get(clsName).getFullyQualifiedName().get())
            ) {
                return;
            }
            // else
            throw new RuntimeException("Class name collision: " + clsName);
        }

        originalDepCUs.put(clsName, cls.getPrimaryType().get());

        TypeDeclaration newInterface = classToInterface(cls.getPrimaryType().get(), null);

        generatedDepInterfaces.put(clsName, cls.getPrimaryType().get());

        System.out.println(cls.getPrimaryType().get().getFullyQualifiedName().get());

        chestbuster = chestbuster + extractChestbusterConstructors(cls.getPrimaryType().get());

        System.out.println(newInterface);

        System.out.println(chestbuster);


        // TODO add IRenderEngine
        // the 3 chestbusters will implement IRenderEngine

        // TODO create the 3 types of chestbusters ... fully qualified
        // com.MercuryRed.UI - package
        // New Foo() -> com.MercuryRed.UI.RenderEngines.Main.createFoo() ...
    }

    // TODO type of chestbuster: DevNull, Swing or Skija - also one param will just generate the IRenderInterface
    static String extractChestbusterConstructors(TypeDeclaration<?> cls) {
        BodyDeclaration[] constructors =
                cls
                        .getMembers()
                        .stream()
                        .filter(bodyDeclaration -> bodyDeclaration.isConstructorDeclaration())
                        .toArray(BodyDeclaration[]::new);

        String code = "";

        if (constructors.length == 0) {
            // This should be based on constructors
           return
                    "\n" +
                    "public static " + cls.getNameAsString() + " create" + cls.getNameAsString() + "() {\n" +
                    "  return null;\n" +
                    "}\n";
        } else {
            for (BodyDeclaration cnstr: constructors) {
                code = code + "\n" +
                        "public static " + cls.getNameAsString() + " create" + cls.getNameAsString() + "(";

                NodeList<Parameter> params = cnstr.asConstructorDeclaration().getParameters();

                for (int i = 0 ; i < params.size(); i++) {
                    code = code + params.get(i).getTypeAsString() + " " + params.get(i).getNameAsString();
                    if (i < params.size() - 1) {
                        code = code + ", ";
                    }
                }

                code = code + ") {\n";
                code = code +
                        "  return null;\n" +
                        "}\n";

            }
            return code;
        }
    }

    // if filter is null, no filter
    // if a method is used with multiple param names, just extract all of them
    static TypeDeclaration classToInterface(TypeDeclaration<?> cls, HashSet<String> filterMethods) {
        TypeDeclaration newInterface = new ClassOrInterfaceDeclaration(
                createModifierList(Modifier.Keyword.PUBLIC),
                true,
                cls.getNameAsString());

        MethodDeclaration[] methods =
                cls
                        .getMembers()
                        .stream()
                        .filter(bodyDeclaration -> bodyDeclaration.isMethodDeclaration())
                        .toArray(MethodDeclaration[]::new);

        for (MethodDeclaration method: methods) {

            MethodDeclaration decl = newInterface.addMethod(method.asMethodDeclaration().getNameAsString());
            decl.setParameters(method.getParameters());
            decl.setBody(null);
            decl.setType(method.getType());
        }

        return newInterface;
    };


    // MercuryRedSettings: RenderEngine: Null, Swing, Skija

    // createFoo():
    //  return new MyFoo(new Foo())

    // Foo is interface
    // MyFoo is the hidden class, impl Foo
    // MyFoo has private awt.Foo _foo member

    // this way we can test in between engines
    // and android uses the Null one
    // but w can test locally with Swing, and implement Skija for future and do SxS testing between Skija and Swing
    // with extract image ..
}
