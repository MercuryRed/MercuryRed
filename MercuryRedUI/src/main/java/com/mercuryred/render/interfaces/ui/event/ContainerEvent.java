package com.mercuryred.render.interfaces.ui.event;

import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Component;



public interface ContainerEvent {

    Container getContainer();
    Component getChild();
}
