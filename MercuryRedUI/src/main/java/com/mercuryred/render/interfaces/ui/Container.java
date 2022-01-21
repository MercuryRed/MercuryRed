package com.mercuryred.render.interfaces.ui;



public interface Container {

    int getComponentCount();

    Component getComponent(int n);

    Insets getInsets();

    Component add(Component comp);

    Component add(String name, Component comp);

    Component add(Component comp, int index);

    void add(Component comp, Object constraints);

    void add(Component comp, Object constraints, int index);
}
