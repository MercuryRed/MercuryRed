package com.mercuryred.render.interfaces.ui.dnd;


import com.mercuryred.render.interfaces.ui.Point;
import com.mercuryred.render.interfaces.ui.datatransfer.Transferable;

public interface DropTargetDropEvent {

    Point getLocation();

    Transferable getTransferable();

    void acceptDrop(int dropAction);

    void rejectDrop();

    void dropComplete(boolean success);
}
