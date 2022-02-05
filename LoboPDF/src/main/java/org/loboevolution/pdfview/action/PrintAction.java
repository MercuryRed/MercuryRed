package org.loboevolution.pdfview.action;

import com.mercuryred.render.interfaces.ui.event.ActionEvent;

import com.mercuryred.render.interfaces.uiplus.AbstractAction;

import org.loboevolution.pdf.PDFViewer;

/**
 * <p>PrintAction class.</p>
 *
  *
  *
 */
public class PrintAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	private final PDFViewer dialog;
	
	/**
	 * <p>Constructor for PrintAction.</p>
	 *
	 * @param dialog a {@link org.loboevolution.pdf.PDFViewer} object.
	 */
	public PrintAction(PDFViewer dialog) {
		super("Print...", dialog.getIcon("/org/loboevolution/images/print.png"));
		this.dialog = dialog;
	}

	/** {@inheritDoc} */
	@Override
	public void actionPerformed(final ActionEvent e) {
		dialog.doPrint();

	}
}
