package Games;



public class run2048
{
    public static void main(String[] args)
    {
        double num = Math.random()*2048;
        if(num<0.5)
        {
            System.out.println("You win");
        }
    }    
}
