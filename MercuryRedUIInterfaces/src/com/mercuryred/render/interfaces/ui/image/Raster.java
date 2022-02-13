package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.Shape;

public interface Raster {

    int getWidth();
    int getHeight();
    DataBuffer getDataBuffer();
    SampleModel getSampleModel();
    int[] getPixel(int x, int y, int[] iArray);
    float[] getPixel(int x, int y, float[] fArray);
    double[] getPixel(int x, int y, double[] dArray);
    int[] getSamples(int x, int y, int w, int h, int b, int[] iArray);
    float[] getSamples(int x, int y, int w, int h, int b, float[] fArray);
    double[] getSamples(int x, int y, int w, int h, int b, double[] dArray);

    void setRect(int x, int y, Raster raster);

    Shape getBounds();

    int getSample(int x, int y, int i);
}
