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
        int[] memory = new int[256];
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
                System.out.print((char)memory[memoryHead]);
            }
            
            instructions.remove(0);
        }


        //display the Memory Array
        printMemory(memory);
    
    
        System.out.println();
    }

    public static void printMemory(int[] memory)
    {
        int count = 0;
        for(int i = 0; i<32; i++) {
            count%=8;
            if(count==0)
            {
                System.out.println();
            }
            count++;
            System.out.print(memory[i]+" ");
        }
        System.out.println();
    }

}