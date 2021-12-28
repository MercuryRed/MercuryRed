package com.mercuryred.facehugger;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.Expression;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;

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

        TypeDeclaration newInterface = cloneClass(cls.getPrimaryType().get(), null, true, false, false);
        TypeDeclaration wrapper = cloneClass(cls.getPrimaryType().get(), null, false, false, true);
        TypeDeclaration devNull = cloneClass(cls.getPrimaryType().get(), null, false, true, false);

        generatedDepInterfaces.put(clsName, cls.getPrimaryType().get());

        System.out.println(cls.getPrimaryType().get().getFullyQualifiedName().get());

        chestbuster = chestbuster + extractChestbusterConstructors(cls.getPrimaryType().get(), false, null);

        chestbuster = chestbuster + extractChestbusterConstructors(cls.getPrimaryType().get(), true, cls.getPrimaryType().get().getFullyQualifiedName().get());

        chestbuster = chestbuster + extractChestbusterConstructors(cls.getPrimaryType().get(), true, null);

        chestbuster = chestbuster + extractChestbusterConstructors(cls.getPrimaryType().get(), true, "com.mercuryred.devnull." + cls.getPrimaryType().get().getNameAsString());


        System.out.println(newInterface);

        System.out.println(devNull);

        System.out.println(wrapper);

        System.out.println(chestbuster);


        // TODO add IRenderEngine
        // the 3 chestbusters will implement IRenderEngine

        // TODO create the 3 types of chestbusters ... fully qualified
        // com.mercuryred.ui - package
        // New Foo() -> com.mercuryred.ui.RenderEngines.Get().createFoo() ...
    }

    // TODO type of chestbuster: DevNull, Swing or Skija - also one param will just generate the IRenderInterface
    static String extractChestbusterConstructors(TypeDeclaration<?> cls, boolean implement, String factory) {
        BodyDeclaration[] constructors =
                cls
                        .getMembers()
                        .stream()
                        .filter(bodyDeclaration -> bodyDeclaration.isConstructorDeclaration())
                        .toArray(BodyDeclaration[]::new);

        String code = "";

        if (constructors.length == 0) {
            // This should be based on constructors
           code =
                    "\n  " +
                            (implement ? "public " : "") + cls.getNameAsString() + " create" + cls.getNameAsString() + "()";
           if (implement) {
               code = code + " {\n" +
                       "  return " + (factory == null ? "null" : "new " + factory + "()") + ";\n" +
                       "}\n";
           } else {
               code = code + ";";
           }
        } else {
            for (BodyDeclaration cnstr: constructors) {
                code = code + "\n" +
                        (implement ? "public " : "") + cls.getNameAsString() + " create" + cls.getNameAsString() + "(";

                NodeList<Parameter> params = cnstr.asConstructorDeclaration().getParameters();

                for (int i = 0 ; i < params.size(); i++) {
                    code = code + params.get(i).getTypeAsString() + " " + params.get(i).getNameAsString();
                    if (i < params.size() - 1) {
                        code = code + ", ";
                    }
                }

                code = code + ")";
                if (implement) {
                    code = code + " {\n" +
                            "  return ";

                    if (factory == null) {
                        code = code + "null";
                    } else {
                        code = code + "new " + factory + "(";

                        for (int i = 0 ; i < params.size(); i++) {
                            code = code + params.get(i).getNameAsString();
                            if (i < params.size() - 1) {
                                code = code + ", ";
                            }
                        }

                        code = code + ")";
                    }

                    code = code + ";\n" +
                            "}\n";
                } else {
                    code = code + ";";
                }

            }
        }
        return code;
    }

    // if filter is null, no filter
    // if a method is used with multiple param names, just extract all of them
    // todo ... create class wrapper ...
    static TypeDeclaration cloneClass(TypeDeclaration<?> cls, HashSet<String> filterMethods, boolean asInterface, boolean asDevNull, boolean asWrapper) {
        TypeDeclaration newEntity = new ClassOrInterfaceDeclaration(
                createModifierList(Modifier.Keyword.PUBLIC),
                asInterface,
                cls.getNameAsString());

        if (asWrapper) {
            newEntity.addField(
                    cls.getFullyQualifiedName().get(), "_" + cls.getNameAsString(), Modifier.Keyword.PUBLIC
            );

            // todo  go over all constructors ...
            // create Cstr(params) as _Foo = new awt.Foo(params)
            // or have the factory create the foo, and pass it here .. I think better ...
            // then the wrapper classes only have to deal with one constructor ...

            // the factory will do _foo = new Foo(); return myFoo(_foo);
            // and the awt supid stuff stays contained ... does not need to polute skija ...

            ConstructorDeclaration cd = newEntity.addConstructor(Modifier.Keyword.PUBLIC);
            // cd.setParameters(); // todo .. the can
        }

        MethodDeclaration[] methods =
                cls
                        .getMembers()
                        .stream()
                        .filter(bodyDeclaration -> bodyDeclaration.isMethodDeclaration())
                        .toArray(MethodDeclaration[]::new);

        for (MethodDeclaration method: methods) {

            MethodDeclaration decl = newEntity.addMethod(method.asMethodDeclaration().getNameAsString());
            decl.setParameters(method.getParameters());

            Expression[] params = new Expression[method.getParameters().size()];

            for (int ip = 0; ip < params.length; ip++) {
                params[ip] = new NameExpr(method.getParameters().get(ip).getName());
            }

            if (asInterface) {
                decl.setBody(null);
            } else if (asWrapper) {
                if (method.getType().isVoidType()) {
                    decl.setBody(
                            new BlockStmt(
                                    new NodeList(
                                            new ExpressionStmt(
                                                    new MethodCallExpr(
                                                            "_" + cls.getNameAsString() + "." + method.asMethodDeclaration().getNameAsString(),
                                                            params)
                                            )
                                    )
                            )
                    );
                } else {
                    decl.setBody(
                            new BlockStmt(
                                    new NodeList(
                                            new ReturnStmt(
                                                    new MethodCallExpr(
                                                            "_" + cls.getNameAsString() + "." + method.asMethodDeclaration().getNameAsString(),
                                                            params)
                                            )
                                    )
                            )
                    );
                }
                // todo add _class.foo(...)
            } else if (asDevNull) {
                // nothing ?
            }
            decl.setType(method.getType());
        }

        return newEntity;
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
