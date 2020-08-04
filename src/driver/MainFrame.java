package driver;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import buttonhandler.MovieButtonExecutor;
import data.DataHandler;
import data.DataManager;
import guicomponents.SplitDisplay;
import tablehandler.TableHandler;
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
	DataManager dm = new DataManager();
	DataHandler dh = new DataHandler(dm);
	SplitDisplay sd = new SplitDisplay(dh);
	TableHandler th = new TableHandler(sd); 
	MovieButtonExecutor mbe = new MovieButtonExecutor(form, dh, th);
	
	
	

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
				
				//add the split display (which contains table data and movie form)
				sd.setPane();
				contentPanel.add(sd);
				
				//add content panel
				add(contentPanel);
				
				
				//print initial database info
				dh.printDatabaseInfo();

				
				//activate add, delete, delete all button execution
				mbe.executeAdd();
				mbe.executeDelete();
				mbe.executeDeleteAll();
				
					
	}
}


