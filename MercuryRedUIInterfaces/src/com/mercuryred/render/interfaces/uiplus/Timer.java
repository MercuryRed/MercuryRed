package com.mercuryred.render.interfaces.uiplus;




public interface Timer {

    void setInitialDelay(int initialDelay);
    void setRepeats(boolean flag);
    void start();
    void stop();
    void restart();
}
