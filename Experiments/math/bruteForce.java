package Experiments.math;

public class bruteForce
{
    public static void main(String[] args)
    {
        double num1 = 0.00;
        double x1 = 0.00;
        double y1 = 0.00;
        double num2 = 0.00;
        double x2 = 0.00;
        double y2 = 0.00;
        
        for(x1=0;x1<50;x1+=0.1)
        {
            for(y1=66.67;y1>0;y1-=0.1)
            {
                num1=x1*y1;
                if(num1>num2)
                {
                    num2=num1;
                    x2=x1;
                    y2=y1;
                }
                System.out.println(num2+": ("+x2+", "+y2+")");
            }
        }
    }    
}
