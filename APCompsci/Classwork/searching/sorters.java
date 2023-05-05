import java.util.Arrays;
import java.util.Collections;

public class sorters
{
    public static void selectionSort(int[] arr)
    {
        int cycles = 0;
        int swaps = 0;
        for(int i = 0; i<arr.length; i++)
            for(int j = 1; j<arr.length-i; j++)
            {
                if(arr[j-1]>arr[j])
                {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    swaps++;
                }
                cycles++;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(cycles+", "+swaps);
    }

    public static void insertionSort(int[] arr)
    {
        int cycles = 0;
        int swaps = 0;
        for(int i = 1; i<arr.length;i++)
        {
            for(int j = i; j>0; j--)
            {
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    swaps++;
                }
                cycles++;
            }
        }
    }
  
    public static void mergeSort(int[] arr)
    {
        if(arr.length <=1) return;
        int[] first = new int[arr.length/2];
        int[] second = new int[arr.length-first.length];
        
        System.arraycopy(arr, 0, first, 0, 0);
        System.arraycopy(arr, first.length, second, 0, second.length);

        mergeArray3(arr, first, second);
    }

    public static void mergeArray(int[] a, int[] f, int[] s)
    {
        int iF = 0;
        int iS = 0;
        int iA = 0;
        while((iS+iF)<a.length)
        {
            if(f[iF]<s[iS])
            {
                System.out.println("a, "+iF+", "+iS+", "+iA);
                a[iA] = f[iF];
                iF++;
                iA++;
            } else {
                System.out.println("b, "+iF+", "+iS+", "+iA);
                a[iA] = s[iS];
                iS++;
                iA++;
            }
            System.out.println("f.length-iF "+((f.length-1)-iF));
            System.out.println("s.length-iS "+((s.length-1)-iS));
            if((f.length-1)-iF<0)
            {
                System.out.println("c, "+iF+", "+iS+", "+iA);
                a[iA] = s[iS];
                iS++;
                iA++;
            } else
            if((s.length-1)-iS<0)
            {
                System.out.println("d, "+iF+", "+iS+", "+iA);
                a[iA] = f[iF];
                iF++;
                iA++;
            } else
            if((s.length-1)-iS<0 && (f.length-1)-iF<0)
            {
                return;
            }
        }
    }
    public static void mergeArray2(int[] a, int[] f, int[] s)
    {
        int iA = 0;
        for(int i = 0 ;i<f.length;i++)
        {
            a[iA] = f[i];
            iA++;
        }
        for(int i = 0 ;i<s.length;i++)
        {
            a[iA] = s[i];
            iA++;
        }
        selectionSort(a);

    }
    public static void mergeArray3(int[] a, int[] f, int[] s)
    {
        System.out.println(Arrays.toString(f));
        System.out.println(Arrays.toString(s));
        int iF = 0;
        int iS = 0;
        int iA = 0;
        while(((f.length-1)-iF>=0 || (s.length-1)-iS>=0) && (iF+iS)<(a.length-1))
        {
            if(f[iF]<s[iS])
            {
                // System.out.println("a, "+iF+", "+iS+", "+iA);
                a[iA] = f[iF];
                iF++;
                iA++;
            } else {
                // System.out.println("b, "+iF+", "+iS+", "+iA);
                a[iA] = s[iS];
                iS++;
                iA++;
            }
        }
    }
    public static void bogoSort(int [] arr)
    {
        boolean sorted = false;
        while(!sorted)
        {
            for(int i = 1; i<arr.length;i++)
            {
                if(arr[i]<arr[i-1])
                    sorted = false;
            }
        }
    }
    public static void main(String[] args)
    {
        // int[] n = {6,5,7,4,8,76,3,9,2,0,1,1,2,3,4,5,6,7,8,9,10};
        // insertionSort(n);
        // n = new int[]{6,5,7,4,8,76,3,9,2,0,1};
        // selectionSort(n);
        // for(int i = 0; i<n.length; i++)
        //     System.out.print(n[i]+",  ");

        // int[] first = {3, 5,6,9,11};
        // int[] second = {1,2,7,10};
        // int[] a = new int[first.length + second.length];
        // mergeArray2(a, first, second);
        // System.out.println(Arrays.toString(a)+"\ndone");

        // first = new int[]{3, 5};
        // second = new int[]{1};
        // a = new int[first.length + second.length];
        // mergeSort(first);
        // System.out.println(Arrays.toString(a));
        
        int limit = 7;
        int[] a = new int[limit];
        for(int i = 0; i<limit;i++)
        {
            a[i] = (int)(Math.random()*limit);
        }

        long nano = System.nanoTime();
        
        selectionSort(a);
        
        // System.out.println(Arrays.toString(a));
        System.out.println((System.nanoTime()-nano)/1_000_000_000.0);
    }
}
