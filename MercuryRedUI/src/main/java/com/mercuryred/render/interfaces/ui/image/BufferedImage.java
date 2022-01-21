package com.mercuryred.render.interfaces.ui.image;


import com.mercuryred.render.interfaces.ui.Rectangle;

public interface BufferedImage {

    int getType();

    ColorModel getColorModel();

    WritableRaster getRaster();

    int getRGB(int x, int y);

    int[] getRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize);

    int getWidth();

    int getHeight();

    int getWidth(ImageObserver observer);

    int getHeight(ImageObserver observer);

    BufferedImage getSubimage(int x, int y, int w, int h);

    int getMinX();

    int getMinY();

    Raster getData();

    Raster getData(Rectangle rect);
}
