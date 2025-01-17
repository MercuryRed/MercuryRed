/*
 * GNU GENERAL LICENSE
 * Copyright (C) 2014 - 2021 Lobo Evolution
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either
 * verion 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * General License for more details.
 *
 * You should have received a copy of the GNU General Public
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact info: ivan.difrancesco@yahoo.it
 */

package org.loboevolution.html.renderstate;

import org.loboevolution.html.dom.domimpl.HTMLElementImpl;
import org.loboevolution.html.style.HtmlInsets;
import org.loboevolution.html.style.HtmlValues;

public class UListRenderState extends BlockRenderState {

    /**
     * <p>Constructor for BlockRenderState.</p>
     *
     * @param prevRenderState a {@link RenderState} object.
     * @param element         a {@link HTMLElementImpl} object.
     */
    public UListRenderState(RenderState prevRenderState, HTMLElementImpl element) {
        super(prevRenderState, element);
    }

    @Override
    public int getDefaultDisplay() {
        return DISPLAY_LIST_ITEM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HtmlInsets getMarginInsets() {
        HtmlInsets insets = this.marginInsets;
        if (insets != INVALID_INSETS) {
            return insets;
        }
        insets = super.getMarginInsets();
        if (insets == null ||
                (insets.top == 0 && insets.bottom == 0 &&
                        insets.left == 0 && insets.right == 0)) {
            insets = getDefaultMarginInsets();
        }
        this.marginInsets = insets;
        return insets;
    }

    @Override
    public HtmlInsets getPaddingInsets() {
        HtmlInsets insets = this.paddingInsets;
        if (insets != INVALID_INSETS) {
            return insets;
        }
        insets = super.getPaddingInsets();
        if (insets == null ||
                (insets.top == 0 && insets.bottom == 0 &&
                        insets.left == 0 && insets.right == 0)) {
            insets = getDefaultPaddingInsets();
        }
        this.marginInsets = insets;
        return insets;
    }


    private HtmlInsets getDefaultMarginInsets() {
        HtmlInsets insets = new HtmlInsets();
        final int topBottom = HtmlValues.getPixelSize("1rem", null, element.getDocumentNode().getDefaultView(), -1);
        insets.top = topBottom;
        insets.bottom = topBottom;
        insets.topType = HtmlInsets.TYPE_PIXELS;
        insets.bottomType = HtmlInsets.TYPE_PIXELS;
        return insets;
    }

    private HtmlInsets getDefaultPaddingInsets() {
        HtmlInsets insets = new HtmlInsets();
        insets.left = HtmlValues.getPixelSize("40px", null, element.getDocumentNode().getDefaultView(), -1);
        insets.leftType = HtmlInsets.TYPE_PIXELS;
        return insets;
    }
}
