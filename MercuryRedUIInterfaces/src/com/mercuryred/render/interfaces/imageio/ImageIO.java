package com.mercuryred.render.interfaces.imageio;


import com.mercuryred.render.interfaces.ui.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

public class ImageIO {
    public static BufferedImage read(InputStream stream) throws IOException {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    public static void write(BufferedImage image, String ext, File outputfile) throws IOException {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    public static Iterator<ImageReader> getImageReadersByFormatName(String jpeg) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    public static Object createImageInputStream(ByteBuffer byteBufferInputStream) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }
}
