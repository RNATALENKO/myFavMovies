package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class ResultsConverter {
	
	public static String[][] convertToArray(ResultSet results, DataHandler dh) throws SQLException {

		int rows = 0; 
		int columns = 0; 
		String[][] array = null;
		int rowIndex = 0; 
		int columnIndex = 0; 
		int currentColumn = 1; 
		
		try {
			
			rows = dh.countNumberOfRows();
			columns = results.getMetaData().getColumnCount();
			array = new String[rows][columns];
			
			while(results.next()) {
				
				for(columnIndex = 0; columnIndex < columns; columnIndex++) {
					array[rowIndex][columnIndex] = results.getString(currentColumn);
					currentColumn++;
				}
				
				//increase row count
				rowIndex++;
				
				//forgot to reset the index and current column back to initial positions
				//therefore column index just kept increasing rather then resetting causing out of bounds
				columnIndex=0;
				currentColumn=1; 
			}
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return array; 
		
	}
}
