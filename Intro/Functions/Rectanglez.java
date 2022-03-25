package Intro.Functions;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Rectanglez {

	public static void main(String[] args) {}

	
	public static Rectangle getmaxAreaRectangle(ArrayList<Rectangle> rectangles)
	{
		Rectangle maxRect = rectangles.get(0);
		
			
			return maxRect;
	}
	

	
	public static int getMaximumArea(ArrayList<Rectangle> rectangles)
	{
		int maxArea = rectangles.get(0).width * rectangles.get(0).height;
		
		for(int i = 0; i<rectangles.size(); i++)
		{
			int area  = rectangles.get(i).width * rectangles.get(i).height;
			if(area > maxArea) maxArea = area;
			
		}
		
		return maxArea;
		
		
	}
	public static int getMinimumArea(ArrayList<Rectangle> rectangles)
	{
		int minArea = rectangles.get(0).width * rectangles.get(0).height;
		
		for(int i = 0; i<rectangles.size(); i++)
		{
			int area  = rectangles.get(i).width * rectangles.get(i).height;
			if(area < minArea)
				minArea = area;	
		}
		return minArea;
	}
	
	public static Rectangle getRectWMaxArea(ArrayList<Rectangle> rectangles)
	{
		Rectangle maxRect = rectangles.get(0);
		
		for(int i = 0; i<rectangles.size(); i++)
		{
			int currentMaxArea = maxRect.width * maxRect.height;
			int nextArea = rectangles.get(i).width * rectangles.get(i).height;
			if(nextArea > currentMaxArea) maxRect = rectangles.get(i);
		}
		
		return maxRect;
		
	}
	
	public static Rectangle getRectWMinArea(ArrayList<Rectangle> rectangles)
	{
		Rectangle minRect = rectangles.get(0);
		
		for(int i = 0; i<rectangles.size(); i++)
		{
			int currentMinArea = minRect.width * minRect.height;
			int nextArea = rectangles.get(i).width * rectangles.get(i).height;
			if(nextArea < currentMinArea) minRect = rectangles.get(i);
		}
		
		return minRect;
		
	}
	
}
