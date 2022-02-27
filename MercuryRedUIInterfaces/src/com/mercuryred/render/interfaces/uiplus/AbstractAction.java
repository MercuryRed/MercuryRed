package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.ui.event.ActionEvent;

public abstract class AbstractAction {
    public AbstractAction(String s) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    public abstract void actionPerformed(final ActionEvent e);
}
