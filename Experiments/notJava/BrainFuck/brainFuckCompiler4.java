package notJava.BrainFuck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class brainFuckCompiler4 {
    static String PATH = "/Users/gbancroft25/Documents/GitHub/FileSync2/Experiments/notJava/BrainFuck/testcode.bf";
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(PATH));

        // Read the BrainFuck code from the input
        String code = scanner.nextLine();

        // Initialize the memory tape and pointer
        int[] tape = new int[30000];
        int pointer = 0;

        // Iterate through each character in the code
        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            switch (c) {
                case '>':
                    pointer++;
                    break;
                case '<':
                    pointer--;
                    break;
                case '+':
                    tape[pointer]++;
                    break;
                case '-':
                    tape[pointer]--;
                    break;
                case '.':
                    System.out.print((char) tape[pointer]);
                    break;
                case ',':
                    tape[pointer] = scanner.next().charAt(0);
                    break;
                case '[':
                    if (tape[pointer] == 0) {
                        int loopCount = 1;
                        while (loopCount > 0) {
                            i++;
                            char d = code.charAt(i);
                            if (d == '[') {
                                loopCount++;
                            } else if (d == ']') {
                                loopCount--;
                            }
                        }
                    }
                    break;
                case ']':
                    if (tape[pointer] != 0) {
                        int loopCount = 1;
                        while (loopCount > 0) {
                            i--;
                            char d = code.charAt(i);
                            if (d == ']') {
                                loopCount++;
                            } else if (d == '[') {
                                loopCount--;
                            }
                        }
                    }
                    break;
            }
        }
        System.out.println();
    }
}
