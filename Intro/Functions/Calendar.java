package Intro.Functions;

public class Calendar {

	public static void main(String[] args) 
	{
		
		getEasterYear(4,1,48,10000,true);
		
	}
	
	public static String getMonthName(int intMonth)
	{
		String stringMonth = "";
		
		if(intMonth == 1) stringMonth = "January";
		else if(intMonth == 2) stringMonth = "February";
		else if(intMonth == 3) stringMonth = "March";
		else if(intMonth == 4) stringMonth = "April";
		else if(intMonth == 5) stringMonth = "May";
		else if(intMonth == 6) stringMonth = "June";
		else if(intMonth == 7) stringMonth = "July";
		else if(intMonth == 8) stringMonth = "August";
		else if(intMonth == 9) stringMonth = "September";
		else if(intMonth == 10) stringMonth = "October";
		else if(intMonth == 11) stringMonth = "November";
		else if(intMonth == 12) stringMonth = "December";
		else if(intMonth > 12) stringMonth = "Not a month.";
		return stringMonth;
		
	}
	
	public static int getEasterDay(int year)
	{
		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g +15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int month = (h - m + r + 90) / 25;
		int day = (h - m + r + month + 19) % 32;
		
		return day;
	}
	
	public static int getEasterMonth(int year)
	{
		int a = year % 19;
		int b = year / 100;
		int c = year % 100;
		int d = b / 4;
		int e = b % 4;
		int g = (8 * b + 13) / 25;
		int h = (19 * a + b - d - g +15) % 30;
		int j = c / 4;
		int k = c % 4;
		int m = (a + 11 * h) / 319;
		int r = (2 * e + 2 * j - k - h + m + 32) % 7;
		int month = (h - m + r + 90) / 25;
		
		return month;
	}
	
	
	public static void getEasterDate(int year)
	{
		int month = getEasterMonth(year);
		String monthname = getMonthName(month);
		
		int day = getEasterDay(year);
		
		System.out.println("In the year " + year + " Easter falls on " + monthname + " " + day + "" + getNumSuffix(day));
	}
	
	public static String getNumSuffix(int num)
	{
		String output = "";
		if ((num % 100) == 11) output = "th";
		else if ((num % 100) == 12) output = "th";
		else if ((num % 100) == 13) output = "th";
		else if ((num % 10) == 1) output = "st";
		else if ((num % 10) == 2) output = "nd";
		else if ((num % 10) == 3) output = "rd";
		else if ((num % 10) == 4) output = "th";
		else if ((num % 10) == 5) output = "th";
		else if ((num % 10) == 6) output = "th";
		else if ((num % 10) == 7) output = "th";
		else if ((num % 10) == 8) output = "th";
		else if ((num % 10) == 9) output = "th";
		else if ((num % 10) == 0) output = "th";	
		
		return(output);
		
	}

	public static void getEasterYear(int month, int day,int startYear, int endYear, boolean printCount){
		String result = "";
		int count = 0;
		
		for(int x = startYear; x <= endYear; x++)
			if(getEasterDay(x)==day && getEasterMonth(x) == month){
				result = "" + x;
				System.out.println(result);	
				count++;
			};
			
		if(printCount == true) System.out.println("Out of "+ (endYear-startYear) +" years there were " + count + " years that have Easter on "+ month + "/" + day + ".");
		
		
		
		
	}
	
}
