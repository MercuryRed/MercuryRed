package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.LayoutManager;
import com.mercuryred.render.interfaces.uiplus.JMenuBar;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.uiplus.plaf.ComponentUI;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.uiplus.JLayeredPane;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.uiplus.plaf.RootPaneUI;

import java.beans.PropertyChangeListener;


public interface JRootPane {

    int getWindowDecorationStyle();
    RootPaneUI getUI();
    // ComponentUI getUI();
    JMenuBar getJMenuBar();
    Container getContentPane();
    JLayeredPane getLayeredPane();
    Component getGlassPane();
    void setBorder(Border border);
    Border getBorder();
    Insets getInsets();
    Insets getInsets(Insets insets);
    Object getClientProperty(Object key);
    void putClientProperty(Object key, Object value);
    Rectangle getBounds(Rectangle rv);
    Dimension getSize(Dimension rv);
    void repaint(long tm, int x, int y, int width, int height);
    void repaint(Rectangle r);
    void revalidate();
    LayoutManager getLayout();
    void setLayout(LayoutManager mgr);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    Container getParent();
    Dimension getSize();
    Rectangle getBounds();
    void repaint();
    void repaint(long tm);
    void repaint(int x, int y, int width, int height);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
