package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.uiplus.event.ListDataListener;

public interface ListModel<E> {
    int getSize();
    E getElementAt(int index);
    void addListDataListener(ListDataListener l);
    void removeListDataListener(ListDataListener l);
}
