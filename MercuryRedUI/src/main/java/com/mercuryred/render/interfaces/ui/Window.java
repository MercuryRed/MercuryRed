package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.event.BaseEvent;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.event.MouseMotionListener;
import com.mercuryred.render.interfaces.ui.event.WindowListener;
import com.mercuryred.render.interfaces.ui.Cursor;


import java.beans.PropertyChangeListener;


public interface Window {

    void setCursor(Cursor cursor);
    void addWindowListener(WindowListener l);
    void removeWindowListener(WindowListener l);
    boolean isActive();
    void addPropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
    Color getBackground();
    boolean isValid();
    void setBackground(Color c);
    void dispatchEvent(BaseEvent e);
    void addMouseListener(MouseListener l);
    void removeMouseListener(MouseListener l);
    void addMouseMotionListener(MouseMotionListener l);
    void removeMouseMotionListener(MouseMotionListener l);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(String propertyName, PropertyChangeListener listener);
    ComponentOrientation getComponentOrientation();
}
