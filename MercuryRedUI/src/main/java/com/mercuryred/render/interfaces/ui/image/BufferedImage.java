package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.image.WritableRaster;
import com.mercuryred.render.interfaces.ui.image.ImageObserver;
import com.mercuryred.render.interfaces.ui.image.Raster;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.image.ColorModel;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.Graphics;



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
    Graphics2D createGraphics();
    BufferedImage getSubimage(int x, int y, int w, int h);
    void coerceData(boolean isAlphaPremultiplied);
    int getMinX();
    int getMinY();
    Raster getData();
    Raster getData(Rectangle rect);
    Graphics getGraphics();
    void flush();
}
