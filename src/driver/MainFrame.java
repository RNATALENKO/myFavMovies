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

				
				
				
				//activate add, delete, delete all button execution
				
				mbe.executeAdd();
				mbe.executeDelete();
				mbe.executeDeleteAll();
				
				
				
				
				//test the conversion
				try {
					//allRecords = dh.getAllRecords();
					ResultSet allRecords = dh.getAllRecords();
					
					//print database info
					dh.printDatabaseInfo();
					
					
					/* need to fix results converter method, since it's not properly storing values in the correct index*/
					//convert result set to 2d array
					String[][] myString = ResultsConverter.convertToArray(allRecords, dh);
					
					
					
					//print the 2d array
					for(int x= 0; x < dh.countNumberOfRows(allRecords); x++) {
						
						for(int y = 0; y < 3; y++) {
							System.out.println(myString[x][y] + " " );
						}
					}
					
				
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			
			
				
	}
}


