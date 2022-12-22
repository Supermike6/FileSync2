package Experiments.ComputerGoBRRR;

import java.util.Scanner;

public class scientificNotation
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        System.out.println();
        for(int i = 0; i<Integer.parseInt(in.substring(in.indexOf("e")+1));i++) System.out.print("0");
        System.out.println();
        System.out.println(in);

    }    
}
