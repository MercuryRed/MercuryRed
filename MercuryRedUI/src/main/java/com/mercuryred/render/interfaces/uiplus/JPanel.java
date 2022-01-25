package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.MenuComponent;
import com.mercuryred.render.interfaces.ui.PopupMenu;
import com.mercuryred.render.interfaces.ui.event.MouseEvent;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.Point;



public interface JPanel {

    Dimension getPreferredSize();
    void setBorder(Border border);
    Insets getInsets();
    Insets getInsets(Insets insets);
    void setFont(Font font);
    Point getPopupLocation(MouseEvent event);
    int getWidth();
    void repaint(long tm, int x, int y, int width, int height);
    void repaint(Rectangle r);
    void revalidate();
    Component add(Component comp);
    Component add(String name, Component comp);
    Component add(Component comp, int index);
    void add(Component comp, Object constraints);
    void add(Component comp, Object constraints, int index);
    void remove(int index);
    void remove(Component comp);
    Container getParent();
    void setBounds(int x, int y, int width, int height);
    void setBounds(Rectangle r);
    void repaint();
    void repaint(long tm);
    void repaint(int x, int y, int width, int height);
    void add(PopupMenu popup);
    void remove(MenuComponent popup);
}
