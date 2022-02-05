package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Insets;



public interface Container {

    int getComponentCount();
    Component getComponent(int n);
    Insets getInsets();
    Component add(Component comp);
    Component add(String name, Component comp);
    Component add(Component comp, int index);
    void add(Component comp, Object constraints);
    void add(Component comp, Object constraints, int index);
    void paint(Graphics g);
    Dimension getSize();
    int getWidth();
    int getHeight();
    Dimension getSize(Dimension rv);
    void add(PopupMenu popup);
    ComponentOrientation getComponentOrientation();
}
