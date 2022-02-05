package com.jtattoo.plaf.lobo;

import com.mercuryred.render.interfaces.ui.Cursor;
import com.mercuryred.render.interfaces.ui.Font;

import com.mercuryred.render.interfaces.uiplus.JButton;
import com.mercuryred.render.interfaces.uiplus.border.LineBorder;

/**
 * <p>LoboButton class.</p>
 *
 *
 *
 */
public class LoboButton extends JButton implements LoboLookAndFeel {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for LoboButton.</p>
	 */
	public LoboButton() {
		setForeground(foreground());
		setFont(new Font("Tahoma", Font.BOLD, 14));
		setFocusPainted(false);
		setContentAreaFilled(false);
		setBorder(new LineBorder(foreground()));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
