

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
// import java.awt.FontMetrics;
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
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//Honors Computer Science - Mr. Uhl
//Program description: Building a Snowman on a Java Panel


public class yellowrectangles extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{
   //Variables for the class
   private static final long serialVersionUID = 1L;
   public static final int PREF_W = 800;
   public static final int PREF_H = 600;
   
   private ArrayList<Integer> xList;
   private ArrayList<Integer> yList;
   private int numFlakes;
   private int cloud1X;
   private int cloud2X;
   private boolean snowmanVisible;
   private Timer timer;
   private ArrayList<Rectangle> obstacles;
   private int maxRectangles;
   private int rectX;
   
   private boolean playing;
   private boolean gameOver;
   // private String message;
   private boolean isPaused;
   // private int score, time;
   
   
   //bird values1
   private int x, y, dx, dy, birdSpeed, w, h;
   private boolean isFacingRight;
   private boolean canPassThrough;
   //bird values2
   // private int x1, y1, dx1, dy1, birdSpeed1, w1, h1;
   // private boolean isFacingRight1;
   // private boolean canPassThrough1;
   
   //Class constructor
   public yellowrectangles()
   {
      this.setFocusable(true);
      this.setBackground(Color.WHITE);
      this.addMouseListener(this);
      this.addMouseMotionListener(this);
      this.addKeyListener(this);
      xList = new ArrayList<Integer>();
      yList = new ArrayList<Integer>();
      numFlakes = 15;
      cloud1X = 400;
      cloud2X = 200;
      snowmanVisible = false;
     
      //bird stuff
      x = 100;
      y = 75;
      dx = 0;
      dy = 0;
      isFacingRight = true;
      birdSpeed = 5;
      w = 65;
      h = 45;
      canPassThrough = false;
     
      obstacles = new ArrayList<Rectangle>();
      maxRectangles = 2;
      resetRectangles(maxRectangles);
     
      playing = false;
      gameOver = false;
      isPaused = false;
     
      // message = "Press <Space> to play!";
     
      // score = 0;
      // time = 0;
     
     
      timer = new Timer(10, new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e)
         {
            if(playing)
            {
               // time++;
               // message = "";
               //move the bird
               x += dx;
               y += dy;
               
               //Check Collision
               Rectangle birdHitBox = new Rectangle(x, y, w, h);
               for(int i = obstacles.size()-1; i >= 0; i--)
                  if(birdHitBox.intersects(obstacles.get(i)))
                  {
                     obstacles.remove(i);
                     // score += 2;
   //                  r.x = (int)(Math.random()*(PREF_W-r.width));
   //                  r.y = (int)(Math.random()*(PREF_H-r.height));
                  }
               if(obstacles.size() <= 0)
               {
                  maxRectangles = maxRectangles/2;
                  resetRectangles(maxRectangles);
               }
               if(maxRectangles == 0) {
                  gameOver = true;
                  playing = false;
               }
               
               if(canPassThrough)
               {
                  //pass through the panel
                  if(x > PREF_W)
                     x = -w;
                 
                  if(x < -w)
                     x = PREF_W;
                 
                  if(y > PREF_H)
                     y = -h;
                  if(y < -h)
                     y = PREF_H;
               }
               else
               {
                  //stop the bird for passing through
                  if(x > PREF_W - w)
                     x = PREF_W - w;
                  if(x < 0)
                     x = 0;
                 
                  if(y > PREF_H - h)
                     y = PREF_H - h;
                  if(y < 0)
                     y = 0;
               }
             
               
   //            System.out.println("Timing...");
               cloud1X += 10;
               cloud2X += 10;
               rectX +=8;
               if(cloud1X >+ 750)
                  cloud1X = -200;
               if(cloud2X >+ 750)
                  cloud2X = -200;
               if(rectX >+ 750)
                  rectX = -200;
            }
            else //not playing
            {
               if(gameOver)
               {
                  // message = "Game Over... <R> to Restart!";
               }
               else if(isPaused)
               {
                  // message = "Paused... <Space> to Continue!";
               }
               
            }
           
            repaint();
             
         }
      });
      timer.start();
   }
   
   //The method used to add graphical images to the panel
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
     
      g2.setFont((new Font("Times New Roman", Font.PLAIN, 50)));
     
      g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
     
      g2.setStroke(new BasicStroke(4));
     
    //sky
    g2.setColor(new Color(0, 191, 255));
    g2.fillRect(0, 0, getWidth(), PREF_H/2);
   
    drawCloud(g2, cloud1X, -20);
    drawCloud(g2, cloud2X, 50);
    if(snowmanVisible)
       drawSnowman(g2);
   
    g2.setColor(Color.YELLOW);
    //drawRectangles
    Rectangle r;
    for(int i = 0; i< obstacles.size()-1;i++)
    {
        r = new Rectangle(obstacles.get(i).x+rectX,obstacles.get(i).y,obstacles.get(i).width,obstacles.get(i).height);
        g2.fill(r);
    }
    //bird1
    Image birdPic = new ImageIcon(this.getClass().getResource("bird_background.png")).getImage();
    if(isFacingRight)
       g2.drawImage(birdPic, x, y, w, h, this);
    else
       g2.drawImage(birdPic, x+45, y, -w, h, this);
     
    //Snowflake(not key motion)
    Image pic = new ImageIcon(this.getClass().getResource("snowflake.png")).getImage();
    for(int i = 0; i <= numFlakes; i++)
    {
       int size = (int)(Math.random()*20)+11;
       g2.drawImage(pic, (int)(Math.random()*getWidth()), (int)(Math.random()*getHeight()), size, size, this);
    }
   
    
   }
   
   public void drawSnowman(Graphics2D g2)
   {
      //Bottom snowball
      g2.setColor(Color.WHITE);
      g2.fillOval(275, 340, 250, 220);
      g2.setColor(Color.BLACK);
      g2.drawOval(275, 340, 250, 220);
     
      //Middle snowball
      g2.setColor(Color.WHITE);
      g2.fillOval(305, 225, 190, 175);
      g2.setColor(Color.BLACK);
      g2.drawOval(305, 225, 190, 175);
     
      //Scarf
      g2.setColor(Color.RED);
      g2.fillOval(335, 200, 140, 80);
      g2.setColor(Color.BLACK);
      g2.drawOval(335, 200, 140, 80);
     
      //Head
      g2.setColor(Color.WHITE);
      g2.fillOval(340, 140, 120, 120);
      g2.setColor(Color.BLACK);
      g2.drawOval(340, 140, 120, 120);
     
      //Scarf end
      g2.setColor(Color.RED);
      int[] xs3 = {405, 408, 428, 432, 437, 442, 444, 443, 436, 400, 403, 407, 409, 408, 403};
      int[] ys3 = {256, 254, 247, 248, 254, 270, 290, 316, 360, 355, 340, 320, 300, 280, 259};
      g2.fillPolygon(xs3, ys3, xs3.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs3, ys3, xs3.length);
     
      //Scarf bottom
      g2.setStroke(new BasicStroke(10));
      g2.setColor(Color.WHITE);
      g2.drawLine(400, 355, 436, 360);
      g2.setStroke(new BasicStroke(7));
      g2.setColor(Color.RED);
      g2.drawLine(406, 353, 431, 355);
      g2.setStroke(new BasicStroke(4));
      g2.setColor(Color.BLACK);
      g2.drawArc(401, 347, 11, 10, 160, 155);//bottom of scarf
      g2.drawArc(413, 349, 11, 10, 180, 150);//bottom of scarf
      g2.drawArc(426, 351, 11, 10, 180, 172);//bottom of scarf
      g2.drawLine(413, 354, 415, 340);
      g2.drawLine(425, 355, 427, 342);
     
      //Hat brim
      g2.setColor(new Color(60, 60, 60));
      g2.fillOval(310, 139, 180, 25);
      g2.setColor(Color.BLACK);
      g2.drawOval(310, 139, 180, 25);
     
      //Hat
      g2.setColor(new Color(60, 60, 60));
      int[] xs1 = {344, 356, 440, 450};
      int[] ys1 = {74, 146, 146, 74};
      g2.fillPolygon(xs1, ys1, xs1.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs1, ys1, xs1.length);
     
      //Hat bottom arc
      g2.setColor(new Color(60, 60, 60));
      g2.fillArc(356, 136, 84, 16, 180, 180);
      g2.setColor(Color.BLACK);
      g2.drawArc(356, 136, 84, 16, 180, 180);
     
      //Hat top
      g2.setColor(new Color(60, 60, 60));
      g2.fillOval(344, 62, 106, 16);
      g2.setColor(Color.BLACK);
      g2.drawOval(344, 62, 106, 16);
     
      //Left Eye
      g2.setColor(Color.BLACK);
      g2.fillOval(390, 175, 20, 20);
      g2.setColor(Color.WHITE);
      g2.fillOval(393, 178, 6, 6);
     
      //Right Eye
      g2.setColor(Color.BLACK);
      g2.fillOval(350, 176, 20, 20);
      g2.setColor(Color.WHITE);
      g2.fillOval(353, 179, 6, 6);
     
      //Smile
      g2.setColor(Color.BLACK);
      g2.fillOval(360, 226, 12, 12);
      g2.fillOval(374, 232, 12, 12);
      g2.fillOval(388, 231, 12, 12);
      g2.fillOval(402, 225, 12, 12);
     
      //Nose
      int[] xs2 = {375, 356, 310, 310, 335, 378};
      int[] ys2 = {198, 203, 207, 212, 216, 218};
      g2.setColor(new Color(254, 146, 0));
      g2.fillPolygon(xs2, ys2, xs2.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs2, ys2, xs2.length);
      g2.fillArc(305, 206, 8, 8, 90, 180);//tip of nose
      g2.setColor(new Color(254, 146, 0));
      g2.fillOval(367, 200, 20, 17);
      g2.setColor(Color.BLACK);
      g2.drawArc(368, 198, 20, 21, -94, 188);//base of nose
     
      for(int i = 0; i < xList.size()-1; i++)
      {
         g2.drawLine(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1));
      }
     
      //Right Hand
      int[] xs4 = {472, 532, 570, 564, 582, 584, 598, 603, 594, 609, 608, 594, 586, 481};
      int[] ys4 = {306, 268, 245, 221, 217, 235, 228, 238, 248, 251, 264, 265, 261, 318};
      g2.setColor(new Color(152, 93, 42));
      g2.fillPolygon(xs4, ys4, xs4.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs4, ys4, xs4.length);
     
      //Left Hand
      int[] xs5 = {302, 241, 214, 200, 187, 193, 209, 198, 213, 219, 227, 242, 234, 234, 242, 252, 303};
      int[] ys5 = {306, 307, 267, 276, 258, 253, 256, 233, 226, 244, 231, 237, 249, 263, 279, 291, 291};
      g2.setColor(new Color(152, 93, 42));
      g2.fillPolygon(xs5, ys5, xs5.length);
      g2.setColor(Color.BLACK);
      g2.drawPolygon(xs5, ys5, xs5.length);
             
   }
   
   public void drawCloud(Graphics2D g2, int cloudX, int cloudY)

   {
      //Cloud
      g2.setColor(Color.WHITE);
      g2.fillOval(50 + cloudX, 100 + cloudY, 50, 50);
      g2.fillOval(80 + cloudX, 85 + cloudY, 50, 50);
      g2.fillOval(85 + cloudX, 110 + cloudY, 40, 40);
      g2.fillOval(105 + cloudX, 100 + cloudY, 50, 50);
      g2.fillOval(138 + cloudX, 115 + cloudY, 30, 30);
     
   }
   
   public void resetRectangles(int numRectangles)
   {
      for(int i = 1; i <= numRectangles; i++)
      {
         int rectW = (int)(Math.random()*101) + 21;
         int rectH = (int)(Math.random()*61) + 21;
         int rectX = (int)(Math.random()*(PREF_W-rectW));
         int rectY = (int)(Math.random()*(PREF_H-rectH));
         obstacles.add(new Rectangle(rectX, rectY, rectW, rectH));
      }
     
   }
   
   public void resetGame()
   {
      // score = 0;
      // time = 0;
      maxRectangles = 10;
      resetRectangles(maxRectangles);
      gameOver = false;
      // message = "Welcome Back! Press <Space> to Start!";
   }
   
