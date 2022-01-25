package com.mercuryred.render.interfaces.ui.event;




public interface KeyEvent {

    int getKeyCode();
    void setKeyCode(int keyCode);
    char getKeyChar();
    void setSource(Object newSource);
}
