package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Component;

import java.beans.PropertyChangeListener;


public interface JSplitPane {

    void setLeftComponent(Component comp);
    void setRightComponent(Component comp);
    void setOneTouchExpandable(boolean newValue);
    void setDividerLocation(double proportionalLocation);
    void setDividerLocation(int location);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String propertyName, PropertyChangeListener listener);
}
