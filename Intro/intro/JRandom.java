package Intro.intro;

import javax.swing.JOptionPane;

public class JRandom {

	public static void main(String[] args)
	{
		
		int randomNum=100;
		int count = 0;
		
		do
		{
			JOptionPane.showMessageDialog(null, randomNum, "breuh",-1);
			randomNum = (int) (Math.random()*100+1);
			count++;
		}while(randomNum != 100);
		
			System.out.println(randomNum);
			System.out.println("You Generated " + count + " numbers.");
			
		
	}

}
