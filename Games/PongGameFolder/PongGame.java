package PongGameFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Experiments.Classes.Ball;

public class PongGame extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1000;
   private static final int PREF_H = 700;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Minecraft", Font.PLAIN, 50);
   private String message = "Hello";
   private Timer timer;
   Ball lpaddle = new Ball(20, 200, 10, 80,Color.PINK);
   Ball rpaddle = new Ball(PREF_W-40, 200, 10, 80,Color.PINK);
   Rectangle l,r,b;
   Ball ball;
   int ballStartx = PREF_W/2-8, ballStarty = (int)(Math.random()*PREF_H);
   int playerSpeed = 5, ballSpeed = 2, colideNum;
   int timerSpeed = 10;
   int lScore, rScore;
   Clip collisionSound, match, win;
   String state = "Start";
   Image lImage = new ImageIcon(this.getClass().getResource("lpaddle.png")).getImage();
   Image rImage = new ImageIcon(this.getClass().getResource("rpaddle.png")).getImage();
   Image doomdie = new ImageIcon(this.getClass().getResource("doomdie.png")).getImage();
   Image sky = new ImageIcon(this.getClass().getResource("sky.gif")).getImage();
   Image Sky = new ImageIcon(this.getClass().getResource("skyFrozen.png")).getImage();
   Image laser = new ImageIcon(this.getClass().getResource("laserTall.png")).getImage();
   boolean debug;
   
   public PongGame()
   {
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
      lpaddle.setXmax(PREF_W);
      lpaddle.setYmax(PREF_H);
      rpaddle.setXmax(PREF_W);
      rpaddle.setYmax(PREF_H);

      setDoubleBuffered(false);

      ball = new Ball(PREF_W/2-8, PREF_H/2-8, 30, 30, ballSpeed, ballSpeed, -20, PREF_W+20, 0, PREF_H, Color.GREEN);
      ball.setXmin(-20);
      
      try {
         //Open an audio input stream
         File file = new File("Games/PongGameFolder/pongHit.wav");
         AudioInputStream audio = AudioSystem.getAudioInputStream(file);
         collisionSound = AudioSystem.getClip();
         collisionSound.open(audio);
         file = new File("Games/PongGameFolder/match.wav");
         audio = AudioSystem.getAudioInputStream(file);
         match = AudioSystem.getClip();
         match.open(audio);
         file = new File("Games/PongGameFolder/win.wav");
         audio = AudioSystem.getAudioInputStream(file);
         win = AudioSystem.getClip();
         win.open(audio);
      } catch (Exception e) {e.printStackTrace();}
      
      timer = new Timer(timerSpeed, new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            l = new Rectangle(lpaddle.getX()+2,lpaddle.getY(),lpaddle.getW(),lpaddle.getH());
            r = new Rectangle(rpaddle.getX()-2,rpaddle.getY(),rpaddle.getW(),rpaddle.getH());
            b = new Rectangle(ball.getX(),ball.getY(),ball.getW(),ball.getH());

            if(b.intersects(r)||b.intersects(l))
            {
               playSound(collisionSound);
               ball.setDx(ball.getDx()+1);
               ball.setDy(ball.getDy()+1);
               colideNum++;
            }
            
            lpaddle.noYBounceUpdate();
            rpaddle.noYBounceUpdate();
            ball.update();
            
            ball.checkAndReactToCollisionWith(lpaddle);
            ball.checkAndReactToCollisionWith(rpaddle);

            if(ball.getX()>=PREF_W)
            {
               lScore++;
               ball.setX(ballStartx);
               ball.setY(ballStarty);
               state = "End";
               if(lScore!=3)
               {
                  playSound(match);
               } else {
                  playSound(win);
               }
            }
            if(ball.getX()<=0)
            {
               rScore++;
               ball.setX(ballStartx);
               ball.setY(ballStarty);
               state = "End";
               if(rScore!=3)
               {
                  playSound(match);
               } else {
                  playSound(win);
               }
            }
            if(state.equals("End"))
            {
               ball.setDx(ballSpeed*getSign(ball.getDx()));
               ball.setDy(ballSpeed*getSign(ball.getDy()));
            }
            if(!state.equals("Playing"))
            {
               ball.setX(ballStartx);
               ball.setY(ballStarty); 
            } else {
               if(ball.getDx()==0){ball.setDx(1);}
               if(ball.getDy()==0){ball.setDy(1);}
            }

            if(state.equals("Start"))
            {
               message = "Press the space bar to start!";
               ball.setDx(ballSpeed*getSign(ball.getDx()));
               ball.setDy(ballSpeed*getSign(ball.getDy()));
            }
            if(lScore>=3)
            {
               state = "BlueWin";
            }
            
            if(rScore>=3)
            {
               state = "RedWin";
            }

            if(state.equals("RedWin") || state.equals("BlueWin"))
            {
               ball.setDx(ballSpeed*getSign(ball.getDx()));
               ball.setDy(ballSpeed*getSign(ball.getDy()));
            }
            repaint();
         }
      });

     timer.start();
   }
   
   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      

      g2.drawImage(Sky, 0, 0, PREF_W, PREF_H, this);
      g2.drawImage(sky, 0, 0, PREF_W, PREF_H, this);
      

      g2.drawImage(lImage, lpaddle.getX(), lpaddle.getY(), lpaddle.getW(), lpaddle.getH(), this);
      g2.drawImage(rImage, rpaddle.getX()+rpaddle.getW(), rpaddle.getY(), -rpaddle.getW(), rpaddle.getH(), this);
      g2.drawImage(doomdie, ball.getX(), ball.getY(), ball.getW(), ball.getH(), this);
      
      g2.setFont(font);
      g2.setColor(new Color(208,207,184));

      if(state.equals("Start"))
      {
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth(message);
         int startX = getWidth()/2 - messageWidth/2;
         g2.drawString(message, startX, getHeight()/2);
      } else {
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth("Blue: "+lScore);
         int startX = getWidth()/4 - messageWidth/2;
         g2.drawString("Blue: "+lScore, startX, 50);
         messageWidth = fm.stringWidth("Red: "+rScore);
         startX = getWidth()*3/4 - messageWidth/2;
         g2.drawString("Red: "+rScore, startX, 50);
      }
      if(state.equals("BlueWin"))
      {
         g2.setFont(new Font("Minecraft", Font.PLAIN, 100));
         g2.setColor(new Color(66,165,245));
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth("Blue Wins!");
         int startX = getWidth()/2 - messageWidth/2;
         g2.drawString("Blue Wins!", startX, getHeight()/2);
      }
      if(state.equals("RedWin"))
      {
         g2.setFont(new Font("Minecraft", Font.PLAIN, 100));
         g2.setColor(new Color(229,57,53));
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth("Red Wins!");
         int startX = getWidth()/2 - messageWidth/2;
         g2.drawString("Red Wins!", startX, getHeight()/2);
      }
      if(state.equals("RedWin") || state.equals("BlueWin"))
      {
         g2.setFont(new Font("Minecraft", Font.PLAIN, 50));
         g2.setColor(new Color(208,207,184));
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth("Press the R key to restart!");
         int startX = getWidth()/2 - messageWidth/2;
         g2.drawString("Press the R key to restart!", startX, 600);
      }
      if(state.equals("End"))
      {
         g2.setFont(new Font("Minecraft", Font.PLAIN, 50));
         g2.setColor(new Color(208,207,184));
         FontMetrics fm = g2.getFontMetrics();
         int messageWidth = fm.stringWidth("Press the Space key to serve!");
         int startX = getWidth()/2 - messageWidth/2;
         g2.drawString("Press the Space key to serve!", startX, getHeight()/2);
      }
      
      



      //Debug variable toggles hitboxes
      if(debug)
      {
         g2.setColor(Color.WHITE);
         g2.draw(r);
         g2.draw(l);
         g2.draw(b);
         System.out.println(ball.getDx()+", "+ball.getDy());
      }
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      
      if(key == KeyEvent.VK_SPACE)
      {
         if(state.equals("Start"))
         {
            state = "Playing";
         }

         if(state.equals("End"))
         {
            state = "Playing";
         }
      }  
      
      if(key == KeyEvent.VK_R)
      {
         if(state.equals("RedWin") || state.equals("BlueWin"))
         {
            lScore=0;
            rScore=0;
            state = "Playing";
         }
      }
      if(key == KeyEvent.VK_W)
      {
         lpaddle.setDy(-playerSpeed);
      }
      if(key == KeyEvent.VK_SHIFT)
      {
         timer.setDelay(30);
      }
      if(key == KeyEvent.VK_S)
      {
         lpaddle.setDy(playerSpeed);
      }
      if(key == KeyEvent.VK_UP)
      {
         rpaddle.setDy(-playerSpeed);
      }
      if(key == KeyEvent.VK_DOWN)
      {
         rpaddle.setDy(playerSpeed);
      }
      if(key == KeyEvent.VK_F)
      {
         debug = !debug;
      }
      if(key == KeyEvent.VK_EQUALS)
      {
         rScore+=1;
      }
      if(key == KeyEvent.VK_MINUS)
      {
         lScore+=1;
      }
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_W)
      {
         lpaddle.setDy(0);
      }
      if(key == KeyEvent.VK_S)
      {
         lpaddle.setDy(0);
      }
      if(key == KeyEvent.VK_UP)
      {
         rpaddle.setDy(0);
      }
      if(key == KeyEvent.VK_DOWN)
      {
         rpaddle.setDy(0);
      }
      if(key == KeyEvent.VK_SHIFT)
      {
         timer.setDelay(10);
      }
   }

   @Override
   public void keyTyped(KeyEvent e)
   {

      
   }
   
   private static void createAndShowGUI() {
      PongGame gamePanel = new PongGame();
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
      public void playSound(Clip sound)
      {
         sound.setFramePosition(0);
         sound.start();
      }
      public int getSign(int num)
      {
         if(num<0) return -1;
         return 1;

      }
}