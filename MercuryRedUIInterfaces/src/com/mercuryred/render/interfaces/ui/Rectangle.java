package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.geom.Rectangle2D;
import com.mercuryred.utils.Nyi;

public class Rectangle implements Rectangle2D {
    public double x;
    public double y;
    public double width;
    public double height;

    public Rectangle() {
        this(0, 0, 0, 0);
    }

    public Rectangle(Rectangle r) {
        this(r.x, r.y, r.width, r.height);
    }

    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int width, int height) {
        this(0, 0, width, height);
    }

    public Rectangle(Point p, Dimension d) {
        this(p.x, p.y, d.width, d.height);
    }

    public Rectangle(Point p) {
        this(p.x, p.y, 0, 0);
    }

    public Rectangle(Dimension d) {
        this(0, 0, d.width, d.height);
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getMinX() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public double getMinY() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    public boolean intersects(Rectangle r) {
        double tw = this.width;
        double th = this.height;
        double rw = r.width;
        double rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        double tx = this.x;
        double ty = this.y;
        double rx = r.x;
        double ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }


    public boolean intersects(double x, double y, double w, double h) {
        if (isEmpty() || w <= 0 || h <= 0) {
            return false;
        }
        double x0 = getX();
        double y0 = getY();
        return (x + w > x0 &&
                y + h > y0 &&
                x < x0 + getWidth() &&
                y < y0 + getHeight());
    }

    public boolean isEmpty() {
        return (width <= 0.0) || (height <= 0.0);
    }

    @Override
    public Rectangle2D getBounds2D() {
        return new Rectangle(this);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this);
    }
}
