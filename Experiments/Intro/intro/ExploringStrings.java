package Intro.intro;


public class ExploringStrings {

	public static void main(String[] args)
	{
		
//		String name = "William Gates";
//		
//		System.out.println(name.substring(name.indexOf(" ")+1));
//		
//		char[] myString = {'h', 'e', 'l', 'l', 'o'};
//		
//		System.out.println(myString);
		
//		String text = "William Gates";
//
//		System.out.println("You entered: \""+text+"\"");
//		System.out.println("The string \""+text+"\" has "+text.length()+" characters.");
//		System.out.println("In all uppercase, it reads: "+text.toUpperCase());
//		System.out.println("In all uppercase, it reads: "+text.toLowerCase());
//		char character = 'a';
//		System.out.println("The character '" +character+"' is found at index "+text.indexOf(character)+".");
//		System.out.println("The character at the end of the string is: "+text.substring(text.length()-1));
//		System.out.println("The first half of the string is: "+text.substring(0,text.length()/2));
//		System.out.println("the second half of the string is: "+text.substring(text.length()/2));
//		System.out.println("The first word entered is \"" +text.substring(0,text.indexOf(" "))+"\"");
//		System.out.println("The words after the first word are \"" +text.substring(1+text.indexOf(" "))+"\"");
	
		String name = "William Gates";
	
		String first = name.substring(0, name.indexOf(" "));
		String last = name.substring(name.indexOf(" ") + 1);
		System.out.println(last + ", " + first);
		
		
		
		
	}

}
