package com.mercuryred.render.interfaces.ui;


import com.mercuryred.render.interfaces.ui.image.ImageObserver;

public interface Image {

    int getWidth(ImageObserver observer);

    int getHeight(ImageObserver observer);
}
