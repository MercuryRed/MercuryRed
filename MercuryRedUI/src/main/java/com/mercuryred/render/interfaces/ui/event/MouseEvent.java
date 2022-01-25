package com.mercuryred.render.interfaces.ui.event;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Point;



public interface MouseEvent {

    Point getLocationOnScreen();
    int getX();
    int getY();
    Point getPoint();
    int getClickCount();
    int getButton();
    boolean isPopupTrigger();
    int getModifiers();
    void consume();
    Component getComponent();
}
