package com.mercuryred.facehugger;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import static com.github.javaparser.ast.Modifier.createModifierList;

public class Refactor {
    static HashMap<String, TypeDeclaration> originalDepCUs = new HashMap<String, TypeDeclaration> ();
    static HashMap<String, TypeDeclaration> generatedDepInterfaces = new HashMap<String, TypeDeclaration> ();

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

        TypeDeclaration newInterface = new ClassOrInterfaceDeclaration(createModifierList(Modifier.Keyword.PUBLIC), true, clsName);

        generatedDepInterfaces.put(clsName, cls.getPrimaryType().get());

        System.out.println(cls.getPrimaryType().get().getFullyQualifiedName().get());

        System.out.println(
                cls.getPrimaryType()
                        .get()
                        .getMembers()
                        .stream()
                        .filter(bodyDeclaration -> bodyDeclaration.isMethodDeclaration())
                        .toArray()[0]);

        System.out.println(newInterface);
    }
}
