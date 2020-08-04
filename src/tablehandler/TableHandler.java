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
		dtm.fireTableDataChanged();
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
	
	
	//method that will find the row based on a given value
	//the issue here was that I was comparing not the contents but the rather the reference by not using the equals() method
	//needs validation for a non existing movie name, otherwise if movieName doesn't exist, row will continue to be returned as 0 
	public int getRow(String movieName) {
	
		int row = 0; 
		
		for(int x = 0; x < dtm.getRowCount(); x++) {
			 
			if(dtm.getValueAt(x, 1).equals(movieName)) {
				row = x; 
				break;
				
			}
			else {
				System.out.println(dtm.getValueAt(x, 1));
			}
			
		}
		
		//System.out.println(dtm.getValueAt(0, 1)); this will print the 2nd coloumn, 1st row value which is Tarzan
		
		return row; 
		
	}
	
	
	//method that checks if table value exists
	public boolean valueExists(String movieName) {
		
		for(int x = 0; x < dtm.getRowCount(); x++) {
			if(dtm.getValueAt(x, 1).equals(movieName)) {
				return true; 
			}
		}
		return false; 
	}

}
