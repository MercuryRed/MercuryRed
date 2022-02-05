package com.mercuryred.render.interfaces.ui.dnd;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Image;
import com.mercuryred.render.interfaces.ui.event.InputEvent;
import com.mercuryred.render.interfaces.ui.dnd.DragSourceListener;
import com.mercuryred.render.interfaces.ui.Cursor;
import com.mercuryred.render.interfaces.ui.datatransfer.Transferable;
import com.mercuryred.render.interfaces.ui.Point;



public interface DragGestureEvent {

    Component getComponent();
    Point getDragOrigin();
    InputEvent getTriggerEvent();
    void startDrag(Cursor dragCursor, Transferable transferable);
    void startDrag(Cursor dragCursor, Transferable transferable, DragSourceListener dsl);
    void startDrag(Cursor dragCursor, Image dragImage, Point imageOffset, Transferable transferable, DragSourceListener dsl);
}
