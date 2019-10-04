/**
 * @author tinarambo
 * 
 */
package gui;

import javax.swing.table.AbstractTableModel;
import tsp.Test;

public class TableModel extends AbstractTableModel {

	Test t = new Test();

	private String[] columnNames = { "Initial Method", "Tour length", "Optimizer Method", "Tour length", "Diff", "%" };
	private Object[][] data = {
			{ "Random", t.drm, "Greedy Impro", t.dgirm, t.dgirm - t.drm, inPercent(t.drm, t.dgirm) + "%" },
			{ "Iterative Random", "T", "Greedy Impro", "T", "D", "%" },
			{ "Greedy", "T", "Greedy Impro", "T", "D", "%" }, { "Random", "T", "Greedy Random", "T", "D", "%" },
			{ "Iterative Random", "T", "Greedy Random", "T", "D", "%" },
			{ "Greedy", "T", "Greedy Random", "T", "D", "%" } };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	private double inPercent(int a, int b) {
		double x = (double) Math.abs(b - a);
		if (x > 0) {
			return (x / a) * 100;
		} else {
			return 0.0;
		}
	}

}
