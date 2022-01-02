package com.mercuryred.facehugger;

import com.github.javaparser.ast.body.TypeDeclaration;

public class Egg {
    public TypeDeclaration newInterface;
    public TypeDeclaration swingWrapper;
    public TypeDeclaration devnull;
    public TypeDeclaration skija;

    public String renderEngineInterface;
    public String renderEngineSwing;
    public String renderEngineDevnull;
    public String renderEngineSkija;

    public Egg() {
        renderEngineInterface = "";
        renderEngineSwing = "";
        renderEngineDevnull = "";
        renderEngineSkija = "";
    }
}
