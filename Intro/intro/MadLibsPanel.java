package Intro.intro;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class MadLibsPanel {

	public static void main(String[] args) 
	{
		
		Font font1 = new Font("Courier",Font.PLAIN,35);
		
		Font font2 = new Font("Courier",Font.PLAIN,25);
		
		UIManager.put("TextField.font", font2);
		
		UIManager.put("OptionPane.messageForeground", Color.ORANGE);
		
		UIManager.put("Panel.background", Color.DARK_GRAY);
		
		UIManager.put("OptionPane.background", Color.BLACK);
		
		UIManager.put("OptionPane.messageFont", font1); 
		
		ImageIcon icon = new ImageIcon(MadLibsPanel.class.getResource("madlibicon.png"));
		
		JOptionPane.showMessageDialog(null, "Madlib \n \nBy: Grant Bancroft ", "Madlib",0,icon);
		
		Object noun1 = JOptionPane.showInputDialog(null, "Enter a noun: ", "Madlib", 0, icon, null, "Noun");
		
		Object adj1 = JOptionPane.showInputDialog(null, "Enter an adjective: ", "Madlib", 0, icon, null, "Adjective");
		
		Object noun2 = JOptionPane.showInputDialog(null, "Enter a noun: ", "Madlib", 0, icon, null, "Noun");
		
		Object noun3 = JOptionPane.showInputDialog(null, "Enter a noun: ", "Madlib", 0, icon, null, "Noun");
		
		Object result = "Old mother Hubbard went to the " + ((String) noun1).toUpperCase()
				+ " \nto get her " + ((String) adj1).toUpperCase() + " " + ((String) noun2).toUpperCase() + " a " + ((String) noun3).toUpperCase() + ". \nWhen she got to the "
				+ ((String) noun1).toUpperCase() + " the " + ((String) noun3).toUpperCase() + " was not there, \nand so her "+ ((String) adj1).toUpperCase() + " " + ((String) noun1).toUpperCase() + " had none.";
		
		JOptionPane.showMessageDialog(null, "Here is your mad lib! ", "Result",0,icon);
		JOptionPane.showMessageDialog(null, result, "Madlib", 1, icon);
		JOptionPane.showMessageDialog(null, "I hope you enjoyed your story! ", "Thank You!",0,icon);
		
		
		

	}

}
