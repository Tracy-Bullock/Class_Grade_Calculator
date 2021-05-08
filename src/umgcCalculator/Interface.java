package umgcCalculator;

import javax.swing.JOptionPane;

// class to hanle user interactions and program flow
public class Interface {
	
	// variables to use throughout entire program
	public static String[] options = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	public static String[] topics;
	public static double[] allGrades;
	public static String usrInput;
	
	// method for program introduction
	public static void intro() {
		String spaces = "                                                            ";
		JOptionPane.showInternalMessageDialog(null, "NAME: Tracy Bullock" + spaces +
				spaces + "        DATE: May 08, 2021           \n\n\n\n" + 
				"                                            " +
				"    This program is a personal project to calculate class grades.\n\n" + 
				spaces + "                    :::::::::::::::::::::::::::::\n" +
				spaces + "                    ::   Please note   ::\n" + 
				spaces + "                    :::::::::::::::::::::::::::::\n" +
				"\n             The word \"Topics\" in this program reffer to assignment categories such as Discussions and Quizes.\n\n\n" +
				spaces + "        Have fun and enjoy the program!\n\n ",
				"Personal Project", JOptionPane.INFORMATION_MESSAGE);
		
		JOptionPane.showMessageDialog(null, "\n   Welcome to the UMGC Grade Calculator!   \n", "UMGC GRADE CALCULATOR", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method for program outro
	public static void outro() {
		JOptionPane.showMessageDialog(null, "\n   Thank you for using UMGC Grade Calculator!    \n", "GOODBYE", JOptionPane.PLAIN_MESSAGE);
	}
	
	// Method to get the number of topics to be entered
	public static int getNumOfTopics() {
			
		int numOfTopics;
			
		while (true) {
			try {
				usrInput = (String) JOptionPane.showInputDialog(null, "\nPlease enter the number of "
						+ "topics being graded.        \n ", 
						"NUMBER OF TOPICS", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (usrInput == null) {
					errorMessage(0);
				} else {
					numOfTopics = Integer.parseInt(usrInput);
					topics = new String[numOfTopics];
					allGrades = new double[numOfTopics];
					return numOfTopics;
				}
			} catch (Exception e) {
				errorMessage(0);
			}
		}
	}
	
	// method to present the grade to the user
	public static void presentGrade() {
		
		double finalGrade = Calculate.getOverAllGrade();
		int repeat;
		
		if (finalGrade >= 90) {
			JOptionPane.showMessageDialog(null, "\n      CONGRADULATIONS, you have an A!!      \n" 
					+ "                  Your final grade is " + finalGrade + "!\n ", "FINAL GRADE", 
					JOptionPane.PLAIN_MESSAGE);
		} else if(finalGrade < 90 && finalGrade >= 80) {
			JOptionPane.showMessageDialog(null, "\n      Your final grade is " + finalGrade 
					+ ". You have a B.      \n ", "FINAL GRADE", JOptionPane.PLAIN_MESSAGE);
		} else if(finalGrade < 80 && finalGrade >= 70) {
			JOptionPane.showMessageDialog(null, "\n      Your final grade is " + finalGrade 
					+ ". You have a c.      \n ", "FINAL GRADE", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "\n      Your final grade is " + finalGrade 
					+ ". You have failed and should be ashamed!      \n ", 
					"FINAL GRADE", JOptionPane.PLAIN_MESSAGE);
		}
		
		// prompt user to run program again
		repeat = JOptionPane.showConfirmDialog(null, "\n  Would you like to calculate your grades again?        \n ", 
				"Keep Calculating?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if (repeat == 0) {
			UmgcCalculator.run = true;
		} else {
			UmgcCalculator.run = false;
		}
		
	}
	
	// method to display err messages and/or exit program
	public static void errorMessage(int errorCode) {
						
		// errorCode 1 is for invalid input
		if (errorCode == 1) {
			JOptionPane.showMessageDialog(null, "\nInput can only be letters or numbers with a lenght of 3-20 characters!      ", 
					"Error", JOptionPane.ERROR_MESSAGE);
		} else if (errorCode == 2) {
			JOptionPane.showMessageDialog(null, "\nYou must enter a valid grade between 0-100!     ", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (errorCode == 3) {
			JOptionPane.showMessageDialog(null, "\nYou must enter a valid percentage between 0-100!     ", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
		// others, errorCode 0, is for cancel buttons
			errorCode = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ", 
					"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (errorCode == 0) {
				outro();
				System.exit(0);
			} 
		}
	}

}
