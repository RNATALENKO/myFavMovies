package UnitTests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DataHandler;
import data.DataManager;
import guicomponents.SplitDisplay;
import tablehandler.TableHandler;


//testing the ability to find a row of a given value within a JTable
public class getRowTest {

	
	
	DataManager dm;
	DataHandler dh; 
	TableHandler th; 
	SplitDisplay sd; 
	
	@Before
	public void setup() {
		dm = new DataManager();
		dh = new DataHandler(dm); 
		sd = new SplitDisplay(dh);
		th = new TableHandler(sd); 
	}
	
	
	@Test
	public void test() {

		
		//print database info
		dh.printDatabaseInfo();
		
		//note that the first row is row 0
		int actual = th.getRow("Tarzan");
		
		System.out.println(String.format("Found at Row: %s", actual));
		
		
		//assertEquals(expected, actual);
		
		
		
		
		
	}
	
	@After
	public void tear(){
		dm = null;
		dh = null;
		th = null;
		sd = null; 
	}

}
