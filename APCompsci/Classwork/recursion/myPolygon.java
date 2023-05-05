package APCompsci.Classwork.recursion;

import java.awt.Point;
import java.util.ArrayList;

public class myPolygon
{
    public static void main(String[] args)
    {
        Point p1 = new Point(5, 0);
        Point p2 = new Point(5, 2);
        Point p3 = new Point(0, 0);
        Point p4 = new Point(0,1);
        Point p5 = new Point(0,1);
        Point p6 = new Point(0,1);
        Point p7 = new Point(0,1);
        ArrayList<Point> ps = new ArrayList<Point>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);
        ps.add(p4);
        ps.add(p5);
        ps.add(p6);
        ps.add(p7);
        System.out.println(triArea(p1,p2,p3));
        System.out.println(polyArea(ps));
    }

    public static double triArea(Point p1, Point p2, Point p3)
    {
        return Math.abs(p1.x*p2.y+p2.x*p3.y+p3.x*p1.y-p1.y*p2.x-p2.y*p3.x-p3.y*p1.x)/2.0;
    }

    public static double polyArea(ArrayList<Point> ps)
    {
        if(ps.size()<=3) return triArea(ps.get(0), ps.get(1), ps.get(2));
        double d = triArea(ps.get(0), ps.get(1), ps.get(2));
        ps.remove(0);
        return d+polyArea(ps);
    }

}
