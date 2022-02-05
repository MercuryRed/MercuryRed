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

import com.mercuryred.render.interfaces.ui.Container;
import com.mercuryred.render.interfaces.ui.Window;
import com.mercuryred.render.interfaces.ui.event.WindowAdapter;
import com.mercuryred.render.interfaces.ui.event.WindowEvent;
import com.mercuryred.render.interfaces.ui.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.mercuryred.render.interfaces.uiplus.Icon;
import com.mercuryred.render.interfaces.uiplus.JComponent;
import com.mercuryred.render.interfaces.uiplus.JDesktopPane;
import com.mercuryred.render.interfaces.uiplus.JInternalFrame;
import com.mercuryred.render.interfaces.uiplus.LookAndFeel;
import com.mercuryred.render.interfaces.uiplus.SwingUtilities;
import com.mercuryred.render.interfaces.uiplus.UIManager;
import com.mercuryred.render.interfaces.uiplus.border.Border;
import com.mercuryred.render.interfaces.uiplus.border.EmptyBorder;
import com.mercuryred.render.interfaces.uiplus.plaf.ComponentUI;
import com.mercuryred.render.interfaces.uiplus.plaf.UIResource;
import com.mercuryred.render.interfaces.uiplus.plaf.basic.BasicInternalFrameUI;

/**
 * <p>BaseInternalFrameUI class.</p>
 *
 *
 *
 */
public class BaseInternalFrameUI extends BasicInternalFrameUI {

	// -----------------------------------------------------------------------------
// inner classes
//-----------------------------------------------------------------------------
	private static class MyPropertyChangeHandler implements PropertyChangeListener {

		@Override
		public void propertyChange(PropertyChangeEvent e) {
			JInternalFrame jif = (JInternalFrame) e.getSource();
			if (!(jif.getUI() instanceof BaseInternalFrameUI)) {
				return;
			}

			BaseInternalFrameUI ui = (BaseInternalFrameUI) jif.getUI();
			String name = e.getPropertyName();
			if (name.equals(FRAME_TYPE)) {
				if (e.getNewValue() instanceof String) {
					if (PALETTE_FRAME.equals(e.getNewValue())) {
						LookAndFeel.installBorder(ui.frame, FRAME_PALETTE_BORDER);
						ui.setPalette(true);
					} else {
						LookAndFeel.installBorder(ui.frame, FRAME_BORDER);
						ui.setPalette(false);
					}
				}
			} else if (name.equals(IS_PALETTE)) {
				if (e.getNewValue() != null) {
					ui.setPalette((Boolean) e.getNewValue());
				} else {
					ui.setPalette(false);
				}
			} else if (name.equals(JInternalFrame.CONTENT_PANE_PROPERTY)) {
				ui.stripContentBorder();
			} else if (name.equals("ancestor") && !AbstractLookAndFeel.isWindowDecorationOn()) {
				if (e.getNewValue() instanceof JDesktopPane) {
					JDesktopPane jp = (JDesktopPane) e.getNewValue();
					Window window = SwingUtilities.getWindowAncestor(jp);
					if (window != null) {
						boolean doAdd = true;
						for (WindowListener wl : window.getWindowListeners()) {
							if (wl.equals(MY_WINDOW_HANDLER)) {
								doAdd = false;
								break;
							}
						}
						if (doAdd) {
							window.addWindowListener(MY_WINDOW_HANDLER);
						}
					}
				} else if (e.getOldValue() instanceof JDesktopPane) {
					JDesktopPane jp = (JDesktopPane) e.getOldValue();
					Window window = SwingUtilities.getWindowAncestor(jp);
					if (window != null) {
						window.removeWindowListener(MY_WINDOW_HANDLER);
					}
				}
			}
		}
	} // end of class MyPropertyChangeHandler
		// -----------------------------------------------------------------------------

	private static class MyWindowHandler extends WindowAdapter {

		@Override
		public void windowActivated(WindowEvent e) {
			e.getWindow().invalidate();
			e.getWindow().repaint();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			e.getWindow().invalidate();
			e.getWindow().repaint();
		}
	} // end of class MyWindowHandler

