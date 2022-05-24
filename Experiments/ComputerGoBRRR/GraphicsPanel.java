package Experiments.ComputerGoBRRR;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//Honors Computer Science - Mr. Uhl
//Program description: A template class for creating graphical applications


public class GraphicsPanel extends JPanel implements MouseListener, MouseMotionListener
{
   //Variables for the class
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 800;
   public static final int PREF_H = 600;
   
   private int countRectClicks;
   private int countCircleClicks;
   private int countOuterClicks;
   
   private Rectangle rect1;
   private Ellipse2D.Double circle;
   
   //Class constructor
   public GraphicsPanel()
   {
      this.setFocusable(true);
      this.setBackground(Color.WHITE);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      countRectClicks=0;
      countCircleClicks=0;
      countOuterClicks=0;
      
      rect1 = new Rectangle(100,100,150,50);
      circle = new Ellipse2D.Double(20,20,40,40);

   }
   
   //The method used to add graphical images to the panel
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      BasicStroke s = new BasicStroke(5);
      Font f = new Font("Comic sans MS",Font.PLAIN,24);
      
      g2.setColor(Color.magenta);
      g2.fill(rect1);
      g2.setColor(Color.black);
      g2.setStroke(s);
      g2.draw(rect1);
      g2.setColor(Color.pink);
      g2.fill(circle);
      g2.setColor(Color.black);
      g2.draw(circle);
      g2.setColor(Color.pink);
      g2.setFont(f);
      g2.drawString("Hello world!", 108, 135);
    
      g2.drawString("Clicks In Rectangle: " +countRectClicks, 400, 50);
      g2.drawString("Clicks In Circle: " +countCircleClicks, 400, 100);
      g2.drawString("Clicks Out Of Shapes: " +countOuterClicks, 400, 150); 
      
   }
   
   
   /** *******  METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL  *********/

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("My First Panel!");
      JPanel gamePanel = new GraphicsPanel();
      
      frame.getContentPane().add(gamePanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
   
   public static void main(String[] args)
   {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }

@Override
	public void mouseClicked(MouseEvent e)
{
	
}

@Override
	public void mousePressed(MouseEvent e)
{
	System.out.println("Pressing mouse ("+e.getX()+", "+e.getY()+").");
	if(isInRect(rect1,e.getX(),e.getY()))
	{
		countRectClicks++;
		rect1.x = (int) (Math.random()*600);
		rect1.y = (int) (Math.random()*550);
		
	}
	else if(isInCirclec(circle,e.getX(),e.getY()))
	{
		countCircleClicks++;
		circle.x = (int) (Math.random()*600);
		circle.y = (int) (Math.random()*550);
		
	}
	else countOuterClicks++;

	repaint();
}
	
@Override
	public void mouseReleased(MouseEvent e)
{
	
	
}

@Override
	public void mouseEntered(MouseEvent e)
{
	
	
}

@Override
	public void mouseExited(MouseEvent e)
{
	
	
}

@Override
	public void mouseDragged(MouseEvent e) {
	
}

@Override
	public void mouseMoved(MouseEvent e)
{
	
	System.out.println("Moved: ("+e.getX()+", "+e.getY()+")");

}

//My functions below
	public static boolean isInRect(Rectangle rect, int mouseX, int mouseY)
{
	return rect.contains(mouseX, mouseY);
}
	public static boolean isInCircle(int x, int y, int r, int mouseX, int mouseY)
{
	return Math.sqrt((x-mouseX)*(x-mouseX)+(y-mouseY)*(y-mouseY)) < r;
}
	public static boolean isInCirclec(Ellipse2D.Double c, int mouseX, int mouseY)
{
	return c.contains(mouseX, mouseY);
}
	public static boolean isACircle(int x, int y)
{
	
	return x==y;

}

}


