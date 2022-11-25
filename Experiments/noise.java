package Experiments;

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
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;

import Experiments.Classes.Ball;

public class noise extends JPanel implements MouseInputListener
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
   Clip collisionSound;
   String state = "Start";
   boolean click = false;
   
   public noise()
   {
      addMouseListener(this);
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
         File file = new File("Experiments/pongHit.wav");
         AudioInputStream audio = AudioSystem.getAudioInputStream(file);
         collisionSound = AudioSystem.getClip();
         collisionSound.open(audio);
      } catch (Exception e) {e.printStackTrace();}
      
      timer = new Timer(timerSpeed, new ActionListener() {
         public void actionPerformed(ActionEvent e)
         {
            if(click)
            {
               playSound(collisionSound);
               click = false;
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
      
    g2.drawString(click+"", 40, 40);

   }
   
   private static void createAndShowGUI() {
      noise gamePanel = new noise();
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

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        click = true;
        
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
        
    }
}