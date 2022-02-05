package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.event.ActionListener;



public interface JCheckBox {

    void setSelected(boolean b);
    void addActionListener(ActionListener l);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setToolTipText(String text);
    void setOpaque(boolean isOpaque);
    void addMouseListener(MouseListener l);
    void applyComponentOrientation(ComponentOrientation orientation);
}
