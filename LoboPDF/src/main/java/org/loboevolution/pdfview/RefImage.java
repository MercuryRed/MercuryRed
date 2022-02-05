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
package org.loboevolution.pdfview;

import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.Rectangle;
import com.mercuryred.render.interfaces.ui.image.BufferedImage;
import com.mercuryred.render.interfaces.ui.image.ColorModel;
import com.mercuryred.render.interfaces.ui.image.ImageObserver;
import com.mercuryred.render.interfaces.ui.image.ImageProducer;
import com.mercuryred.render.interfaces.ui.image.Raster;
import com.mercuryred.render.interfaces.ui.image.WritableRaster;
import com.mercuryred.utils.Nyi;

/**
 * A BufferedImage subclass that holds a strong reference to its graphics
 * object.  This means that the graphics will never go away as long as
 * someone holds a reference to this image, and createGraphics() and
 * getGraphics() can be called multiple times safely, and will always return
 * the same graphics object.
 *
  *
  *
 */
public class RefImage implements BufferedImage {

    /** a strong reference to the graphics object */
    private Graphics2D g;

    /**
     * Creates a new instance of RefImage
     *
     * @param width a int.
     * @param height a int.
     * @param type a int.
     */
    public RefImage(int width, int height, int type) {
        init(width, height, type);
    }

    private void init(int width, int height, int type) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    @Override
    public int getType() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public ColorModel getColorModel() {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public WritableRaster getRaster() {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public int getRGB(int x, int y) {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int[] getRGB(int startX, int startY, int w, int h, int[] rgbArray, int offset, int scansize) {
        throw Nyi.ReportNyi();
        // return new int[0];
    }

    @Override
    public int getWidth() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int getHeight() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int getWidth(ImageObserver observer) {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int getHeight(ImageObserver observer) {
        throw Nyi.ReportNyi();
        // return 0;
    }

    /**
	 * {@inheritDoc}
	 *
	 * Create a graphics object only if it is currently null, otherwise
	 * return the existing graphics object.
	 */
    @Override
	public Graphics2D createGraphics() {
        throw com.mercuryred.utils.Nyi.ReportNyi();
//        if (this.g == null) {
//            this.g = super.createGraphics();
//        }

        // return this.g;
    }

    @Override
    public BufferedImage getSubimage(int x, int y, int w, int h) {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public void coerceData(boolean isAlphaPremultiplied) {
        throw Nyi.ReportNyi();
        //
    }

    @Override
    public int getMinX() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public int getMinY() {
        throw Nyi.ReportNyi();
        // return 0;
    }

    @Override
    public Raster getData() {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public Raster getData(Rectangle rect) {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public Graphics getGraphics() {
        throw Nyi.ReportNyi();
        // return null;
    }

    @Override
    public void flush() {
        throw Nyi.ReportNyi();
        //
    }

    @Override
    public ImageProducer getSource() {
        throw Nyi.ReportNyi();
        // return null;
    }
}
