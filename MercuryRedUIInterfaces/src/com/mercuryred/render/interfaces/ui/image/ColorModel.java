package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.color.ColorSpace;

public interface ColorModel {

    SampleModel createCompatibleSampleModel(int w, int h);

    int getPixelSize();

    int getNumComponents();

    ColorSpace getColorSpace();
}
