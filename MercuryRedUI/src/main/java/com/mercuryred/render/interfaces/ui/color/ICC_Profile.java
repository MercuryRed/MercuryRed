package com.mercuryred.render.interfaces.ui.color;


import java.io.InputStream;

public interface ICC_Profile {

    ICC_Profile getInstance(byte[] data);

    ICC_Profile getInstance(int cspace);

    ICC_Profile getInstance(String fileName);

    ICC_Profile getInstance(InputStream s);
}
