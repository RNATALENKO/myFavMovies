package UnitTests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DataHandler;
import data.DataManager;

public class getColumnNames {

	DataHandler dh; 
	DataManager dm; 
	ResultSet allRecords; 
	
	//set up a connection and data classes before each test, get all records, print all records
	@Before
	public void setup() {
		dm = new DataManager(); 
		dh = new DataHandler(dm); 
		
		//gets records, print column count
		try {
			allRecords = dh.getAllRecords();
			dh.printDatabaseInfo();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//testing the column names method
	@Test
	public void test() {
		
		
		try {
			String[] columnNames = dh.getColumnNames(dh.countNumOfColumns(), allRecords);
			
			//print the names
			for(int x = 0; x < dh.countNumOfColumns(); x++) {
				System.out.println(columnNames[x]);
			};
			
			String[] expectedColumnNames = {"id", "name", "genre"};
			
			//convert actual and expected to char arrays
			char[] actual = new char[columnNames.length];
			char[] expected = new char[expectedColumnNames.length];
			
			String actualString = "";
			String expectedString = "";
			
			for(String name : columnNames) {
				actualString+=name;
			}
			for(String name: expectedColumnNames) {
				expectedString += name; 
			}
		
			actual = actualString.toCharArray();
			expected = expectedString.toCharArray(); 
			
			
			//assert the char arrays
			assertArrayEquals(expected, actual);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//destroy the objects after each test run
	@After
	public void destroy() {
		dh = null;
		dm = null; 
	}

}
