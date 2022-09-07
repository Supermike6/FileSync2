
public class e
{
    public static void main(String[]args)
    {
        //Task 4
        int x1=5;
        int x2=8;

        System.out.println("The average of "+x1+" and "+x2+" is "+((x1+x2)/2.0)+".");

        //Task 5
        double a = 1;
        double b = 4;
        double c = 8;
        System.out.println(-b+(Math.sqrt(Math.pow(b, 2)-(4*a*c)/(2*a))));
        System.out.println(-b-(Math.sqrt(Math.pow(b, 2)-(4*a*c)/(2*a))));

        //Task 8
        String firstLast = "Bancroft, Grant";
        System.out.println(("First name: "+firstLast.substring(firstLast.indexOf(" ")+1))+"\n"+("Last name: "+firstLast.substring(0,firstLast.indexOf(","))));



    }
}