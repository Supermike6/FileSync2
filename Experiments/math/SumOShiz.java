public class SumOShiz
{
    public static void main(String[] args)
    {

        long sumOfSquares = 0;
        long sums = 0;
        long squareOfSums = 0;
        long num = 0;

        for(int i = 0; i<=100; i++)
        {
            sumOfSquares+=Math.pow(i, 2);

            sums+=i;
        }

        squareOfSums = (long) Math.pow(sums, 2);

        num = squareOfSums-sumOfSquares;

        System.out.println("Sum of Squares minus Square of Sums: "+ num);

    }
}
