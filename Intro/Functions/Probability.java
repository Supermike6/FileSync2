package Intro.Functions;

public class Probability {

	public static void main(String[] args) {
		
	flipACoin(90);
		
	}

	public static void flipACoin(int timesCoinFliped)
	{
		for(int i=0; i<timesCoinFliped; i++)
		{
			double ranNum = Math.random();
			if(ranNum<0.5) System.out.println("Heads");
			if(ranNum>0.5) System.out.println("Tails");
			if(ranNum==0.5) System.out.println("Edge");
		}		
		
	}
	
	public static void rollADice(int timesDieRolled)
	{
		for(int i=0; i<timesDieRolled; i++)
		{
			double side = ((Math.random()*6)+1);
			System.out.println((int) side);
			
		}	
		
	}
	
}
