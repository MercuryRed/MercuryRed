package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.ComponentOrientation;



public interface JRadioButton {

    void setSelected(boolean b);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setToolTipText(String text);
    void setOpaque(boolean isOpaque);
    void applyComponentOrientation(ComponentOrientation orientation);
}
