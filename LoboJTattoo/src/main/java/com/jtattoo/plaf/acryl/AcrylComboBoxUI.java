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

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;

import com.jtattoo.plaf.AbstractLookAndFeel;
import com.jtattoo.plaf.BaseComboBoxUI;
import com.jtattoo.plaf.ColorHelper;
import com.jtattoo.plaf.JTattooUtilities;

/**
 * <p>AcrylComboBoxUI class.</p>
 *
 * Author Michael Hagen
 *
 */
public class AcrylComboBoxUI extends BaseComboBoxUI {

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new AcrylComboBoxUI();
	}

	/** {@inheritDoc} */
	@Override
	public JButton createArrowButton() {
		ArrowButton button = new BaseComboBoxUI.ArrowButton();
		Color borderColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 50);
		if (JTattooUtilities.isLeftToRight(comboBox)) {
			Border border = BorderFactory.createMatteBorder(0, 1, 0, 0, borderColor);
			button.setBorder(border);
		} else {
			Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, borderColor);
			button.setBorder(border);
		}
		return button;
	}

	/** {@inheritDoc} */
	@Override
	protected void setButtonBorder() {
		Color borderColor = ColorHelper.brighter(AbstractLookAndFeel.getTheme().getFrameColor(), 50);
		if (JTattooUtilities.isLeftToRight(comboBox)) {
			Border border = BorderFactory.createMatteBorder(0, 1, 0, 0, borderColor);
			arrowButton.setBorder(border);
		} else {
			Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, borderColor);
			arrowButton.setBorder(border);
		}
	}

} // end of class AcrylComboBoxUI
