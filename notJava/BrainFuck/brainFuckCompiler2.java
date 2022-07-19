package notJava.BrainFuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class brainFuckCompiler2 
{
    // private static String line;
    // private static Integer[] memory = new Integer[256];
    // private static int memoryHead = 0;
    // private static ArrayList<String> instructions = new ArrayList<>(0);
    // private static String instruction = "";
    // private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws FileNotFoundException
    {
        //initializing variables
        String line="";
        Integer[] memory = new Integer[256];
        int memoryHead = 0;
        ArrayList<String> instructions = new ArrayList<>(0);
        String instruction = "";
        File file = new File("notJava/BrainFuck/testcode.bf");
        Scanner sc = new Scanner(file);

        //populating memory array
        for(int i = 0; i<256; i++)
        {
            memory[i] = 0;
        }
    
        //populating instructions list
        while(sc.hasNextLine())
        {
            line = sc.nextLine();
            for(int i = 0; i<line.length();i++){
                instructions.add(line.split("")[i]);
            }
        }

        compipleAndRun(memory, memoryHead, instructions);

        //display the Memory Array
        printMemory(memory, memoryHead);
    
        System.out.println();
    }

    public static void compipleAndRun(Integer[] memory, int memoryHead, ArrayList<String> instructions) throws FileNotFoundException
    {
        String instruction = "";
        Scanner sc = new Scanner(System.in);
    //basic instructions loop
        while(instructions.size()>0)
        {
            instruction = instructions.get(0);
            if(instruction.equals("+")){
                memory[memoryHead]++;
                if(memory[memoryHead]>255)
                {
                    memory[memoryHead] = 0;
                }
            }
            if(instruction.equals("-")){
                memory[memoryHead]--;
                if(memory[memoryHead]<0)
                {
                    memory[memoryHead] = 255;
                }
            }
            if(instruction.equals(">")){
                memoryHead++;
            }
            if(instruction.equals("<")){
                memoryHead--;
            }
            if(instruction.equals(".")){
                System.out.print((char)(int)memory[memoryHead]);
            }
            if(instruction.equals(",")){
                System.out.print("Enter a character: ");
                sc = new Scanner(System.in);
                memory[memoryHead] = sc.nextInt();
            }
            looping(instructions, memory, memoryHead, sc);
            instructions.remove(0);
        }
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

    public static void looping(ArrayList<String> instructions, Integer[] memory, int memoryHead, Scanner sc) throws FileNotFoundException
    {

        int tempInt = memory[memoryHead];
        int tempMemH = memoryHead;
        if(instructions.get(0).equals("["))
        System.out.println(tempInt);
        String instS = "";
        for(String s: instructions) instS+=s;
        System.out.println(instS);
        while(tempInt!=0)
        {
            compipleAndRun(memory, memoryHead, instructions);
            tempInt = memory[memoryHead];
            tempMemH = memoryHead;
        }
        
        

    }
}
