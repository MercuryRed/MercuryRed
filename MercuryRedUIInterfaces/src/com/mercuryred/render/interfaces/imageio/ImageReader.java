package com.mercuryred.render.interfaces.imageio;

import com.mercuryred.render.interfaces.imageio.ImageReadParam;
import com.mercuryred.render.interfaces.ui.image.BufferedImage;
import com.mercuryred.render.interfaces.ui.image.Raster;
import com.mercuryred.render.interfaces.imageio.metadata.IIOMetadata;

import java.util.Set;


public interface ImageReader {

    IIOMetadata getImageMetadata(int imageIndex);
    IIOMetadata getImageMetadata(int imageIndex, String formatName, Set<String> nodeNames);
    BufferedImage read(int imageIndex);
    BufferedImage read(int imageIndex, ImageReadParam param);
    Raster readRaster(int imageIndex, ImageReadParam param);
}
