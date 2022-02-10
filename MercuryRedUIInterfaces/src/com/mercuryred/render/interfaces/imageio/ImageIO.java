package com.mercuryred.render.interfaces.imageio;


import com.mercuryred.render.interfaces.ui.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ImageIO {
    public static BufferedImage read(InputStream stream) throws IOException {
        return null;
    }

    public static void write(BufferedImage image, String ext, File outputfile) throws IOException {
        throw new RuntimeException("NYI");
    }
}
