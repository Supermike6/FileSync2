import java.util.ArrayList;
import java.util.Scanner;
    /*Before each round, you will be prompted to place a bet. You can place any bet as long as it is within the number of points you have. If you try to 
        cheat the system by entering more points than you have, you will automatically bet all of the points you have, but not anymore than that. If you 
        lose the round, you lose the amount of points you bet. If you win the round, you win the number of points you bet. After that you are dealt two 
        'cards' with values ranging from 1 to 11. The dealer also has two cards, but you can only see the value of 1 of those cards. After that you can 
        choose either to hit or stand. If you hit, you are dealt another card, and then you are prompted again to hit or stand. You can hit as many times 
        as you want, but beware that if the total value of your cards goes over 21 you get a bust and you lose. If the total value of your cards is exactly
        21, it is a blackjack and you instantly win the round. If you choose to stand, you are no longer prompted to hit or stand for that turn and the
        the dealer reveals his second card. The dealer will then continuously start dealing himself cards until the total value of his cards is more than the
        total value of your cards, he gets a blackjack, or until he gets a bust. If the total value of the dealer's cards is more than yours or if the
        the dealer gets a blackjack, you will lose. If the dealer gets a bust, then you win! You will get 1000 points to start with, so good luck!
        Press enter to start.
        */

public class blackJack
{
    private static int points = 1000;
    private static double ran = Math.random();

    //creates hands
    private static ArrayList<Integer> deck = new ArrayList<Integer>();
    private static ArrayList<Integer> player = new ArrayList<Integer>();
    private static ArrayList<Integer> dealer = new ArrayList<Integer>();
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        //gets bet
        System.out.print("Enter an amount to bet: ");
        int bet = sc.nextInt();

        //fixes bad bets
        if(bet>=points) bet = points;
        if(bet<=0) bet = 1;

        //generates deck
        for(int i = 1; i<=11;i++)
            for(int j = 0; j<4; j++) 
                deck.add(i);

        //deals cards
        for(int i = 0;i<2;i++)
        {
            dealTo(player, deck);
            dealTo(dealer, deck);
        }
        
        
        while(sumList(player)<=21)
        {
            System.out.println("Your Hand: ");
            String s = sc.nextLine();
            System.out.print("Would you like to hit or stand? ");

            if(s.equalsIgnoreCase("Hit"))
                dealTo(player, deck);
            
            if(s.equalsIgnoreCase("Stand"))
                dealTo(dealer, deck);  

        }
        

    }

    public static int sumList(ArrayList<Integer> nums)
    {
        int num = 0;
        for(int i = 0; i<nums.size();i++)
            num+=nums.get(i);
        
        return num;
    }
    
    public static void dealTo(ArrayList<Integer> target, ArrayList<Integer> source)
    {
        ran = Math.random();
        target.add(source.get((int)(ran*source.size())));
        source.remove((int)(ran*source.size()));
    }


}   