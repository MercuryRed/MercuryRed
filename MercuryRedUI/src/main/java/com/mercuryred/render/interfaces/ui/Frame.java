package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.GraphicsConfiguration;



public interface Frame {

    Component getFocusOwner();
    GraphicsConfiguration getGraphicsConfiguration();
}
