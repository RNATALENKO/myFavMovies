package data;

import java.sql.ResultSet;
import java.sql.SQLException;

//this class will convert a resultset into a 2d array which will then be passed into the JTable to display results.
public class ResultsConverter {
	
	private ResultSet results; 
	private int numOfRows;
	private int numOfColumns; //gets column count of stored results
	private Object[][] ResultsArray = new Object[numOfRows][numOfColumns];
	
	
	public int getNumOfRows() {
		return numOfRows;
	}


	public void setNumOfRows(int numOfRows) {
		this.numOfRows = numOfRows;
	}


	public int getNumOfColumns() {
		return numOfColumns;
	}


	public void setNumOfColumns(ResultSet res) throws SQLException {
		this.numOfColumns = res.getMetaData().getColumnCount();
	}


	//inputs result set, outputs a 2D array
	public ResultSet getResults() {
		return results;
	}


	public void setResults(ResultSet results) {
		this.results = results;
	}


	public Object[][] getResultsArray() {
		return ResultsArray;
	}


	public void setResultsArray(Object[][] resultsArray) {
		ResultsArray = resultsArray;
	}


	public void get2DArray(ResultSet res) {
		
	}
	
	public static void main(String[] args) {
		
	}

}


//this class should manipulate and out put an array like this to represent records from a ResultSet

/*

String[][] fillerData = {
			{"Tarzan", "Adventure"},
			{"Batman Begins", "Action"},
			{"Tarzan", "Adventure"}
	};

*/