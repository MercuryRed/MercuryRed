package com.mercuryred.render.interfaces.uiplus;


import java.io.File;
import java.io.FileFilter;

public interface JFileChooser {

    File getSelectedFile();

    FileFilter getFileFilter();
}
