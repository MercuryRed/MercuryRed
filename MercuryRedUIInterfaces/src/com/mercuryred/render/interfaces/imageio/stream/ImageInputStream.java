package com.mercuryred.render.interfaces.imageio.stream;


import java.io.IOException;

public interface ImageInputStream {

    int read();
    int read(byte[] b) throws IOException;
    int read(byte[] b, int off, int len);
    void readFully(byte[] b, int off, int len);
    void readFully(byte[] b);
    void readFully(short[] s, int off, int len);
    void readFully(char[] c, int off, int len);
    void readFully(int[] i, int off, int len);
    void readFully(long[] l, int off, int len);
    void readFully(float[] f, int off, int len);
    void readFully(double[] d, int off, int len);
    long length();

    void mark();

    void reset();
}
