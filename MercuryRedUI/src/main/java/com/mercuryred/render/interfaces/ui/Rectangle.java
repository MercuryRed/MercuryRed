package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.geom.Rectangle2D;



public interface Rectangle {

    double getWidth();
    double getHeight();
    boolean intersects(Rectangle r);
    boolean intersects(double x, double y, double w, double h);
    boolean intersects(Rectangle2D r);
}
