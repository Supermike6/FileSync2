package Intro.intro;


import java.awt.GraphicsEnvironment;

public class Fontfinder {

	public static void main(String[] args) {
		
		for(String s : GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames())
	         System.out.println(s);

	}

}
