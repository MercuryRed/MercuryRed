package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Insets;



public interface JScrollBar {

    int getValue();
    int getVisibleAmount();
    int getMinimum();
    int getMaximum();
    Insets getInsets();
    Insets getInsets(Insets insets);
    Dimension getSize(Dimension rv);
    void invalidate();
    Dimension getSize();
}
