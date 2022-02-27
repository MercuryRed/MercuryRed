package com.mercuryred.render.interfaces.ui.image;




public interface DataBuffer {


    int TYPE_BYTE = 1;

    public interface State {

    }

    int getElem(int i);
    int getElem(int bank, int i);
}
