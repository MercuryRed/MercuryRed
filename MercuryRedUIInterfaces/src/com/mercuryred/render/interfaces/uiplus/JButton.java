package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.ComponentOrientation;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.event.ActionListener;
import com.mercuryred.render.interfaces.ui.event.MouseListener;



public interface JButton extends Component {

    void setText(String text);
    void setMargin(Insets m);
    void setIcon(Icon defaultIcon);
    void setAction(Action a);
    void addActionListener(ActionListener l);
    void setVisible(boolean aFlag);
    void setEnabled(boolean enabled);
    void setBackground(Color bg);
    void setToolTipText(String text);
    void putClientProperty(Object key, Object value);
    Container getParent();
    void setBounds(int x, int y, int width, int height);
    void setBounds(Rectangle r);
    void addMouseListener(MouseListener l);
    void applyComponentOrientation(ComponentOrientation orientation);
}
