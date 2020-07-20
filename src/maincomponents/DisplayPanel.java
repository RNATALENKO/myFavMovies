package maincomponents;

import java.awt.Color;
import java.awt.Dimension;

import driver.MainFrame;
import interfaces.Panel;

@SuppressWarnings("serial")
public class DisplayPanel extends Panel {
	
	
	public static int xPos = 0 + MovieFormPanel.getPanelWidth(); 
	public static int yPos = 0;
	public static int panelWidth = MainFrame.FRAMEWIDTH - MovieFormPanel.getPanelWidth(); 
	public static int panelHeight = MainFrame.FRAMEHEIGHT;
	
	public void DisplayPanel() {
		setWindow(); 
	}

	@Override
	public void setWindow() {
		
		this.setBackground(Color.WHITE);
		this.setBounds(xPos,yPos,panelWidth,panelHeight);
	
	}

}
