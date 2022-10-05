
public class e
{
    public static void main(String[]args)
    {
       
        // //Task 4
        // int x1=5;
        // int x2=8;

        // System.out.println("The average of "+x1+" and "+x2+" is "+((x1+x2)/2.0)+".");

        // //Task 5
        // double a = 1;
        // double b = 4;
        // double c = 8;
        // System.out.println(-b+(Math.sqrt(Math.pow(b, 2)-(4*a*c)/(2*a))));
        // System.out.println(-b-(Math.sqrt(Math.pow(b, 2)-(4*a*c)/(2*a))));

        // //Task 8
        // String firstLast = "Bancroft, Grant";
        // System.out.println(("First name: "+firstLast.substring(firstLast.indexOf(" ")+1))+"\n"+("Last name: "+firstLast.substring(0,firstLast.indexOf(","))));

        //task 9

        // String name = "Einstein, Albert";
        // String checkNumOf = "a";
        // int numOf = 0;

        // for(int i = 0; i<name.length();i++)
        // {
        //     if(name.substring(i,i+1).equalsIgnoreCase(checkNumOf))
        //     {
        //         numOf++;
        //     }
        // }
        // if(numOf>1)
        // {
        //     System.out.println("The number of \""+checkNumOf+"\"s in "+name+" is "+numOf);
        // } else {
        //     System.out.println("The number of "+checkNumOf+" in "+name+" is "+numOf);
        // }

        System.out.println(hasVowel("jkhjkdfhgkjdklhgjfdhkfi"));
    }
    public static boolean hasVowel(String str) { if(str.contains("a")) return true; if(str.contains("e")) return true; if(str.contains("i")) return true; if(str.contains("o")) return true; if(str.contains("u")) return true; return false; }
}