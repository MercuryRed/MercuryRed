package com.mercuryred.render.interfaces.ui;

public interface GraphicsEnvironment {

    GraphicsDevice getDefaultScreenDevice();

    String[] getAvailableFontFamilyNames();

    Rectangle getMaximumWindowBounds();
}
