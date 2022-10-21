package rngGames;

import java.util.Scanner;

public class GuessMyNumber
{
	public static int totalGuesses = 0;
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String playAgain = "";
		do
		{
		int randomNum = (int) (Math.random()*10)+1;
		System.out.println(randomNum);
		int answer=-1;
		
		
		while(answer!=randomNum)
		{
			System.out.print("Guess a number from 1 to 10: ");
			answer=sc.nextInt();
			totalGuesses++;
			
			if(answer < randomNum)
				System.out.println("WRONG! Guess a higher number: ");
			else if(answer > randomNum)
				System.out.println("WRONG! Guess a lower Number");
			else
				System.out.print("");
		}
		sc.nextLine();
	
		System.out.println("");
		System.out.println("Congradulations, You won! \nThe answer was " + answer + ".");	
		System.out.println("");
		
		
		System.out.print("Play again? (Y/N) ");
		playAgain = sc.nextLine();
		
		}while(playAgain.equalsIgnoreCase("Y"));
		
		while(playAgain.equals("N"))
			System.out.println("Thanks for playing !");
		
			sc.close();
	}
	
}