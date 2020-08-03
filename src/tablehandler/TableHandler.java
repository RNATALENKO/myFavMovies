package tablehandler;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import guicomponents.SplitDisplay;

//Table handler will add a record to a jatable
//remove a record from jtable
//or clear the entire Jtable
//these methods will be called in the MovieButtonExeccutor class, when a button is clicked
public class TableHandler {
	
	
	//first get movie table 
	private JTable movieTable; 
	private DefaultTableModel dtm; 
	
	public TableHandler(SplitDisplay sd){
		movieTable = sd.getMovieTable();
		dtm = (DefaultTableModel) movieTable.getModel();
	}
	

	
	public void addRow(String[] row) {
		
		//add the row
		dtm.addRow(row);
		
		//notify listeners data structure changed, repaint or validate? 
		dtm.fireTableDataChanged();
	}
	
	
	
	

	
	public void deleteRow(int row) {
		
		dtm.removeRow(row); //removes row at selected index, which means you have to find the index where the row is located
		
		//notify listeners
	}
	
	
	
	
	public void deleteAllRows() {
		
		//get number of rows
		int rows = movieTable.getModel().getRowCount();
		
		//loop through length of Jtable, dtm.removeRow(RowIndex); 
		for(int rowIndex = 1; rowIndex < rows; rowIndex++) {
			dtm.removeRow(rowIndex);
		}
		
		//notify listeners
		
	
	}
	
	

}
