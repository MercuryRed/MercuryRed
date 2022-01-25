package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.LayoutManager;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.MenuComponent;
import com.mercuryred.render.interfaces.ui.PopupMenu;
import com.mercuryred.render.interfaces.ui.Rectangle;


public interface JLayeredPane {

    void remove(int index);
    void setOpaque(boolean isOpaque);
    void repaint(long tm, int x, int y, int width, int height);
    void repaint(Rectangle r);
    void revalidate();
    Component[] getComponents();
    Component add(Component comp);
    Component add(String name, Component comp);
    Component add(Component comp, int index);
    void add(Component comp, Object constraints);
    void add(Component comp, Object constraints, int index);
    void remove(Component comp);
    void setLayout(LayoutManager mgr);
    void repaint();
    void repaint(long tm);
    void repaint(int x, int y, int width, int height);
    void add(PopupMenu popup);
    void remove(MenuComponent popup);
}
