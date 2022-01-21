package com.mercuryred.render.interfaces.ui;



public interface Rectangle {

    double getWidth();

    double getHeight();

    boolean intersects(Rectangle r);
}
