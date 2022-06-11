package notJava.BrainFuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class brainFuckCompiler2 
{
    
    public static void main(String[] args) throws FileNotFoundException
    {
        //initializing variables
        File file = new File("notJava/BrainFuck/testcode.bf");
        Scanner sc = new Scanner(file);
        String line;
        Integer[] memory = new Integer[256];
        int memoryHead = 0;
        ArrayList<String> instructions = new ArrayList<>(0);
        
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


        //basic instructions loop
        while(instructions.size()>0)
        {
            String instruction = instructions.get(0);
            if(instruction.equals("+"))
            {
                memory[memoryHead]++;
                if(memory[memoryHead]>=256)
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
            
            instructions.remove(0);
        }


        //display the Memory Array
        printMemory(memory,memoryHead);
    
    
        System.out.println();
    }

    public static void printMemory(Integer[] memory, int memoryHead)
    {
        ArrayList<String> tempList = new ArrayList<>(32);
        for(Integer i = 0; i<32; i++)
        {
            String tempString = "";
            for(int j = 0; j<digits(memory[i]); j++){
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

}