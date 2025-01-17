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

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicMenuItemUI;

/**
 * <p>BaseMenuItemUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class BaseMenuItemUI extends BasicMenuItemUI {

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new BaseMenuItemUI();
	}

	/** {@inheritDoc} */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		c.setOpaque(false);
	}

	/**
	 * <p>paintBackground.</p>
	 *
	 * @param g a {@link java.awt.Graphics} object.
	 * @param c a {@link javax.swing.JComponent} object.
	 * @param x a int.
	 * @param y a int.
	 * @param w a int.
	 * @param h a int.
	 */
	protected void paintBackground(Graphics g, JComponent c, int x, int y, int w, int h) {
		JMenuItem mi = (JMenuItem) c;
		Color backColor = mi.getBackground();
		if (backColor == null || backColor instanceof UIResource) {
			backColor = AbstractLookAndFeel.getMenuBackgroundColor();
		}

		ButtonModel model = mi.getModel();
		if (model.isArmed() || model.isRollover() || c instanceof JMenu && model.isSelected()) {
			g.setColor(AbstractLookAndFeel.getMenuSelectionBackgroundColor());
			g.fillRect(x, y, w, h);
			g.setColor(AbstractLookAndFeel.getMenuSelectionForegroundColor());
		} else if (!AbstractLookAndFeel.getTheme().isMenuOpaque()) {
			Graphics2D g2D = (Graphics2D) g;
			Composite savedComposite = g2D.getComposite();
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
					AbstractLookAndFeel.getTheme().getMenuAlpha());
			g2D.setComposite(alpha);
			g2D.setColor(backColor);
			g2D.fillRect(x, y, w, h);
			g2D.setComposite(savedComposite);
			g.setColor(AbstractLookAndFeel.getMenuForegroundColor());
		} else {
			g.setColor(backColor);
			g.fillRect(x, y, w, h);
			g.setColor(AbstractLookAndFeel.getMenuForegroundColor());
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void paintBackground(Graphics g, JMenuItem menuItem, Color bgColor) {
		if (menuItem.isOpaque()) {
			int w = menuItem.getWidth();
			int h = menuItem.getHeight();
			paintBackground(g, menuItem, 0, 0, w, h);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void paintText(Graphics g, JMenuItem menuItem, Rectangle textRect, String text) {
		ButtonModel model = menuItem.getModel();
		Color foreColor = menuItem.getForeground();
		if (model.isArmed() || model.isRollover()) {
			foreColor = AbstractLookAndFeel.getMenuSelectionForegroundColor();
		} else if (foreColor == null || foreColor instanceof UIResource) {
			foreColor = AbstractLookAndFeel.getMenuForegroundColor();
		}
		Graphics2D g2D = (Graphics2D) g;
		Object savedRenderingHint = null;
		if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
			savedRenderingHint = g2D.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					AbstractLookAndFeel.getTheme().getTextAntiAliasingHint());
		}
		g2D.setColor(foreColor);
		super.paintText(g, menuItem, textRect, text);
		if (AbstractLookAndFeel.getTheme().isTextAntiAliasingOn()) {
			g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, savedRenderingHint);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void uninstallUI(JComponent c) {
		c.setOpaque(true);
		super.uninstallUI(c);
	}

	/** {@inheritDoc} */
	@Override
	public void update(Graphics g, JComponent c) {
		paintBackground(g, c, 0, 0, c.getWidth(), c.getHeight());
		paint(g, c);
	}

} // end of class BaseMenuItemUI
