package guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
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
import javax.swing.table.TableModel;

import data.DataHandler;
import data.DataManager;
import data.ResultsConverter;
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
	private String[] columnNames;
	
	//set the data
	private void setData() throws ClassNotFoundException, SQLException {
		this.data = ResultsConverter.convertToArray(dh.getAllRecords(), dh);
	}
	
	public String[][] getData() {
		return data; 
	}
	
	private void setColumnNames() throws ClassNotFoundException, SQLException {
		this.columnNames = dh.getColumnNames(dh.countNumOfColumns(), dh.getAllRecords());
	}
	
	public String[] getColumnNames() {
		return columnNames; 
	}
	
	//constructor sets scroll pane on table, sets initial table data from dh
	public SplitDisplay(DataHandler dh) {
		this.dh = dh;
		
		try {
			setData();
			setColumnNames();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		//disables editable cells, pass in data and columns
		movieTable = new JTable(new DefaultTableModel(this.data, this.columnNames)) {
		public boolean editCellAt(int row, int col, java.util.EventObject e) {
				      return false; //make cells non-editable
				 }
		};

		this.scroll = new JScrollPane(this.movieTable);	
	}
	
	
	public JTable getMovieTable() {
		return movieTable; 
	}
	
	
	

	public void setPane() {
		this.setOrientation(JSplitPane.VERTICAL_SPLIT);
		this.setTopComponent(TableLabel);
		this.setBottomComponent(scroll);
		this.setBackground(Color.WHITE);
		this.setBounds(xPos,yPos,panelWidth,panelHeight);
	}

}
