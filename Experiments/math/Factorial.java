package Experiments.math;

public class Factorial
{
	public static void main(String[] args)
	{
		
		int n = -10;
		
		System.out.println(factorial((long) n));
		
	}
	
	public static long factorial(long n)
	{
		long nFac = 1;
		
		for(long i = 0; i<n; i++)
		{
			nFac*=(n-i);
		}
		
		return nFac;
	}

	
}
