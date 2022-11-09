package Experiments.math;

import java.util.ArrayList;

public class Desmosus
{
    public static void main(String[] args)
    {
        String eq = "20=5x";
        int yLoc = eq.indexOf("y");
        int eLoc = eq.indexOf("=");
        int xLoc = eq.indexOf("x");
        String leftSide = eq.substring(0, eLoc);
        String rightSide = eq.substring(eLoc+1);
        System.out.println(leftSide+", "+rightSide);
        for(String step:breakNumbers(eq)) System.out.println(step);
    }
    private static ArrayList<String> breakNumbers(String eq)
    {
        ArrayList<String> out = new ArrayList<String>();
        for(int i = 0;i<eq.length();i++)
        {
            out.add(eq.substring(i, eq.indexOf("+")));
            out.add(eq.substring(i, eq.indexOf("-")));
            out.add(eq.substring(i, eq.indexOf("*")));
            out.add(eq.substring(i, eq.indexOf("/")));
            out.add(eq.substring(i, eq.indexOf("=")));
            out.add(eq.substring(i, eq.indexOf("(")));
            out.add(eq.substring(i, eq.indexOf(")")));
        }


        return out;
    }

     

}
