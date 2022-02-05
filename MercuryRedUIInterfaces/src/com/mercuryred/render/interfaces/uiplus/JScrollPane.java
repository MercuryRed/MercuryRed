package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.uiplus.JScrollBar;
import com.mercuryred.render.interfaces.uiplus.JViewport;



public interface JScrollPane {

    JScrollBar getHorizontalScrollBar();
    JScrollBar getVerticalScrollBar();
    JViewport getViewport();
    void setViewportView(Component view);
}
