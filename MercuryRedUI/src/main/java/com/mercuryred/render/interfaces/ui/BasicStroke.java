package com.mercuryred.render.interfaces.ui;




public interface BasicStroke {

    float getLineWidth();
    int getEndCap();
    int getLineJoin();
    float getMiterLimit();
    float[] getDashArray();
    float getDashPhase();
}
