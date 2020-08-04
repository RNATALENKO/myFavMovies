package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DataHandler;
import data.DataManager;

public class getIdTest {

	DataManager dm;
	DataHandler dh; 
	
	@Before
	public void setup() {
		dm = new DataManager();
		dh = new DataHandler(dm); 	
	}
	
	
	@Test
	public void test() {
		
			dh.printDatabaseInfo();
			
			try {
				int Expected = 1; 
				int actual = dh.getId("Tarzan");
				assertEquals(Expected, actual);
				
				System.out.println(dh.getId("Tarzan"));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
	}
	
	@After
	public void tearDown() {
		dm = null;
		dh = null;
	}

}
