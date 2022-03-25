import java.util.ArrayList;

public class mathFunc {
	
	public static void main(String[] args)
	{
		int[] nums = {10,3,45,6};
		
		for(int i = 0; i<gcf(nums).size(); i++)
		System.out.println(gcf(nums).get(i));
	}

	public static Double op(Double num){return 0-num;}
	public static Integer op(Integer num){return 0-num;}
	public static ArrayList<String> gcf(int[] nums)
	{
		ArrayList<String> factors = new ArrayList<String>();
		// ArrayList<String> factormin = new ArrayList<String>();
		for(int index = 0; index<nums.length; index++)
		{
			for(int i = 1; i<nums[index];i++)
			{
				if((nums[index]/(double)i)==(int)(nums[index]/i))
				{
					factors.add(i+"");
				}
			}
			factors.add("S");
		}

		// for(String i:factors)
		{
			

		}

		return factors;
	}

}
