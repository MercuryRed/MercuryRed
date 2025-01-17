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

package com.jtattoo.plaf.acryl;

import java.awt.Adjustable;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseScrollBarUI;
import com.jtattoo.plaf.ColorHelper;
import com.jtattoo.plaf.JTattooUtilities;

/**
 * <p>AcrylScrollBarUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class AcrylScrollBarUI extends BaseScrollBarUI {

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new AcrylScrollBarUI();
	}

	/** {@inheritDoc} */
	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		if (!c.isEnabled()) {
			return;
		}

		g.translate(thumbBounds.x, thumbBounds.y);

		Color[] colors = getThumbColors();
		Color frameColor = AbstractLookAndFeel.getFrameColor();
		if (!JTattooUtilities.isActive(scrollbar)) {
			frameColor = ColorHelper.brighter(frameColor, 80);
		}
		if (isRollover || isDragging) {
			frameColor = AbstractLookAndFeel.getTheme().getRolloverColorDark();
		}

		if (scrollbar.getOrientation() == Adjustable.VERTICAL) {
			JTattooUtilities.fillVerGradient(g, colors, 1, 1, thumbBounds.width - 1, thumbBounds.height - 1);

			JTattooUtilities.draw3DBorder(g, frameColor, ColorHelper.darker(frameColor, 15), 0, 0, thumbBounds.width,
					thumbBounds.height);

			Graphics2D g2D = (Graphics2D) g;
			Composite composite = g2D.getComposite();
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
			g2D.setComposite(alpha);

			if (!AbstractLookAndFeel.getTheme().isMacStyleScrollBarOn()) {
				int dx = 5;
				int dy = thumbBounds.height / 2 - 3;
				int dw = thumbBounds.width - 11;

				Color c1 = Color.white;
				Color c2 = Color.darkGray;

				for (int i = 0; i < 4; i++) {
					g.setColor(c1);
					g.drawLine(dx, dy, dx + dw, dy);
					dy++;
					g.setColor(c2);
					g.drawLine(dx, dy, dx + dw, dy);
					dy++;
				}
			}
			g2D.setComposite(composite);
		} else { // HORIZONTAL
			JTattooUtilities.fillHorGradient(g, colors, 1, 1, thumbBounds.width - 1, thumbBounds.height - 1);
			JTattooUtilities.draw3DBorder(g, frameColor, ColorHelper.darker(frameColor, 10), 0, 0, thumbBounds.width,
					thumbBounds.height);

			int dx = thumbBounds.width / 2 - 3;
			int dy = 5;
			int dh = thumbBounds.height - 11;

			Graphics2D g2D = (Graphics2D) g;
			Composite composite = g2D.getComposite();
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f);
			g2D.setComposite(alpha);

			if (!AbstractLookAndFeel.getTheme().isMacStyleScrollBarOn()) {
				Color c1 = Color.white;
				Color c2 = Color.darkGray;

				for (int i = 0; i < 4; i++) {
					g.setColor(c1);
					g.drawLine(dx, dy, dx, dy + dh);
					dx++;
					g.setColor(c2);
					g.drawLine(dx, dy, dx, dy + dh);
					dx++;
				}
			}
			g2D.setComposite(composite);
		}

		g.translate(-thumbBounds.x, -thumbBounds.y);
	}

} // end of class AcrylScrollBarUI
