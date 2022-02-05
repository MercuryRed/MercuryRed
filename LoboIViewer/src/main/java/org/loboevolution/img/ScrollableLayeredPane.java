/*
 *
 *     GNU GENERAL LICENSE
 *     Copyright (C) 2014 - 2021 Lobo Evolution
 *
 *     This program is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU General Public
 *     License as published by the Free Software Foundation; either
 *     verion 3 of the License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     General License for more details.
 *
 *     You should have received a copy of the GNU General Public
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *     Contact info: ivan.difrancesco@yahoo.it
 *
 */
package org.loboevolution.img;

import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Rectangle;

import com.mercuryred.render.interfaces.uiplus.JLayeredPane;
import com.mercuryred.render.interfaces.uiplus.JViewport;
import com.mercuryred.render.interfaces.uiplus.Scrollable;

/**
 * <p>ScrollableLayeredPane class.</p>
 *
 *
 *
 */
public class ScrollableLayeredPane extends JLayeredPane implements Scrollable {
	
	private static final long serialVersionUID = 1L;
	private final transient LayeredImageView layeredImageView;
	

	/**
	 * <p>Constructor for ScrollableLayeredPane.</p>
	 *
	 * @param layeredImageView a {@link org.loboevolution.img.LayeredImageView} object.
	 */
	public ScrollableLayeredPane(LayeredImageView layeredImageView) {
		this.layeredImageView = layeredImageView;
	}

	/** {@inheritDoc} */
	@Override
	public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 10;
	}

	/** {@inheritDoc} */
	@Override
	public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
		return 50;
	}

	/*
	 * The getScrollableTracksViewportXxx functions below are used by
	 * com.mercuryred.render.interfaces.uiplus.ScrollPaneLayout to determine whether the scroll bars should be
	 * visible; so these need to be implemented.
	 */
	/** {@inheritDoc} */
	@Override
	public boolean getScrollableTracksViewportWidth() {
		return layeredImageView.getTheImage().getResizeStrategy() == ResizeStrategy.SHRINK_TO_FIT
				|| layeredImageView.getTheImage().getResizeStrategy() == ResizeStrategy.RESIZE_TO_FIT;
	}

	/** {@inheritDoc} */
	@Override
	public boolean getScrollableTracksViewportHeight() {
		return layeredImageView.getTheImage().getResizeStrategy() == ResizeStrategy.SHRINK_TO_FIT
				|| layeredImageView.getTheImage().getResizeStrategy() == ResizeStrategy.RESIZE_TO_FIT;
	}

	/*
	 * The getPreferredScrollableViewportSize does not seem to be used.
	 */
	/** {@inheritDoc} */
	@Override
	public Dimension getPreferredScrollableViewportSize() {
		if (layeredImageView.getTheImage().getResizeStrategy() == ResizeStrategy.NO_RESIZE)
			return getPreferredSize();
		else
			return javax.swing.SwingUtilities.getAncestorOfClass(JViewport.class, this).getSize();
	}
}
