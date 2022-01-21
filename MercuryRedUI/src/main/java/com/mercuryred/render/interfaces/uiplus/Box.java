package com.mercuryred.render.interfaces.uiplus;



public interface Box {

    Box createHorizontalBox();

    Box createVerticalBox();

    Component createRigidArea(Dimension d);

    Component createGlue();

    Component createHorizontalGlue();
}
