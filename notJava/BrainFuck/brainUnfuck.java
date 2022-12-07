package notJava.BrainFuck;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
        File points = new File("Experiments/Graphics/points.txt");

        FileReader fr = new FileReader(points);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        makeFile("", "notJava/BrainFuck/testcode.bf");


        String out = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        char[] in = sc.nextLine().toCharArray();
        
        System.out.println((in[0]+"").compareTo(((char)(0)+"")));
        for(int j = 0;j<(in[0]+"").compareTo(((char)(0)+""));j++)
            out+="+";
            
        for(int j = 0;j>(in[0]+"").compareTo(((char)(0)+""));j--)
            out+="-";

        out+=".";


        // System.out.println((int)'h');
        for(int i = 1;i<in.length;i++)
        {
            for(int j = 0;j<(in[i]+"").compareTo(in[i-1]+"");j++)
                out+="+";
            
            for(int j = 0;j>(in[i]+"").compareTo(in[i-1]+"");j--)
                out+="-";
            out+=".";
        }
            
        
        
        makeFile(out,"notJava/BrainFuck/testcode.bf");
        sc.close();
    }

    public static void makeFile(String s, String path)
    {
        try {
            FileWriter fw = new FileWriter(path, false);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            
            pw.print(s);
            
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}