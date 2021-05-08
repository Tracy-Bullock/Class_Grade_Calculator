package umgcCalculator;

import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class UmgcCalculator {
	
	static Boolean run;
	

	public static void main(String[] args) {
		
		// Customize DialogPanes
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Arial", Font.BOLD, 12));
		UI.put("OptionPane.background", new ColorUIResource(144,146,151));
		UI.put("OptionPane.messageForeground", new ColorUIResource(252,252,252));
		UI.put("Panel.background", new ColorUIResource(112,112,114));
		
		// run intro method
		Interface.intro();
		
		// run program while user wants
		do {
			Topic.getTopics();
			Interface.presentGrade();
		} while (run);
		
		// run outro method
		Interface.outro();
		

	}
	
	

}
