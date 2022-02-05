package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.geom.AffineTransform;
import com.mercuryred.render.interfaces.ui.image.BufferedImage;
import com.mercuryred.render.interfaces.ui.image.BufferedImageOp;
import com.mercuryred.render.interfaces.ui.image.ImageObserver;

import java.text.AttributedCharacterIterator;


public interface Graphics2D {

    void draw(Shape s);
    boolean drawImage(Image img, AffineTransform xform, ImageObserver obs);
    void drawImage(BufferedImage img, BufferedImageOp op, int x, int y);
    void drawString(String str, int x, int y);
    void drawString(String str, float x, float y);
    void drawString(AttributedCharacterIterator iterator, int x, int y);
    void drawString(AttributedCharacterIterator iterator, float x, float y);
    void fill(Shape s);
    void setComposite(Composite comp);
    void setPaint(Paint paint);
    void setStroke(Stroke s);
    void setRenderingHint(String hintKey, Object hintValue);
    void translate(int x, int y);
    void translate(double tx, double ty);
    void transform(AffineTransform Tx);
    void setTransform(AffineTransform Tx);
    AffineTransform getTransform();
    Composite getComposite();
    void clip(Shape s);
    void setColor(Color c);
    void setFont(Font font);
    FontMetrics getFontMetrics();
    FontMetrics getFontMetrics(Font f);
    void setClip(int x, int y, int width, int height);
    Shape getClip();
    void setClip(Shape clip);
    void drawLine(int x1, int y1, int x2, int y2);
    void fillRect(int x, int y, int width, int height);
    void drawRect(int x, int y, int width, int height);
    void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight);
    void drawOval(int x, int y, int width, int height);
    boolean drawImage(Image img, int x, int y, ImageObserver observer);
    boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer);
    boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer);
    boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer);
    boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer);
    boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer);

    void dispose();
}
