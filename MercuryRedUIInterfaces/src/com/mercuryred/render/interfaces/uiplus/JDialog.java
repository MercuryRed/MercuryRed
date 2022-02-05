package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Point;



public interface JDialog {

    void setDefaultCloseOperation(int operation);
    Container getContentPane();
    void setVisible(boolean b);
    void pack();
    void setLocation(int x, int y);
    void setLocation(Point p);
    void dispose();
}
