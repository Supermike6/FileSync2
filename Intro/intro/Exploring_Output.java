package Intro.intro;

import java.util.Scanner;

public class Exploring_Output {

	
	
	public static void main(String[] args) {
		
		System.out.print("Enter your name in console: ");
		
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		
		System.out.println("Hello " + name + ".");

		double avg;
		double avg2;
		
		// ask for num 1
		System.out.print("What is the first number: ");
		double num1 = sc.nextDouble();
		
		
		//ask for num2
		System.out.print("What is the second number: ");
		double num2 = sc.nextDouble();
		
		//Add numbers
		avg = num1+num2;
		
		//Devide 
		avg2 = avg/2;
		
		System.out.println("The average is: " + avg2);

		//using math
		System.out.println(Math.sin(Math.toRadians(30)));

		
		char letter = 'n';
		int number = 1;
		System.out.println((int) letter);
		System.out.println((char) number);
		
		sc.close();
	}

}