package Intro.intro;

import java.util.Scanner;

//Honors Computer Science
//Sept 2020
//Program description: These exercises are designed to:
//                      - introduce math operations and functions in Java
//                      - practice declaring and using variables
//                      - develop algorithmic thinking

public class MathExercises
{
   public static void main(String[] args)
   {
	   
	   Scanner sc = new Scanner(System.in);
	   
      /** Exercise #1
       *  a) Prompt the user to enter 2 integers.
       *  b) Display the sum, difference, product and quotient.
       *     For example, if 42 and 18 are entered, display:  42 + 18 = 60 ... etc.
       */
      
	   
	   System.out.print("Enter an integer: ");
	   int num1 = sc.nextInt();
	   System.out.println();
	  
	   System.out.print("Enter another integer: ");
	   int num2 = sc.nextInt();
	   System.out.println();
	   
	   
	   int sum = num1 + num2;
	   System.out.println(num1 + " + " + num2 + " = " + sum);
	   
	   
      /** Exercise #2
       *  Repeat exercise #1 using decimals
       */
	   
	   
	   System.out.print("Enter an integer: ");
	   int num1i = sc.nextInt();
	   System.out.println();
	  
	   System.out.print("Enter another integer: ");
	   int num2i = sc.nextInt();
	   System.out.println();
	   
	   int sumi = num1i + num2i;
	   System.out.println(num1i + " + " + num2i + " = " + sumi);
	   
      
      /** Exercise #3
       *  a) Prompt the user for 2 integer sets of ordered pairs... (x1, y1) and (x2, y2)
       *  b) Calculate and display the slope of the line containing those points using a variable called slope.
       *  c) Calculate and display the distance between those points using a variable called distance.
       */
      System.out.println();
      
	   
	   System.out.print("First x value: ");
	   int x1 = sc.nextInt();
	   
	   System.out.print("First y value: ");
	   int y1 = sc.nextInt();
	   
	   System.out.print("Second x value: ");
	   int x2 = sc.nextInt();
	   
	   System.out.print("Second y value: ");
	   int y2 = sc.nextInt();
	   
	   int slope = (y2 - y1)/(x2-x1);
	   double distance = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
	   
	   System.out.println("The slope is " + slope);
	   System.out.println();
	   System.out.println("The distance is " + distance);
	   
      /** Exercise #4
       *  a) Enter the number of quarters, dimes, nickels and pennies in a piggy bank.
       *  b) Calculate and display the total amount of money in a variable called total.
       */
      
	   System.out.print("Number of quarters: ");
	   int q = sc.nextInt();
	   
	   System.out.print("Number of dimes: ");
	   int d = sc.nextInt();
	   
	   System.out.print("Number of nickles: ");
	   int n = sc.nextInt();
	   
	   System.out.print("Number of pennies: ");
	   int p = sc.nextInt();
      
	   int cents4 = q*25+d*10+n*5+p;
	   
	   System.out.println("Your piggy bank contains: " + cents4 + " cents.");
	   
      /** Exercise #5
       *  a) Enter a total number of cents (int) and determine the minimum number of dollar bills and coins needed for that amount of money.
       *  b) For example, 293 cents is 2 dollars, 3 quarters, 1 dime, 1 nickels, and 3 pennies.
       */
	   
      System.out.println();
	   
	  System.out.print("Number of cents: ");
	  int cents5 = sc.nextInt();
	  int dol = (cents5-(cents5 % 100));
	  int qua = ((cents5-dol)-(cents5-dol)%25);
	  int dim = ((cents5-dol-qua)-(cents5-dol-qua)%10);
	  int nic = ((cents5-dol-qua-dim)-(cents5-dol-qua-dim)%5);
	  int pen = ((cents5-dol-qua-dim-nic)-(cents5-dol-qua-dim-nic)%1);
	  
	  System.out.println(cents5 + " is " + dol/100 + " dollars, " + qua/25 + " quarters, " + dim/10 + " dimes, " + nic/5 + " nickles and, " + pen + " penies.");
	   
	  sc.close();
   }
}
