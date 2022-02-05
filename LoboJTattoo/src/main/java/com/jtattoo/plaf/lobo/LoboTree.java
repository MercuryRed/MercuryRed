package com.jtattoo.plaf.lobo;

import com.mercuryred.render.interfaces.ui.Component;
import com.mercuryred.render.interfaces.ui.Graphics;
import com.mercuryred.render.interfaces.ui.Rectangle;

import com.mercuryred.render.interfaces.uiplus.JLabel;
import com.mercuryred.render.interfaces.uiplus.JTree;
import com.mercuryred.render.interfaces.uiplus.tree.DefaultTreeCellRenderer;

/**
 * <p>LoboTree class.</p>
 *
 *
 *
 */
public class LoboTree extends JTree implements LoboLookAndFeel {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>Constructor for LoboTree.</p>
	 */
	public LoboTree() {
		setBackground(background());
		setForeground(foreground());
		setCellRenderer(new TreeCellRenderer());
	}

	/** {@inheritDoc} */
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRect(0, 0, getWidth(), getHeight());
		if (getSelectionCount() > 0) {
			g.setColor(foreground());
			for (int i : getSelectionRows()) {
				Rectangle r = getRowBounds(i);
				g.fillRect(r.x, r.y, getWidth() - r.x, r.height);
			}
		}
		super.paintComponent(g);
		if (getLeadSelectionPath() != null) {
			Rectangle r = getRowBounds(getRowForPath(getLeadSelectionPath()));
			g.setColor(hasFocus() ? foreground() : null);
			g.drawRect(r.x, r.y, getWidth() - r.x - 1, r.height - 1);
		}
	}

	class TreeCellRenderer extends DefaultTreeCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
				boolean leaf, int row, boolean hasFocus) {
			JLabel l = (JLabel) super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, false);
			l.setBackground(background());
			l.setForeground(foreground());
			l.setOpaque(true);
			return l;
		}
	}
}
