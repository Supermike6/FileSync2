// public class SysEq
// {
//     public static void main(String[] args)  
//     {
//         String eq1 = "0.5x+1.5y+4.5z=2";
//         String eq2 = "3x+1y+0z=2";
//         String eq3 = "-2x+5y-0.6z=4";

//         System.out.println(stuff3(eq1,eq2,eq3));

//     }

//     public static String stuff2(String str1, String str2)
//     {
//         Double a1 = Double.parseDouble(str1.substring(0, str1.indexOf("x")));
//         Double a2 = Double.parseDouble(str2.substring(0, str2.indexOf("x")));
//         Double b1 = Double.parseDouble(str1.substring(str1.indexOf("x")+1, str1.indexOf("y")));
//         Double b2 = Double.parseDouble(str2.substring(str2.indexOf("x")+1, str2.indexOf("y")));
//         Double c1 = Double.parseDouble(str1.substring(str1.indexOf("=")+1));
//         Double c2 = Double.parseDouble(str2.substring(str2.indexOf("=")+1));
//         Double fa1 = 0.0,fb1 = 0.0,fc1 = 0.0,fa2 = 0.0,fb2 = 0.0,fc2 = 0.0;
//         Double a = 0.0, b = 0.0;


      
//         fa1=a1*a2;
//         fa2=a1*a2;
//         fb1 = b1*a2;
//         fc1 = c1*a2;
//         fb2 = b2*a1;
//         fc2 = c2*a1;

//         b = (fc2-fc1)/(fb2-fb1);
//         a = (c1-(b*a1))/a1;
        
//         return a+", "+b;
      
//     }

//     public static String stuff3(String str1, String str2, String str3)
//     {
//         Double a1 = Double.parseDouble(str1.substring(0, str1.indexOf("x")));
//         Double a2 = Double.parseDouble(str2.substring(0, str2.indexOf("x")));
//         Double a3 = Double.parseDouble(str3.substring(0, str3.indexOf("x")));
//         Double b1 = Double.parseDouble(str1.substring(str1.indexOf("x")+1, str1.indexOf("y")));
//         Double b2 = Double.parseDouble(str2.substring(str2.indexOf("x")+1, str2.indexOf("y")));
//         Double b3 = Double.parseDouble(str3.substring(str3.indexOf("x")+1, str3.indexOf("y")));
//         Double c1 = Double.parseDouble(str1.substring(str1.indexOf("y")+1, str1.indexOf("z")));
//         Double c2 = Double.parseDouble(str2.substring(str2.indexOf("y")+1, str2.indexOf("z")));
//         Double c3 = Double.parseDouble(str3.substring(str3.indexOf("y")+1, str3.indexOf("z")));
//         Double d1 = Double.parseDouble(str1.substring(str1.indexOf("=")+1));
//         Double d2 = Double.parseDouble(str2.substring(str2.indexOf("=")+1));
//         Double d3 = Double.parseDouble(str3.substring(str3.indexOf("=")+1));
//         Double fa1 = 0.0,fb1 = 0.0,fc1 = 0.0,fd1 = 0.0, fa2 = 0.0,fb2 = 0.0,fc2 = 0.0, fd2 = 0.0, fa3 = 0.0,fb3 = 0.0,fc3 = 0.0, fd3 = 0.0;
//         Double gb1 = 0.0, gc1 = 0.0, gd1 = 0.0;
//         Double a = 0.0, b = 0.0, c = 0.0;
        
//         fa1=a2/a1;
//         fb1=b1*fa1;
//         fc1=c1*fa1;
//         fd1=d1*fa1;
//         gb1 = b1-fb1;
//         gc1 = c1-fc1;
//         gd1 = d1-fd1;

//         String solve = stuff2(""+fb1+"x"+fc1+"y="+fd1+"", ""+gb1+"x"+gc1+"y="+gd1+"");
        
        
//         return solve;
    
//     }

// }
