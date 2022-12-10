package Experiments.math;

import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.Scanner;

public class Quadratics {

	public static void main(String[] args)
	{
//		
		
		System.out.print("Enter an equation: ");	
		Scanner s = new Scanner(System.in);
		String eq = s.nextLine();
		
	
//		System.out.println("\n"+quadToIntercept(eq));
		System.out.println(quadSolving(eq));
		s.close();
	}
	
	public static String quadToIntercept(String eq)
	{
		//Preparing all variables
		
		//toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x")));
		Double a;
		
		if(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")).equals("-")) a = -1.0;
		else a = toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")));
		
		String fsymb = eq.substring(eq.indexOf("^2")+2, eq.indexOf("^2")+3).toString();
		Double b = Double.parseDouble(eq.substring(eq.indexOf("^2")+2, eq.indexOf("x",eq.indexOf("^2"))))/a;
		Double c = Double.parseDouble(eq.substring(eq.indexOf("x",eq.indexOf("^2"))+1, eq.length()))/a;
		Double b2 = b/2;
		Double y = Math.pow(b2, 2)+ op(c);
		Double z = op(y)*a;
		String comp = "Equation: y=";
			
		//Assembling the equation
		if(a==1)comp+="";
		else if(a==-1)comp+="-";
		else if(a!=1 && a!=-1)comp+=a;
		
		comp+="(x";
		
		if(fsymb.equals("+") && b2>0) comp+="+"+b2;
		else if(fsymb.equals("+") && b2<0) comp+=b2;
		else if(fsymb.equals("-") && b2>0) comp+=b2;
		else if(fsymb.equals("-") && b2<0) comp+="+"+op(b2);
		else comp+= "XD";
		
		comp +=")²";
		
		if(z==0)comp+="";
		if(z>0)comp+="+"+z;
		else comp+=z;
		
		if(op(b2)>0) comp+="\nx Shift: Left "+ op(b2);
		else comp+="\nx Shift: Right "+ b2;
		
		if(z>0) comp+="\ny Shift: Up "+ z;
		else comp+="\ny Shift: Down "+ op(z);
		
		return comp;
		
	}
	
	public static String quadSolving(String eq)
	{
		Double a = toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")));
		
		Double b = Double.parseDouble(eq.substring(eq.indexOf("^2")+2, eq.indexOf("x",eq.indexOf("^2"))));
		Double c = Double.parseDouble(eq.substring(eq.indexOf("x",eq.indexOf("^2"))+1, eq.length()));
		Double vertx = (op(b)/(2*a));
		Double verty = (a*Math.pow(vertx, 2)+(b*vertx)+c);
		
		Double quadp = (op(b)+Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		Double quadm = (op(b)-Math.sqrt(Math.pow(b, 2)-4*a*c))/(2*a);
		String comp = "";
		
		comp+="\nEquation: "+eq;
		
		if(quadp<quadm)comp+="\nX Intercepts: "+quadp+", "+quadm;
		else if(quadp>quadm)comp+="\nX Intercepts: "+quadm+", "+quadp;
		else comp+="\nX Intercept: "+quadm;
		
		comp+="\nY Intercept: "+c;
		
		comp+="\nVertex: ("+vertx+", "+verty+")";
		
		return comp;
	}
	
	public static int vertX(String eq) 
	{
		Double a;
		if(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")).equals("-")) a = -1.0;
		else a = toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")));
		
		Double b = Double.parseDouble(eq.substring(eq.indexOf("^2")+2, eq.indexOf("x",eq.indexOf("^2"))));
		
		return (int) (op(b)/(2*a));
	}
	
	public static int vertY(String eq)
	{
		Double a;
		
		if(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")).equals("-")) a = -1.0;
		else a = toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")));
		
		Double b = Double.parseDouble(eq.substring(eq.indexOf("^2")+2, eq.indexOf("x",eq.indexOf("^2"))));
		Double c = Double.parseDouble(eq.substring(eq.indexOf("x",eq.indexOf("^2"))+1, eq.length()));
		
		
		return (int) (a*Math.pow(vertX(eq), 2)+(b*vertX(eq))+c);
	}
	
	public static Double op(Double num)
	{//Returns opposite of input
		return 0-num;
	}
	public static Integer opi(Integer num)
	{
		return 0-num;
	}
	public static Double toFrac(String num)
	{//Turns strings into fractions
		if(num.equals("")) return 1.0;
		if(num.equals("-")) return -1.0;
		
		if(num.indexOf("/")!= -1)
		{
			Double nume = Double.parseDouble(num.substring(0, num.indexOf("/")));
			Double deno = Double.parseDouble(num.substring(num.indexOf("/")+1));
			return nume/deno;
		}
		return Double.parseDouble(num);
	}

	public static Double a(String eq)
	{
		return toFrac(eq.substring(eq.indexOf("y=")+2, eq.indexOf("x^2")));
	}
	public static Double b(String eq)
	{
		return toFrac(eq.substring(eq.indexOf("^2")+2, eq.indexOf("x",eq.indexOf("^2"))));
	}
	public static Double c(String eq)
	{
		return toFrac(eq.substring(eq.indexOf("x",eq.indexOf("^2"))+1, eq.length()));
	}

	
	public static Double quadp(String eq)
	{
		return (op(Quadratics.b(eq))+Math.sqrt(Math.pow(Quadratics.b(eq), 2)-4*Quadratics.a(eq)*Quadratics.c(eq)))/(2*Quadratics.a(eq));
	}
	public static Double quadm(String eq)
	{
		return (op(Quadratics.b(eq))-Math.sqrt(Math.pow(Quadratics.b(eq), 2)-4*Quadratics.a(eq)*Quadratics.c(eq)))/(2*Quadratics.a(eq));
	}
	public static void drawQudratic(Graphics2D g2, int w, int h, String eq, int scale)
	{
		Polygon q = new Polygon();
	    for (Double i = (double) (w*-1); i <= 2*w; i+=0.01)
	    {
	    	 
	    	q.addPoint((int) (w+i*2*w/(scale*2.0)),
				(int) (h-(Quadratics.a(eq)*i*i+Quadratics.b(eq)*i+Quadratics.c(eq))*2*h/(scale*2)));
	    	 
	    }
	    g2.drawPolyline(q.xpoints, q.ypoints, q.npoints);
		
		
	}

}