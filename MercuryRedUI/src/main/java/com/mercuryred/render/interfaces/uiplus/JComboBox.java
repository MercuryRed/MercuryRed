package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.event.ActionListener;

import java.awt.event.ItemListener;


public interface JComboBox {

    void setEditable(boolean aFlag);
    void setMaximumRowCount(int count);
    int getMaximumRowCount();
    void setSelectedItem(Object anObject);
    Object getSelectedItem();
    void setSelectedIndex(int anIndex);
    int getSelectedIndex();
    <E> void addItem(E item);
    void removeAllItems();
    void addItemListener(ItemListener aListener);
    void addActionListener(ActionListener l);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setToolTipText(String text);
    Object getClientProperty(Object key);
    void putClientProperty(Object key, Object value);
    void applyComponentOrientation(ComponentOrientation orientation);
}
