package com.mercuryred.render.interfaces.ui;




public interface BasicStroke extends Stroke {

    int CAP_BUTT = 0;
    int JOIN_MITER = 1;
    int CAP_ROUND = 2;
    int CAP_SQUARE = 3;
    int JOIN_ROUND = 4;
    int JOIN_BEVEL = 5;

    float getLineWidth();
    int getEndCap();
    int getLineJoin();
    float getMiterLimit();
    float[] getDashArray();
    float getDashPhase();
}
