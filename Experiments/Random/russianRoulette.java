package Experiments.Random;




public class russianRoulette
{
    public static void main(String[] args)
    {
        int dead = (int)(Math.random()*6);
        if(dead==1)System.out.println("you gone gone");
        else System.out.println("you not gone gone");
    }
}
