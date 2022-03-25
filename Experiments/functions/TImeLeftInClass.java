package Experiments.functions;

import java.time.*;

public class TImeLeftInClass {

	public static void main(String[] args)
	{	
		timeLeft();
	}
	
	public static void timeLeft()
	{
	
		LocalTime now = LocalTime.now();
		System.out.println(now.toString());
		
		System.out.println(now.getMinute());
		
		
		
		
	}
	
}
