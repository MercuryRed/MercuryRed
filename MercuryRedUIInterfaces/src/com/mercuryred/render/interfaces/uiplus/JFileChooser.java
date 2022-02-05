package com.mercuryred.render.interfaces.uiplus;

import com.mercuryred.render.interfaces.uiplus.event.AncestorListener;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.uiplus.JComponent;
import com.mercuryred.render.interfaces.ui.Rectangle;

import java.io.File;
import java.io.FileFilter;


public interface JFileChooser {

    File getSelectedFile();
    int showSaveDialog(Component parent);
    void setDialogTitle(String dialogTitle);
    JComponent getAccessory();
    void setAccessory(JComponent newAccessory);
    void setFileFilter(FileFilter filter);
    FileFilter getFileFilter();
    void addAncestorListener(AncestorListener listener);
    void removeAncestorListener(AncestorListener listener);
    void repaint(long tm, int x, int y, int width, int height);
    void repaint(Rectangle r);
    void revalidate();
    void repaint();
    void repaint(long tm);
    void repaint(int x, int y, int width, int height);
}
