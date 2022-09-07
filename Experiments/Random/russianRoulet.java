package Experiments.Random;

public class russianRoulet
{
    public static void main(String[] args)
    {
        
        int num = (int)(Math.random()*6);
        while(num!=3)
        {
            System.out.println("You didn't die :) "+num);
            num = (int)(Math.random()*6);
        }
        System.out.println("BANG! You are have dead now "+num);
    }
}
