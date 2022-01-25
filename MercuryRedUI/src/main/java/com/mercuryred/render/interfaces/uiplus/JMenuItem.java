package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.event.ActionListener;
import com.mercuryred.render.interfaces.uiplus.ButtonModel;



public interface JMenuItem {

    boolean isArmed();
    boolean isSelected();
    int getDisplayedMnemonicIndex();
    ButtonModel getModel();
    void addActionListener(ActionListener l);
    void setVisible(boolean aFlag);
    int getWidth();
    int getHeight();
    boolean isOpaque();
    Container getParent();
    Color getForeground();
    Font getFont();
}
