/*
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.loboevolution.pdf;

import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.Font;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Image;
import com.mercuryred.render.interfaces.ui.Insets;
import com.mercuryred.render.interfaces.ui.MenuComponent;
import com.mercuryred.render.interfaces.ui.Point;
import com.mercuryred.render.interfaces.ui.PopupMenu;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.event.MouseEvent;
import com.mercuryred.render.interfaces.ui.event.MouseListener;
import com.mercuryred.render.interfaces.ui.image.ImageObserver;

import com.mercuryred.render.interfaces.uiplus.JPanel;

import com.mercuryred.render.interfaces.uiplus.border.Border;
import org.loboevolution.pdfview.PDFPage;

/**
 * A Swing-based panel that displays a PDF page image.  If the zoom tool
 * is in use, allows the user to select a particular region of the image to
 * be zoomed.
 *
  *
  *
 */
public class PagePanel implements JPanel, ImageObserver, MouseListener {

	
	private static final long serialVersionUID = 1L;
	
	/** The image of the rendered PDF page being displayed */
	private Image image;
	
	/** The current PDFPage that was rendered into image */
	private PDFPage page;
	
	/** The horizontal offset of the image from the left edge of the panel */
	private int offx;
	
	/** The vertical offset of the image from the top of the panel */
	int offy;
	
	/** the size of the image */
	private Dimension size;

	/** a flag indicating whether the current page is done or not. */
	private final Flag flag = new Flag();

	/**
	 * Create a new PDFPanel, with a default size of 800 by 600 pixels.
	 */
	public PagePanel() {
		setPreferredSize(new Dimension(800, 600));
		setFocusable(true);
		addMouseListener(this);
   }

	private void addMouseListener(PagePanel pagePanel) {
	}

	private void setFocusable(boolean b) {
	}

	/**
	 * Stop the generation of any previous page, and draw the new one.
	 *
	 * @param page the PDFPage to draw.
	 */
	public synchronized void showPage(PDFPage page) {
		// stop drawing the previous page
		if (page != null && size != null) {
			page.stop(size.width, size.height, null);
		}

		// set up the new page
		this.page = page;

		if (page == null) {
			// no page
			image = null;
			repaint();
		} else {
			flag.clear();

			// image should fit preferred size
			// image should fit size if panel is smaller than preferred size
			int width  = Math.min(getPreferredSize().width,  getSize().width );
			int height = Math.min(getPreferredSize().height, getSize().height);

			if (width + height > 0) {
				this.size = page.getUnstretchedSize(width, height, null);
				this.image = page.getImage(size.width, size.height, null, this);
				repaint();
			}
		}
	}

	private Dimension getSize() {
		throw com.mercuryred.utils.Nyi.ReportNyi();
	}

	/** {@inheritDoc} */
	public void setPreferredSize(Dimension size) {
		// todo store prefered size
//		if (super.getPreferredSize() != size) {
//			super.setPreferredSize(size);
			this.image = null;
			this.size = null;
			repaint();
//		}
	}

	/**
	 * <p>getPreferredSize.</p>
	 *
	 * @return a {@link com.mercuryred.render.interfaces.ui.Dimension} object.
	 */
	public Dimension getPreferredSize() {
		// todo
		throw com.mercuryred.utils.Nyi.ReportNyi();
//		return size == null
//				? super.getPreferredSize()
//				: this.size;
	}

	@Override
	public void setBorder(Border border) {

	}

	@Override
	public Insets getInsets() {
		return null;
	}

	@Override
	public Insets getInsets(Insets insets) {
		return null;
	}

	@Override
	public void setFont(Font font) {

	}

	@Override
	public Point getPopupLocation(MouseEvent event) {
		return null;
	}

	@Override
	public int getWidth() {
		return 0;
	}

	@Override
	public void repaint(long tm, int x, int y, int width, int height) {

	}

	@Override
	public void repaint(Rectangle r) {

	}

	@Override
	public void revalidate() {

	}

	@Override
	public Component add(Component comp) {
		return null;
	}

	@Override
	public Component add(String name, Component comp) {
		return null;
	}

	@Override
	public Component add(Component comp, int index) {
		return null;
	}

	@Override
	public void add(Component comp, Object constraints) {

	}

	@Override
	public void add(Component comp, Object constraints, int index) {

	}

	@Override
	public void remove(int index) {

	}

	@Override
	public void remove(Component comp) {

	}

	@Override
	public Container getParent() {
		return null;
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {

	}

	@Override
	public void setBounds(Rectangle r) {

	}

	@Override
	public void repaint() {

	}

	@Override
	public void repaint(long tm) {

	}

	@Override
	public void repaint(int x, int y, int width, int height) {

	}

	@Override
	public void add(PopupMenu popup) {

	}

	@Override
	public void remove(MenuComponent popup) {

	}


	/**
	 * {@inheritDoc}
	 *
	 * Draw the image.
	 */
	public void paint(final Graphics g) {
		Dimension sz = getSize();
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (image == null) {
			if (page == null) {
				g.setColor(Color.BLACK);
				g.drawString("No page selected", getWidth() / 2 - 30, getHeight() / 2);
			}
			else {
				showPage(page);
			}
		} else {
			// draw the image
			int imageWidth  = image.getWidth (null);
			int imageHeight = image.getHeight(null);

			if (imageWidth <= sz.width && imageHeight <= sz.height) {
				// draw it centered within the panel
				this.offx = (sz.width  - imageWidth ) / 2;
				this.offy = (sz.height - imageHeight) / 2;
				g.drawImage(image, offx, offy, this);

			} else {
				// the image size is wrong.  try again, or give up.
				if (page != null) {
					showPage(page);
				}
			}
		}
	}

	private int getHeight() {
		throw com.mercuryred.utils.Nyi.ReportNyi();
	}

	private Color getBackground() {
		throw com.mercuryred.utils.Nyi.ReportNyi();
	}

	/**
	 * Gets the page currently being displayed
	 *
	 * @return a {@link org.loboevolution.pdfview.PDFPage} object.
	 */
	public PDFPage getPage() {
		return page;
	}

	/**
	 * Gets the size of the image currently being displayed
	 *
	 * @return a {@link com.mercuryred.render.interfaces.ui.Dimension} object.
	 */
	public Dimension getCurSize() {
		return size;
	}

	/**
	 * Waits until the page is either complete or had an error.
	 */
	public void waitForCurrentPage() {
		flag.waitForFlag();
	}

	/**
	 * {@inheritDoc}
	 *
	 * Handles notification of the fact that some part of the image
	 * changed.  Repaints that portion.
	 */
	public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) {
		// TODO handle this
//		if ((infoflags & (SOMEBITS | ALLBITS)) != 0) {
			repaint(x + offx, y + offy, width, height);
//		}
//		if ((infoflags & (ALLBITS | ERROR | ABORT)) != 0) {
//			flag.set();
			return false;
//		} else {
//			return true;
//		}
	}

	/** {@inheritDoc} */
	public void mouseClicked(final MouseEvent e) {
		requestFocus();
	}

	private void requestFocus() {
		throw com.mercuryred.utils.Nyi.ReportNyi();
	}

	/** {@inheritDoc} */
	public void mouseEntered(final MouseEvent e) {}
	/** {@inheritDoc} */
	public void mouseExited(final MouseEvent e) {}
	/** {@inheritDoc} */
	public void mousePressed(final MouseEvent e) {}
	/** {@inheritDoc} */
	public void mouseReleased(final MouseEvent e) {}

}
