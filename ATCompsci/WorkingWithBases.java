package ATCompsci;

public class WorkingWithBases
{
    public static void main(String[] args)
    {
        // System.out.println(convert10toX("58",2));
        System.out.println(convertXtoY1("58", 16, 2));
        // System.out.println(convertXtoY3("58",16, 2));
        
    }



    public static String convertXtoY1(String number, int currentBase, int targetBase)
    {
        return Integer.toString(Integer.parseInt(number,currentBase), targetBase);
    }




    public static String convertXtoY2(String number, int currentBase, int targetBase)
    {
        int outint = 0;
        int num1 = 0;
        for(int i = 0; i<number.length(); i++)
        {
            num1+= Integer.parseInt(number.substring(i, i+1))*Math.pow(currentBase, number.length()-1-i);
            System.out.println(num1);
        }

        return num1+"";

    }
    public static String convertXtoY3(String number, int currentBase, int targetBase)
    {
        if(number.equals("0"));
        if(number.equals("")) return "";
        int out = Integer.parseInt(number)/currentBase;
        return out+""+convertXtoY3(number.substring(1, number.length()), currentBase, targetBase);

    }
    

}
