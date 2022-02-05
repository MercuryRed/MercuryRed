package com.mercuryred.render.interfaces.ui.color;




public interface ColorSpace {

    float[] toRGB(float[] colorvalue);
    float[] fromRGB(float[] rgbvalue);
    float[] toCIEXYZ(float[] colorvalue);
    float[] fromCIEXYZ(float[] colorvalue);
    int getType();
    int getNumComponents();
}
