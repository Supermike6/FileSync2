package APCompsci.Homework;

import java.util.Scanner;

public class WhileLoopStuff
{
    public static void main(String[] args)
    {
        excedes100();
    }   
    public static void excedes100()
    {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while(sum<100)
        {
            System.out.print("Enter a integer: ");
            int num = sc.nextInt();
            sum+=num;
        }
        System.out.println("The sum is: "+ sum);
        
        sc.close();
    } 
}
