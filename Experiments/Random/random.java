package Experiments.Random;

import java.util.ArrayList;

public class random
{
    public static void main(String[] args)
    {
        int a = 2;
        int b = 3;



        System.out.println((a<0&&b<0 || a>0&&b<0)==(b<0));


    }  
    
    public static int gcf (int num1, int num2)
    {
        int gcf = 1;
        for(int i = 1; i<=num1 && i<=num2; i++)
            if(num1%i == 0 && num2%i == 0)
            gcf = i;
        return gcf;
    }
    public void simplify()
    {
        int gcf = gcf(a,b)
        a = a/gcf;
        b = b/gcf;
        if(b<0)
        {
            a = -a;
            b = -b;
        }
        if(a == 0) b = 1;
    }
    public static int getDigitSum(int num)
    {
        int sum = 0;
        while(num != 0)
        {
            sum+= (num%10);
            num/=10;
        }
        return sum;
    }
    public static ArrayList<Integer> getFactors(int value)
    {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for(int i = 1; i<=Math.sqrt(value);i++)
        {
            if(value%i==0)
            {
                factors.add(i);
                factors.add(value/i);
            }
        }
        return factors;
    }   
    public boolean isPrime(int num)
    {
        for(int i = 2; i<=Math.sqrt(num);i++)
            if(num%i==0) return false;
        return true;
    }
    public long getFactorial(int num)
    {
        long f = 1;
        for(int i = 1; i<num; i++)
        f*=i;
        return f;

    }
}
