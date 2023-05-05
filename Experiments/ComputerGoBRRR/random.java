package Experiments.ComputerGoBRRR;

public class random
{
    public static int gcd(int a, int b)
    {
        if(b <= 0 ||  a<=0) return Math.min(a, b);
         return gcd(b, a%b);
    }

    public static void main(String[] args)
    {
        System.out.println(gcd(Integer.MAX_VALUE,Integer.MIN_VALUE));
        System.out.println("Success");
    }
}
