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


public class ConvertResultSet {

	DataHandler dh; 
	DataManager dm; 
	ResultSet allRecords; 
	int count = 0; 
	
	//set up a connection and data classes before each test, get all records, print all records
	@Before
	public void setup() {
		dm = new DataManager(); 
		dh = new DataHandler(dm); 
		
		
		//gets records, prints database info
		try {
			allRecords = dh.getAllRecords();
			while(allRecords.next()) {
				System.out.print(allRecords.getString(1) + " ");
				System.out.print(allRecords.getString(2) + " "); 
				System.out.print(allRecords.getString(3));
				System.out.println();
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
		
		
		
		
		
		
		
	}

	
	
	
	

	//the objects after each test run
	@After
	public void destroy() {
		dh = null;
		dm = null; 
		try {
			dh.setConnectionToNull();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}