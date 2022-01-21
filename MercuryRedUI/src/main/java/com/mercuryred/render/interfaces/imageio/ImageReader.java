package com.mercuryred.render.interfaces.imageio;



public interface ImageReader {

    IIOMetadata getImageMetadata(int imageIndex);

    IIOMetadata getImageMetadata(int imageIndex, String formatName, Set<String> nodeNames);

    BufferedImage read(int imageIndex);

    BufferedImage read(int imageIndex, ImageReadParam param);

    Raster readRaster(int imageIndex, ImageReadParam param);
}
