package com.mercuryred.render.interfaces.imageio;

import com.mercuryred.render.interfaces.ui.image.BufferedImage;
import com.mercuryred.render.interfaces.ui.Point;



public interface ImageReadParam {

    BufferedImage getDestination();
    int getSourceXSubsampling();
    int getSourceYSubsampling();
    Point getDestinationOffset();
}
