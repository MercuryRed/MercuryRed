package com.mercuryred.render.interfaces.uiplus;

public interface ComboBoxModel<E> extends ListModel<E> {
    void setSelectedItem(Object anItem);
    Object getSelectedItem();
}
