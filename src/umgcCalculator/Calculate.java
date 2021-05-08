package umgcCalculator;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.swing.JOptionPane;

// class to conduct all calculations
public class Calculate {
	
	// variable to use within this calss
	private static double percent;
	
	// method to set the percentage weight of each topic
	public static void setPercentage(int numOfGrades, String topic) {
		
		String[] singPlural = {" does this grade carry ", "do these grades carry "};
		String insertString;
		
		if (numOfGrades == 1) {
			insertString = singPlural[0];
		} else {
			insertString = singPlural[1];
		}
		
		while (true) {
			try {
				Interface.usrInput = JOptionPane.showInputDialog(null, "\nWhat percentage weight" + insertString 
						+ "(e.g. 10 for 10%)?        \n ", topic.toUpperCase() + " GRADE WEIGHT", 
						JOptionPane.QUESTION_MESSAGE);
				if (Interface.usrInput == null) {
					Interface.errorMessage(0);
				} else if (Interface.usrInput.isBlank()) {
					Interface.errorMessage(3);
				} else if (Double.parseDouble(Interface.usrInput) < 0 || Double.parseDouble(Interface.usrInput) > 100){
					Interface.errorMessage(3);
				} else {
					percent = Double.parseDouble(Interface.usrInput) * 0.01;
					break;
				}
			} catch(Exception e) {
				Interface.errorMessage(3);
			}
		}
	}
	
	// method to get the average combined weight of each topic
	public static double avgCombinedWeight(double[] grades) {
		
		double avg, sum = 0;
		
		for (double d:grades) {
			sum += d;
		}
		
		avg = sum / grades.length;
		return avg * percent;
	}
	
	// method to calculate and format the overall grade
	public static double getOverAllGrade() {
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat grade = new DecimalFormat("##.0", symbols);
		
		double overAllGrade = 0;
		
		for (double d: Interface.allGrades) {
			overAllGrade += d;
		}
		
		return Double.parseDouble(grade.format(overAllGrade));
	}

}
