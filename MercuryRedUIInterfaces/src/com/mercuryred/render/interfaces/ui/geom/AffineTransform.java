package com.mercuryred.render.interfaces.ui.geom;

import com.mercuryred.render.interfaces.ui.Shape;



public interface AffineTransform {

    double getScaleX();
    double getScaleY();
    double getShearX();
    double getShearY();
    double getTranslateX();
    double getTranslateY();
    void translate(double tx, double ty);
    void setToIdentity();
    void setTransform(AffineTransform Tx);
    void setTransform(double m00, double m10, double m01, double m11, double m02, double m12);
    void concatenate(AffineTransform Tx);
    AffineTransform createInverse();
    Point2D transform(Point2D ptSrc, Point2D ptDst);
    void transform(Point2D[] ptSrc, int srcOff, Point2D[] ptDst, int dstOff, int numPts);
    void transform(float[] srcPts, int srcOff, float[] dstPts, int dstOff, int numPts);
    void transform(double[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts);
    void transform(float[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts);
    void transform(double[] srcPts, int srcOff, float[] dstPts, int dstOff, int numPts);
    Point2D deltaTransform(Point2D ptSrc, Point2D ptDst);
    void deltaTransform(double[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts);
    Shape createTransformedShape(Shape pSrc);
    String toString();
    boolean isIdentity();
    Object clone();
    boolean equals(Object obj);

    void scale(double scaleWidth, double scaleHeight);

    AffineTransform getTranslateInstance(float x, float y);
}
