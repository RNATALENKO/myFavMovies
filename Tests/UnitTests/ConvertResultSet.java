package UnitTests;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import data.DataHandler;
import data.DataManager;
import data.ResultsConverter;


public class ConvertResultSet {

	DataHandler dh; 
	DataManager dm; 
	ResultSet allRecords; 
	int count = 0; 
	

	//create objects, get records, print what's in current database
	@Before
	public void setup() {
		dm = new DataManager(); 
		dh = new DataHandler(dm); 
		
		//gets records, prints database info
		try {
			allRecords = dh.getAllRecords();
			
			dh.printDatabaseInfo();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testing the row count method
	@Test
	public void test() {
		
		try {
			
			//allRecords = dh.getAllRecords();
			ResultSet allRecords = dh.getAllRecords();
		
			//need to fix results converter method, since it's not properly storing values in the correct index
			//convert result set to 2d array
			String[][] myString = ResultsConverter.convertToArray(allRecords, dh);
			
			
			//print the 2d array values
			for(int x= 0; x < dh.countNumberOfRows(); x++) {
				
				for(int y = 0; y < 3; y++) {
					System.out.print(myString[x][y] + " " );
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//the objects after each test run
	@After
	public void destroy() {
		dh = null;
		dm = null; 
	}
}