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
package com.jtattoo.plaf.mcwin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.border.Border;
import javax.swing.plaf.UIResource;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseBorders;
import com.jtattoo.plaf.ColorHelper;
import com.jtattoo.plaf.JTattooUtilities;

/**
 * <p>McWinBorders class.</p>
 *
 * Author Michael Hagen
 *
 */
public class McWinBorders extends BaseBorders {

	// ------------------------------------------------------------------------------------
	// Implementation of border classes
	// ------------------------------------------------------------------------------------
	public static class ButtonBorder implements Border, UIResource {
		private static final Insets INSETS = new Insets(2, 12, 2, 12);
		private static final Insets SQUARE_INSETS = new Insets(3, 4, 3, 4);

		@Override
		public Insets getBorderInsets(final Component c) {
			if (AbstractLookAndFeel.getTheme().doDrawSquareButtons()) {
				return SQUARE_INSETS;
			} else {
				return INSETS;
			}
		}

		public Insets getBorderInsets(final Component c, final Insets borderInsets) {
			Insets insets = getBorderInsets(c);
			borderInsets.left = insets.left;
			borderInsets.top = insets.top;
			borderInsets.right = insets.right;
			borderInsets.bottom = insets.bottom;
			return borderInsets;
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
		}

	} // end of class ButtonBorder

	public static class InternalFrameBorder extends BaseInternalFrameBorder {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			boolean active = isActive(c);
			boolean resizable = isResizable(c);
			int th = getTitleHeight(c);
			Color frameColor = AbstractLookAndFeel.getWindowInactiveBorderColor();
			Color titleColor = AbstractLookAndFeel.getWindowInactiveTitleColorLight();
			Color borderColor = AbstractLookAndFeel.getWindowInactiveTitleColorDark();
			if (active) {
				frameColor = AbstractLookAndFeel.getWindowBorderColor();
				titleColor = AbstractLookAndFeel.getWindowTitleColorLight();
				borderColor = AbstractLookAndFeel.getWindowTitleColorDark();
			}
			if (!resizable) {
				Insets borderInsets = getBorderInsets(c);
				g.setColor(frameColor);
				g.drawRect(x, y, w - 1, h - 1);
				if (active) {
					g.setColor(AbstractLookAndFeel.getWindowTitleColorDark());
				} else {
					g.setColor(AbstractLookAndFeel.getWindowInactiveTitleColorDark());
				}
				for (int i = 1; i < borderInsets.left; i++) {
					g.drawRect(i, i, w - 2 * i - 1, h - 2 * i - 1);
				}
				g.setColor(ColorHelper.brighter(frameColor, 20));
				g.drawLine(borderInsets.left - 1, y + th + borderInsets.top, borderInsets.left - 1,
						y + h - borderInsets.bottom);
				g.drawLine(w - borderInsets.right, y + th + borderInsets.top, w - borderInsets.right,
						y + h - borderInsets.bottom);
				g.drawLine(borderInsets.left - 1, y + h - borderInsets.bottom, w - borderInsets.right,
						y + h - borderInsets.bottom);
			} else {
				g.setColor(titleColor);
				g.fillRect(x, y + 1, w, DW - 1);
				g.setColor(borderColor);
				g.fillRect(x + 1, y + h - DW, w - 2, DW - 1);
				if (active) {
					JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), 1, DW, DW,th + 1);
					JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowTitleColors(), w - DW, DW, DW, th + 1);
				} else {
					JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), 1, DW, DW, th + 1);
					JTattooUtilities.fillHorGradient(g, AbstractLookAndFeel.getTheme().getWindowInactiveTitleColors(), w - DW, DW, DW, th + 1);
				}
				g.setColor(borderColor);
				g.fillRect(1, INSETS.top + th + 1, DW - 1, h - th - DW);
				g.fillRect(w - DW, INSETS.top + th + 1, DW - 1, h - th - DW);

				g.setColor(ColorHelper.darker(frameColor, 10));
				g.drawRect(x, y, w - 1, h - 1);
				g.setColor(frameColor);
				g.drawLine(x + DW - 1, y + DW + th, x + DW - 1, y + h - DW);
				g.drawLine(x + w - DW, y + DW + th, x + w - DW, y + h - DW);
				g.drawLine(x + DW - 1, y + h - DW, x + w - DW, y + h - DW);
			}
		}
	}// end of class InternalFrameBorder

	public static class RolloverToolButtonBorder implements Border, UIResource {

		private static final Insets INSETS = new Insets(1, 1, 1, 1);

		@Override
		public Insets getBorderInsets(final Component c) {
			return INSETS;
		}

		public Insets getBorderInsets(final Component c, final Insets borderInsets) {
			borderInsets.top = 1;
			borderInsets.left = 1;
			borderInsets.bottom = 1;
			borderInsets.right = 1;
			return borderInsets;
		}

		@Override
		public boolean isBorderOpaque() {
			return true;
		}

		@Override
		public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
			AbstractButton button = (AbstractButton) c;
			ButtonModel model = button.getModel();
			Color frameColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 40);
			if (model.isPressed() && model.isArmed() || model.isSelected()) {
				frameColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 20);
			} else if (model.isRollover()) {
				frameColor = AbstractLookAndFeel.getTheme().getRolloverColor();
			}
			g.setColor(frameColor);
			g.drawRect(x, y, w - 2, h - 1);
			g.setColor(AbstractLookAndFeel.getTheme().getToolbarBackgroundColor());
			g.drawLine(w - 1, 0, w - 1, h - 1);
		}

	} // end of class RolloverToolButtonBorder

	// ------------------------------------------------------------------------------------
	// Lazy access methods
	// ------------------------------------------------------------------------------------
	/**
	 * <p>getButtonBorder.</p>
	 *
	 * @return a {@link javax.swing.border.Border} object.
	 */
	public static Border getButtonBorder() {
		if (buttonBorder == null) {
			buttonBorder = new ButtonBorder();
		}
		return buttonBorder;
	}

	/**
	 * <p>getInternalFrameBorder.</p>
	 *
	 * @return a {@link javax.swing.border.Border} object.
	 */
	public static Border getInternalFrameBorder() {
		if (internalFrameBorder == null) {
			internalFrameBorder = new InternalFrameBorder();
		}
		return internalFrameBorder;
	}

	/**
	 * <p>getRolloverToolButtonBorder.</p>
	 *
	 * @return a {@link javax.swing.border.Border} object.
	 */
	public static Border getRolloverToolButtonBorder() {
		if (rolloverToolButtonBorder == null) {
			rolloverToolButtonBorder = new RolloverToolButtonBorder();
		}
		return rolloverToolButtonBorder;
	}

	/**
	 * <p>getTabbedPaneBorder.</p>
	 *
	 * @return a {@link javax.swing.border.Border} object.
	 */
	public static Border getTabbedPaneBorder() {
		return null;
	}

	/**
	 * <p>getToggleButtonBorder.</p>
	 *
	 * @return a {@link javax.swing.border.Border} object.
	 */
	public static Border getToggleButtonBorder() {
		return getButtonBorder();
	}

} // end of class McWinBorders
