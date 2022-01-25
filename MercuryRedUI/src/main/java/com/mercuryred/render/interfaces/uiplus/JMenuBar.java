package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.PopupMenu;
import com.mercuryred.render.interfaces.uiplus.JMenu;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.Dimension;



public interface JMenuBar {

    JMenu add(JMenu c);
    Dimension getPreferredSize();
    int getWidth();
    Component add(Component comp);
    Component add(String name, Component comp);
    Component add(Component comp, int index);
    void add(Component comp, Object constraints);
    void add(Component comp, Object constraints, int index);
    void setBounds(int x, int y, int width, int height);
    void setBounds(Rectangle r);
    void add(PopupMenu popup);
}
