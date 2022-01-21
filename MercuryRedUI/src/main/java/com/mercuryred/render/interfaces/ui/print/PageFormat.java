package com.mercuryred.render.interfaces.ui.print;



public interface PageFormat {

    double getImageableX();

    double getImageableY();

    double getImageableWidth();

    double getImageableHeight();

    void setOrientation(int orientation);

    int getOrientation();
}
