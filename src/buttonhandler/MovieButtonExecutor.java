package buttonhandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import data.DataHandler;
import guicomponents.MovieForm;

//handles all button executions and logic

public class MovieButtonExecuter {
	
	private MovieForm form;
	private DataHandler dataHandler; 
	
	public MovieForm getForm() {
		return form;
	}

	public void setForm(MovieForm form) {
		this.form = form;
	}

	public DataHandler getDataHandler() {
		return dataHandler;
	}

	public void setDataHandler(DataHandler dataHandler) {
		this.dataHandler = dataHandler;
	}
	
	
	public void executeAdd() {
		
		form.getAddButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//adds a movie to database
				try {
					dataHandler.addMovie(form.getMovieNameField().getText(), form.getGenreField().getText());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
	}
	
	public void executeDelete() {
		form.getDeleteButton().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dataHandler.deleteMovie(form.getMovieNameField().getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
					dataHandler.deleteAllRecords(deleteConfirmation);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//need method that updates table
			}
		});
	}
}