package UnitTests;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DataHandler;
import data.DataManager;

public class CheckRecordTest {

	DataManager dm;
	DataHandler dh;
	ResultSet res; 
	
	@Before
	public void setup() {
		dm = new DataManager();
		dh = new DataHandler(dm); 	
		try {
			res = dh.getAllRecords();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test() {
		
		dh.printDatabaseInfo();
		
		try {
			assertTrue(dh.checkRecord("300"));
			System.out.println(dh.checkRecord("300"));
			//test false assertion
			assertFalse(dh.checkRecord("asdfl;askdf;alskdjf"));
			System.out.println(dh.checkRecord("asdfl;askdf;alskdjf"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tear() {
		dm = null;
		dh = null;
		res = null;
	}

}
