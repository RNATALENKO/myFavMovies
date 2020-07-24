package data;

import java.sql.ResultSet;
import java.sql.SQLException;

//this class will convert a resultset into a 2d array which will then be passed into the JTable to display results.
public class ResultsConverter {
	
	public static void resultsToArray(ResultSet res) throws SQLException {
		//int numOfColumns = res.getMetaData().getColumnCount();
		int numOfRows = 0; 
		//Object[][] resultsArray = new Object[numOfRows][numOfColumns];
		
		
		//count number of rows
		while(res.next()) {
			numOfRows++;
		}
		
		System.out.println(numOfRows);
		
		
		
		//return resultsArray;
	}
	
}



