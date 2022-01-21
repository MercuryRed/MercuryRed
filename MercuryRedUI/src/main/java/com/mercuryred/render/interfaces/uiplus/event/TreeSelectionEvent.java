package com.mercuryred.render.interfaces.uiplus.event;



public interface TreeSelectionEvent {

    TreePath getPath();

    boolean isAddedPath();

    boolean isAddedPath(TreePath path);

    boolean isAddedPath(int index);
}
