package Games;

import java.util.Scanner;

import Experiments.functions.Formating;

public class Chopsticks
{
    int p11 = 0;
    int p12 = 0;
    int p21 = 0;
    int p22 = 0;

    
    public static void main(String[] args)
    {
        Formating.textRed();
        String mode = "default";
        Scanner sc = new Scanner(System.in);
        int p11 = 1;
        System.out.println("P1: ");
        String input = sc.nextLine();
        String state = "won";

        while(mode.equals("default") && !state.equals("won"));


    }    
    public void printHand()
    {

    }
}
