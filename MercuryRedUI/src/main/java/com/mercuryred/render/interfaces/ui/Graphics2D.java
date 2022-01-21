package com.mercuryred.render.interfaces.ui;



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

    void setRenderingHint(Key hintKey, Object hintValue);

    void translate(int x, int y);

    void translate(double tx, double ty);

    void transform(AffineTransform Tx);

    void setTransform(AffineTransform Tx);

    AffineTransform getTransform();

    Composite getComposite();
}
