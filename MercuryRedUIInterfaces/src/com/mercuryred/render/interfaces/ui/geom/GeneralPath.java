package com.mercuryred.render.interfaces.ui.geom;


public interface GeneralPath {
    void moveTo(int x, int y);

    void lineTo(int x, int y);

    void closePath();

    GeneralPath createTransformedShape(AffineTransform at);

    Rectangle2D getBounds();
}
