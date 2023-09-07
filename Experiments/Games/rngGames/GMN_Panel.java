package rngGames;



import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

//Program description: Guess a number game

public class GMN_Panel
{
   public static void main(String[] args)
   {
     
      String playAgain;
      
      Font font1 = new Font("Courier",Font.PLAIN,35);
      
      UIManager.put("TextField.font", font1);
		  
		UIManager.put("OptionPane.messageForeground", Color.black);
		
		UIManager.put("Panel.background", Color.white);
		
		UIManager.put("OptionPane.background", Color.BLACK);
		
		UIManager.put("OptionPane.messageFont", font1); 
      
      
      
		ImageIcon icon = new ImageIcon(GMN_Panel.class.getResource("ezgif.com-gif-maker.gif"));
		
      do {
    	  
         int upperLimit = Integer.parseInt((String) JOptionPane.showInputDialog(null, "Enter the maximum number to guess up to", "Pick guessing range", 0, icon, null, 10));
   
         
         int maxGuesses = (int)(Math.log(upperLimit) / Math.log(2)); //calulate number of guesses to give player
         
         int guess;
         int totalGuesses = 0;
         int winningNumber = (int)(Math.random()*upperLimit) + 1;
         
         guess = Integer.parseInt((String) JOptionPane.showInputDialog(null, "You will have " + maxGuesses + " guess(es).\nGuess a number from 1 to " + upperLimit, "Guess a Number",-1));
         
         totalGuesses++;
         
         while(guess != winningNumber && totalGuesses < maxGuesses)
         {
            if(guess < winningNumber)
            	 guess = Integer.parseInt((String) JOptionPane.showInputDialog(null, "WRONG! Guess a higher number\nYou have " + (maxGuesses-totalGuesses)+ " guess(es).", "Guess another number", -1));
            	 else
            	 guess = Integer.parseInt((String) JOptionPane.showInputDialog(null, "WRONG! Guess a lower number\nYou have " + (maxGuesses-totalGuesses)+" guess(es).", "Guess another number", -1));
            totalGuesses++;
         }
         
         
         if(guess == winningNumber)
        	 JOptionPane.showMessageDialog(null, "Correct! It took " + totalGuesses + " guesses.\nThe Correct number was: " + winningNumber, "Results",-1);
         else
        	 JOptionPane.showMessageDialog(null, "Sorry, you lose! It took " + totalGuesses + " guesses.\nThe Correct number was: " + winningNumber, "Results",-1);
         
         playAgain = (String) JOptionPane.showInputDialog(null, "Would you like to play again? (Yes or No)", "Results",0,icon,null, "Yes");
         
      } while(playAgain.equalsIgnoreCase("Yes") || playAgain.equalsIgnoreCase("yes"));
      
      JOptionPane.showMessageDialog(null, "Thank you for playing!", "Bye Bye",-1);
   }
}
