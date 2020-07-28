package data;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultsConverter {
	
	public static String[][] convertToArray(ResultSet results, DataHandler dh) throws SQLException {

		int rows = 0; 
		int columns = 0; 
		String[][] array = null;
		int rowIndex = 0; 
		int columnIndex = 1; 
		
		try {
			rows = dh.countNumberOfRows(results);
			columns = results.getMetaData().getColumnCount();
			array = new String[rows][columns];
		
			System.out.println(String.format("rows: %s", Integer.toString(rows)));
			System.out.println(String.format("colums: %s", Integer.toString(columns)));
			
			while(results.next()) {
				
				for(int x = 0; x < columns; x++) {
					array[rowIndex][columnIndex] = results.getString(columnIndex);
				}
				
				rowIndex++; 
				columnIndex++; 
			}
			
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return array; 
		
	}
	
	

}
