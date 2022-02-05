package com.mercuryred.render.interfaces.uiplus;




public interface DefaultListModel {

    int getSize();
    <E> void addElement(E element);
    <E> E get(int index);
    void clear();
}
