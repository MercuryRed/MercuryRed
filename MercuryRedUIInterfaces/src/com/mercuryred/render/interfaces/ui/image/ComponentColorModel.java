package com.mercuryred.render.interfaces.ui.image;


import com.mercuryred.render.interfaces.ui.color.ColorSpace;
import com.mercuryred.utils.Nyi;

public class ComponentColorModel implements ColorModel {
    @Override
    public SampleModel createCompatibleSampleModel(int w, int h) {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public int getPixelSize() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int getNumComponents() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public ColorSpace getColorSpace() {
        throw Nyi.ReportNyi();
        // return null;
    }
}
