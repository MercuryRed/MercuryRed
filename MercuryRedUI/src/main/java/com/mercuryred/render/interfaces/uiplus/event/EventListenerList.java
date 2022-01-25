package com.mercuryred.render.interfaces.uiplus.event;




public interface EventListenerList {

    Object[] getListenerList();
    <T> void add(Class<T> t, T l);
    <T> void remove(Class<T> t, T l);
}
