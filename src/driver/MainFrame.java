package driver;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
				
				
	}
}


