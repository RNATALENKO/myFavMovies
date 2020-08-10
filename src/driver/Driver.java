package driver; 

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import driver.MainFrame;
import guicomponents.MovieForm;
import guicomponents.MovieFormPanel;
import utilities.SingleInstance;



/*
 * reminder: remote repository short name is myfavmovies
 * to push to git hub use git push myfavmovies --all for all content/commits
 * 
 * validation requirements
 * also need to check if record exists, if does do not add
 * also check if record doesn't exist, if it doesn't cannot delete
 * also check if there's any record at all, if there's none, no records
 * 
 * 
 * Need to: create it as one instance, so the sql database doesn't get locked
 * https://stackoverflow.com/questions/177189/how-to-implement-a-single-instance-java-application
 *
 * 
 * Then finally deploy the application, let friends test it, get feedback
 * 
 * After hitting a button, clear the form texts.
 * 
 * 
 */


public class Driver {

	public static void main(String[] args) {
		
		SingleInstance instance = new SingleInstance();
		
		try {
			//if instance doesn't exist, run the program
			if(!instance.instanceExists()) {
				new MainFrame(); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
