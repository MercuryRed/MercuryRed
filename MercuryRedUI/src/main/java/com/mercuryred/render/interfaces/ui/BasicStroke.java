package com.mercuryred.render.interfaces.ui;



public interface BasicStroke {

    Object CAP_BUTT = ;

    float getLineWidth();

    int getEndCap();

    int getLineJoin();

    float getMiterLimit();

    float[] getDashArray();

    float getDashPhase();
}
