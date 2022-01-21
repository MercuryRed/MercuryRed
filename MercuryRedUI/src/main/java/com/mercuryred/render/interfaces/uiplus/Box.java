package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Dimension;

public interface Box {

    Box createHorizontalBox();

    Box createVerticalBox();

    Component createRigidArea(Dimension d);

    Component createGlue();

    Component createHorizontalGlue();
}
