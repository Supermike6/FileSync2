import java.awt.Point;

public class runGame
{
    public static void main(String[] args)
    {
        int[][] board1 = new int[10][10];
        board1[0][1] = 2;
        Ship s = new Ship(1,3,new Point(1,4),true);

        printStandardArray(board1);

    }

    public static void printStandardArray(int[][] in)
    {
        for(int i = 0; i<in.length-1;i++)
        {
            for(int j = 0; j<in[i].length-2;j++)
            {
                System.out.print(in[i][j]+",");
            }
            System.out.println(in[i][in[i].length-1]);
        }
    }
}
