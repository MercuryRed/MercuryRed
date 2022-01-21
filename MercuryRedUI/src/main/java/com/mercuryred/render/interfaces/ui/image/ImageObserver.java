package com.mercuryred.render.interfaces.ui.image;


import com.mercuryred.render.interfaces.ui.Image;

public interface ImageObserver {

    boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height);
}
