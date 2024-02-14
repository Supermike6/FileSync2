package math;
    
public class einsteinBox {
        
    int targetSum = 15;
    public static void main(String[] args)
    {
        int array[][] = new int[3][3];
        int i, j;
        int count = 0;

        while(check(array) == false)
        {
            count++;
            String co = Integer.toString(count);
            addZeroString(co);
            for(i=0; i<3; i++)
                for(j=0; j<3; j++)
                    array[i][j] = Integer.parseInt(co.charAt(i*3+j)+"");
        }
        
        printArray(array);  
            

        
    }

    private static boolean check(int[][] array)
    {
        for(int i=0; i<3; i++)
            for(int j=0; j<3; j++)
                if(array[i][j] + array[i][j] + array[i][j] != 15)
                    return false;

        if(array[0][0] + array[1][1] + array[2][2] != 15) return false;
        if(array[0][2] + array[1][1] + array[2][0] != 15) return false;
    
        return true;
    }
    private static void printArray(int[][] array)
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
                System.out.print(array[i][j]+", ");
            System.out.println();
        }
    }
    private static String addZeroString(String s)
    {
        for(int i=0; i+s.length()<9; i++)
            s = "0" + s;
        return s;
    }
        
}