package driver;

import java.awt.Color;
import java.awt.FlowLayout;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import buttonhandler.MovieButtonExecutor;
import data.DataHandler;
import data.DataManager;
import data.ResultsConverter;
import guicomponents.SplitDisplay;
import guicomponents.MovieForm;
import guicomponents.MovieFormPanel;

//main application code
@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	public static int FRAMEWIDTH = 1300;
	public static int FRAMEHEIGHT = 700; 
	
	//list of main component objects
	MovieForm form = new MovieForm(); 
	MovieFormPanel movieFormPanel = new MovieFormPanel(); 
	SplitDisplay displayPanel = new SplitDisplay(); 
	DataManager dm = new DataManager();
	DataHandler dh = new DataHandler(dm);
	MovieButtonExecutor mbe = new MovieButtonExecutor(form, dh);
	ResultSet allRecords;
	ResultsConverter rc = new ResultsConverter(); 
	
	
	private void setWindow() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(FRAMEWIDTH, FRAMEHEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		this.setResizable(false);
	}
	
	public MainFrame() {
		
				setWindow();
	
				//main panel
				JPanel contentPanel = new JPanel(); 
				contentPanel.setBackground(Color.DARK_GRAY);
				contentPanel.setSize(this.getWidth(), this.getHeight());
				contentPanel.setLayout(null);
				
				
				//add movie form to content panel
				movieFormPanel.setWindow();
				movieFormPanel.setGridBag(form);
				contentPanel.add(movieFormPanel);
				
				//add the display panel
				displayPanel.setPane();
				contentPanel.add(displayPanel);
				
				//add content panel
				add(contentPanel);
				

				//first make sure values are being passed in
				System.out.println(form.getGenreField().getText());
				
				
				
				//activate add, delete, delete all button execution
				mbe.executeAdd();
				mbe.executeDelete();
				mbe.executeDeleteAll();
				
				
				//create results converter with given results, set columns

				
	}
}


