import java.util.ArrayList;

public class random
{
    public static void main(String[] args)
    {
        int num = 0;
        while(true)
        {
            Thread thread = new Thread(){
                public void run(){
                  System.out.print("Heating Chocolate");

                }
              };
              thread.start();
              System.out.println(1/Math.sqrt(num));
              num++;
              
        }
        
    }
}
