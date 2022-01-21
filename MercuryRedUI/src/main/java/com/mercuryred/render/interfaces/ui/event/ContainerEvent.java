package com.mercuryred.render.interfaces.ui.event;


import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Container;

public interface ContainerEvent {

    Container getContainer();

    Component getChild();
}
