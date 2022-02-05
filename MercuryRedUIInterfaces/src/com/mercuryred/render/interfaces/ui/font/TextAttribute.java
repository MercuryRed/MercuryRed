package com.mercuryred.render.interfaces.ui.font;




public class TextAttribute {
    public static final TextAttribute SUPERSCRIPT = new TextAttribute("SUPERSCRIPT");
    public static final TextAttribute UNDERLINE = new TextAttribute("UNDERLINE");
    public static final TextAttribute STRIKETHROUGH_ON = new TextAttribute("STRIKETHROUGH_ON");
    public static final TextAttribute STRIKETHROUGH = new TextAttribute("STRIKETHROUGH");
    public static final TextAttribute TRACKING = new TextAttribute("TRACKING");
    public static final TextAttribute WEIGHT = new TextAttribute("WEIGHT");
    public static final float WEIGHT_EXTRA_LIGHT = 0.5f;
    public static final float WEIGHT_LIGHT = 0.75f;
    public static final float WEIGHT_DEMILIGHT = 0.875f;
    public static final float WEIGHT_REGULAR = 1.0f;
    public static final float WEIGHT_MEDIUM = 1.5f;
    public static final float WEIGHT_DEMIBOLD = 1.75f;
    public static final float WEIGHT_BOLD = 2.0f;
    public static final float WEIGHT_HEAVY = 2.25f;
    public static final float WEIGHT_EXTRABOLD = 2.5f;

    private String _name;
    public TextAttribute(String name) {
        _name = name;
    }
}
