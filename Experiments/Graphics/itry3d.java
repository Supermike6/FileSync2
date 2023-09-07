package Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class itry3d extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private int i = 0;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   int thingx = 0;
   int thingy = 0;
   int thingw = 50;
   int thingh = 20;
   
   private Timer timer;
   
   public itry3d()
   {
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      
      
      timer = new Timer((int)(10/60.0), new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
             i++;
            repaint();
         }
      });
      timer.start();
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      
      g2.setRenderingHints(hints);
      g2.setStroke(new BasicStroke(2));

      g2.drawLine(FRAMEBITS, ERROR, ALLBITS, ABORT);

   }
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE);
      if(key == KeyEvent.VK_C);
   }
   
   @Override
   public void keyReleased(KeyEvent e){}

   @Override
   public void keyTyped(KeyEvent e){}

   private static void createAndShowGUI() {
      itry3d gamePanel = new itry3d(); 
      JFrame frame = new JFrame("Balls 😏 😏 😏 😏 😏 😏 😏");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(gamePanel);
      frame.setResizable(true);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.white);
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
}