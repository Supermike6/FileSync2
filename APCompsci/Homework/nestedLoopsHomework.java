package APCompsci.Homework;

public class nestedLoopsHomework
{
    public static void main(String[] args)
    {
    perimiter(7, 5);
    System.out.println("Bottom Left:");
    bottomLeft(5);
    System.out.println("Upper Left:");
    upperLeft(5);
    System.out.println("Bottom Right:");
    bottomRight(5);
    System.out.println("Upper Right:");
    upperRight(5);
    System.out.println("Diamond:");
    diamond(5);
    }
    public static void perimiter(int w, int h)
    {
        for(int i = 0;i<h;i++)
        {
            for(int j = 0;j<w;j++)
            {
                if(i==0||i==h-1||j==0||j==w-1)
                {
                    System.out.print("*");
                } else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void bottomLeft(int num)
    {
        for(int i = 0; i<num;i++)
        {
            for(int j = 0;j<i+1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void upperLeft(int num)
    {
        for(int i = num-1; i>=0;i--)
        {
            for(int j = 0;j<i+1;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void upperRight(int num)
    {
        for(int i = num-1; i>=0;i--)
        {
            for(int j = 0;j<5-i;j++)
            {
                System.out.print(" ");
            }
            for(int j = 0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        } 
    }
    public static void bottomRight(int num)
    {
        for(int i = 0; i<num;i++)
        {
            for(int j = 0;j<5-i;j++)
            {
                System.out.print(" ");
            }
            for(int j = 0;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        } 
    }
    public static void diamond(int num)
    {
        if(num%2==0) System.out.println("Enter an odd number.");
        for(int i = 0; i<num;i++)
        {
            for(int j = 0;j<5-i;j++)
            {
                System.out.print(" ");
            }
            for(int j = 0;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        } 
        for(int i = num-2; i>=0;i--)
        {
            for(int j = 0;j<5-i;j++)
            {
                System.out.print(" ");
            }
            for(int j = 0;j<=i;j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        } 
    }

}