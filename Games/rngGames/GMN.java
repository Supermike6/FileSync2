package Games.rngGames;

import java.util.Scanner;

//Program description: Guess a number game

public class GMN
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      String playAgain;
      
      do {
         System.out.print("Enter the maximum number to guess up to: ");
         int upperLimit = sc.nextInt();
         
         int maxGuesses = (int)(Math.log(upperLimit) / Math.log(2));
         System.out.println("you will have " + maxGuesses + " guesses.");
         int guess;
         int totalGuesses = 0;
         int winningNumber = (int)(Math.random()*upperLimit) + 1;
         System.out.println(winningNumber);
         System.out.print("Guess a number from 1 to " + upperLimit + ": ");
         guess = sc.nextInt();
         totalGuesses++;
         
         while(guess != winningNumber && totalGuesses < maxGuesses)
         {
            if(guess < winningNumber)
               System.out.print("WRONG! Guess a higher number: ");
            else
               System.out.print("WRONG! Guess a lower number: ");
            guess = sc.nextInt();
            totalGuesses++;
         }
         sc.nextLine();
         
         if(guess == winningNumber)
            System.out.println("Correct! It took " + totalGuesses + " guesses.");
         else
            System.out.println("Sorry, you lose! It took " + totalGuesses + " guesses.");
            
         
         System.out.println("\nPlay again? (Y/N): ");
         playAgain = sc.nextLine();
         
      } while(playAgain.equalsIgnoreCase("Y") || playAgain.equalsIgnoreCase("yes"));
      
      System.out.println("Thanks for playing!");
      sc.close();
   }
}
