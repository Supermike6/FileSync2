package Intro.intro;


import java.lang.reflect.Array;

public class FORLOOOOPS {

	public static void main(String[] args) {
		
//		for(int x = 0; x <= 2030; x = x+1)
//			Functions.Calendar.getEasterDate(x);
		

		
		int[] years = {2021, 2022, 2023, 2024, 2025};
		
		for( int i = 0; i<years.length; i++)
			if(i < years.length-1)
			{
				System.out.print(years[i]+ ", ");
			} else {
				System.out.println(years[i] + ".");
			}
	}

}
