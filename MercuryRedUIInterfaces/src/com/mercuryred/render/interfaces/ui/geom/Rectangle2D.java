package com.mercuryred.render.interfaces.ui.geom;


import com.mercuryred.render.interfaces.ui.Shape;

public interface Rectangle2D extends Shape {
    boolean equals(Object obj);
    double getX();
    double getY();
    double getWidth();
    double getHeight();
    double getMinX();
    double getMinY();
    boolean isEmpty();
}
