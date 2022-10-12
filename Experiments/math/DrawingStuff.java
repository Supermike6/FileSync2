package Experiments.math;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class DrawingStuff extends JComponent implements MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private static String eq;
	private Integer scale = 10;
     private Integer mx=0,my=0;

	
public DrawingStuff()
{
     setFocusable(true);
     requestFocus();
     this.addMouseListener(this);
	this.addMouseMotionListener(this);
}
     public static void main(String[] args)
{
	// Scanner sc = new Scanner(System.in);
     
     // System.out.print("Type the equation: ");
     // eq=sc.nextLine();

     eq = "y=20x^2-5x+7";

    JFrame frame = new JFrame();
    frame.pack();
    frame.setSize(800, 800);
    frame.setTitle("Graph");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);  
    DrawingStuff draw = new DrawingStuff();
    frame.add(draw);
    frame.setVisible(true);
	    
}
	
public void paintComponent(Graphics g)
{   
	
	
     //w is x, and h is y (as in x/y values in a graph)
     int w = this.getWidth()/2;
     int h = this.getHeight()/2;

     Graphics2D g1 = (Graphics2D) g;
     g1.setStroke(new BasicStroke(2));
     g1.setColor(Color.black);
     //horizontal
     g1.drawLine(0,h,w*2,h);
     //Veritcal
     g1.drawLine(w,0,w,h*2);
     //x line ticks
     for(double i = 0; i <= this.getWidth(); i+=this.getWidth()/(Double)(scale*2+0.0/this.getWidth()))
    	 g1.drawLine((int) i, h-4, (int) i, h+4);
     //y line ticks
     for(double i = 0; i <= this.getHeight(); i+=this.getHeight()/(Double)(scale*2+0.0/this.getHeight()))
    	 g1.drawLine(w-4,(int) i, w+4, (int) i);
     
 
     Graphics2D g2 = (Graphics2D) g;
//     g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
     g2.setStroke(new BasicStroke(2));
     g2.setColor(Color.red);
     
     Quadratics.drawQudratic(g2, w, h, eq, scale);

     g2.setColor(Color.black);
     
     g2.drawString("Equation: "+eq, 10, 20);
  
     if(Quadratics.quadp(eq)<Quadratics.quadm(eq)) g2.drawString("X Intercepts: "+Quadratics.quadp(eq)+", "+Quadratics.quadm(eq), 10, 40);
     else if(Quadratics.quadp(eq)>Quadratics.quadm(eq)) g2.drawString("X Intercepts: "+Quadratics.quadm(eq)+", "+Quadratics.quadp(eq), 10, 40);
     else if(Quadratics.quadp(eq)==Quadratics.quadm(eq)) g2.drawString("X Intercept: "+Quadratics.quadm(eq), 10, 40);
     else g2.drawString("Null", 10, 40);
     
     g2.drawString("Y Intercept: "+(Quadratics.a(eq)*Quadratics.op(Math.pow(0, 2))+Quadratics.b(eq)*Quadratics.opi(0)+Quadratics.c(eq)), 10, 60);
  
     g2.drawString("Vertex: ("+Quadratics.vertX(eq)+", "+Quadratics.vertY(eq)+")", 10, 80);
  
     g2.setColor(Color.blue);

     g2.drawString("Mouse Loaction: ("+(mx+getWidth())/(scale*2.0)+", "+my+")", 10, 100);
     
     g2.drawLine(mx, 0, mx, getHeight());
     g2.drawLine(0,my,getWidth(),my);
     repaint();
  
     //vertX verticle line
//     Polygon xvert = new Polygon();
//     for (int i = w*-1; i <= this.getWidth(); i++)
//     {
//    	 xvert.addPoint((int) (w+(Quadratics.vertX(eq)*this.getWidth()/(Double)(scale*2+0.0/this.getWidth()))),i);
//     }
//     g2.drawPolyline(xvert.xpoints, xvert.ypoints, xvert.npoints); 
  
     //vertY horizontal line
//     Polygon yvert = new Polygon();
//     for (int i = w*-1; i <= this.getWidth(); i++)
//     {
//    	 yvert.addPoint(i, (int) (h-(Quadratics.vertY(eq)*this.getHeight()/(Double)(scale*2+0.0/this.getHeight()))));
//     }
//     g2.drawPolyline(yvert.xpoints, yvert.ypoints, yvert.npoints); 
 }

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	// TODO Auto-generated method stub
     mx=e.getX();
     my=e.getY();
	repaint();
     System.out.println(e.getX());
}


}






