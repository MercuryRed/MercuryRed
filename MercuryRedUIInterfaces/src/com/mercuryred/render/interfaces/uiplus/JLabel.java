package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Dimension;



public interface JLabel extends Component {

    void setText(String text);
    int getDisplayedMnemonicIndex();
    void setPreferredSize(Dimension preferredSize);
    Dimension getPreferredSize();
    void setMaximumSize(Dimension maximumSize);
    void setMinimumSize(Dimension minimumSize);
    void setFont(Font font);
    Object getClientProperty(Object key);
    Color getForeground();
    Font getFont();
    void addMouseListener(MouseListener l);
}
