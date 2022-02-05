package com.mercuryred.render.interfaces.ui.color;




public interface ICC_ColorSpace {

    float[] toRGB(float[] colorvalue);
    float[] fromRGB(float[] rgbvalue);
    float[] toCIEXYZ(float[] colorvalue);
    float[] fromCIEXYZ(float[] colorvalue);
}
