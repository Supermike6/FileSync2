package Experiments.Random;

import java.util.ArrayList;

public class random
{
    public static void main(String[] args)
    {
        
        int[] arr = {10, 20, 30, 40, 50};

for(int x = 1; x < arr.length - 1; x++)

{

arr[x + 1] = arr[x] + arr[x + 1];

}
for(int i : arr)System.out.println(i);
        
        
    }
}
