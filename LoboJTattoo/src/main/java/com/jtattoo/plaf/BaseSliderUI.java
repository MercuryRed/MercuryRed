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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSliderUI;

/**
 * <p>BaseSliderUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class BaseSliderUI extends BasicSliderUI {

	// --------------------------------------------------------------------------
	// inner classes
	// --------------------------------------------------------------------------
	protected class MyTrackListener extends TrackListener {

		@Override
		public void mouseEntered(final MouseEvent e) {
			super.mouseEntered(e);
			if (slider.isEnabled()) {
				isRollover = thumbRect.contains(e.getPoint());
				slider.repaint();
			}
		}

		@Override
		public void mouseExited(final MouseEvent e) {
			super.mouseExited(e);
			if (slider.isEnabled()) {
				isRollover = false;
				slider.repaint();
			}
		}

		@Override
		public void mouseMoved(final MouseEvent e) {
			super.mouseMoved(e);
			if (slider.isEnabled()) {
				boolean rollover = thumbRect.contains(e.getPoint());
				if (rollover != isRollover) {
					isRollover = rollover;
					slider.repaint();
				}
			}
		}

	} // end of class MyTrackListener

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new BaseSliderUI((JSlider) c);
	}

	protected boolean isRollover = false;

	/**
	 * <p>Constructor for BaseSliderUI.</p>
	 *
	 * @param slider a {@link javax.swing.JSlider} object.
	 */
	public BaseSliderUI(JSlider slider) {
		super(slider);
	}

	/** {@inheritDoc} */
	@Override
	public TrackListener createTrackListener(JSlider slider) {
		return new MyTrackListener();
	}

	/**
	 * <p>getThumbHorIcon.</p>
	 *
	 * @return a {@link javax.swing.Icon} object.
	 */
	public Icon getThumbHorIcon() {
		if (UIManager.getLookAndFeel() instanceof AbstractLookAndFeel) {
			return ((AbstractLookAndFeel) UIManager.getLookAndFeel()).getIconFactory().getThumbHorIcon();
		}
		return null;
	}

	/**
	 * <p>getThumbHorIconRollover.</p>
	 *
	 * @return a {@link javax.swing.Icon} object.
	 */
	public Icon getThumbHorIconRollover() {
		if (UIManager.getLookAndFeel() instanceof AbstractLookAndFeel) {
			return ((AbstractLookAndFeel) UIManager.getLookAndFeel()).getIconFactory().getThumbHorIconRollover();
		}
		return null;
	}

	/** {@inheritDoc} */
	@Override
	protected Dimension getThumbSize() {
		Dimension size = super.getThumbSize();
		if (getThumbHorIcon() != null && getThumbVerIcon() != null) {
			if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
				size.width = getThumbHorIcon().getIconWidth();
				size.height = getThumbHorIcon().getIconHeight();
			} else {
				size.width = getThumbVerIcon().getIconWidth();
				size.height = getThumbVerIcon().getIconHeight();
			}
		}
		return size;
	}

	/**
	 * <p>getThumbVerIcon.</p>
	 *
	 * @return a {@link javax.swing.Icon} object.
	 */
	public Icon getThumbVerIcon() {
		if (UIManager.getLookAndFeel() instanceof AbstractLookAndFeel) {
			return ((AbstractLookAndFeel) UIManager.getLookAndFeel()).getIconFactory().getThumbVerIcon();
		}
		return null;
	}

	/**
	 * <p>getThumbVerIconRollover.</p>
	 *
	 * @return a {@link javax.swing.Icon} object.
	 */
	public Icon getThumbVerIconRollover() {
		if (UIManager.getLookAndFeel() instanceof AbstractLookAndFeel) {
			return ((AbstractLookAndFeel) UIManager.getLookAndFeel()).getIconFactory().getThumbVerIconRollover();
		}
		return null;
	}

	/**
	 * <p>getTrackWidth.</p>
	 *
	 * @return a int.
	 */
	protected int getTrackWidth() {
		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			return thumbRect.height - 9;
		} else {
			return thumbRect.width - 9;
		}
	}

	/** {@inheritDoc} */
	@Override
	protected boolean isDragging() {
		return super.isDragging();
	}

	/** {@inheritDoc} */
	@Override
	public void paint(final Graphics g, final JComponent c) {
		paintBackground(g, c);
		recalculateIfInsetsChanged();
		recalculateIfOrientationChanged();
		Rectangle clip = g.getClipBounds();

		if (!clip.intersects(trackRect) && slider.getPaintTrack()) {
			calculateGeometry();
		}

		if (slider.getPaintTrack() && clip.intersects(trackRect)) {
			paintTrack(g);
		}
		if (slider.getPaintTicks() && clip.intersects(tickRect)) {
			paintTicks(g);
		}
		if (slider.getPaintLabels() && clip.intersects(labelRect)) {
			paintLabels(g);
		}
		if (slider.hasFocus() && clip.intersects(focusRect)) {
			paintFocus(g);
		}
		if (clip.intersects(thumbRect)) {
			paintThumb(g);
		}
	}

	/**
	 * <p>paintBackground.</p>
	 *
	 * @param g a {@link java.awt.Graphics} object.
	 * @param c a {@link javax.swing.JComponent} object.
	 */
	public void paintBackground(Graphics g, JComponent c) {
		if (c.isOpaque()) {
			if (c.getBackground() instanceof ColorUIResource) {
				g.setColor(AbstractLookAndFeel.getBackgroundColor());
			} else {
				g.setColor(c.getBackground());
			}
			g.fillRect(0, 0, c.getWidth(), c.getHeight());
		}
	}

	/** {@inheritDoc} */
	@Override
	public void paintThumb(Graphics g) {
		Icon icon;
		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			if ((isRollover || isDragging()) && slider.isEnabled()) {
				icon = getThumbHorIconRollover();
			} else {
				icon = getThumbHorIcon();
			}
		} else {
			if ((isRollover || isDragging()) && slider.isEnabled()) {
				icon = getThumbVerIconRollover();
			} else {
				icon = getThumbVerIcon();
			}
		}
		Graphics2D g2D = (Graphics2D) g;
		Composite savedComposite = g2D.getComposite();
		if (!slider.isEnabled()) {
			g.setColor(AbstractLookAndFeel.getBackgroundColor());
			g.fillRect(thumbRect.x + 1, thumbRect.y + 1, thumbRect.width - 2, thumbRect.height - 2);
			AlphaComposite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f);
			g2D.setComposite(alpha);
		}
		icon.paintIcon(null, g, thumbRect.x, thumbRect.y);
		g2D.setComposite(savedComposite);
	}

	/** {@inheritDoc} */
	@Override
	public void paintTicks(Graphics g) {
		boolean leftToRight = JTattooUtilities.isLeftToRight(slider);
		Rectangle tickBounds = tickRect;
		g.setColor(slider.getForeground());
		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			g.translate(0, tickBounds.y);

			int value = slider.getMinimum();
			int xPos;

			if (slider.getMinorTickSpacing() > 0) {
				while (value <= slider.getMaximum()) {
					xPos = xPositionForValue(value);
					paintMinorTickForHorizSlider(g, tickBounds, xPos);
					value += slider.getMinorTickSpacing();
				}
			}

			if (slider.getMajorTickSpacing() > 0) {
				value = slider.getMinimum();
				while (value <= slider.getMaximum()) {
					xPos = xPositionForValue(value);
					paintMajorTickForHorizSlider(g, tickBounds, xPos);
					value += slider.getMajorTickSpacing();
				}
			}

			g.translate(0, -tickBounds.y);
		} else {
			g.translate(tickBounds.x, 0);

			int value = slider.getMinimum();
			int yPos;

			if (slider.getMinorTickSpacing() > 0) {
				int offset = 0;
				if (!leftToRight) {
					offset = tickBounds.width - tickBounds.width / 2;
					g.translate(offset, 0);
				}

				while (value <= slider.getMaximum()) {
					yPos = yPositionForValue(value);
					paintMinorTickForVertSlider(g, tickBounds, yPos);
					value += slider.getMinorTickSpacing();
				}
				if (!leftToRight) {
					g.translate(-offset, 0);
				}
			}

			if (slider.getMajorTickSpacing() > 0) {
				value = slider.getMinimum();
				if (!leftToRight) {
					g.translate(2, 0);
				}

				while (value <= slider.getMaximum()) {
					yPos = yPositionForValue(value);
					paintMajorTickForVertSlider(g, tickBounds, yPos);
					value += slider.getMajorTickSpacing();
				}

				if (!leftToRight) {
					g.translate(-2, 0);
				}
			}
			g.translate(-tickBounds.x, 0);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void paintTrack(Graphics g) {
		boolean leftToRight = JTattooUtilities.isLeftToRight(slider);

		g.translate(trackRect.x, trackRect.y);
		int overhang = 4;
		int trackLeft = 0;
		int trackTop = 0;
		int trackRight;
		int trackBottom;

		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			trackBottom = trackRect.height - 1 - overhang;
			trackTop = trackBottom - (getTrackWidth() - 1);
			trackRight = trackRect.width - 1;
		} else {
			if (leftToRight) {
				trackLeft = trackRect.width - overhang - getTrackWidth();
				trackRight = trackRect.width - overhang - 1;
			} else {
				trackLeft = overhang;
				trackRight = overhang + getTrackWidth() - 1;
			}
			trackBottom = trackRect.height - 1;
		}

		g.setColor(AbstractLookAndFeel.getFrameColor());
		g.drawRect(trackLeft, trackTop, trackRight - trackLeft - 1, trackBottom - trackTop - 1);

		int middleOfThumb;
		int fillTop;
		int fillLeft;
		int fillBottom;
		int fillRight;

		if (slider.getOrientation() == SwingConstants.HORIZONTAL) {
			middleOfThumb = thumbRect.x + thumbRect.width / 2;
			middleOfThumb -= trackRect.x;
			fillTop = trackTop + 1;
			fillBottom = trackBottom - 2;

			if (!drawInverted()) {
				fillLeft = trackLeft + 1;
				fillRight = middleOfThumb;
			} else {
				fillLeft = middleOfThumb;
				fillRight = trackRight - 2;
			}
			Color[] colors;
			if (!JTattooUtilities.isActive(slider)) {
				colors = AbstractLookAndFeel.getTheme().getInActiveColors();
			} else {
				if (slider.isEnabled()) {
					colors = AbstractLookAndFeel.getTheme().getSliderColors();
				} else {
					colors = AbstractLookAndFeel.getTheme().getDisabledColors();
				}
			}
			JTattooUtilities.fillHorGradient(g, colors, fillLeft + 2, fillTop + 2, fillRight - fillLeft - 2,
					fillBottom - fillTop - 2);
			Color cHi = ColorHelper.darker(colors[colors.length - 1], 5);
			Color cLo = ColorHelper.darker(colors[colors.length - 1], 10);
			JTattooUtilities.draw3DBorder(g, cHi, cLo, fillLeft + 1, fillTop + 1, fillRight - fillLeft - 1,
					fillBottom - fillTop - 1);
		} else {
			middleOfThumb = thumbRect.y + thumbRect.height / 2;
			middleOfThumb -= trackRect.y;
			fillLeft = trackLeft + 1;
			fillRight = trackRight - 2;

			if (!drawInverted()) {
				fillTop = middleOfThumb;
				fillBottom = trackBottom - 2;
			} else {
				fillTop = trackTop + 1;
				fillBottom = middleOfThumb;
			}
			Color[] colors;
			if (!JTattooUtilities.isActive(slider)) {
				colors = AbstractLookAndFeel.getTheme().getInActiveColors();
			} else {
				if (slider.isEnabled()) {
					colors = AbstractLookAndFeel.getTheme().getSliderColors();
				} else {
					colors = AbstractLookAndFeel.getTheme().getDisabledColors();
				}
			}
			JTattooUtilities.fillVerGradient(g, colors, fillLeft + 2, fillTop + 2, fillRight - fillLeft - 2,
					fillBottom - fillTop - 2);
			Color cHi = ColorHelper.darker(colors[colors.length - 1], 5);
			Color cLo = ColorHelper.darker(colors[colors.length - 1], 10);
			JTattooUtilities.draw3DBorder(g, cHi, cLo, fillLeft + 1, fillTop + 1, fillRight - fillLeft - 1,
					fillBottom - fillTop - 1);
		}
		g.translate(-trackRect.x, -trackRect.y);
	}

} // end of class BaseSliderUI
