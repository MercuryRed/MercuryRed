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
package org.loboevolution.html.dom.domimpl;

import org.loboevolution.html.renderstate.FontStyleRenderState;
import org.loboevolution.html.renderstate.RenderState;
import org.loboevolution.laf.LAFType;

/**
 * Element used for TT and CODE.
 */
public class HTMLMonospacedElementImpl extends HTMLElementImpl {
	/**
	 * <p>Constructor for HTMLMonospacedElementImpl.</p>
	 *
	 * @param name a {@link java.lang.String} object.
	 */
	public HTMLMonospacedElementImpl(final String name) {
		super(name);
	}

	/** {@inheritDoc} */
	@Override
	protected RenderState createRenderState(RenderState prevRenderState) {
        return new FontStyleRenderState(prevRenderState, this, LAFType.MONOSPACED);
	}
	
	/** {@inheritDoc} */
	@Override
	public String toString() {
		return "[object HTMLMonospacedElement]";
	}
}
