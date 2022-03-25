package Intro.intro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//Honors Computer Science - Mr. Uhl
//Program description: Building a Snowman on a Java Panel


public class Snowman extends JPanel implements MouseListener, MouseMotionListener
{
   //Variables for the class
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 800;
   public static final int PREF_H = 600;
   
   //Class constructor
   public Snowman()
   {
      this.setFocusable(true);
      this.setBackground(Color.WHITE);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
   }
   
   //The method used to add graphical images to the panel
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
     //Bottom snowball
     g2.drawOval(275, 350, 250, 220);
     //Middle snowball
     g2.drawOval(305, 225, 190, 175);
     //Head
     g2.drawOval(340, 140, 120, 120);
     //Hat brim
     g2.drawOval(300, 130, 200, 30);
     //Hat
     g2.drawRect(350, 50, 100, 90);
     //Hat top
     g2.drawOval(350, 43, 100, 16);
      
      BufferedImage bufferedImage = new BufferedImage(PREF_W, PREF_H, BufferedImage.TYPE_INT_RGB);
      
   // Save as PNG
      File file = new File("myimage.png");
      try {
		ImageIO.write(bufferedImage, "png", file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
   }
   
   
/** *******  METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL  *********/

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Do You Want to Build a Snowman?");
      JPanel gamePanel = new Snowman();
      
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
   public void mouseClicked(MouseEvent e) {}
   
   @Override
   public void mousePressed(MouseEvent e)
   {
      System.out.println(e.getX() + " " + e.getY());
      
      repaint();
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
   }

   @Override
   public void mouseEntered(MouseEvent e) {}

   @Override
   public void mouseExited(MouseEvent e) {}

   @Override
   public void mouseDragged(MouseEvent e) {}

   @Override
   public void mouseMoved(MouseEvent e)
   {
//      System.out.println("Moving...@ " + e.getX() + " " + e.getY());
//      repaint();
   }
}