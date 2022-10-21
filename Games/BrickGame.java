package Games;




import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Experiments.Classes.Brick;



public class BrickGame extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1440;
   private static final int PREF_H = 875;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Penguin", Font.PLAIN, 100);
   private boolean sp = true;
   private boolean cToggle = false;
   private String message = "Hello";
   private Timer timer,timer1;
   Brick b = new Brick(100, 200, 50, 60,Color.PINK);
   ArrayList<Brick> bricks = new ArrayList<Brick>();
   Color[] colors = new Color[]{Color.red,Color.orange,Color.yellow,Color.green,Color.CYAN,Color.blue,Color.magenta};
   int brickNums = 5;
   int playerSpeed = 10;
   int playerNum = 0;
   Clip collisionSound;
   
   public BrickGame()
   {
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      b.setXmax(PREF_W);
      b.setYmax(PREF_H);
      for(int i = 0; i<brickNums; i++) bricks.add(new Brick(100,100,25,25,(int)(Math.random()*8),(int)(Math.random()*8),0,PREF_W,0,PREF_H,new Color(0,0,0)));

      try {
         //Open an audio input stream
          File file = new File("/Users/gbancroft25/Documents/GitHub/fileSync/Games/ball-hit.wav");
          AudioInputStream audio = AudioSystem.getAudioInputStream(file);
          collisionSound = AudioSystem.getClip(); //initialize a sound clip object
          collisionSound.open(audio); //direct the clip to play the audio defined above
         } catch (Exception e) {e.printStackTrace();}


      timer = new Timer(10, new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            b.update();
            for(Brick br: bricks)
            {
               br.checkAndReactToCollisionWith(b);

               if(br.checkAndReactToCollisionWith(b))
               {
                  collisionSound.setFramePosition(0);
                  collisionSound.start();
               }

               br.update();
               for(Brick b:bricks)
                  for(Brick b1:bricks)
                     if(b != b1)
                     {
                        b.checkAndReactToCollisionWith(b1);
                     }
            }
            
         }
      });
     timer1 = new Timer(5, new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            repaint();
         }
      });
     timer.start();
     timer1.start();
      
     
  
   }


   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      
      g2.setFont(font);
      g2.setColor(Color.cyan);
      FontMetrics fm = g2.getFontMetrics();
		int messageWidth = fm.stringWidth(message);
		int startX = getWidth()/2 - messageWidth/2;
      if(sp==true)
      {
         g2.drawString(message, startX, getHeight()/2);
      }
      if(cToggle==true)
      {
         b.setColor(new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
      }

      b.fill(g2);
      for(Brick b: bricks)
      {
         b.fill(g2);
      }
   
   
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE)
      {
         if(playerNum==0){playerNum=1;}else{playerNum=0;}
      }
      if(key == KeyEvent.VK_C)
      {
         collisionSound.setFramePosition(0);
         collisionSound.start();
      }   

      if(key == KeyEvent.VK_RIGHT)
      {
         b.setDx(playerSpeed);
      }
      if(key == KeyEvent.VK_LEFT)
      {
         b.setDx(-playerSpeed);
      }
      if(key == KeyEvent.VK_UP)
      {
         b.setDy(-playerSpeed);
      }
      if(key == KeyEvent.VK_DOWN)
      {
         b.setDy(playerSpeed);
      }

      repaint();
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_RIGHT)
      {
         b.setDx(0);
      }
      if(key == KeyEvent.VK_LEFT)
      {
         b.setDx(0);
      }
      if(key == KeyEvent.VK_UP)
      {
         b.setDy(0);
      }
      if(key == KeyEvent.VK_DOWN)
      {
         b.setDy(0);
      }

   }

   @Override
   public void keyTyped(KeyEvent e)
   {
      
   }

   private static void createAndShowGUI() {
      BrickGame gamePanel = new BrickGame();
      JFrame frame = new JFrame("My Frame");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(gamePanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.WHITE);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}