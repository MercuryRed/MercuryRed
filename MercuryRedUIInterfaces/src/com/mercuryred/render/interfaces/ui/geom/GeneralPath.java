package com.mercuryred.render.interfaces.ui.geom;


import com.mercuryred.render.interfaces.ui.Shape;

public interface GeneralPath extends Shape {
    void moveTo(double x, double y);

    void lineTo(double x, double y);

    void closePath() throws IllegalPathStateException;

    GeneralPath createTransformedShape(AffineTransform at);

    Point2D getCurrentPoint();

    void curveTo(double v, double v1, double v2, double v3, double v4, double v5);

    void setWindingRule(int windEvenOdd);
}
