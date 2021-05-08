package umgcCalculator;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

// class to control topic access and get topic information
public class Topic {
	
	// variable to use throuhout class
	private static double[] topicGrades;
	
	// method to get the name of each topic
	static public void getTopics() {
			
		int count = Interface.getNumOfTopics();
			
		for (int i = 0; i < count; i++) {
				
			String topic;
			
			while (true) {
				try {
						topic = JOptionPane.showInputDialog(null, "\nPlease enter the name of the "
								+ numberAbreviation(i) + " topic.          \n     ", "NAME OF TOPIC", 
								JOptionPane.QUESTION_MESSAGE);
						if (topic == null) {
							Interface.errorMessage(0);
						} else if (Pattern.matches("[a-zA-Z 0-9]{3,20}", topic)) {
							topic = topic.substring(0,1).toUpperCase() + topic.substring(1).toLowerCase();
							Interface.topics[i] = topic;
							break;
						} else {
							Interface.errorMessage(1);
						}
				} catch (Exception e) {
					Interface.errorMessage(0);
				}
			}
		}
		getNumGradesForTopic();
	}
	
	// method to get the number of grades received for a topic
	static void getNumGradesForTopic() {
		
		int numOfGrades;
		
		for (int i = 0; i < Interface.topics.length; i++) {

			while (true) {
				try {
					Interface.usrInput = (String) JOptionPane.showInputDialog(null, "\nPlease enter the number of "
							+ "grades that you received for your " + Interface.topics[i] + "        \n ", 
							"NUMBER OF GRADES FOR " + Interface.topics[i].toUpperCase(), JOptionPane.QUESTION_MESSAGE, null, Interface.options, Interface.options[0]);
					if (Interface.usrInput == null) {
						Interface.errorMessage(0);
					} else {
						numOfGrades = Integer.parseInt(Interface.usrInput);
						topicGrades = new double[numOfGrades];
						int count = 0;
						for(double d:topicGrades) {
							topicGrades[count] = getEachGrade(count, i);
							count++;
						}
						break;
					}
				} catch (Exception e) {
					Interface.errorMessage(0);
				}
			}
		
			Calculate.setPercentage(numOfGrades, Interface.topics[i]);
			Interface.allGrades[i] = Calculate.avgCombinedWeight(topicGrades);
		}
	}
	
	// method to get each grade for a topic
	static double getEachGrade(int count, int i) {
		double grade;
		while (true) {
			try {
				Interface.usrInput = JOptionPane.showInputDialog(null, "\nWhat is your "
						+ numberAbreviation(count) + " grade for " + Interface.topics[i] + "        \n ", 
						"GRADES FOR " + Interface.topics[i].toUpperCase(), JOptionPane.QUESTION_MESSAGE);
				if (Interface.usrInput == null) {
					Interface.errorMessage(0);
				} else if (Interface.usrInput.isBlank()) {
					Interface.errorMessage(2);
				} else {
					grade = Double.parseDouble(Interface.usrInput);
					if (grade > 0 && grade < 100){
						return grade;
					} else {
						Interface.errorMessage(2);
					}
				}
			} catch (Exception e) {
				Interface.errorMessage(0);
			}
		}			
	}
	
	// method to set output number abreviations throughout program
	static String numberAbreviation(int i) {
		
		String numAbreviation;
		
		switch (i){
			case 0:
				numAbreviation = (i+1) + "st";
				return numAbreviation;
			case 1:
				numAbreviation = (i+1) + "nd";
				return numAbreviation;
			case 2:
				numAbreviation = (i+1) + "rd";
				return numAbreviation;
			default:
				numAbreviation = (i+1) + "th";
				return numAbreviation;
		}
	}
}
