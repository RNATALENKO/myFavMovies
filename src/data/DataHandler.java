package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



/*
 * note: can move close connection to a method
 * 
 * try these solutions for a locked sql database:
 * https://stackoverflow.com/questions/42348862/sqlite-is-busy-database-is-locked
 * 
 * gets locked when multiple connections are open or operations on the same connection i.e. close the programs that were left open from previus runs
 * which most likely reference the same connection or have multiple connections trying to perform something. 
 * 
 */


//this class will perform crud operation duties
public class DataHandler {
	
	private DataManager dm;
	private final Connection nullconn = null;
	
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
			addQuery.close();
			
			//close connection if connection not null i.e. open, set's dm connection back to null
			this.setConnectionToNull();
			
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
			deleteQuery.close();
			
			//close connection set dm object connection to null
			this.setConnectionToNull();
		}
		
		
		//method that will delete all records (USED AS TESTING, NO FINAL CODE). 
		public void deleteAllRecords(boolean deleteConfirmation) throws SQLException, ClassNotFoundException {
			
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//delete all records
			Statement deleteAllRecords = this.dm.getConn().createStatement();
			
			//if confirmed, execute the deletion and close the connection
			if(deleteConfirmation == true) {
				
				deleteAllRecords.executeUpdate("DELETE FROM movies");	
				deleteAllRecords.close();
			}
			//close connection set dm object connection to null
			this.setConnectionToNull();
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
			
			
			//note that if you close this connection the results get closed, 
			//if results are closed, you cannot access it's values and you get an sql error thrown
			
			return allData; 
		}
		
		
		
		//method that will get the Id based on movie name
		//needs a test
		public int getId(String movieName) throws ClassNotFoundException, SQLException {
			
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//execute a query from the database to get the result of the movie name
			PreparedStatement prep = this.dm.getConn().prepareStatement("SELECT id FROM movies WHERE name=?");
			prep.setString(1, movieName);
			
			ResultSet results = prep.executeQuery();
			
			int id = results.getInt("id");
			
			
			return id; 
			
		}
		
		
		
		
		//method that will count number of rows, using an SQL count aggregate function
		public int countNumberOfRows() throws SQLException, ClassNotFoundException {	
			
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//execute query and grab results
			Statement statement = this.dm.getConn().createStatement(); 
			ResultSet count = statement.executeQuery("SELECT COUNT(*) FROM movies;");
			
			//get the row count and return it
			int rows = count.getInt(1); 
			
			return rows; 
		}
		
		
		//method that checks if connection still open, closes it, then sets dm connection object to null
		public void setConnectionToNull() throws SQLException {
			
			//check and set to null
			if(this.dm.getConn()!= null) {
				this.dm.getConn().close();
				this.dm.setConn(nullconn);
				}
		}	
		
		//method that will print results for all columns
		public void printResults(ResultSet results) throws SQLException, ClassNotFoundException {
			
			System.out.println("database info: [");
			while(results.next()) {
				System.out.print(" " + results.getString(1));
				System.out.print(" " + results.getString(2));
				System.out.print(" " + results.getString(3));
				System.out.println();
			}
			System.out.println("]");
		}
		
		
		public void printDatabaseInfo() {
			//print values of table and print row count when we add a movie
			try {
				ResultSet results = this.getAllRecords();
				this.printResults(results);
				System.out.println(String.format("rowcount: %s", this.countNumberOfRows()));	
				System.out.println(String.format("columncount: %s", this.countNumOfColumns()));
				System.out.println();
				
			} catch (ClassNotFoundException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		
		//method that counts columns
		public int countNumOfColumns() throws SQLException, ClassNotFoundException {
			
			//check connection
			if(this.dm.getConn() == null) {
				dm.getConnection();
			}
			
			//execute query and grab results
			Statement statement = this.dm.getConn().createStatement(); 
			ResultSet count = statement.executeQuery("SELECT * FROM movies;");
			
			//get the row count and return it
			ResultSetMetaData rsmd = count.getMetaData();
			int columns = rsmd.getColumnCount();
			
			return columns;  
		}
		
		
		//method that returns columns names as string array
		public String[] getColumnNames(int columncount, ResultSet results) throws SQLException {
			
			int columnIndex = 1; 
			
			String[] columnNames = new String[columncount];
			
			ResultSetMetaData metaData = results.getMetaData();
			
			for(int x = 0; x < columncount; x++) {
				columnNames[x] = metaData.getColumnName(columnIndex);
				columnIndex++;
			}
			
			return columnNames; 	
		}
		
		 
		
		
}
