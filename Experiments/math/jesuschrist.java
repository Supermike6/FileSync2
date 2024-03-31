package math;

import java.math.BigInteger;

public class jesuschrist
{

    public static void main(String[] args)
    {
        BigInteger a2100 = new BigInteger("1");
        BigInteger out1 = new BigInteger("1");
        
        for(int i = 0; i<100;i++)
        {
            a2100 = a2100.multiply(new BigInteger("2"));
        }
        System.out.println(a2100.toString());

    
    }
}
