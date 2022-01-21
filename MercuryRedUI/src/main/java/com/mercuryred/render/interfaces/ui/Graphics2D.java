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

    // TODO was RenderingHints.Key
    void setRenderingHint(/*Key*/Object hintKey, Object hintValue);

    void translate(int x, int y);

    void translate(double tx, double ty);

    void transform(AffineTransform Tx);

    void setTransform(AffineTransform Tx);

    AffineTransform getTransform();

    Composite getComposite();
}
