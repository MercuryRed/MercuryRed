package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.uiplus.event.ListSelectionListener;

public interface JList {

    void addListSelectionListener(ListSelectionListener listener);
    void setSelectionMode(int selectionMode);
    boolean isSelectedIndex(int index);
    void addSelectionInterval(int anchor, int lead);
    void setSelectedIndex(int index);
}
