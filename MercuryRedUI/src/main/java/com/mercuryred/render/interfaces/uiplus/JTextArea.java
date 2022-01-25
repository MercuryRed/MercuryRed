package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.uiplus.text.Document;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.event.KeyListener;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.ui.event.FocusListener;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.event.FocusEvent;
import com.mercuryred.render.interfaces.uiplus.event.CaretListener;
import com.mercuryred.render.interfaces.ui.Insets;



public interface JTextArea {

    void append(String str);
    void addCaretListener(CaretListener listener);
    void setDocument(Document doc);
    void setMargin(Insets m);
    void setSelectionColor(Color c);
    String getText(int offs, int len);
    void setText(String t);
    String getText();
    String getSelectedText();
    void setEditable(boolean b);
    void select(int selectionStart, int selectionEnd);
    void selectAll();
    void requestFocus();
    boolean requestFocus(boolean temporary);
    FontMetrics getFontMetrics(Font font);
    void setPreferredSize(Dimension preferredSize);
    void setBorder(Border border);
    Insets getInsets();
    Insets getInsets(Insets insets);
    void setEnabled(boolean enabled);
    void setFont(Font font);
    Font getFont();
    void addFocusListener(FocusListener l);
    void addKeyListener(KeyListener l);
    void addMouseListener(MouseListener l);
    void setFocusable(boolean focusable);
    void requestFocus(FocusEvent.Cause cause);
    boolean requestFocus(boolean temporary, FocusEvent.Cause cause);
}
