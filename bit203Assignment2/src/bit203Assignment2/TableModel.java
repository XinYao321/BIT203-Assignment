package bit203Assignment2;

import javax.swing.table.AbstractTableModel;

// Date: 7th April 2023

/*Table Model class*/

// @author: Lee Xin Yao B2100617
public class TableModel extends AbstractTableModel{
	private Object[][] data = {};
	  private String[] columnNames = {};
	  private Class[] columnClass = {};
	  private Object[][] rowData = new Object[][] {};
	
	public TableModel() {
	  }
	
	public int getRowCount() {
	    return rowData.length;
	  }

	  public int getColumnCount() {
	    return columnNames.length;
	  }

	  public String getColumnName(int columnIndex) {
	    return columnNames[columnIndex];
	  }

	  
	  public Class getColumnClass(int columnIndex) {
	    return columnClass[columnIndex];
	  }

	  
	  public boolean isCellEditable(int rowIndex, int columnIndex) {
	    boolean isEditable = true;
	    if (columnIndex == 0) {
	      isEditable = false; // Make the ID column non-editable
	    }
	    return isEditable;
	  }

	  
	  public Object getValueAt(int rowIndex, int columnIndex) {
	    return rowData[rowIndex][columnIndex];
	  }

	  
	  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	    rowData[rowIndex][columnIndex] = aValue;
	  }
}
