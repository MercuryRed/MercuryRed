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
package com.jtattoo.plaf.fast;

import java.awt.Graphics;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseSplitPaneDivider;

/**
 * <p>FastSplitPaneDivider class.</p>
 *
 * Author Michael Hagen
 *
 */
public class FastSplitPaneDivider extends BaseSplitPaneDivider {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for FastSplitPaneDivider.</p>
	 *
	 * @param ui a {@link com.jtattoo.plaf.fast.FastSplitPaneUI} object.
	 */
	public FastSplitPaneDivider(FastSplitPaneUI ui) {
		super(ui);
	}

	/** {@inheritDoc} */
	@Override
	public void paint(final Graphics g) {
		g.setColor(AbstractLookAndFeel.getBackgroundColor());
		g.fillRect(0, 0, getSize().width, getSize().height);
		paintComponents(g);
	}

} // end of class FastSplitPaneDivider
