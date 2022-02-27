package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.PopupMenu;
import com.mercuryred.render.interfaces.uiplus.text.Document;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.LayoutManager;
import com.mercuryred.render.interfaces.ui.event.KeyListener;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.event.ActionListener;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.event.FocusListener;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.event.FocusEvent;
import com.mercuryred.render.interfaces.uiplus.event.CaretListener;
import com.mercuryred.render.interfaces.ui.Insets;



public interface JTextField extends Component {

    void setDocument(Document doc);
    Dimension getPreferredSize();
    void addActionListener(ActionListener l);
    void addCaretListener(CaretListener listener);
    Document getDocument();
    void setMargin(Insets m);
    void setSelectionColor(Color c);
    String getText(int offs, int len);
    void setText(String t);
    String getText();
    void setEditable(boolean b);
    void setSelectionStart(int selectionStart);
    void setSelectionEnd(int selectionEnd);
    void select(int selectionStart, int selectionEnd);
    void selectAll();
    void requestFocus();
    boolean requestFocus(boolean temporary);
    void setPreferredSize(Dimension preferredSize);
    void setMaximumSize(Dimension maximumSize);
    void setBorder(Border border);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setForeground(Color fg);
    void setBackground(Color bg);
    void setFont(Font font);
    void setToolTipText(String text);
    Component add(Component comp);
    Component add(String name, Component comp);
    Component add(Component comp, int index);
    void add(Component comp, Object constraints);
    void add(Component comp, Object constraints, int index);
    void removeAll();
    void setLayout(LayoutManager mgr);
    Font getFont();
    void addFocusListener(FocusListener l);
    void addKeyListener(KeyListener l);
    void addMouseListener(MouseListener l);
    void setFocusable(boolean focusable);
    void requestFocus(FocusEvent.Cause cause);
    boolean requestFocus(boolean temporary, FocusEvent.Cause cause);
    void add(PopupMenu popup);
    void applyComponentOrientation(ComponentOrientation orientation);
}
