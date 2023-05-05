package APCompsci.Classwork.recursion;

public class ExploringRecursion
{
    public static double factorial(double x)
    {
        if(x<=1) return x;
        return x*factorial(x-1);
    }

    public static int sumAB(int a, int b)
    {
        if(a==b)
        {
            return a;
        } else {
            return a+sumAB(a+1, b);
        }
    }
    // public static int countDigits(int num)
    // {

        
    // }

    public static int countLetter(String text, char let)
    {
        if(text.length()==0) return 0;
        if(text.charAt(0)==let)
        {
            return 1+countLetter(text.substring(1), let);
        } else {
            return 0+countLetter(text.substring(1), let);
        }
    }

    public static boolean isPalindrome(String text)
    {
        if(text.length()<=1) return true;
        else if(text.charAt(0)==text.charAt(text.length()-1))
        {
            return true && isPalindrome(text.substring(1, text.length()-1));
        } else {
            return false;
        }

    }
    public static void main(String[] args)
    {
        // for(int i = 0; i<40; i++)
        // System.out.println(factorial(i));
        // System.out.println(0x10);

        System.out.println(isPalindrome(""));
    }
}
