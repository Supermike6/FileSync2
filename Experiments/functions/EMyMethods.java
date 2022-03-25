package Experiments.functions;

//Grant Bancroft
//Dec 1, 2021

public class EMyMethods {

	
	public static void main(String[] args)
	{
		
		String time = "17:59";
		String text = "adjjjjkkkkklllll jkj2";
		String[] array = {"aczzzze","ad","ab","ac","ahjgjhkhjg"};
		int num = (int) (Math.random()*1000000);
		
		System.out.println(isSchoolTime(time));
		System.out.println(countChar(text,','));
		System.out.println(printArray(array));
		System.out.println(getDayName(num));
	}

	public static int countChar(String text, char Target)
	{
		int count = 0;
		
		for(int i = 0; i < text.length(); i++)
		{
			if(text.toLowerCase().charAt(i) == Character.toLowerCase(Target))
				count++;
		}
		return count;
	}
	
	public static String reverseString(String text)
	{
		String rev = "";
		
		for(int i = 0; i < text.length(); i++)
		{
			
		rev += text.substring(text.length()-i-1,text.length()-i);
		
		}
		
		return rev;
		
	}

	public static boolean isOdd(int num)
	{
			
		return num%2 == 1;
		
	}

	public static String getDayName(int dayNum)
	{
		if(dayNum==1) return "Sunday";
		else if(dayNum==2) return "Monday";
		else if(dayNum==3) return "Tuesday";
		else if(dayNum==4) return "Wedsnesday";
		else if(dayNum==5) return "Thursday";
		else if(dayNum==6) return "Friday";
		else if(dayNum==7) return "Saturday";
		
		
		return "";
	}
	
	public static boolean isInRectangle(int x, int y, int w, int h, int x1, int y1)
	{
		boolean xCheck=false;
		boolean yCheck=false;
		
		if(x<x1 && x1<x+w) xCheck = true;
		if(y<y1 && y1<y+h) yCheck = true;
		
		if(xCheck==true && yCheck==true) return true;
		else return false;
		
	}
	
	public static boolean isVerticle(int x1, int y1, int x2, int y2)
	{
		
		if(x1==x2) return true;
		
		return false;
	}

	public static boolean isInCircle(int x, int y, int r, int x1, int y1)
	{
		int xProb = (int) Math.pow((x1-x), 2);
		int yProb = (int) Math.pow((y1-y), 2);
		int totalProb = xProb+yProb;
		
		if(totalProb<Math.pow(r, 2)) return true;
		
		return false;
	}

	public static boolean isSchoolTime(String time)
	{
		
		int hour = Integer.parseInt(time.substring(0,time.indexOf(':')));
		int min = Integer.parseInt(time.substring(time.indexOf(':')+1,time.length()));
		
		hour+=(min-min%60)/60;
		min=min%60;

		
		if(8<=hour && hour<15)
		{
			if(0<=min && min<=60)
			{
				if(hour==14 && min>53)
				{
					return false;
				}	
				
				return true;
			}
		}
		
		return false;
	}

	public static int sumArray(int[] arr)
	{
		int total = 0;
		for(int i=0;i<arr.length;i++) 
		{	
			total+=arr[i];
		}
		
		return total;
		
	}

	public static double getAverage(int[] arr)
	{
		return (sumArray(arr)+0.0) / arr.length;
		
	}
	
	public static int countOccurrencesOf(int[]arr ,int target)
	{
		int occur = 0;
		
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i] == target) occur++;
		}
		
		return occur;
		
	}

	public static int indexOf(int[] arr, int target)
	{
		
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i] == target) return i;
		}
		
		return -1;
	
	}
	
	public static String printArray(int[] arr)
	{
		String comp = "";
		
		for(int i=0; i<arr.length; i++)
		{
			if(i==arr.length-1) comp+=arr[i]+".";
			else comp+=arr[i]+", ";
		}
		
		return comp;
		
	}
	
	public static String printArray(String[] arr)
	{
		String comp = "";
		
		for(int i=0; i<arr.length; i++)
		{
			if(i==arr.length-1) comp+=arr[i]+".";
			else comp+=arr[i]+", ";
		}
		
		return comp;
		
	}
	
	public static int[] fillWithRandom(int[] arr, int min, int max)
	{
		int[] newArray = arr;
		
		for(int i = 0; i<arr.length; i++)
		{
			newArray[i] = (int)(Math.random()*(max-min+1))+min;
			
		}
		
		return newArray;
		
	}
	
	public static int getMax(int[] arr)
	{
		int highNum = arr[0];
		
		for(int i = 0; i<arr.length;i++)
		{
			if(arr[i]>highNum) highNum = arr[i];
		}
		
		return highNum;
	}
	
	public static int SSL(String[] arr)
	{
		int shortest = 0;
		int current = 0;
		
		for(int i = 0; i<arr.length; i++)
		{
			
			current = arr[i].length();
			if(current<shortest) shortest = current;
			
		}
		
		return shortest;
		
	}
	
	public static int fLN(String text, int index)
	{ 
		return (int) text.toUpperCase().charAt(index);
	//turns a string's first character into it's corresponding ascii number
	}
	
	public static String getFirstAlphabetically(String[] arr)
	{
		int currNum = fLN(arr[0],0);
		int lowNum=0;
		
		for(int i = 0; i<arr.length; i++)
		{
			if(currNum>fLN(arr[i],0)) lowNum = i;
		}
		
		return arr[lowNum];
	}

	public static String[] swapFirstLast(String[] arr)
	{
		String[] swap = arr;
		String first = arr[0];
		String last = arr[arr.length-1];
		
		swap[0] = last;
		swap[swap.length-1] = first;
		
		return swap;
	}
	
	public static String printRectangle(int width, int height)
	{
		String rect = "";
		
		for(int i = 0; i<height; i++)
		{
			for(int j = 0; j<width; j++)
			{
				rect +="*";	
			}
			rect +="\n";
		}
		
		return rect;
	}
	
}