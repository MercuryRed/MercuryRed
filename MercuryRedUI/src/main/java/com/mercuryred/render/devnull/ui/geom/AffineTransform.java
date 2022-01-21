package com.mercuryred.render.devnull.ui.geom;



public class AffineTransform {

    AffineTransform getTranslateInstance(double tx, double ty) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform getRotateInstance(double theta) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform getRotateInstance(double theta, double anchorx, double anchory) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform getRotateInstance(double vecx, double vecy) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform getRotateInstance(double vecx, double vecy, double anchorx, double anchory) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform getScaleInstance(double sx, double sy) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    double getScaleX() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    AffineTransform createInverse() {
        throw com.mercuryred.nyi.ReportNyi();
    }

    Point2D transform(Point2D ptSrc, Point2D ptDst) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void transform(Point2D[] ptSrc, int srcOff, Point2D[] ptDst, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void transform(float[] srcPts, int srcOff, float[] dstPts, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void transform(double[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void transform(float[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void transform(double[] srcPts, int srcOff, float[] dstPts, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    Point2D deltaTransform(Point2D ptSrc, Point2D ptDst) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    void deltaTransform(double[] srcPts, int srcOff, double[] dstPts, int dstOff, int numPts) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    Shape createTransformedShape(Shape pSrc) {
        throw com.mercuryred.nyi.ReportNyi();
    }

    boolean isIdentity() {
        throw com.mercuryred.nyi.ReportNyi();
    }
}
