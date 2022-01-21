package com.mercuryred.render.interfaces.uiplus;


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
}
