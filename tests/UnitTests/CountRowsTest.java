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


public class CountRowsTest {

	DataHandler dh; 
	DataManager dm; 
	ResultSet allRecords; 
	int count = 0; 
	
	//set up a connection and data classes before each test, get all records, print all records
	@Before
	public void setup() {
		dm = new DataManager(); 
		dh = new DataHandler(dm); 
		
		
		//gets records, prints column count
		try {
			allRecords = dh.getAllRecords();
			while(allRecords.next()) {
				System.out.println(allRecords.getString(2)); //print movie names, column 1 is the id
				count++;
			}
			
			System.out.println(String.format("Count: %s", count));
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//testing the row count method
	@Test
	public void test() {
		try {
			//count columns should return 2
			dh.countNumberOfRows(allRecords);
			
			double expected = count; 
			double actual = dh.countNumberOfRows(allRecords);
			double delta = 0; 
			
			//asserts there's no difference between number of columns and what the count method outputs
			org.junit.Assert.assertEquals(expected, actual, delta);

		} catch (ClassNotFoundException | SQLException e) {
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
