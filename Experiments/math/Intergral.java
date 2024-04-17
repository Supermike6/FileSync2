package math;

public class Intergral {
    
    public static void main(String[] args)
    {
        System.out.print("Interval a: ");
        double a = 1;
        System.out.print("Interval b: "); 
        double b = 2;
        System.out.print("subintervals: ");
        int n = 10000;
        System.out.print("Coefficient: ");
        double coef = 1;
        System.out.print("Power: ");
        double power = 2;
        System.out.print("Vert: ");
        double vert = 0;
        System.out.print("Horiz: ");
        double horiz = 0;
        System.out.println("f(x) = "+coef+"(x+"+horiz+")^"+power+"+"+vert);
        double error = 0.000001;
        while (Math.abs((7.0/3.0)-EQtrapSum(a, b, n, coef, power, vert, horiz)) > error){
            n++;
        }
        System.out.println(n);
        System.out.println("Trapezoid Sum:  "+EQtrapSum(a, b, n, coef, power, vert, horiz));
    }

    static double EQtrapSum(double a, double b, int n, double coef, double power, double vert, double horiz){
        double h = Math.abs((b - a) / (double)n);
        double sum=0;
        for(double i = a; i <b; i+=h){
            sum += h*0.5*(coef*Math.pow(i+horiz,power)+vert+coef*Math.pow(i+h+horiz,power)+vert);
        }
        return sum;
    }
}
