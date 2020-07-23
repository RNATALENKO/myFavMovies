package guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Enumeration;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import driver.MainFrame;
import interfaces.Panel;





@SuppressWarnings("serial")
public class SplitDisplay extends JSplitPane {
	
	JLabel TableLabel = new JLabel("My Favorite Movies"); 
	JTable movieTable; 
	JScrollPane scroll;
	
	String[] columnNames = {
			"Movie Name",
			"Genre"	
	};
	
	String[][] fillerData = {
			{"Tarzan", "Adventure"},
			{"Batman Begins", "Action"},
			{"Tarzan", "Adventure"}
	};
	
	
	public static int xPos = 0 + MovieFormPanel.getPanelWidth(); 
	public static int yPos = 0;
	public static int panelWidth = MainFrame.FRAMEWIDTH - MovieFormPanel.getPanelWidth(); 
	public static int panelHeight = MainFrame.FRAMEHEIGHT;
	
	
	//set table, set scroll, set table to read only
	public SplitDisplay() {
		
		//disables editable cells
		movieTable = new JTable(fillerData, columnNames) {
			public boolean editCellAt(int row, int col, java.util.EventObject e) {
	            return false;
	         }
		};
		
		//sets jtable as the scroll pane
		scroll = new JScrollPane(movieTable);
	}
	
	public void setPane() {
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setTopComponent(TableLabel);
		this.setBottomComponent(scroll);
		this.setBackground(Color.WHITE);
		this.setBounds(xPos,yPos,panelWidth,panelHeight);
	
	}

}
