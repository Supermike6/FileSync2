package Graphics;


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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//Honors Computer Science - Mr. Uhl
//Program description: A template class for creating graphical applications


public class glitchMouse extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
   //Variables for the class
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 800;
   public static final int PREF_H = 600;
   
   private int countRectClicks;
   private int countCircleClicks;
   private int countOuterClicks;
   
   private int mousex = 0;
   private int mousey = 0;
   private int magnitude = 2;

   private Rectangle rect1;
   private Ellipse2D.Double circle;
   long frames = 0;
   
   //Class constructor
   public glitchMouse()
   {
      this.setFocusable(true);
      this.setBackground(Color.WHITE);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
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
      
      int change1 = magnitude * (int)(Math.random()*2)-1; 
      int change2 = magnitude * (int)(Math.random()*2)-1; 
      g2.drawRect(mousex-change1, mousey-change2, 12, 16);


   //   magnitude = (mousex/10);
   //   for(int i = 0; i<800;i+=20)
   //   {
   //       g2.drawLine(i, 0, i, 600);
   //   }
   //  g2.drawOval(mousex-(int)(Math.cos(frames*Math.PI/180)*magnitude)-10, mousey-(int)(Math.sin(frames*Math.PI/180)*magnitude)-10, 20, 20);
   //  g2.drawLine(mousex, mousey, mousex-(int)(Math.cos(frames*Math.PI/180)*magnitude), mousey-(int)(Math.sin(frames*Math.PI/180)*magnitude));
    frames++;
      repaint();
   }
   
   
   /** *******  METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL  *********/

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("My First Panel!");
      JPanel gamePanel = new glitchMouse();
      
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
	
    mousex = e.getX();
    mousey = e.getY();
    

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

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			magnitude++;
		}
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			magnitude--;
		}
        if(magnitude<0) magnitude = 0;
        System.out.println(magnitude);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}


