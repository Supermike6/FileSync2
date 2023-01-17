package Intro.intro;

import java.util.Scanner;

public class ExploringLists {

	public static void main(String[] args)
	{
		
		//option one for creating a list
//		int[] years = {2021,2031,2042,2050,3141};
//		
//		years[3] = 2060;
//		
//		for(int i = 0; i < years.length; i++)
//			System.out.println(years[i]);
		
		//option two create an empty list and fill it later
		
		int[] years1 = new int[10];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < years1.length; i++) 
		{
			System.out.print("Enter value number " + i +": ");
			years1[i] = sc.nextInt();
		}
		
		
		
		for(int i = 0; i < years1.length; i++)
		System.out.println(years1[i]);
	
		sc.close();
	}
}
