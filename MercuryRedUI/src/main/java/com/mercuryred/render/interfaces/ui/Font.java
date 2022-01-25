package com.mercuryred.render.interfaces.ui;

import com.mercuryred.render.interfaces.ui.font.GlyphVector;
import com.mercuryred.render.interfaces.ui.geom.AffineTransform;
import com.mercuryred.render.interfaces.ui.font.TextAttribute;
import com.mercuryred.render.interfaces.ui.font.FontRenderContext;

import java.text.AttributedCharacterIterator;
import java.text.CharacterIterator;
import java.util.Map;


public interface Font {

    int hashCode();
    Map<TextAttribute, ?> getAttributes();
    Font deriveFont(int style, float size);
    Font deriveFont(int style, AffineTransform trans);
    Font deriveFont(float size);
    Font deriveFont(AffineTransform trans);
    Font deriveFont(int style);
    Font deriveFont(Map<? extends AttributedCharacterIterator.Attribute, ?> attributes);
    boolean canDisplay(char c);
    boolean canDisplay(int codePoint);
    GlyphVector createGlyphVector(FontRenderContext frc, String str);
    GlyphVector createGlyphVector(FontRenderContext frc, char[] chars);
    GlyphVector createGlyphVector(FontRenderContext frc, CharacterIterator ci);
    GlyphVector createGlyphVector(FontRenderContext frc, int[] glyphCodes);
}