/** *******  METHODS FOR INITIALLY CREATING THE JFRAME AND JPANEL  *********/

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Do You Want to Build a Snowman?");
      JPanel gamePanel = new yellowrectangles();
     
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
   public void mouseClicked(MouseEvent e){}
   
   @Override
   public void mousePressed(MouseEvent e)
   {
      System.out.println(e.getX() + " " + e.getY());
      xList.add(e.getX());
      yList.add(e.getY());
     
      System.out.println("The x-values: " + xList);
      System.out.println("The y-values: " + yList);
     
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

   }

   @Override
   public void keyTyped(KeyEvent e)
   {
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      System.out.println("There was a key press....." + keyCode);
     
      if(keyCode == KeyEvent.VK_SPACE)
         if(!gameOver)
         {
            playing = true;
            isPaused = false;
         }
     
      if(keyCode == KeyEvent.VK_P)
      {
         playing = false;
         isPaused = true;
      }
     
      if(keyCode == KeyEvent.VK_R)
         if(gameOver)
            resetGame();
     
      if(keyCode == KeyEvent.VK_LEFT)
      {
         dx = -birdSpeed;
         isFacingRight = false;
      }
      if(keyCode == KeyEvent.VK_RIGHT)
      {
         dx = birdSpeed;
         isFacingRight = true;
      }
      if(keyCode == KeyEvent.VK_UP)
         dy = -birdSpeed;
      if(keyCode == KeyEvent.VK_DOWN)
         dy = birdSpeed;      
     
      if(keyCode == 'C')
      {
         cloud1X += 10;
         if(cloud1X >+ 750)
            cloud1X = -200;
         if(cloud2X >+ 750)
            cloud2X = -200;
         System.out.println(cloud1X);
         cloud2X += 10;  
      }
     
      if(keyCode == 'S')
         snowmanVisible = !snowmanVisible;
     
      if(keyCode == 'G')
         canPassThrough = !canPassThrough;
     
      System.out.println(canPassThrough);
     
      //Cloud
      if(keyCode == 'O')
      {
         
         if(cloud1X >+ 750)
            cloud1X = -200;
         if(cloud2X >+ 750)
            cloud2X = -200;
      }
     
      repaint();
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      int keyCode = e.getKeyCode();
      System.out.println("There was a key press....." + keyCode);
     
      if(keyCode == KeyEvent.VK_LEFT)
         dx = 0;
      if(keyCode == KeyEvent.VK_RIGHT)
         dx = 0;
      if(keyCode == KeyEvent.VK_UP)
         dy = 0;
      if(keyCode == KeyEvent.VK_DOWN)
         dy = 0;
   }
}