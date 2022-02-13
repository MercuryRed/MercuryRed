package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Image;
import com.mercuryred.render.interfaces.ui.Rectangle;



public interface BufferedImage extends Image {

    int TYPE_BYTE_BINARY = 1;
    int TYPE_BYTE_GRAY = 2;
    int TYPE_INT_ARGB = 3;
    int TYPE_CUSTOM = 4;
    int TYPE_BYTE_INDEXED = 5;

    int getType();
    ColorModel getColorModel();
    WritableRaster getRaster();
    int getRGB(int x, int y);
    int[] getRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize);
    int getWidth();
    int getHeight();
    int getWidth(ImageObserver observer);
    int getHeight(ImageObserver observer);
    Graphics createGraphics();
    BufferedImage getSubimage(int x, int y, int w, int h);
    void coerceData(boolean isAlphaPremultiplied);
    int getMinX();
    int getMinY();
    Raster getData();
    Raster getData(Rectangle rect);
    Graphics getGraphics();
    void flush();

    ImageProducer getSource();

    void setData(Raster raster);
}
