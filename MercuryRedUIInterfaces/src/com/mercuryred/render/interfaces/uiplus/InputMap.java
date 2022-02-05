package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.uiplus.KeyStroke;



public interface InputMap {

    void setParent(InputMap map);
    void put(KeyStroke keyStroke, Object actionMapKey);
    void clear();
}
