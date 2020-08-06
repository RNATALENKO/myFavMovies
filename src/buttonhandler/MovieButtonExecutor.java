package buttonhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.DataHandler;
import guicomponents.MovieForm;
import tablehandler.TableHandler;

//handles all button executions and logic
//this class will also handle updating the Jtable when a row is added, deleted, or entire JTable is deleted
//this class will also add delete or remove records simultaneously from the sqllite database

//these buttons need validation for empty fields, if they're empty then don't execute

//note you can refactor the movieId into a method and set it

public class MovieButtonExecutor {
	
	private MovieForm form;
	private DataHandler dh; 
	private TableHandler th; 
	
	private String movieId;
	private int row;
	
	
	//constructor, takes in a form and datahandler
	public MovieButtonExecutor(MovieForm form, DataHandler handler, TableHandler th) {
		this.form = form; 
		this.dh = handler; 
		this.th = th; 
	}
	
	public MovieForm getForm() {
		return form;
	}

	public void setForm(MovieForm form) {
		this.form = form;
	}

	public DataHandler getDataHandler() {
		return dh;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dh = dataHandler;
	}
	
	
	public TableHandler getTableHandler() {
		return th;
	}

	public void setTableHandler(TableHandler tableHandler) {
		this.th = tableHandler;
	}

	public void executeAdd() {
		
		form.getAddButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//adds a movie to database
				try {
					dh.addMovie(form.getMovieNameField().getText(), form.getGenreField().getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//print values of table and print row count when we add a movie
				dh.printDatabaseInfo();
				
				
				//logic to update the Jtable
				
				//get movie ID given movie name from form input field
				try {
					movieId = Integer.toString(dh.getId(form.getMovieNameField().getText()));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				String[] row = {movieId, form.getMovieNameField().getText(), form.getGenreField().getText()};
				th.addRow(row);
				
			}
			
		});
	}
	
	
	public void executeDelete() {
		form.getDeleteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dh.deleteMovie(form.getMovieNameField().getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//print values of table and print row count when we add a movie
				dh.printDatabaseInfo();
				
				
				//logic to remove movie row from the Jtable
				
				//if table value exists, then get the input value, get the row it's located, and delete that row
				if(th.valueExists(form.getMovieNameField().getText())) {
					th.deleteRow(th.getRow(form.getMovieNameField().getText()));
				}
				
				
				
			}
			
		});
	}
	
	
	
	public void executeDeleteAll() {
		
		//adds listener to form's delete button
		form.getDeleteAllButton().addActionListener(new ActionListener() {

			//when clicked, get a confirmation, execute deletion if confirmed and wipes all records
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//pop up for confirmation of delete
				boolean deleteConfirmation = false;
				JFrame confirmBox = new JFrame();
				JOptionPane confirmOptionPane = new JOptionPane(); 
				
				//popup box to get delete 
				int confirmationNumber = JOptionPane.showConfirmDialog(confirmBox, "Are you sure you want to delete all records?");
				
				if(confirmationNumber == JOptionPane.YES_OPTION) {
					deleteConfirmation = true; 
				}
				
				//perform the delete movie
				try {
					dh.deleteAllRecords(deleteConfirmation);
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//print values of table and print row count when we add a movie
				dh.printDatabaseInfo();
			
				//need method that updates JTable
				th.deleteAllRows();
				
			}
		});
	}
}
