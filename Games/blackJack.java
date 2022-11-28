import java.util.ArrayList;
import java.util.Scanner;
public class blackJack
{
    private static int points = 1000; 
    private static double ran = Math.random();
    private static ArrayList<Integer> deck = new ArrayList<Integer>();
    private static ArrayList<Integer> player = new ArrayList<Integer>();
    private static ArrayList<Integer> dealer = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to Blackjack! If you are reading this then the author assumes you know how to play blackjack. (ace counts as 1)");
        while(points!=0)
        {
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter an amount to bet: ");
            int bet = sc.nextInt();
            if(bet>=points) bet = points;
            if(bet<1) bet = 1;
            for(int i = 1; i<=10;i++)
                for(int j = 0; j<4; j++) 
                    deck.add(i);
            for(int i = 0;i<2;i++) {
                dealToPlayer();
                dealToDealer();
            }
            System.out.println("Your hand: " + player);
            System.out.println("Dealer's hand: [" +dealer.get(dealer.size()-1) + ", ...]");

            while(sumList(player)<21&&sumList(dealer)<21) {
                System.out.print("Hit or stand? ");
                String choice = sc.next();
                
                if(choice.equalsIgnoreCase("hit"))
                {
                    dealToPlayer();
                    System.out.println();
                    if(sumList(player)==21) {
                            System.out.println("Blackjack! You win!");
                            points+=bet;
                        } else if(sumList(player)>21) {
                                System.out.println("Bust! You lose!");
                                points-=bet;
                            }
                            
                    System.out.println("Your hand: " + player);
                    System.out.print("Dealer's hand: ["); for(int i = 0;i<dealer.size()-2;i++) System.out.print(dealer.get(i) + ", "); System.out.println(dealer.get(dealer.size()-1) + "]");
                            
                        } else if(choice.equalsIgnoreCase("stand"))
                    {
                    while(sumList(dealer)<21)
                        if(Math.random()<((21-sumList(dealer))/21)) {
                            dealToDealer();
                            System.out.println("Dealer hits!");

                            // if(sumList(dealer)>21) {
                            //     System.out.println("Dealer busts! You win!");
                            //     points+=bet;
                            // } else if(sumList(dealer)==21) {
                            //     System.out.println("Dealer has blackjack! You lose!");
                            //     points-=bet;
                            // } else if(sumList(dealer)>sumList(player)) {
                            //     System.out.println("Dealer has a higher hand! You lose!");
                            //     points-=bet;
                            // }
                        } else {
                            System.out.println("Dealer stands!");
                            
                            if(sumList(dealer)<sumList(player))
                            {
                                System.out.println("You have a higher hand! You win!");
                                points+=bet;
                            } else if(sumList(dealer)==sumList(player))
                            {
                                System.out.println("You have the same hand! You tie!");
                            }
                        }
                } else {
                    System.out.println("Invalid choice.");
                }
            }
            System.out.println("You have " + points + " points."); 
        }
    }
    public static int sumList(ArrayList<Integer> nums)
    {
        int num = 0;
        for(int i = 0; i<nums.size();i++)
            num+=nums.get(i);
        
        return num;
    }   
    public static void dealToPlayer()
    {
        ran = Math.random();
        player.add(deck.get((int)(ran*deck.size())));
        deck.remove((int)(ran*deck.size()));
    }
    public static void dealToDealer()
    {
        ran = Math.random();
        dealer.add(deck.get((int)(ran*deck.size())));
        deck.remove((int)(ran*deck.size()));
    }
}   

//print hello in a method caller printHello
