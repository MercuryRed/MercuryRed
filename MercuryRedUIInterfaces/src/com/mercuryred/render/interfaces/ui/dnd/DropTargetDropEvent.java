package com.mercuryred.render.interfaces.ui.dnd;

import com.mercuryred.render.interfaces.ui.datatransfer.Transferable;
import com.mercuryred.render.interfaces.ui.Point;



public interface DropTargetDropEvent {

    Point getLocation();
    Transferable getTransferable();
    void acceptDrop(int dropAction);
    void rejectDrop();
    void dropComplete(boolean success);
}
