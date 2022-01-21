package com.mercuryred.render.interfaces.ui.image;

import java.util.Hashtable;

public interface ImageConsumer {

    void setDimensions(int width, int height);

    void setProperties(Hashtable<?,?> props);

    void setColorModel(ColorModel model);

    void setHints(int hintflags);

    void setPixels(int x, int y, int w, int h,
                   ColorModel model, byte[] pixels, int off, int scansize);


    void setPixels(int x, int y, int w, int h,
                   ColorModel model, int[] pixels, int off, int scansize);

    void imageComplete(int status);

}
