/**
 * @author tinarambo
 * 
 */
package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Table extends JPanel {

	public Table() {
		super(new GridLayout(1, 0));

		JTable table = new JTable(new TableModel());
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		table.setFillsViewportHeight(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);

		// Add the scroll pane to this panel.
		add(scrollPane);
	}
}
