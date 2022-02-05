package com.mercuryred.render.interfaces.ui;




public class Color {

    /** Constant RED */
    public static final Color RED = new Color(255, 0, 0);
    /** Constant GREEN */
    public static final Color GREEN = new Color(0, 255, 255);
    /** Constant CYAN */
    public static final Color CYAN = new Color(0, 255, 255);
    /** Constant WHITE */
    public static final Color WHITE = new Color(255, 255, 255);
    /** Constant SUPER_LIGHT_GRAY */
    public static final Color SUPER_LIGHT_GRAY = new Color(248, 248, 248);
    /** Constant EXTRA_LIGHT_GRAY */
    public static final Color EXTRA_LIGHT_GRAY = new Color(232, 232, 232);
    /** Constant LIGHT_GRAY */
    public static final Color LIGHT_GRAY = new Color(196, 196, 196);
    /** Constant GRAY */
    public static final Color GRAY = new Color(164, 164, 164);
    /** Constant DARK_GRAY */
    public static final Color DARK_GRAY = new Color(148, 148, 148);
    /** Constant EXTRA_DARK_GRAY */
    public static final Color EXTRA_DARK_GRAY = new Color(96, 96, 96);
    /** Constant BLACK */
    public static final Color BLACK = new Color(0, 0, 0);
    /** Constant ORANGE */
    public static final Color ORANGE = new Color(255, 200, 0);
    /** Constant LIGHT_ORANGE */
    public static final Color LIGHT_ORANGE = new Color(255, 220, 96);
    /** Constant YELLOW */
    public static final Color YELLOW = new Color(255, 255, 196);
    /** Constant BLUE */
    public static final Color BLUE = new Color(0, 128, 255);
    /** Constant DARK_BLUE */
    public static final Color DARK_BLUE = new Color(0, 64, 128);

    private int value;

    public Color(int r, int g, int b) {
        this(r, g, b, 255);
    }

    public Color(int r, int g, int b, int a) {
        value = ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8)  |
                ((b & 0xFF) << 0);
    }

    public int getRed() {
        return (value >> 16) & 0xFF;
    }

    public int getGreen() {
        return (value >> 8) & 0xFF;
    }

    public int getBlue() {
        return (value >> 0) & 0xFF;
    }


    public int getAlpha() {
        return (value >> 24) & 0xff;
    }
}
