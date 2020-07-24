package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/*
 * note: can move close connection to a method
 * 
 */


//this class will perform crud operation duties
public class DataHandler {
	
	private DataManager dm;
	private Connection nullconn = null;
	
	//constructor takes dm object and sets it to dm
	public DataHandler(DataManager dm){
		this.dm = dm; 
	}
	
		//method that adds a movie to the database (needs to check for connection)
		public void addMovie(String movieName, String movieGenre) throws SQLException, ClassNotFoundException {
		
			//check connection, if it's null get a connection
			if(dm.getConn() == null) {
				dm.getConnection();
			}
			
			//sql query that adds a movie with a name and genre input
			PreparedStatement addQuery = dm.getConn().prepareStatement("INSERT INTO movies (name, genre)  VALUES(?,?);");
			addQuery.setString(1, movieName);
			addQuery.setString(2, movieGenre);
			addQuery.executeUpdate();
			
			//close connection if connection not null i.e. open, set's dm connection back to null
			if(this.dm.getConn()!= null) {
				this.dm.getConn().close();
				this.dm.setConn(nullconn);
				}	
		}
		
		//method that deletes a movie to the database (needs to check for connection)
		public void deleteMovie(String movieName) throws SQLException, ClassNotFoundException {
		
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//execute query to delete whatever movie name is
			PreparedStatement deleteQuery = this.dm.getConn().prepareStatement("DELETE FROM movies WHERE name =?");
			deleteQuery.setString(1, movieName);
			deleteQuery.executeUpdate();
			
			if(this.dm.getConn()!= null) {
				this.dm.getConn().close();
				this.dm.setConn(nullconn);
				}	
		
		}
		
		//method that will delete all records (USED AS TESTING, NO FINAL CODE). 
		public void deleteAllRecords(boolean deleteConfirmation) throws SQLException {
			
			if(deleteConfirmation == true) {
				//delete all records
				Statement deleteAllRecords = this.dm.getConn().createStatement();
				deleteAllRecords.executeUpdate("DELETE FROM movies");	
				
				if(this.dm.getConn()!= null) {
					this.dm.getConn().close();
					this.dm.setConn(nullconn);
					}	
			}
		}
		
	
		//method that will get the resultset of the database
		public ResultSet getAllRecords() throws SQLException, ClassNotFoundException {
			
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//statement to get all columns from query
			Statement queryAllData = this.dm.getConn().createStatement();
			ResultSet allData = queryAllData.executeQuery("SELECT * FROM movies");
			
			if(this.dm.getConn()!= null) {
				this.dm.getConn().close();
				this.dm.setConn(nullconn);
				}	
			
			return allData; 
		}
		
		
		
		//method that will close connection and reset after it's null
		public void resetConnectionToNull() {
			
		}

}
