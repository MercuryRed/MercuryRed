package com.mercuryred.render.interfaces.ui;



public interface BasicStroke {

    int CAP_BUTT = 0; // TODO

    float getLineWidth();

    int getEndCap();

    int getLineJoin();

    float getMiterLimit();

    float[] getDashArray();

    float getDashPhase();
}
