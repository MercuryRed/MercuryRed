package com.mercuryred.render.interfaces.uiplus.event;

import com.mercuryred.render.interfaces.uiplus.tree.TreePath;



public interface TreeSelectionEvent {

    TreePath getPath();
    boolean isAddedPath();
    boolean isAddedPath(TreePath path);
    boolean isAddedPath(int index);
}
