package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.Image;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Point;
import com.mercuryred.render.interfaces.ui.image.ImageProducer;

import java.beans.PropertyChangeListener;


public interface Component {

    Container getParent();
    boolean isVisible();
    boolean isShowing();
    void setVisible(boolean b);
    Color getBackground();
    Font getFont();
    Point getLocationOnScreen();
    void setBounds(int x, int y, int width, int height);
    void setBounds(Rectangle r);
    int getWidth();
    int getHeight();
    Dimension getPreferredSize();
    void invalidate();
    void paint(Graphics g);
    Image createImage(ImageProducer producer);
    Image createImage(int width, int height);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    PropertyChangeListener[] getPropertyChangeListeners();
    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
    PropertyChangeListener[] getPropertyChangeListeners(String propertyName);
    ComponentOrientation getComponentOrientation();
}
