package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Graphics;

public interface Icon {

    void paintIcon(Component c, Graphics g, int x, int y);

    int getIconWidth();

    int getIconHeight();
}
