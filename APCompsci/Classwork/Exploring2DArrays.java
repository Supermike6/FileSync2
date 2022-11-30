package APCompsci.Classwork;

public class Exploring2DArrays
{

    public static void main(String[] args)
    {
        
        int[][] nums = new int[3][5];
        initialize2DArray(nums);
        print2DArray(nums);
    
    
    }

    public static void print2DArray(int[][] arr2D)
    {
        for(int i = 0; i<arr2D.length;i++)
        {
            for(int j = 0; j<arr2D[i].length;j++)
            {
                System.out.print(arr2D[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void print2DArrayForEach(int[][] arr2D)
    {
        for(int[] i:arr2D)
        {
            for(int j:i)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
    public static void initialize2DArray(int[][] a)
    {
        for(int i = 0; i<a.length;i++)
        {
            for(int j = 0; j<a[i].length;j++)
            {
                a[i][j] = (int)(Math.random()*21)+80;
            }
        }

    }
    public static double getColumbAverage(int[][] a, int col)
    {
        double out = 0.0;
        for(int i =0;i<a[col].length;i++)
            out+=a[col][i];

        out/=a[col].length;
        return out;

    }

}