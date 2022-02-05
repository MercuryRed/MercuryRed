package com.mercuryred.render.interfaces.ui;




public interface BasicStroke extends Stroke {

    int CAP_BUTT = 0;
    int JOIN_MITER = 1;

    float getLineWidth();
    int getEndCap();
    int getLineJoin();
    float getMiterLimit();
    float[] getDashArray();
    float getDashPhase();
}
