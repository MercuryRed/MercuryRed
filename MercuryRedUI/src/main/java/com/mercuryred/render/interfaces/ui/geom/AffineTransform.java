package com.mercuryred.render.interfaces.ui.geom;



public interface AffineTransform {

    AffineTransform getTranslateInstance(double tx, double ty);

    AffineTransform getRotateInstance(double theta);

    AffineTransform getRotateInstance(double theta, double anchorx, double anchory);

    AffineTransform getRotateInstance(double vecx, double vecy);

    AffineTransform getRotateInstance(double vecx, double vecy, double anchorx, double anchory);

    AffineTransform getScaleInstance(double sx, double sy);

    double getScaleX();

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

    boolean isIdentity();
}
