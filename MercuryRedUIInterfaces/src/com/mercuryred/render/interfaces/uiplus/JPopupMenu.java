package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Dimension;



public interface JPopupMenu {

    void show(Component invoker, int x, int y);
    Component getComponent();
    Dimension getPreferredSize();
    int getComponentCount();
    Component getComponent(int n);
    void show();
    void show(boolean b);
}
