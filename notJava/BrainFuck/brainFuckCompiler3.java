package notJava.BrainFuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class brainFuckCompiler3
{
    static String line="";
    static Integer[] memory = new Integer[32];
    static int memoryHead = 0;
    static ArrayList<String> instructions = new ArrayList<>(0);
    static String instruction = "";
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("notJava/BrainFuck/testcode.bf");
        Scanner sc = new Scanner(file);
        //initializing variables

        // int num = 0;
        // for(int i = 8; i!=0;i--)
        // {
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        //     num++;
        // }
        // System.out.println((char)num);

        //populating memory array
        for(int i = 0; i<32; i++)
        {
            memory[i] = 0;
        }
        
        //populating instructions list
        while(sc.hasNextLine())
        {
            line += sc.nextLine();
        }
        runTask(line);
        
        //display the Memory Array
        // printMemory(memory, memoryHead);
        
        System.out.println();
        sc.close();
    }
    public static void printMemory(Integer[] memory, int memoryHead)
    {
        ArrayList<String> tempList = new ArrayList<>(32);
        for(Integer i = 0; i<32; i++)
        {
            String tempString = "";
            for(int j = 0; j<=digits(memory[i]); j++){
                tempString+=" ";
            }
            tempList.add(tempString);
            
        }
        tempList.set(memoryHead, "^");
        for(int i = 0; i<32; i++) {
            System.out.print(memory[i]+" ");
        }
        System.out.println();
        for(int i = 0; i<32; i++) {
            System.out.print(tempList.get(i)+" ");
        }
        System.out.println();
    }
    
    public static int digits(int num)
    {
        int count = 0;
        while(num>0)
        {
            num/=10;
            count++;
        }
        return count;
    }
    
    public static void runTask(String in)
    {
        int startHead = 0;
        char[] insts = in.toCharArray();
        for(int i = 0;i<insts.length;i++)
        {
            char inst = insts[i];
            if(inst=='+')
            {
                memory[memoryHead]++;
                if(memory[memoryHead]>255) memory[memoryHead]=0;   
            }
            if(inst=='-')
            {
                memory[memoryHead]--;
                if(memory[memoryHead]<0) memory[memoryHead]=255;  
            }
            if(inst=='>')
            {
                memoryHead ++;
            }
            if(inst=='<')
            {
                if(memoryHead-1<0)
                {
                    memoryHead = 31;
                } else {
                    memoryHead --;
                }   
            }
            if(inst=='.')
            {
                System.out.print((char)(int)memory[memoryHead]);
            }
            if(inst==',')
            {
                Scanner sc = new Scanner(System.in);
                memory[memoryHead] = (int) sc.nextLine().toCharArray()[0];
                sc.close();
            }
            // in.substring(instIndex, in.indexOf("]", instIndex));
            
            if(inst == '[')
            {
                startHead=memoryHead;
                if(memory[startHead] == 0)
                {
                    for(int j = 0; j<in.substring(i,in.indexOf("]", i)).length(); j++)
                        i++;
                } else 
                {
                    while(memory[startHead] !=0)
                    {
                        runTask(in.substring(i+1,in.indexOf("]", i+1)));
                    }
                    // System.out.println(memory[startHead]);
                    i = in.indexOf("]", i);
                }
            }
            // printMemory(memory, memoryHead);
        }   
    }
}