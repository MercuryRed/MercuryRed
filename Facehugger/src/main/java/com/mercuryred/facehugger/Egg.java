package com.mercuryred.facehugger;

import com.github.javaparser.ast.body.TypeDeclaration;

import java.util.HashSet;
import java.util.Set;

public class Egg {
    public String pkg;

    public TypeDeclaration newInterface;
    public TypeDeclaration devnull;
    public TypeDeclaration skija;

    public String renderEngineInterface;
    public String renderEngineDevnull;
    public String renderEngineSkija;

    public Set<String> usedClasses;

    public Egg() {
        renderEngineInterface = "";
        renderEngineDevnull = "";
        renderEngineSkija = "";

        usedClasses = new HashSet<>();
    }

    public void usingClass(String clsName) {
        usedClasses.add(clsName);
    }
}
