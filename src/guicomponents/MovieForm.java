package guicomponents; 

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class MovieForm {
	
	private int fieldWidth = 140;
	private int fieldHeight = 20; 
	private int buttonWidth = 100; 
	private int buttonHeight = 30;
	
	private JLabel movieNameLabel = new JLabel("Movie Name: ");
	private JLabel genreLabel = new JLabel("Movie Genre ");
	private JTextField movieNameField = new JTextField();
	private JTextField genreField = new JTextField(); 
	
	private JButton addButton = new JButton("Add +");
	private JButton deleteButton = new JButton("Delete -");
	private JButton deleteAllButton = new JButton("Delete all");
	
	
	public JButton getAddButton() {
		return addButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}


	public JLabel getMovieNameLabel() {
		return movieNameLabel;
	}

	public JLabel getGenreLabel() {
		return genreLabel;
	}

	public JTextField getMovieNameField() {
		return movieNameField;
	}

	public JTextField getGenreField() {
		return genreField;
	}
	
	
	public JButton getDeleteAllButton() {
		return deleteAllButton;
	}

	public void setDeleteAllButton(JButton deleteAllButton) {
		this.deleteAllButton = deleteAllButton;
	}
	
	
	public MovieForm(){
		setFieldLength(); 
		setButtonLength(); 
	}
	
	
	//method to set textfield length
	public void setFieldLength() {
		movieNameField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
		genreField.setPreferredSize(new Dimension(fieldWidth, fieldHeight));
	}
	
	//method to set textfield length
	public void setButtonLength() {
		addButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		deleteButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
		deleteAllButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
	}
	
	
	//method that sets color of buttons

	

}
