package Intro.intro;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;

public class ExploringRectangles
{

	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		
//		Rectangle r1 = new Rectangle(10,20,100,50);
//		Rectangle r2 = new Rectangle(15,25,105,55);
//		System.out.println(r1.width * r1.height);
//		System.out.println(r2);
//		 
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		
		
		
		
		System.out.print("How many Rectangles do you want?: ");
		int output = sc.nextInt();
		
		for(int i=0;i<output;i++)
		{
			Rectangle rect = new Rectangle ((int)(Math.random()*801),
											(int)(Math.random()*601),
											((int)(Math.random()*191)+10),
											((int)(Math.random()*191)+10));
			rects.add(rect);
			
		}
	
		
		int maxArea = rects.get(0).width * rects.get(0).height;
		
		for(int i = 0; i<rects.size(); i++)
		{
			int area  = rects.get(i).width * rects.get(i).height;
			System.out.println("Area = " + rects.get(i).width + " x " + rects.get(i).height + " = " + area);
			if(area >= maxArea)
				maxArea = area;
		}
		
		System.out.println();
		
		System.out.println(Intro.Functions.Rectanglez.getRectWMaxArea(rects));
		System.out.println(Intro.Functions.Rectanglez.getRectWMinArea(rects));
	
		sc.close();

	}
	
	
}


