public class PointsAndFormulas {

	public static void main(String[] args)
	{
		// String[] points = {"-3 5", "-2 -2", "0 2", "4 2"};
		// System.out.println(EMyMethods.printArray(fxPoints(points,1,1,0,0)));
	}

	public static String[] fxPoints(String[] points, double yCoeff, double xCoeff, double xShift, double yShift)
	{
		String[] fxPoints = points;
		
		for(int i = 0; i < points.length; i++) fxPoints[i] = " ";
		
		return fxPoints;
	}
	
	
}
