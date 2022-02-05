/*
* Copyright (c) 2002 and later by MH Software-Entwicklung. All Rights Reserved.
*
* JTattoo is multiple licensed. If your are an open source developer you can use
* it under the terms and conditions of the GNU General Public License version 2.0
* or later as published by the Free Software Foundation.
*
* see: gpl-2.0.txt
*
* If you pay for a license you will become a registered user who could use the
* software under the terms and conditions of the GNU Lesser General Public License
* version 2.0 or later with classpath exception as published by the Free Software
* Foundation.
*
* see: lgpl-2.0.txt
* see: classpath-exception.txt
*
* Registered users could also use JTattoo under the terms and conditions of the
* Apache License, Version 2.0 as published by the Apache Software Foundation.
*
* see: APACHE-LICENSE-2.0.txt
*/

package com.jtattoo.plaf;

import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.RenderingHints;

import com.mercuryred.render.interfaces.uiplus.AbstractButton;
import com.mercuryred.render.interfaces.uiplus.ButtonModel;
import com.mercuryred.render.interfaces.uiplus.Icon;
import com.mercuryred.render.interfaces.uiplus.JComponent;
import com.mercuryred.render.interfaces.uiplus.SwingUtilities;
import com.mercuryred.render.interfaces.uiplus.UIManager;
import com.mercuryred.render.interfaces.uiplus.plaf.ComponentUI;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicGraphicsUtils;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicHTML;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicRadioButtonUI;
import com.mercuryred.render.interfaces.uiplus.text.View;

/**
 * <p>BaseRadioButtonUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class BaseRadioButtonUI extends BasicRadioButtonUI {

	private static BaseRadioButtonUI radioButtonUI = null;
	/*
	 * These Dimensions/Rectangles are allocated once for all RadioButtonUI.paint()
	 * calls. Re-using rectangles rather than allocating them in each paint call
	 * substantially reduced the time it took paint to run. Obviously, this method
	 * can't be re-entered.
	 */
	/** Constant size */
	protected static Dimension size = new Dimension();
	/** Constant viewRect */
	protected static final Rectangle viewRect = new Rectangle();
	/** Constant iconRect */
	protected static final Rectangle iconRect = new Rectangle();
	/** Constant textRect */
	protected static final Rectangle textRect = new Rectangle();

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		if (radioButtonUI == null) {
			radioButtonUI = new BaseRadioButtonUI();
		}
		return radioButtonUI;
	}

	/** {@inheritDoc} */
	@Override
	public void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		b.setRolloverEnabled(true);
		icon = UIManager.getIcon("RadioButton.icon");
	}

	/** {@inheritDoc} */
	@Override
	public void paint(final Graphics g, final JComponent c) {
		AbstractButton b = (AbstractButton) c;
		g.setFont(c.getFont());
		FontMetrics fm = JTattooUtilities.getFontMetrics(c, g, c.getFont());

		Insets i = c.getInsets();
		size = b.getSize(size);
		viewRect.x = i.left;
		viewRect.y = i.top;
		viewRect.width = size.width - (i.right + viewRect.x);
		viewRect.height = size.height - (i.bottom + viewRect.y);
		iconRect.x = iconRect.y = iconRect.width = iconRect.height = 0;
		textRect.x = textRect.y = textRect.width = textRect.height = 0;
		Icon altIcon = b.getIcon();
		int iconTextGap = b.getIconTextGap();
		String text = SwingUtilities.layoutCompoundLabel(c, fm, b.getText(),
				altIcon != null ? altIcon : getDefaultIcon(), b.getVerticalAlignment(), b.getHorizontalAlignment(),
				b.getVerticalTextPosition(), b.getHorizontalTextPosition(), viewRect, iconRect, textRect, iconTextGap);

		// fill background
		if (c.isOpaque()) {
			paintBackground(g, c);
		}

		paintIcon(g, c, iconRect);

		if (text != null) {
			paintText(g, c, text, textRect);
		}

		if (b.hasFocus() && b.isFocusPainted() && textRect.width > 0 && textRect.height > 0) {
			paintFocus(g, textRect, size);
		}
	}

	/**
	 * <p>paintBackground.</p>
	 *
	 * @param g a {@link com.mercuryred.render.interfaces.ui.Graphics} object.
	 * @param c a {@link com.mercuryred.render.interfaces.uiplus.JComponent} object.
	 */
	protected void paintBackground(Graphics g, JComponent c) {
		g.setColor(c.getBackground());
		g.fillRect(0, 0, c.getWidth(), c.getHeight());
	}

	/** {@inheritDoc} */
	@Override
	protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
		g.setColor(AbstractLookAndFeel.getFocusColor());
		BasicGraphicsUtils.drawDashedRect(g, t.x, t.y - 1, t.width + 1, t.height + 1);
	}

	/** {@inheritDoc} */
	@Override
	protected void paintIcon(Graphics g, JComponent c, Rectangle iconRect) {
		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();
		Icon ico;
		if (!model.isEnabled()) {
			if (b.isSelected()) {
				ico = b.getDisabledSelectedIcon();
			} else {
				ico = b.getDisabledIcon();
			}
		} else {
			if (model.isPressed()) {
				ico = b.getPressedIcon();
			} else {
				if (model.isRollover()) {
					if (b.isSelected()) {
						ico = b.getRolloverSelectedIcon();
					} else {
						ico = b.getRolloverIcon();
					}
				} else {
					if (b.isSelected()) {
						ico = b.getSelectedIcon();
					} else {
						ico = b.getIcon();
					}
				}
			}
		}

		if (ico != null) {
			ico.paintIcon(c, g, iconRect.x, iconRect.y - 1);
		} else {
			if (b.getIcon() != null) {
				b.getIcon().paintIcon(c, g, iconRect.x, iconRect.y - 1);
			} else {
				getDefaultIcon().paintIcon(c, g, iconRect.x, iconRect.y - 1);
			}
		}
	}

	/**
	 * <p>paintText.</p>
	 *
	 * @param g a {@link com.mercuryred.render.interfaces.ui.Graphics} object.
	 * @param c a {@link com.mercuryred.render.interfaces.uiplus.JComponent} object.
	 * @param text a {@link java.lang.String} object.
	 * @param textRect a {@link com.mercuryred.render.interfaces.ui.Rectangle} object.
	 */
	protected void paintText(Graphics g, JComponent c, String text, Rectangle textRect) {
		View v = (View) c.getClientProperty(BasicHTML.propertyKey);
		if (v != null) {
			Graphics2D g2D = (Graphics2D) g;
			Object savedRenderingHint = null;
			if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
				savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
				g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
						AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
			}
			v.paint(g, textRect);
			if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
				g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
			}
		} else {
			AbstractButton b = (AbstractButton) c;
			ButtonModel model = b.getModel();
			g.setFont(b.getFont());
			FontMetrics fm = JTattooUtilities.getFontMetrics(b, g, b.getFont());
			int mnemIndex = b.getDisplayedMnemonicIndex();
			if (model.isEnabled()) {
				g.setColor(b.getForeground());
				JTattooUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x,
						textRect.y + fm.getAscent());
			} else {
				g.setColor(Color.white);
				JTattooUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x + 1,
						textRect.y + 1 + fm.getAscent());
				g.setColor(AbstractLookAndFeel.getDisabledForegroundColor());
				JTattooUtilities.drawStringUnderlineCharAt(c, g, text, mnemIndex, textRect.x,
						textRect.y + fm.getAscent());
			}
		}
	}

} // end of class BaseRadioButtonUI