	private static final PropertyChangeListener MY_PROPERTY_CHANGE_HANDLER = new MyPropertyChangeHandler();

	private static final WindowAdapter MY_WINDOW_HANDLER = new MyWindowHandler();
	private static final Border HANDY_EMPTY_BORDER = new EmptyBorder(0, 0, 0, 0);
	private static final String IS_PALETTE = "JInternalFrame.isPalette";
	private static final String FRAME_TYPE = "JInternalFrame.frameType";
	private static final String FRAME_BORDER = "InternalFrame.border";

	private static final String FRAME_PALETTE_BORDER = "InternalFrame.paletteBorder";

	private static final String PALETTE_FRAME = "palette";

	/** {@inheritDoc} */
	public static ComponentUI createUI(final JComponent c) {
		return new BaseInternalFrameUI((JInternalFrame) c);
	}

	/**
	 * <p>Constructor for BaseInternalFrameUI.</p>
	 *
	 * @param b a {@link com.mercuryred.render.interfaces.uiplus.JInternalFrame} object.
	 */
	public BaseInternalFrameUI(JInternalFrame b) {
		super(b);
	}

	/** {@inheritDoc} */
	@Override
	protected JComponent createNorthPane(JInternalFrame w) {
		return new BaseInternalFrameTitlePane(w);
	}

	/**
	 * <p>getTitlePane.</p>
	 *
	 * @return a {@link com.jtattoo.plaf.BaseInternalFrameTitlePane} object.
	 */
	public BaseInternalFrameTitlePane getTitlePane() {
		return (BaseInternalFrameTitlePane) titlePane;
	}

	/** {@inheritDoc} */
	@Override
	protected void installDefaults() {
		super.installDefaults();
		Icon frameIcon = frame.getFrameIcon();
		if (frameIcon == null || frameIcon instanceof LazyImageIcon) {
			frame.setFrameIcon(UIManager.getIcon("InternalFrame.icon"));
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void installListeners() {
		super.installListeners();
		frame.addPropertyChangeListener(MY_PROPERTY_CHANGE_HANDLER);
	}

	/** {@inheritDoc} */
	@Override
	public void installUI(JComponent c) {
		super.installUI(c);
		Object paletteProp = c.getClientProperty(IS_PALETTE);
		if (paletteProp != null) {
			setPalette((Boolean) paletteProp);
		}
		stripContentBorder();
	}

	/**
	 * <p>setPalette.</p>
	 *
	 * @param isPalette a boolean.
	 */
	public void setPalette(boolean isPalette) {
		if (isPalette) {
			frame.setBorder(UIManager.getBorder(FRAME_PALETTE_BORDER));
		} else {
			frame.setBorder(UIManager.getBorder(FRAME_BORDER));
		}
		getTitlePane().setPalette(isPalette);
	}

	/**
	 * <p>stripContentBorder.</p>
	 */
	public void stripContentBorder() {
		Container cp = frame.getContentPane();
		if (cp instanceof JComponent) {
			JComponent contentPane = (JComponent) cp;
			Border contentBorder = contentPane.getBorder();
			if (contentBorder == null || contentBorder instanceof UIResource) {
				contentPane.setBorder(HANDY_EMPTY_BORDER);
			}
		}
	}

	/** {@inheritDoc} */
	@Override
	protected void uninstallComponents() {
		titlePane = null;
		super.uninstallComponents();
	}

	/** {@inheritDoc} */
	@Override
	protected void uninstallListeners() {
		frame.removePropertyChangeListener(MY_PROPERTY_CHANGE_HANDLER);
		super.uninstallListeners();
	}

	/** {@inheritDoc} */
	@Override
	public void uninstallUI(JComponent c) {
		Container cp = frame.getContentPane();
		if (cp instanceof JComponent) {
			JComponent contentPane = (JComponent) cp;
			if (contentPane.getBorder() == HANDY_EMPTY_BORDER) {
				contentPane.setBorder(null);
			}
		}
		super.uninstallUI(c);
	}

} // end of class BaseInternalFrameUI
