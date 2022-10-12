package Homework;

import java.util.ArrayList;

public class NumberShiz
{
    public static void main(String[] args)
    {
        // int limit = 1000;
        // ArrayList<Integer> out = new ArrayList<Integer>();
        // ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        // for(int i = 0;i<limit;i++)
        // lists.add(factors(i));

        // System.out.println(lists);
        System.out.println(factors(100000001));
    }
    public static ArrayList<Integer> factors(int num)
    {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(double i = 1; i<=Math.sqrt(num)+1;i++)
        {
            if(num%i==0)
            {
                factors.add((int)i);
                factors.add(num/(int)i);
            }
        }
        return factors;
    }

    public int reverseOrder(int num)
    {
        
        return num;
    }

}
