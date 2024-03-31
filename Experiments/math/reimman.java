package math;

import java.util.Scanner;

public class reimman {

    public static void main(String[] args) throws Exception {
        boolean equation = true;
        Scanner sc = new Scanner(System.in);
        System.out.print("Interval a: ");
        double a = sc.nextDouble();
        System.out.print("Interval b: "); 
        double b = sc.nextDouble();
        System.out.print("subintervals: ");
        int n = sc.nextInt();
        if(equation)
        {
            System.out.print("Coefficient: ");
            double coef = sc.nextDouble();
            System.out.print("Power: ");
            double power = sc.nextDouble();
            System.out.print("Vert: ");
            double vert = sc.nextDouble();
            System.out.print("Horiz: ");
            double horiz = sc.nextDouble();
            System.out.println("f(x) = "+coef+"(x+"+horiz+")^"+power+"+"+vert);
            System.out.println("Left Side Sum:  "+EQleftSum(a, b, n, coef, power, vert, horiz));
            System.out.println("Right Side Sum: "+EQrightSum(a, b, n, coef, power, vert, horiz));
            System.out.println("Midpoint Sum:   "+EQmidSum(a, b, n, coef, power, vert, horiz));
            System.out.println("Trapezoid Sum:  "+EQtrapSum(a, b, n, coef, power, vert, horiz));
        } else {
            System.out.print("Enter points (0,1,0.2,1,4): ");
        }


        sc.close();
    }

    static double EQmidSum(double a, double b, int n, double coef, double power, double vert, double horiz){    
        double h = Math.abs((b - a) / (double)n);
        double sum=0;
        for(double i = a+h/2; i <=b; i+=h){
            sum += h*(coef*Math.pow(i+horiz,power)+vert);
        }
        return sum;
    }

    static double EQleftSum(double a, double b, int n, double coef, double power, double vert, double horiz){
        double h = Math.abs((b - a) / (double)n);
        double sum=0;
        for(double i = a; i<b; i+=h){
            sum += h*(coef*Math.pow(i+horiz,power)+vert);
        }
        return sum;
    }

    static double EQrightSum(double a, double b, int n, double coef, double power, double vert, double horiz){
        double h = Math.abs((b - a) / (double)n);
        double sum=0;
        for(double i = a+h; i <=b; i+=h){
            sum += h*(coef*Math.pow(i+horiz,power)+vert);
        }
        return sum;
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
