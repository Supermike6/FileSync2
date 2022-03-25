public class Factorial
{
	public static void main(String[] args)
	{
		
		int n = 20;
		
		for(int i = 0;i<=n;i++)
		System.out.println(i+". "+factorial(i));
		
	}
	
	public static long factorial(long n)
	{
		long nFac =1;
		
		for(long i =0; i<n;i++)
		{
			nFac*=(n-i);
		}
		
		return nFac;
	}

	
}
