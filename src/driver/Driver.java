package driver; 

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import driver.MainFrame;
import guicomponents.MovieForm;
import guicomponents.MovieFormPanel;



/*
 * reminder: remote repository short name is myfavmovies
 * to push to git hub use git push myfavmovies --all for all content/commits
 * 
 * validation requirements
 * also need to check if record exists, if does do not add
 * also check if record doesn't exist, if it doesn't cannot delete
 * also check if there's any record at all, if there's none, no records
 * 
 */


public class Driver {

	public static void main(String[] args) {
		
		new MainFrame(); 

	}

}
