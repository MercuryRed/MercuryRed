package com.mercuryred.render.interfaces.ui.image;

import com.mercuryred.render.interfaces.ui.Image;



public interface ImageObserver {

    int ALLBITS = -1;
    int SOMEBITS = 1;

    boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height);
}
