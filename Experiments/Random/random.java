package Experiments.Random;



public class random
{
    public static void main(String[] args)
    {
        int coinsFlipped = 200000000;
        int heads = 0;
        int tails = 0;

        for(int i = 0; i<coinsFlipped; i++)
        {
            int num = (int)(2*Math.random());
            if(num>=1)
            {
                heads++;
            } else {
                tails++;
            }
        }
        System.out.println("Heads: "+heads+", Tails: "+tails);


    }    
}
