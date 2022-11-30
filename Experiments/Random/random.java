package Experiments.Random;

import java.util.ArrayList;

public class random
{
    public static void main(String[] args)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(0);
        nums.add(1);


        for(int i = 0;i<nums.size();i++)
            if(nums.get(i)==0)
                nums.remove(i);

                System.out.println(nums);
        
    }
}
