package Homework;

import java.util.ArrayList;

public class algorythms
{
    public static void main(String[] args)
    {
        System.out.println(reverseString("e"));
        for(int i: parseXY("(1,2)")) System.out.println(i);
    }

    public static String reverseString(String s)
    {
        ArrayList<String> ss = new ArrayList<>();
        String out = "";

        for(int i = 0;i<s.length();i++)
            ss.add(s.substring(i, i+1));

        for(int i = ss.size()-1;i>=0;i--)
        out+=ss.get(i);

        return out;
        
    }



    public 
    static 
    int[] 
    parseXY
    (
        String 
        s
        )
    {
        return
         new
          int[]
        {
            Integer
            .
            parseInt
            (
                s
                .
                substring
                (
                    s
                    .
                    indexOf
                    (
                        "("
                    )
                +
                1
            ,
             s
             .
             indexOf
             (
                 ","
             )
             )
             )
             ,
            Integer
            .
            parseInt
            (
                s
                .
                substring
                (
                    s
                    .
                    indexOf
                    (
                        ","
                    )
                    +
                    1
            ,
             s
             .
             indexOf
             (
                 ")"
                 )
                 )
                 )
        }
        ;
    }
}