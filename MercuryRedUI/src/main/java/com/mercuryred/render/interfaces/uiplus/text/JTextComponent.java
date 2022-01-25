package com.mercuryred.render.interfaces.uiplus.text;




public interface JTextComponent {

    String getText(int offs, int len);
    void setText(String t);
    String getText();
    String getSelectedText();
}
