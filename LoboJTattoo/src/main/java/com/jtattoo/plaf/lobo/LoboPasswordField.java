package com.jtattoo.plaf.lobo;

import com.mercuryred.render.interfaces.ui.Color;

import com.mercuryred.render.interfaces.uiplus.JPasswordField;

/**
 * <p>LoboPasswordField class.</p>
 *
 *
 *
 */
public class LoboPasswordField extends JPasswordField implements LoboLookAndFeel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * <p>Constructor for LoboPasswordField.</p>
	 */
	public LoboPasswordField() {
		final Color fground = foreground();
		final Color bkg = background();
		setBackground(bkg);
		setCaretColor(fground);
		setForeground(fground);
		setEchoChar('*');
	}
}
