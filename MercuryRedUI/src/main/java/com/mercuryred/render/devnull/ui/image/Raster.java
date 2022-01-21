package com.mercuryred.render.devnull.ui.image;



public class Raster {

    WritableRaster createInterleavedRaster(int dataType, int w, int h, int bands, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createInterleavedRaster(int dataType, int w, int h, int scanlineStride, int pixelStride, int[] bandOffsets, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createPackedRaster(int dataType, int w, int h, int[] bandMasks, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createPackedRaster(int dataType, int w, int h, int bands, int bitsPerBand, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createInterleavedRaster(DataBuffer dataBuffer, int w, int h, int scanlineStride, int pixelStride, int[] bandOffsets, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createPackedRaster(DataBuffer dataBuffer, int w, int h, int scanlineStride, int[] bandMasks, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    WritableRaster createPackedRaster(DataBuffer dataBuffer, int w, int h, int bitsPerPixel, Point location) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    int getWidth() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    int getHeight() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    DataBuffer getDataBuffer() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    SampleModel getSampleModel() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    int[] getSamples(int x, int y, int w, int h, int b, int[] iArray) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    float[] getSamples(int x, int y, int w, int h, int b, float[] fArray) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    double[] getSamples(int x, int y, int w, int h, int b, double[] dArray) {
        throw com.mercuryred.nyi.ReportNyi();
    }
}
