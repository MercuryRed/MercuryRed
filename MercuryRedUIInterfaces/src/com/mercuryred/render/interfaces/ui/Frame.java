package com.mercuryred.render.interfaces.ui;

public interface Frame {

    static Frame[] getFrames() {
        return null;
    }

    Component getFocusOwner();
    GraphicsConfiguration getGraphicsConfiguration();
}
