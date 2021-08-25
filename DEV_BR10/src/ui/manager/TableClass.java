package ui.manager;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class TableClass extends AbstractTableModel{

	private ArrayList product;
	
	public TableClass(ArrayList product) {
		this.product = new ArrayList(product);
	}
	
	@Override
	public int getRowCount() {
		return product.size();
	}

	@Override
	public int getColumnCount() {
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return null;
	}

}
