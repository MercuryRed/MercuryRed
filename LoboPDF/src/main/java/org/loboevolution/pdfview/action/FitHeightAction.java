package org.loboevolution.pdfview.action;

import com.mercuryred.render.interfaces.ui.event.ActionEvent;

import com.mercuryred.render.interfaces.uiplus.AbstractAction;

import org.loboevolution.pdf.PDFViewer;

/**
 * <p>FitHeightAction class.</p>
 *
  *
  *
 */
public class FitHeightAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private final PDFViewer dialog;
	
	/**
	 * <p>Constructor for FitHeightAction.</p>
	 *
	 * @param dialog a {@link org.loboevolution.pdf.PDFViewer} object.
	 */
	public FitHeightAction(PDFViewer dialog) {
		super("Fit Height", dialog.getIcon("/org/loboevolution/images/fit-height.png"));
		this.dialog = dialog;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(final ActionEvent e) {
		dialog.doFit(false, false);

	}
}
