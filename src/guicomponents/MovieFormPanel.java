package guicomponents; 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;

import interfaces.Panel;
import driver.Driver;
import driver.MainFrame;



//form panel will add the movie form object. 

@SuppressWarnings("serial")
public class MovieFormPanel extends Panel{
	
	private static int xPos = 0; 
	private static int yPos = 0;
	private static int panelWidth = 400; 
	private static int panelHeight = MainFrame.FRAMEHEIGHT;

	GridBagLayout gbl = new GridBagLayout(); 
	GridBagConstraints gbc = new GridBagConstraints(); 

	//manipulate contraints, add to this panel the form component, and the gbc object
	public void setGridBag(MovieForm form) {
		
		gbc.insets = new Insets(10,5,10,10);
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
		gbc.gridx = 0; 
		gbc.gridy = 0; 
		this.add(form.getMovieNameLabel(), gbc);
		
		
		gbc.gridx = 1; 
		gbc.gridy = 0; 
		add(form.getMovieNameField(), gbc);
		
		
		gbc.gridx = 0; 
		gbc.gridy = 1; 
		add(form.getGenreLabel(), gbc);
		
		
		gbc.gridx = 1; 
		gbc.gridy = 1; 
		add(form.getGenreField(), gbc);
		
		gbc.gridx = 0; 
		gbc.gridy = 2; 
		gbc.anchor = GridBagConstraints.CENTER;
		add(form.getAddButton(), gbc);
		
		gbc.gridx = 1; 
		gbc.gridy = 2; 
		add(form.getDeleteButton(), gbc);

		gbc.gridx = 3; 
		gbc.gridy = 2; 
		add(form.getDeleteAllButton(), gbc);
	}

	
	//set panel details
	@Override
	public void setWindow() {
		this.setBounds(0,0, 400, MainFrame.FRAMEHEIGHT);
		this.setLayout(gbl);
		this.setBackground(Color.WHITE);
		
	}

	//position encapsulations
	public static int getxPos() {
		return xPos;
	}

	public static void setxPos(int xPos) {
		MovieFormPanel.xPos = xPos;
	}

	public static int getyPos() {
		return yPos;
	}

	public static void setyPos(int yPos) {
		MovieFormPanel.yPos = yPos;
	}

	public static int getPanelWidth() {
		return panelWidth;
	}

	public static void setPanelWidth(int panelWidth) {
		MovieFormPanel.panelWidth = panelWidth;
	}

	public static int getPanelHeight() {
		return panelHeight;
	}
	public static void setPanelHeight(int panelHeight) {
		MovieFormPanel.panelHeight = panelHeight;
	}

}
