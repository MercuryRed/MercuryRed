package com.mercuryred.render.devnull.imageio;



public class ImageReader {

    IIOMetadata getImageMetadata(int imageIndex) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    IIOMetadata getImageMetadata(int imageIndex, String formatName, Set<String> nodeNames) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    BufferedImage read(int imageIndex) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    BufferedImage read(int imageIndex, ImageReadParam param) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    Raster readRaster(int imageIndex, ImageReadParam param) {
        throw com.mercuryred.nyi.ReportNyi();
    }
}
