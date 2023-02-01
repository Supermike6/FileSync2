package Intro.intro;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SimpleMathCalculator {

	public static void main(String[] args) {
		
		ImageIcon icon = new ImageIcon(MadLibsPanel.class.getResource("1200px-Basic_arithmetic_operators.png"));
		
		JOptionPane.showMessageDialog(null, "Simple Calculator \n \nBy: Grant Bancroft");
		
		String input1 = JOptionPane.showInputDialog(null, "Enter a number:", "Select First Number",3);
		String input2 = JOptionPane.showInputDialog(null, "Enter a second number:", "Select Second Number",3);
		
		Double sum = Double.parseDouble(input1) + Double.parseDouble(input2);
		Double difference = Double.parseDouble(input1) - Double.parseDouble(input2);
		Double product = Double.parseDouble(input1) * Double.parseDouble(input2);
		Double divisor = Double.parseDouble(input1) / Double.parseDouble(input2);
		
		JOptionPane.showMessageDialog(null, input1 + " + " + input2 + " = " + sum +
											"\n" + input1 + " - " + input2 + " = " + difference +
											"\n" + input1 + " * " + input2 + " = " + product + 
											"\n" + input1 + " ÷ " + input2 + " = " + divisor,
											"Calculations",0,icon);
		
		JOptionPane.showMessageDialog(null, "Thank you for using the Simple Calculator", "Simple Calculator",3);
	
		
		
		
	}

}