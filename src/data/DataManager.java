package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	
	private Connection conn;
	boolean hasConnection = false; 
	
	//method that gets connection, then creates database if none exist
	public void getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC"); //load class driver
		this.conn = DriverManager.getConnection("jdbc:sqlite:movies.db"); //get connection, set it connection var
		createDatabase(); //method that will check if database exists, if not create it	
	}
	
	
	//method that tests to see if database exists, if not, creates the database
	public void createDatabase() throws SQLException {
		
		if(!hasConnection) {
			hasConnection = true; //set to true so it only runs once
			
			
			//execute a statement to see if any results come back from a table
			Statement checkForResults = conn.createStatement();
			ResultSet initialResults = checkForResults.executeQuery("SELECT name FROM sqlite_master WHERE type = 'table' AND name = 'movies'");
			
			//if no results, create the database/table through a statement
			if(!initialResults.next()) {
				
				//create the table
				Statement createTable = conn.createStatement();
				createTable.execute("CREATE TABLE movies (id integer, name varchar(255), genre varchar(255), primary key(id))");	
			}
		}
	}


	public Connection getConn() {
		return conn;
	}


	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	
	
}
	
	

