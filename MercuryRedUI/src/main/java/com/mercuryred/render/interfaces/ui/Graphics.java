package com.mercuryred.render.interfaces.ui;


import com.mercuryred.render.interfaces.ui.image.ImageObserver;

import java.text.AttributedCharacterIterator;

public interface Graphics {

    Graphics create();

    Graphics create(int x, int y, int width, int height);

    void translate(int x, int y);

    Color getColor();

    void setColor(Color c);

    void setPaintMode();

    void setXORMode(Color c1);

    void setFont(Font font);

    FontMetrics getFontMetrics();

    FontMetrics getFontMetrics(Font f);

    Rectangle getClipBounds();

    void setClip(int x, int y, int width, int height);

    Shape getClip();

    void setClip(Shape clip);

    void drawLine(int x1, int y1, int x2, int y2);

    void fillRect(int x, int y, int width, int height);

    void drawRect(int x, int y, int width, int height);

    void drawOval(int x, int y, int width, int height);

    void fillOval(int x, int y, int width, int height);

    void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle);

    void drawPolygon(int[] xPoints, int[] yPoints, int nPoints);

    void drawPolygon(Polygon p);

    void fillPolygon(int[] xPoints, int[] yPoints, int nPoints);

    void fillPolygon(Polygon p);

    void drawString(String str, int x, int y);

    void drawString(AttributedCharacterIterator iterator, int x, int y);

    boolean drawImage(Image img, int x, int y, ImageObserver observer);

    boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer);

    boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer);

    boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer);

    boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer);

    boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer);

    Rectangle getClipBounds(Rectangle r);
}
