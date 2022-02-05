package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.image.ImageObserver;
import com.mercuryred.render.interfaces.ui.Graphics;



public interface Image {

    int getWidth(ImageObserver observer);
    int getHeight(ImageObserver observer);
    Graphics getGraphics();
}
