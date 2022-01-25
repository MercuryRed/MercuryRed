package com.mercuryred.render.interfaces.ui.event;

import com.mercuryred.render.interfaces.ui.event.MouseEvent;



public interface MouseListener {

    void mouseClicked(MouseEvent e);
    void mousePressed(MouseEvent e);
    void mouseReleased(MouseEvent e);
    void mouseEntered(MouseEvent e);
    void mouseExited(MouseEvent e);
}
