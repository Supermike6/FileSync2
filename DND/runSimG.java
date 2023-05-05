package DND;

import java.util.Scanner;

public class runSimG
{
    private static String choice = "";
    public static void main(String[] args)
    {

        for(int i = 0;i<12;i++)System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Have you ever played the wonderful table top role playing game known as dungeons and dragons? \nWell, this program enables you to simulate a randomized battle against a monster of your choosing.");
        System.out.println("\n1. Beholder\n"+
                           "2. Troll\n"+
                           "3. Walking statue of Waterdeap\n"+
                           "4. Great Wyrm");
        System.out.print("Which monster do you wish to fight? ");
        choice = sc.nextLine();
        System.out.println();
        System.out.println("Now that you have chosen to fight monster #"+choice+" you can choose your level. Your stats will be randomized, and, since I am too lazy to code each dnd class, race, and subclass, you will be playing as a human fighter with the champion archetype. What level do you want to play as? (You can pick a number from 1 to 20): Good level choice! While we will preditermine almost all of your class features (ability scores, fighting styles, etc.), your stats will be rolled.");

        sc.close();
    }
}
