package Experiments.ComputerGoBRRR.Robot;

import java.awt.AWTException;
import java.awt.Robot;

public class roboTest
{
    public static void main(String[] args)
    {
        try {
            Robot r = new Robot();
            System.out.println(r);
            r.mouseMove(50, 100);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }    
}
