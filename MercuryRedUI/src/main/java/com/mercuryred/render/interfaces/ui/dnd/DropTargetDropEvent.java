package com.mercuryred.render.interfaces.ui.dnd;



public interface DropTargetDropEvent {

    Point getLocation();

    Transferable getTransferable();

    void acceptDrop(int dropAction);

    void rejectDrop();

    void dropComplete(boolean success);
}
