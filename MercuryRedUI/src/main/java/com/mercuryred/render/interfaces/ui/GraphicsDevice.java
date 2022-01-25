package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.Window;
import com.mercuryred.render.interfaces.ui.DisplayMode;
import com.mercuryred.render.interfaces.ui.GraphicsConfiguration;



public interface GraphicsDevice {

    GraphicsConfiguration getDefaultConfiguration();
    void setFullScreenWindow(Window w);
    boolean isDisplayChangeSupported();
    void setDisplayMode(DisplayMode dm);
    DisplayMode getDisplayMode();
}
