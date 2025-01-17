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

package com.jtattoo.plaf.aero;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.text.View;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseTabbedPaneUI;
import com.jtattoo.plaf.ColorHelper;
import com.jtattoo.plaf.JTattooUtilities;

/**
 * <p>AeroTabbedPaneUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class AeroTabbedPaneUI extends BaseTabbedPaneUI {
	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new AeroTabbedPaneUI();
	}

	private Color[] sepColors = null;

	/** {@inheritDoc} */
	@Override
	protected Color[] getContentBorderColors(int tabPlacement) {
		if (sepColors == null) {
			sepColors = new Color[5];
			sepColors[0] = ColorHelper.brighter(AbstractLookAndFeel.getControlColorDark(), 40);
			sepColors[1] = ColorHelper.brighter(AbstractLookAndFeel.getControlColorLight(), 40);
			sepColors[2] = ColorHelper.brighter(AbstractLookAndFeel.getControlColorLight(), 60);
			sepColors[3] = ColorHelper.brighter(AbstractLookAndFeel.getControlColorLight(), 20);
			sepColors[4] = ColorHelper.brighter(AbstractLookAndFeel.getControlColorDark(), 30);
		}
		return sepColors;
	}

	/** {@inheritDoc} */
	@Override
	protected Font getTabFont(boolean isSelected) {
		if (isSelected) {
			return super.getTabFont(isSelected).deriveFont(Font.BOLD);
		} else {
			return super.getTabFont(isSelected);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void installComponents() {
		simpleButtonBorder = true;
		super.installComponents();
	}

	/** {@inheritDoc} */
	@Override
	protected void paintText(Graphics g, int tabPlacement, Font font, FontMetrics metrics, int tabIndex, String title,
							 Rectangle textRect, boolean isSelected) {
		Color backColor = tabPane.getBackgroundAt(tabIndex);
		if (!(backColor instanceof UIResource)) {
			super.paintText(g, tabPlacement, font, metrics, tabIndex, title, textRect, isSelected);
		} else {
			g.setFont(font);
			View v = getTextViewForTab(tabIndex);
			if (v != null) {
				// html
				Graphics2D g2D = (Graphics2D) g;
				Object savedRenderingHint = null;
				if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
					savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
					g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
				}
				v.paint(g, textRect);
				if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
					g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
				}
			} else {
				// plain text
				int mnemIndex = tabPane.getDisplayedMnemonicIndexAt(tabIndex);

				if (tabPane.isEnabled() && tabPane.isEnabledAt(tabIndex)) {
					if (isSelected) {
						Color titleColor = AbstractLookAndFeel.getTabSelectionForegroundColor();
						if (ColorHelper.getGrayValue(titleColor) > 164) {
							g.setColor(Color.black);
						} else {
							g.setColor(Color.white);
						}
						JTattooUtilities.drawStringUnderlineCharAt(tabPane, g, title, mnemIndex, textRect.x + 1,textRect.y + 1 + metrics.getAscent());
						g.setColor(titleColor);
					} else {
						g.setColor(tabPane.getForegroundAt(tabIndex));
					}
					JTattooUtilities.drawStringUnderlineCharAt(tabPane, g, title, mnemIndex, textRect.x,textRect.y + metrics.getAscent());

				} else { // tab disabled
					g.setColor(tabPane.getBackgroundAt(tabIndex).brighter());
					JTattooUtilities.drawStringUnderlineCharAt(tabPane, g, title, mnemIndex, textRect.x,textRect.y + metrics.getAscent());
					g.setColor(tabPane.getBackgroundAt(tabIndex).darker());
					JTattooUtilities.drawStringUnderlineCharAt(tabPane, g, title, mnemIndex, textRect.x - 1,textRect.y + metrics.getAscent() - 1);
				}
			}
		}
	}

} // end of class AeroTabbedPaneUI
