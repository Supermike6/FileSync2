package notJava.BrainFuck;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
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
    static String PATH = "/Users/gbancroft25/Documents/GitHub/FileSync2/Experiments/notJava/BrainFuck/testcode.bf";

    public static void main(String[] args) throws FileNotFoundException
    {
        makeFile("", PATH);

        String out = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        char[] in = sc.nextLine().toCharArray();
        int difZero = (in[0]+"").compareTo(((char)(0)+""));

        if(isPrimeNumber(difZero))

        for(int i = 0; i<in.length; i++)
        {
            
        }




        for(int j = 0;j<(in[0]+"").compareTo(((char)(0)+""));j++)
            out+="+";
            
        for(int j = 0;j>(in[0]+"").compareTo(((char)(0)+""));j--)
            out+="-";

        out+=".";

        for(int i = 1;i<in.length;i++)
        {
            for(int j = 0;j<(in[i]+"").compareTo(in[i-1]+"");j++)
                out+="+";
            
            for(int j = 0;j>(in[i]+"").compareTo(in[i-1]+"");j--)
                out+="-";
            out+=".";
        }
            
        
        
        makeFile(out,PATH);
        sc.close();
    }

    public static boolean isPrimeNumber(int i) {
        int factors = 0;
        int j = 1;

        while(j <= i)
        {
            if(i % j == 0)
            {
                factors++;
            }
            j++;
        }
        return (factors == 2);
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