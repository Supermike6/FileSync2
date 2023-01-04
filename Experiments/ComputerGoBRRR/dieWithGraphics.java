package Experiments.ComputerGoBRRR;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Experiments.Classes.Brick;

//BASE CODE BY RYAN SCHWARTZ
public class dieWithGraphics extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Minecraft", Font.PLAIN, 25);

//   private Brick brick1, brick2;
   private int brickX, brickY, colorCount;
   private Color color;
   private ArrayList<Brick> bricks = new ArrayList<Brick>();
   private int numBricks = 1000;
   Image backdrop = new ImageIcon(this.getClass().getResource("backdrop.jpg")).getImage();
   
   private Timer timer;
   
   public dieWithGraphics()
   {
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      
      brickX = 0;
      brickY = 0;
      color = Color.RED;
      for(int i = 0; i < numBricks; i++)
      {
         Brick newBrick = new Brick(brickX, brickY, 60, 40, 3, 2, color);
         newBrick.setXmax(PREF_W + 1);
         newBrick.setYmax(PREF_H + 1);
         if(i % 11 == 1|| i % 11 == 10)
            newBrick.setColor(Color.ORANGE);
         if(i % 11 == 2|| i % 11 == 9)
            newBrick.setColor(Color.YELLOW);
         if(i % 11 == 3|| i % 11 == 8)
            newBrick.setColor(Color.GREEN);
         if(i % 11 == 4|| i % 11 == 7)
            newBrick.setColor(Color.BLUE);
         if(i % 11 == 5|| i % 11 == 6)
            newBrick.setColor(new Color(165, 0, 255));
         bricks.add(newBrick);
         brickX += 60;
         setColorCount(getColorCount() + 1);
         if(brickX >= PREF_W)
         {
            brickX = 0;
            brickY += 40;
         }
      }
      
      timer = new Timer(1, new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            for(int i = 0; i < bricks.size(); i++)
               bricks.get(i).update();
            repaint();
            // Thread thread = new Thread(new Runnable() {
            //     @Override
            //     public void run() {
            //         while(true)
            //         {
            //         }
            //     }
            // });
            // thread.start();
         }
      });
      timer.start();
   }

   public int getColorCount() {
      return colorCount;
   }

   public void setColorCount(int colorCount) {
      this.colorCount = colorCount;
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      BasicStroke s = new BasicStroke(4);
      g2.setStroke(s);

      g2.setColor(Color.black);
      g2.fillRect(0, 0, PREF_W, PREF_H);
      
      for(int i = 0; i < bricks.size(); i++)
      {
         g2.setColor(bricks.get(i).getColor());
         g2.drawRoundRect(bricks.get(i).getX(), bricks.get(i).getY(), bricks.get(i).getW(), bricks.get(i).getH(),50,50);
         // g2.drawImage(backdrop,bricks.get(i).getX(), bricks.get(i).getY(), bricks.get(i).getW(), bricks.get(i).getH(),null);
      }
      g2.setFont(font);
      g2.setColor(Color.WHITE);
   }
   
   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE);
      
      if(key == KeyEvent.VK_C)
      {
         for(int c = 0; c < bricks.size(); c++)
            if(c % 11 != 0)
               bricks.get(c).setRandomColor();
      }
   }
   
   @Override
   public void keyReleased(KeyEvent e){}

   @Override
   public void keyTyped(KeyEvent e){}

   private static void createAndShowGUI() {
      dieWithGraphics gamePanel = new dieWithGraphics(); 
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
       ArrayList<String> arrayList = new ArrayList<String>();
      for(int i = 0; i<1; i++)
      {
      SwingUtilities.invokeLater(new Runnable() {
         public void run()  {
            createAndShowGUI();
            } 
            
         });
         System.out.println(i);
      }
      for(int k = Integer.MIN_VALUE; k<Integer.MAX_VALUE; k++)
      { 
      String s = "a";
      for (int j = 0; j < 25; j++)
      {
          s += (char)(Math.random() * 256);
          s += s;
      }
       arrayList.add(s);
   }
   }
}