package com.mercuryred.render.interfaces.ui.image;


import com.mercuryred.render.interfaces.ui.Point;

public interface Raster {

    WritableRaster createInterleavedRaster(int dataType, int w, int h, int bands, Point location);

    WritableRaster createInterleavedRaster(int dataType, int w, int h, int scanlineStride, int pixelStride, int[] bandOffsets, Point location);

    WritableRaster createPackedRaster(int dataType, int w, int h, int[] bandMasks, Point location);

    WritableRaster createPackedRaster(int dataType, int w, int h, int bands, int bitsPerBand, Point location);

    WritableRaster createInterleavedRaster(DataBuffer dataBuffer, int w, int h, int scanlineStride, int pixelStride, int[] bandOffsets, Point location);

    WritableRaster createPackedRaster(DataBuffer dataBuffer, int w, int h, int scanlineStride, int[] bandMasks, Point location);

    WritableRaster createPackedRaster(DataBuffer dataBuffer, int w, int h, int bitsPerPixel, Point location);

    int getWidth();

    int getHeight();

    DataBuffer getDataBuffer();

    SampleModel getSampleModel();

    int[] getSamples(int x, int y, int w, int h, int b, int[] iArray);

    float[] getSamples(int x, int y, int w, int h, int b, float[] fArray);

    double[] getSamples(int x, int y, int w, int h, int b, double[] dArray);
}
