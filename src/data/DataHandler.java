package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//this class will perform crud operation duties
public class DataHandler {
	
	DataManager dm = new DataManager();
	Connection conn; 
	
	//method that adds a movie to the database (needs to check for connection)
		public void addMovie(String movieName, String movieGenre) throws SQLException, ClassNotFoundException {
			
			//check connection
			if(conn == null) {
				dm.getConnection();
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
				dm.getConnection();
			}
			
			//execute query to delete whatever movie name is
			PreparedStatement deleteQuery = conn.prepareStatement("DELETE FROM movies WHERE name =?");
			deleteQuery.setString(1, movieName);
			deleteQuery.execute();
		}
		
		//method that will delete all records (USED AS TESTING, NO FINAL CODE). 
		public void deleteAllRecords(boolean deleteConfirmation) throws SQLException {
			
			if(deleteConfirmation == true) {
				//delete all records
				Statement deleteAllRecords = conn.createStatement();
				deleteAllRecords.execute("DELETE FROM movies");
			}
		}
		
		//method that will get the resultset of the database
		public ResultSet getResults() throws SQLException, ClassNotFoundException {
			
			//check connection
			if(conn == null) {
				dm.getConnection();
			}
			
			//statement to get all columns from query
			Statement queryAllData = conn.createStatement();
			ResultSet allData = queryAllData.executeQuery("SELECT * FROM movies;");
			
			return allData; 
			
		}

}
