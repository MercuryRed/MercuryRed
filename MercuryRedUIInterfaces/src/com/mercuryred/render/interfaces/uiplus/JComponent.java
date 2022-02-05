package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.LayoutManager;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.Point;

import java.beans.PropertyChangeListener;


public interface JComponent {

    FontMetrics getFontMetrics(Font font);
    Dimension getPreferredSize();
    boolean contains(int x, int y);
    void setBorder(Border border);
    Insets getInsets();
    Insets getInsets(Insets insets);
    Graphics getGraphics();
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setForeground(Color fg);
    Object getClientProperty(Object key);
    void putClientProperty(Object key, Object value);
    Dimension getSize(Dimension rv);
    int getWidth();
    int getHeight();
    boolean isOpaque();
    void setOpaque(boolean isOpaque);
    int getComponentCount();
    Component getComponent(int n);
    LayoutManager getLayout();
    void setLayout(LayoutManager mgr);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    Container getParent();
    boolean isEnabled();
    Color getBackground();
    Font getFont();
    Dimension getSize();
    void setBounds(int x, int y, int width, int height);
    void setBounds(Rectangle r);
    boolean contains(Point p);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
