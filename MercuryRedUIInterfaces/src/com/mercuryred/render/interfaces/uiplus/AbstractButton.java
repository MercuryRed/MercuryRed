package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.uiplus.JRootPane;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.uiplus.ButtonModel;
import com.mercuryred.render.interfaces.ui.Insets;



public interface AbstractButton {

    String getText();
    void setMargin(Insets m);
    Insets getMargin();
    boolean isBorderPainted();
    void setBorderPainted(boolean b);
    boolean isContentAreaFilled();
    void setContentAreaFilled(boolean b);
    boolean isRolloverEnabled();
    void setRolloverEnabled(boolean b);
    int getDisplayedMnemonicIndex();
    ButtonModel getModel();
    void setBorder(Border border);
    Border getBorder();
    Object getClientProperty(Object key);
    int getWidth();
    int getHeight();
    void setOpaque(boolean isOpaque);
    JRootPane getRootPane();
    Container getParent();
    boolean isEnabled();
    Color getForeground();
    Color getBackground();
    Font getFont();
    boolean hasFocus();
}
