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

import com.mercuryred.render.interfaces.ui.AlphaComposite;
import com.mercuryred.render.interfaces.ui.Color;
import com.mercuryred.render.interfaces.ui.Composite;
import com.mercuryred.render.interfaces.ui.Dimension;
import com.mercuryred.render.interfaces.ui.FontMetrics;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Graphics2D;
import com.mercuryred.render.interfaces.ui.event.FocusEvent;
import com.mercuryred.render.interfaces.ui.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.mercuryred.render.interfaces.uiplus.BorderFactory;
import com.mercuryred.render.interfaces.uiplus.Icon;
import com.mercuryred.render.interfaces.uiplus.JButton;
import com.mercuryred.render.interfaces.uiplus.JComponent;
import com.mercuryred.render.interfaces.uiplus.JTextField;
import com.mercuryred.render.interfaces.uiplus.LookAndFeel;
import com.mercuryred.render.interfaces.uiplus.UIManager;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.uiplus.plaf.ComponentUI;
import com.mercuryred.render.interfaces.uiplus.plaf.UIResource;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicComboBoxUI;

/**
 * <p>BaseComboBoxUI class.</p>
 *
 *
 *
 */
public class BaseComboBoxUI extends BasicComboBoxUI {

	public static class ArrowButton extends NoFocusButton {

		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(final Graphics g) {
			Dimension size = getSize();
			Color[] colors;
			if (isEnabled()) {
				if (getModel().isArmed() && getModel().isPressed()) {
					colors = AbstractLookAndFeel.getTheme().getPressedColors();
				} else if (getModel().isRollover()) {
					colors = AbstractLookAndFeel.getTheme().getRolloverColors();
				} else {
					colors = AbstractLookAndFeel.getTheme().getButtonColors();
				}
			} else {
				colors = AbstractLookAndFeel.getTheme().getDisabledColors();
			}
			JTattooUtilities.fillHorGradient(g, colors, 0, 0, size.width, size.height);

			boolean inverse = ColorHelper.getGrayValue(colors) < 128;

			Icon icon = inverse ? BaseIcons.getComboBoxInverseIcon() : BaseIcons.getComboBoxIcon();
			int x = (size.width - icon.getIconWidth()) / 2;
			int y = (size.height - icon.getIconHeight()) / 2;

			Graphics2D g2D = (Graphics2D) g;
			Composite savedComposite = g2D.getComposite();
			g2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));
			if (getModel().isPressed() && getModel().isArmed()) {
				icon.paintIcon(this, g, x + 2, y + 1);
			} else {
				icon.paintIcon(this, g, x + 1, y);
			}
			g2D.setComposite(savedComposite);
			paintBorder(g2D);

		}
	}

	public class PropertyChangeHandler implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			String name = e.getPropertyName();
			if (name.equals("componentOrientation")) {
				setButtonBorder();
			}
		}
	}

//-----------------------------------------------------------------------------    
	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new BaseComboBoxUI();
	}

	private PropertyChangeListener myPpropertyChangeListener = null;

	private FocusListener myFocusListener = null;

	private Border orgBorder = null;

	private Color orgBackgroundColor = null;

	/** {@inheritDoc} */
	@Override
	public JButton createArrowButton() {
		JButton button = new ArrowButton();
		if (JTattooUtilities.isLeftToRight(comboBox)) {
			Border border = BorderFactory.createMatteBorder(0, 1, 0, 0, AbstractLookAndFeel.getFrameColor());
			button.setBorder(border);
		} else {
			Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, AbstractLookAndFeel.getFrameColor());
			button.setBorder(border);
		}
		return button;
	}

	/** {@inheritDoc} */
	@Override
	public Dimension getPreferredSize(JComponent c) {
		Dimension size = super.getPreferredSize(c);
		if (comboBox.getGraphics() != null) {
			FontMetrics fm = JTattooUtilities.getFontMetrics(comboBox, comboBox.getGraphics(), comboBox.getFont());
			size.height = fm.getHeight() + 2;
			if (UIManager.getLookAndFeel() instanceof AbstractLookAndFeel) {
				AbstractLookAndFeel laf = (AbstractLookAndFeel) UIManager.getLookAndFeel();
				size.height = Math.max(size.height, laf.getIconFactory().getDownArrowIcon().getIconHeight() + 2);
			}
		}
		return new Dimension(size.width + 2, size.height + 2);
	}

	/** {@inheritDoc} */
	@Override
	protected void installListeners() {
		super.installListeners();
		myPpropertyChangeListener = new PropertyChangeHandler();
		comboBox.addPropertyChangeListener(myPpropertyChangeListener);

		if (AbstractLookAndFeel.getTheme().doShowFocusFrame()) {
			myFocusListener = new FocusListener() {

				@Override
				public void focusGained(FocusEvent e) {
					if (comboBox != null) {
						orgBorder = comboBox.getBorder();
						orgBackgroundColor = comboBox.getBackground();
						LookAndFeel laf = UIManager.getLookAndFeel();
						if (laf instanceof AbstractLookAndFeel) {
							if (orgBorder instanceof UIResource) {
								Border focusBorder = ((AbstractLookAndFeel) laf).getBorderFactory()
										.getFocusFrameBorder();
								comboBox.setBorder(focusBorder);
							}
							Color backgroundColor = AbstractLookAndFeel.getTheme().getFocusBackgroundColor();
							comboBox.setBackground(backgroundColor);
						}
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (comboBox != null) {
						if (orgBorder instanceof UIResource) {
							comboBox.setBorder(orgBorder);
						}
						comboBox.setBackground(orgBackgroundColor);
					}
				}
			};
			comboBox.addFocusListener(myFocusListener);
		}
	}

	/** {@inheritDoc} */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		comboBox.setRequestFocusEnabled(true);
		comboBox.setLightWeightPopupEnabled(false);
		if (comboBox.getEditor() != null) {
			if (comboBox.getEditor().getEditorComponent() instanceof JTextField) {
				((JTextField) comboBox.getEditor().getEditorComponent())
						.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
			}
		}
	}

	/**
	 * <p>setButtonBorder.</p>
	 */
	protected void setButtonBorder() {
		if (JTattooUtilities.isLeftToRight(comboBox)) {
			Border border = BorderFactory.createMatteBorder(0, 1, 0, 0, AbstractLookAndFeel.getFrameColor());
			arrowButton.setBorder(border);
		} else {
			Border border = BorderFactory.createMatteBorder(0, 0, 0, 1, AbstractLookAndFeel.getFrameColor());
			arrowButton.setBorder(border);
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void uninstallListeners() {
		comboBox.removePropertyChangeListener(myPpropertyChangeListener);
		comboBox.removeFocusListener(myFocusListener);
		myPpropertyChangeListener = null;
		myFocusListener = null;
		super.uninstallListeners();
	}

} // end of class BaseComboBoxUI
