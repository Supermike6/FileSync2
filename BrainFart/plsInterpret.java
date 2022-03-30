package BrainFart;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class plsInterpret
{
    public static String source;
    public static int[] mem;
    public static int cellNum;
    public static String func;
    public static Scanner sc;
    public static int braceCheck;
    public static int braceLevel;
    public static int start;
    public static boolean skip;
    public static boolean inBrace;
    
    plsInterpret() throws IOException
    {
    }
    
    public static void main(String[] args) throws IOException
    {
        source = Files.readString(Paths.get("BrainFart", "testcode.bf"));
        mem = new int[256];
        cellNum = 0;
        func = "";
        sc = new Scanner(System.in);
        braceCheck = 0;
        braceLevel = 0;
        start = 0;
        skip = false;
        inBrace = false;
        //Brace counting
        for(int i = 0; i<source.length(); i++){
            func = source.substring(i, i+1);
            if(func.equals("[")) braceCheck++;
            if(func.equals("]")) braceCheck--;
        }
        if(braceCheck != 0){
            System.out.println("Problem with braces");
        }

        for(int j = 0; j<source.length(); j++)
        {
            if(!inBrace)
            {
                func = source.substring(j, j+1);
            } else {
                func = source.substring(cellNum+1, source.indexOf("]"));
            }
            System.out.println(func);
            if(func.equals("["))
            {
                start = cellNum;
                if(mem[cellNum]==0)
                {
                    skip = true;
                    cellNum = source.indexOf("]")+1;
                } else {inBrace = true;}
            }

            if(func.equals("]"))
            {
                if(start!=0)
                {
                    skip = false;
                    cellNum = source.indexOf("[")+1;
                } else {
                    skip = true;
                    cellNum = source.indexOf("]")+1;

                }
            }

            if(!skip){
                if(func.equals(">"))
                {
                    cellNum++;
                }
                if(func.equals("<")){
                    cellNum--;
                }
                if(func.equals("+"))
                {
                    mem[cellNum]++;
                }
                if(func.equals("-"))
                {
                    mem[cellNum]--;
                }
                if(mem[cellNum]<0)
                {
                    mem[cellNum] = 256+mem[cellNum];
                }
                if(func.equals(".")) System.out.println(mem[cellNum] + " | " + (char)mem[cellNum]);
                if(func.equals(","))
                {
                    String out = sc.next(); 
                    cellNum = source.indexOf(",")-1;
                    source.replace(",", out);
                }   
            }
        }
        
        printMem(mem);
            
    }

    public void plsDo(String source)
    {



    }
    public static void printMem(int[] mem)
    {
        for(int k = 0; k<8; k++)
        {
            for(int l = 0; l<32; l++)
            {
                System.out.print(mem[l+k*32]+", ");}
            }
        System.out.println();
        
    }
}