package Intro.Functions;

public class Text
{

	public static void main(String[] args)
	{
		
		String name = "Steve Jobs";
		
		System.out.println(getEmail(name));
		
		for(int i = 0; i<1000; i++)
		System.out.println((char) i);
		System.out.println((int) 'Q');
		
		
		
		
		
	}
	
// First functions
	public static String getFirst(String fullName)
	{
		
		return fullName.substring(0,fullName.indexOf(" "));
	
	}
	
	public static int getFirstLength(String fullName)
	{
		
		return fullName.substring(0,fullName.indexOf(" ")).length();
	
	}
	
//Last functions
	public static String getLast(String fullName)
	{
		
		return fullName.substring(fullName.indexOf(" ")+1,fullName.length());
	
	}
	
	public static int getLastLength(String fullName)
	{
		
		return fullName.substring(fullName.indexOf(" ")+1,fullName.length()).length();
	
	}
	
//Other Functions
	public static int getFullLength(String fullName)
	{
		
		return fullName.length();
		
	}
	
	public static String getLastFirst(String fullName)
	{
		
		return getLast(fullName)+", "+getFirst(fullName);
		
	}

	public static String getInitials(String fullName)
	{
		
		String fInitial = getFirst(fullName).substring(0, 1);
		String lInitial = getLast(fullName).substring(0, 1);
		
		return fInitial + lInitial;
		
	}

	public static String getEmail(String fullName)
	{
		
		String lowerName = fullName.toLowerCase();
		
		String lastSix = "";
		String firstTwo = getFirst(lowerName).substring(0,2);
		if(getLastLength(lowerName)<7)
		{
			lastSix=getLast(lowerName);
		} else {
			getLast(lowerName).substring(0,6);
		}
		
		return lastSix+firstTwo+"@pascack.org";
		
		
	}
	
	
}