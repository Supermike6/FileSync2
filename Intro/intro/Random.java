package Intro.intro;

public class Random {

	public static void main(String[] args)
	{
		
//		int randomNum=100;
//		int count = 0;
//		
//		do
//		{
//			System.out.println(randomNum);
//			randomNum = (int) (Math.random()*100+1);
//			count++;
//		}while(randomNum != 100);
//		
//			System.out.println(randomNum);
//			System.out.println("You Generated " + count + " numbers.");
			
			String[] grades = {"A", "B", "C","D","E","F"};
			
			int randomIndex = (int) (Math.random()*grades.length);
			
			
			System.out.println(grades[randomIndex]);
		
	}

}
