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

import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.Paint;
import com.mercuryred.render.interfaces.ui.geom.GeneralPath;
import com.mercuryred.render.interfaces.ui.geom.Rectangle2D;

/**
 * PDFPaint is some kind of shader that knows how to fill a path.
 * At the moment, only a solid color is implemented, but gradients
 * and textures should be possible, too.
 *
 * Author Mike Wessler
  *
 */
public class PDFPaint {

    private final Paint mainPaint;

    /**
     * create a new PDFPaint based on a solid color
     *
     * @param p a {@link com.mercuryred.render.interfaces.ui.Paint} object.
     */
    protected PDFPaint(Paint p) {
        this.mainPaint = p;
    }

    /**
     * get the PDFPaint representing a solid color
     *
     * @param c a {@link com.mercuryred.render.interfaces.ui.color} object.
     * @return a {@link org.loboevolution.pdfview.PDFPaint} object.
     */
    public static PDFPaint getColorPaint(Color c) {
        return getPaint(c);
    }

    public static PDFPaint getPaint(Color c) {
        throw com.mercuryred.utils.Nyi.ReportNyi();
    }

    /**
     * get the PDFPaint representing a generic paint
     *
     * @param p a {@link com.mercuryred.render.interfaces.ui.Paint} object.
     * @return a {@link org.loboevolution.pdfview.PDFPaint} object.
     */
    public static PDFPaint getPaint(Paint p) {
        return new PDFPaint(p);
    }

    /**
     * fill a path with the paint, and record the dirty area.
     *
     * @param state the current graphics state
     * @param g the graphics into which to draw
     * @param s the path to fill
     * @return a {@link com.mercuryred.render.interfaces.ui.geom.Rectangle2D} object.
     */
    public Rectangle2D fill(PDFRenderer state, Graphics2D g,
            GeneralPath s) {
        g.setPaint(this.mainPaint);
        g.fill(s);

        return s.createTransformedShape(g.getTransform()).getBounds2D();
    }

    /**
     * get the primary color associated with this PDFPaint.
     *
     * @return a {@link com.mercuryred.render.interfaces.ui.Paint} object.
     */
    public Paint getPaint() {
        return this.mainPaint;
    }
}
