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

import data.DataHandler;
import data.DataManager;
import driver.MainFrame;
import interfaces.Panel;





@SuppressWarnings("serial")
public class SplitDisplay extends JSplitPane {
	
	private JLabel TableLabel = new JLabel("My Favorite Movies"); 
	private JTable movieTable; 
	private JScrollPane scroll;
	private DataHandler dh; 
	
	public static int xPos = 0 + MovieFormPanel.getPanelWidth(); 
	public static int yPos = 0;
	public static int panelWidth = MainFrame.FRAMEWIDTH - MovieFormPanel.getPanelWidth(); 
	public static int panelHeight = MainFrame.FRAMEHEIGHT;
	
	
	private String[][] data; 
	
	//set the data
	public void setData(String[][] data) {
		this.data = data; 
	}
	
	public String[][] getData() {
		return data; 
	}
	
	//constructor sets scroll pane on table
	public SplitDisplay(DataHandler dh) {
		this.dh = dh; 
		this.scroll = new JScrollPane(this.movieTable);
	}
	
	
	//pass in data and columnnames and set movie table component
	public void setTable(String[][] data, String[] columnNames) {
		//disables editable cells, pass in data and columns
		movieTable = new JTable(data, columnNames) {
		public boolean editCellAt(int row, int col, java.util.EventObject e) {
		           return false; //make cells non-editable
		        }
		};
	}
	
	
	
	
	
	//method that takes in a new 2d string and updates the table with the new datatable
	//review: https://stackoverflow.com/questions/3179136/jtable-how-to-refresh-table-model-after-insert-delete-or-update-the-data
	public void updateTableData(String[][] newData, String[][] columnNames) {
		
		
		
		
	}
	
	
	
	public void setPane() {
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setTopComponent(TableLabel);
		this.setBottomComponent(scroll);
		this.setBackground(Color.WHITE);
		this.setBounds(xPos,yPos,panelWidth,panelHeight);
	}

}
