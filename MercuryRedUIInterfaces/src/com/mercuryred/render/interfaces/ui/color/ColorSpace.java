package com.mercuryred.render.interfaces.ui.color;




public interface ColorSpace {

    int TYPE_CMYK = 1;
    int CS_sRGB = 2;
    int CS_GRAY = 5;
    int TYPE_GRAY = 4;

    static ColorSpace getInstance(int cssrgb) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    float[] toRGB(float[] colorvalue);
    float[] fromRGB(float[] rgbvalue);
    float[] toCIEXYZ(float[] colorvalue);
    float[] fromCIEXYZ(float[] colorvalue);
    int getType();
    int getNumComponents();
}
