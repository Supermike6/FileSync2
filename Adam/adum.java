package Adam;

public class adum
{
    public static void main(String[] args)
    {
        // String str = "Adam likes Rockets";
        int i = 0;
        int count = 0;
        while(i<20||i>100)
        {
            i = (int)(Math.random()*400000);
            System.out.println(i);
            count++;
        }

        System.out.println("It took "+count+" tries!");
    }  
}

