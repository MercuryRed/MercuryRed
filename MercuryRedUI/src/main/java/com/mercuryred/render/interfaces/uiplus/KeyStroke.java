package com.mercuryred.render.interfaces.uiplus;



public interface KeyStroke {

    KeyStroke getKeyStroke(char keyChar);

    KeyStroke getKeyStroke(char keyChar, boolean onKeyRelease);

    KeyStroke getKeyStroke(Character keyChar, int modifiers);

    KeyStroke getKeyStroke(int keyCode, int modifiers, boolean onKeyRelease);

    KeyStroke getKeyStroke(int keyCode, int modifiers);

    KeyStroke getKeyStroke(String s);
}
