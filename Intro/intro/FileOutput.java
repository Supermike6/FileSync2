package Intro.intro;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileOutput {

	public static void main(String[] args)
	{
		try {
		      //create a buffered reader that connects to the console, we use it so we can read lines
		      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		      //read a line from the console
		      String lineFromInput = in.readLine();

		      //create an print writer for writing to a file
		      PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

		      //output to the file a line
		      out.println(lineFromInput);

		      //close the file (VERY IMPORTANT!)
		      out.close();
		   }
		      catch(IOException e1) {
		        System.out.println("Error during reading/writing");
		   }
		
		
	}

}
