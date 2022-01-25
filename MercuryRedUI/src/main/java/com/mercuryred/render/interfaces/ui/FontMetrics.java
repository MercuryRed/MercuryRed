package com.mercuryred.render.interfaces.ui;




public interface FontMetrics {

    int getLeading();
    int getAscent();
    int charWidth(int codePoint);
    int charWidth(char ch);
    int stringWidth(String str);
}
