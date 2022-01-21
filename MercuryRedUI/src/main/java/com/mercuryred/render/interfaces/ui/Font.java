package com.mercuryred.render.interfaces.ui;


import com.mercuryred.render.interfaces.ui.font.TextAttribute;
import com.mercuryred.render.interfaces.ui.geom.AffineTransform;

import java.io.File;
import java.io.InputStream;
import java.text.AttributedCharacterIterator.Attribute;
import java.util.Map;

public interface Font {

    Font createFont(int fontFormat, InputStream fontStream);

    Font createFont(int fontFormat, File fontFile);

    Map<TextAttribute, ?> getAttributes();

    Font deriveFont(int style, float size);

    Font deriveFont(int style, AffineTransform trans);

    Font deriveFont(float size);

    Font deriveFont(AffineTransform trans);

    Font deriveFont(int style);

    Font deriveFont(Map<? extends Attribute, ?> attributes);
}
