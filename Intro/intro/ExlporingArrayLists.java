package Intro.intro;

import java.util.ArrayList;
import java.util.Scanner;

public class ExlporingArrayLists {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
//		//Create list
//		ArrayList<String> days = new ArrayList<String>();
//		
//		//Add items
//		
//		days.add("Monday");
//		days.add("Tuesday");
//		days.add("Wednessday");
//		days.add("Thursday");
//		days.add("Friday");
//		days.add("Saturday");
//		days.add("Sunday");
//		System.out.println();
//		for(int i=0; i < days.size(); i++)
//		System.out.print(days.get(i) + " ");
//		
//		
//		
//		days.remove(0);
//		System.out.println();
//		for(int i=0; i < days.size(); i++)
//			System.out.print(days.get(i) + " ");
//		
//		System.out.println();
//		days.add(2, "Monday");
//		days.set(6, "Funday");
//		
//		//sorting a list
//		Collections.sort(days);
//		
//		for(int i=0; i < days.size(); i++)
//			System.out.print(days.get(i) + " ");
//		
//		for(String s : days)
//			System.out.print(s + " ");
//		System.out.println();
		
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		System.out.print("How many random numbers should there be?: ");
		int x = sc.nextInt();
		
		for(int i = 0; i<=x ;i++) nums.add((int)((Math.random()*26)+75));
		
		
		for(int n : nums)
		{
			System.out.println(n);	
		}
		
		double average = 0.00;
		int sum = 0;
		
		for(int i = 0; i < nums.size();i++)
		{
			sum = sum+nums.get(i);
		}
		average=1.0*sum/nums.size();
		System.out.println("The average is " +average);
		
		sc.close();
	}

}
