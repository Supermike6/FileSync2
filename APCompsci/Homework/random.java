package APCompsci.Homework;

public class random
{
    public static void main(String[] args)
    {
        int total = 0;
        for(int i = 100; i<1000; i++)
            if(i%4==0&&i%6==0)
                total++;
        System.out.println(total);
    }    
}
