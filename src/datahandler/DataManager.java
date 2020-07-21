package datahandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {
	
	public Connection conn;
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
				createTable.execute("CREATE TABLE favorites (id integer, name varchar(255), genre varchar(255), primary key(id);");	
			}
		}
	}
	
	//method that will get the resultset of the database
	public ResultSet getResults() throws SQLException, ClassNotFoundException {
		
		//check connection
		if(conn == null) {
			getConnection();
		}
		
		//statement to get all columns from query
		Statement queryAllData = conn.createStatement();
		ResultSet allData = queryAllData.executeQuery("SELECT * FROM movies;");
		
		return allData; 
		
	}
	
	
	//method that adds a movie to the database (needs to check for connection)
	public void addMovie(String movieName, String movieGenre) throws SQLException, ClassNotFoundException {
		
		//check connection
		if(conn == null) {
			getConnection();
		}
		
		//execute query to add whatever the input is
		PreparedStatement addQuery = conn.prepareStatement("INSERT INTO movies (name, genre)  VALUES(?,?);");
		addQuery.setString(1, movieName);
		addQuery.setString(2, movieGenre);
		addQuery.execute();
	}
	
	
	//method that deletes a movie to the database (needs to check for connection)
	public void deleteMovie(String movieName) throws SQLException, ClassNotFoundException {
	
		//check connection
		if(conn == null) {
			getConnection();
		}
		
		//execute query to delete whatever movie name is
		PreparedStatement deleteQuery = conn.prepareStatement("DELETE FROM movies WHERE name =?");
		deleteQuery.setString(1, movieName);
		deleteQuery.execute();
	}
	
	//method that will delete all records (USED AS TESTING, NO FINAL CODE). 
	public void deleteAllRecords(String passkey) throws SQLException {
		
		if(passkey != "deleteconfirmation") {
			return; 
		}
		else {
			//delete all records
			Statement deleteAllRecords = conn.createStatement();
			deleteAllRecords.execute("DELETE FROM movies");
		}
		
	}
	
}
