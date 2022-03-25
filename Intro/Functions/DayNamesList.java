package Intro.Functions;

import java.util.Scanner;

//a
public class DayNamesList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//b
		String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wendsday", "Thursday", "Friday", "Saturday"};
		
		//c
		
		for(int i = 0; i<7; i++)
		{
			System.out.print(dayNames[i]);
			if(i<6)
			{
				System.out.print(", ");		
			}
		}
		System.out.println(". ");
		
		//d

		
			System.out.println("Here is a random weekday: " +dayNames[(int) (Math.random()*5+1)]);	
		
		//e
		String response;
		
		do 
		{
			System.out.println("Here is a random day: " + dayNames[(int) (Math.random()*7)]);
			System.out.print("Do you want another random day? ");
			response = (String) sc.next();
			
		} while(response.equalsIgnoreCase("y"));
		System.out.println("Have a nice day!");
		sc.close();
	}

}
