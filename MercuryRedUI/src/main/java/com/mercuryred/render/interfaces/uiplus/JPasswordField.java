package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.uiplus.text.Document;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.event.KeyListener;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.event.ActionListener;
import com.mercuryred.render.interfaces.ui.event.FocusListener;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.uiplus.event.CaretListener;



public interface JPasswordField {

    void setDocument(Document doc);
    Dimension getPreferredSize();
    void addActionListener(ActionListener l);
    void addCaretListener(CaretListener listener);
    void setText(String t);
    void setEditable(boolean b);
    void setPreferredSize(Dimension preferredSize);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setToolTipText(String text);
    void addFocusListener(FocusListener l);
    void addKeyListener(KeyListener l);
    void addMouseListener(MouseListener l);
    void applyComponentOrientation(ComponentOrientation orientation);
}
