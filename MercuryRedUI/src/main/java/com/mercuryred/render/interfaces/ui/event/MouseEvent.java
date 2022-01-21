package com.mercuryred.render.interfaces.ui.event;



public interface MouseEvent {

    Point getLocationOnScreen();

    int getX();

    int getY();

    Point getPoint();

    int getClickCount();

    int getButton();

    boolean isPopupTrigger();
}
