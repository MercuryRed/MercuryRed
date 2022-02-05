package org.loboevolution.pdfview.action;

import com.mercuryred.render.interfaces.ui.event.ActionEvent;

import com.mercuryred.render.interfaces.uiplus.AbstractAction;

import org.loboevolution.pdf.PDFViewer;

/**
 * <p>FitAction class.</p>
 *
  *
  *
 */
public class FitAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private final PDFViewer dialog;
	
	/**
	 * <p>Constructor for FitAction.</p>
	 *
	 * @param dialog a {@link org.loboevolution.pdf.PDFViewer} object.
	 */
	public FitAction(PDFViewer dialog) {
		super("Fit", dialog.getIcon("/org/loboevolution/images/fit.png"));
		this.dialog = dialog;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(final ActionEvent e) {
		dialog.doFit(true, true);

	}
}
