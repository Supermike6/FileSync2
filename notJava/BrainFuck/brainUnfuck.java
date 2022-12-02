package notJava.BrainFuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class brainUnfuck 
{
    static String line="";
    static Integer[] memory = new Integer[256];
    static int memoryHead = 0;
    static ArrayList<String> instructions = new ArrayList<>(0);
    static String instruction = "";
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("notJava/BrainFuck/helloWorld.bf");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        char[] in = sc.nextLine().toCharArray();


        sc.close();
    }
}