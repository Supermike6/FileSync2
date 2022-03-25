package Intro.intro;
//Grant Bancroft
//Sep 17, 2021


import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Welcome to Mad Libs!");
//		System.out.println();
//		
//		System.out.print("Enter a noun: ");
//		String noun1 = sc.nextLine();
//		
//		System.out.print("Enter an adjective: ");
//		String adj = sc.nextLine();
//		
//		System.out.print("Enter a noun: ");
//		String noun2 = sc.nextLine();
//		
//		System.out.print("Enter a noun: ");
//		String noun3 = sc.nextLine();
//		
//		System.out.println();
//		System.out.println("Here is your Mad Lib:");
//		System.out.println();
//		
//		String result = "Old mother Hubbard went to the " + noun1 
//				+ " to get her " + adj + " " + noun2 + " a " + noun3 + ". When she got to the "
//				+ noun1 + " the " + noun3 + " was not there, and so the" + noun1 + "had none.";
//		
//		System.out.println(result);
//		System.out.println();
//		System.out.println();
		
		System.out.println("Welcome to Mad Libs!");
		System.out.println();
		
		System.out.print("Enter a noun: ");
		String noun4 = sc.nextLine();
		
		System.out.print("Enter a continer: ");
		String cont = sc.nextLine();
		
		System.out.print("Enter a liquid: ");
		String liq = sc.nextLine();
		
		System.out.print("Enter a noun: ");
		String noun5 = sc.nextLine();
		
		System.out.print("Enter a famous person: ");
		String famper = sc.nextLine();
		
		System.out.println();
		System.out.println("Here is your Mad Lib:");
		System.out.println();
		
		
		String result2 = "Jack and Jill went up the " + noun4 + " to fetch a(n) " + cont + " of " + liq + " .Jack fell down and broke his " + noun5 +", and " + famper + " came tumbling after."; 
		
		System.out.println(result2);
		
		sc.close();
	}

}
