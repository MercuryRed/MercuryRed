package com.mercuryred.render.interfaces.uiplus;


import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.uiplus.border.Border;

public interface JComponent {

    FontMetrics getFontMetrics(Font font);

    void setBorder(Border border);

    Insets getInsets();

    Insets getInsets(Insets insets);

    Graphics getGraphics();

    void setVisible(boolean aFlag);

    void setEnabled(boolean enabled);

    void setForeground(Color fg);

    Object getClientProperty(Object key);

    void putClientProperty(Object key, Object value);

    int getWidth();

    int getHeight();

    boolean isOpaque();

    void setOpaque(boolean isOpaque);
}
