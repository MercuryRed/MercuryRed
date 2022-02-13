package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.image.ImageObserver;



public interface Image {

    int SCALE_FAST = 1;

    int getWidth(ImageObserver observer);
    int getHeight(ImageObserver observer);
    Graphics getGraphics();

    void setRGB(int startX, int i, int width, int i1, int[] dstPixels, int i2, int height);

    Image getScaledInstance(int w, int h, int hints);
}
