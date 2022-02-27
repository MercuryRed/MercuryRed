package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.color.ColorSpace;

public interface ColorModel {

    static ColorModel getRGBdefault() {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    SampleModel createCompatibleSampleModel(int w, int h);

    int getPixelSize();

    int getNumComponents();

    ColorSpace getColorSpace();
}
