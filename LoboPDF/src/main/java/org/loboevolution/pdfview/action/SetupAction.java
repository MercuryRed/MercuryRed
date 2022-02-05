package org.loboevolution.pdfview.action;

import com.mercuryred.render.interfaces.ui.event.ActionEvent;

import com.mercuryred.render.interfaces.uiplus.AbstractAction;

import org.loboevolution.pdf.PDFViewer;

/**
 * <p>SetupAction class.</p>
 *
  *
  *
 */
public class SetupAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private final PDFViewer dialog;
	
	/**
	 * <p>Constructor for SetupAction.</p>
	 *
	 * @param dialog a {@link org.loboevolution.pdf.PDFViewer} object.
	 */
	public SetupAction(PDFViewer dialog) {
		super("Page setup...");
		this.dialog = dialog;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(final ActionEvent e) {
		dialog.doPageSetup();

	}
}
