package Experiments.Random;

public class russianRoulet
{
        
    public static int maxHits = 0;
    public static void main(String[] args)
    {
        for(int i = 0; i<1; i++)
            emptyClip();
        System.out.println(maxHits); 
    }
    public static void emptyClip()
    {
        int shots = 0;
        int num = (int)(Math.random()*6);
        while(num!=3&&shots!=6)
        {
            shots++;
            System.out.println("You didn't die :) "+num);
            num = (int)(Math.random()*6);
        }
        if(shots>maxHits)
        {
            maxHits=shots;
            System.out.println("BANG! You are have dead now "+num);
            System.out.println("Shots: "+shots);
            System.out.println("Chance(%): "+100*(1/Math.pow(6, shots)));
        }
    }
}
