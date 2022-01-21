package com.mercuryred.render.interfaces.ui.dnd;



public interface DragGestureEvent {

    Component getComponent();

    Point getDragOrigin();

    InputEvent getTriggerEvent();

    void startDrag(Cursor dragCursor, Transferable transferable);

    void startDrag(Cursor dragCursor, Transferable transferable, DragSourceListener dsl);

    void startDrag(Cursor dragCursor, Image dragImage, Point imageOffset, Transferable transferable, DragSourceListener dsl);
}
