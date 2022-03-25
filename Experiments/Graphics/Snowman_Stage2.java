import java.awt.BasicStroke;
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
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Snowman_Stage2 extends JPanel implements KeyListener {
	// Variables for the class
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 800;
	public static final int PREF_H = 600;
	public static int[] ranx = new int[50];
	public static int[] rany = new int[101];
	public static ArrayList<int[]> rans = new ArrayList<int[]>();
	private int cloud1X;
   	private int cloud2X;
   	private boolean snowmanVisible;
   	private ArrayList<Rectangle> obstacles = new ArrayList<Rectangle>();
	private ArrayList<Rectangle> enemies = new ArrayList<Rectangle>();
   	private int maxRectangles;
   	private int rectX;
	private javax.swing.Timer timer;	

	   

	private boolean playing, gameOver;
   	private String message;
   	private boolean isPaused;
   	private int score, time;

	public int birdx,birdy,dx,dy,birdSpeed, w, h;
	public boolean isFacingRight;
	public int obst = 0;
	public boolean thereAreLines = false;
	public double p = 0;
	public Rectangle enemyHitbox;
	
	
	public Snowman_Stage2() throws IOException {
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);
		birdx = 100;
      	birdy = 75;
      	dx = 0;
      	dy = 0;
     	isFacingRight = true;
     	birdSpeed = 10;
     	w = 65;
     	h = 45;
		obstacles = new ArrayList<Rectangle>();
		enemies = new ArrayList<Rectangle>();
      	maxRectangles = 2;
		addRectangles(maxRectangles);
		addEnemies(maxRectangles);
     	playing = false;
     	gameOver = false;
     	isPaused = false;
     	message = "Press <Space> to play!";
      	score = 0;
      	time = 0;

		  timer = new javax.swing.Timer(17, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				birdx += dx;
				birdy += dy;
				if(playing)
			   {
				  time+=5;
				  message = "";
				  //move the bird
				  
				  
				  //Check Collision
				  Rectangle birdHitBox = new Rectangle(birdx, birdy, w, h);
				  for(int i = obstacles.size()-1; i >= 0; i--)
				  {
					if(obstacles.get(i).x >+ 750)
					{
						obstacles.get(i).x = -200;
					} else {
					  obstacles.get(i).x++;
					}

					 if(birdHitBox.intersects(obstacles.get(i)))
					{
						obstacles.remove(i);
						score ++;
					}
				}
				for(int i = enemies.size()-1; i >= 0; i--)
				{
					enemies.get(i).x--;
					if(enemies.get(i).x < -enemies.get(i).width)
						enemies.get(i).x = PREF_W;
					if(birdHitBox.intersects(enemies.get(i)))
				   {
					  gameOver = true;
					  playing = false;
				   }	
				}
				  if(obstacles.size() <= 1)
				  {
					addRectangles(maxRectangles);
					addEnemies(maxRectangles);
				  }
				  
				//stop the bird for passing through
				if(birdx > PREF_W - w)
				birdx = PREF_W - w;
				if(birdx < 0)
				birdx = 0;
					
				if(birdy > PREF_H - h)
				birdy = PREF_H - h;
				if(birdy < 0)
				birdy = 0;
				  
				
				  
				  cloud1X += 14;
				  cloud2X += 10;
				  rectX +=8;
				  if(cloud1X >+ 750)
					 cloud1X = -200;
				  if(cloud2X >+ 800)
					 cloud2X = -200;
				  if(rectX >+ 800)
					 rectX = -120;
					 obst+=4;
			   }
			   else //not playing
			   {
				  	if(gameOver)
				  	{
						message = "Game Over... <R> to Restart!";
				  
				 	}
				 	else if(isPaused)
				  	{
						message = "Paused... <Space> to Continue!";
				  	}
				  
			   }
			  
			   repaint();
				
			}
		 });
		 timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setFont((new Font("Annai MN", Font.PLAIN, 30)));
		
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		//Makes Sky
		g2.setColor(new Color(156,207,237));
		g2.fillRect(0, 0, getWidth(), (getHeight()/2));

		drawCloud(g2, cloud1X, -20);
    	drawCloud(g2, cloud2X, 50);
    	if(snowmanVisible) drawSnowman(g2);

		int[] stumpx = {640,635,635,683,683,678};
		int[] stumpy = {382,421,421,421,421,383};
		g2.setColor(new Color(87,67,45));
		g2.fillPolygon(stumpx, stumpy, stumpx.length);
		g2.setColor(new Color(39,20,9));
		g2.drawPolygon(stumpx, stumpy, stumpx.length);

		g2.setColor(new Color(47,67,42));
		int[] treex = {678,746,746,691,691,760,760,677,677,727,727,675,675,660,660,642,642,608,608,634,634,577,577,623,623,586,588,639};
		int[] treey = {383,382,382,307,307,318,318,224,223,240,240,111,111,68,68,125,125,227,227,222,222,292,294,301,301,383,383,381};
		g2.fillPolygon(treex, treey, treey.length);
		g2.setColor(new Color(21,31,26));
		g2.drawPolygon(treex, treey, treey.length);

		int[] shovelx = {123,126,126,166,166,164,139,149,149,158,158,149,124};
		int[] shovely = {439,405,405,405,407,443,402,319,319,320,320,403,430};
		g2.fillPolygon(shovelx, shovely, shovelx.length);
		g2.setColor(new Color(21,31,26));
		g2.drawPolygon(shovelx, shovely, shovelx.length);

		Image enemy = new ImageIcon(this.getClass().getResource("ghost.png")).getImage();
		Image bird = new ImageIcon(this.getClass().getResource("flappy.png")).getImage();
		Image obstacle = new ImageIcon(this.getClass().getResource("sandwich.png")).getImage();

		g2.setColor(Color.YELLOW);
		//drawRectangles



		Rectangle r;
		int l = 0;
		for(l=0; l<obstacles.size()-1;l++)
		{
			r = new Rectangle(obstacles.get(l).x,obstacles.get(l).y,50,50);
			g2.drawImage(obstacle,r.x,r.y,r.width,r.height,null);
		}
		
		g2.setColor(Color.red);
		Rectangle t;
		for(int i = 0; i<enemies.size()-1;i++)
		{
			t = new Rectangle(enemies.get(i).x,enemies.get(i).y,enemies.get(i).width,enemies.get(i).height);
			g2.drawImage(enemy,enemies.get(i).x,enemies.get(i).y, t.width, t.height, null);
		}

		if(isFacingRight)
		{
			g2.drawImage(bird, birdx, birdy, w, h, null);
		} else {g2.drawImage(bird, birdx+60, birdy, -w, h, null);}
		
		g2.setColor(Color.BLACK);
		g2.drawString("Grant Bancroft", 5, PREF_H-5);
		FontMetrics fm = g2.getFontMetrics();
		int messageWidth = fm.stringWidth(message);
		int startX = getWidth()/2 - messageWidth/2;
		g2.drawString(message, startX, getHeight()/2);
		g2.drawString("Score: " + score, 15, 35);
		double timeValue = (double) time/ 200;
		g2.drawString("Timer: " + timeValue, 600, 35);
		
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Bird Game");
		JPanel gamePanel = new Snowman_Stage2();

		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (IOException e) {
				}
			}
		});
		
		for(int k =0; k<50; k++){
			for(int i =0; i<49; i++)
			{
				ranx[i] = (int) (Math.random()*(PREF_W));
			}
		}

		for(int k =0; k<1000; k++){
			for(int i =0; i<100; i++)
			{
				rany[i] = (int) (Math.random()*(-10000));
			}
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(keyCode == KeyEvent.VK_SPACE)
		{
         if(gameOver=true)
         {
            resetRectangles(maxRectangles);
			resetEnemies(maxRectangles);
			resetEnemies(maxRectangles);
            isPaused = false;
			playing = true;
			gameOver = false;
         }
		 
		}
     
      if(keyCode == KeyEvent.VK_P)
      {
         playing = false;
         isPaused = true;
      }
	  if(keyCode == KeyEvent.VK_E)
	  enemies.remove(enemies.size()-1);

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
		 
		 repaint();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		
		if(keyCode == KeyEvent.VK_LEFT)
         dx = 0;
      if(keyCode == KeyEvent.VK_RIGHT)
         dx = 0;
      if(keyCode == KeyEvent.VK_UP)
         dy = 0;
      if(keyCode == KeyEvent.VK_DOWN)
         dy = 0;
	}

	public static void drawSnowman(Graphics2D g2)
	{

		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.black);
		
		// Bottom snowball
		g2.setColor(Color.WHITE);
		g2.fillOval(275, 340, 250, 220);
		g2.setColor(Color.BLACK);
		g2.drawOval(275, 340, 250, 220);

		// Middle snowball
		g2.setColor(Color.WHITE);
		g2.fillOval(305, 225, 190, 175);
		g2.setColor(Color.BLACK);
		g2.drawOval(305, 225, 190, 175);

		// Scarf
		g2.setColor(Color.RED);
		g2.fillOval(335, 200, 140, 80);
		g2.setColor(Color.BLACK);
		g2.drawOval(335, 200, 140, 80);

		// Head
		g2.setColor(Color.WHITE);
		g2.fillOval(340, 140, 120, 120);
		g2.setColor(Color.BLACK);
		g2.drawOval(340, 140, 120, 120);

		// Scarf end
		g2.setColor(Color.RED);
		int[] xs3 = { 405, 408, 428, 432, 437, 442, 444, 443, 436, 400, 403, 407, 409, 408, 403 };
		int[] ys3 = { 256, 254, 247, 248, 254, 270, 290, 316, 360, 355, 340, 320, 300, 280, 259 };
		g2.fillPolygon(xs3, ys3, xs3.length);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(xs3, ys3, xs3.length);

		// Scarf bottom
		g2.setStroke(new BasicStroke(10));
		g2.setColor(Color.WHITE);
		g2.drawLine(400, 355, 436, 360);
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.RED);
		g2.drawLine(406, 353, 431, 355);
		g2.setStroke(new BasicStroke(4));
		g2.setColor(Color.BLACK);
		g2.drawArc(401, 347, 11, 10, 160, 155);// bottom of scarf
		g2.drawArc(413, 349, 11, 10, 180, 150);// bottom of scarf
		g2.drawArc(426, 351, 11, 10, 180, 172);// bottom of scarf
		g2.drawLine(413, 354, 415, 340);
		g2.drawLine(425, 355, 427, 342);

		// Hat brim
		g2.setColor(new Color(60, 60, 60));
		g2.fillOval(310, 139, 180, 25);
		g2.setColor(Color.BLACK);
		g2.drawOval(310, 139, 180, 25);
		// Hat
		g2.setColor(new Color(60, 60, 60));
		int[] xs1 = { 344, 356, 440, 450 };
		int[] ys1 = { 74, 146, 146, 74 };
		g2.fillPolygon(xs1, ys1, xs1.length);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(xs1, ys1, xs1.length);
		// Hat bottom arc
		g2.setColor(new Color(60, 60, 60));
		g2.fillArc(356, 136, 84, 16, 180, 180);
		g2.setColor(Color.BLACK);
		g2.drawArc(356, 136, 84, 16, 180, 180);
		// Hat top
		g2.setColor(new Color(60, 60, 60));
		g2.fillOval(344, 62, 106, 16);
		g2.setColor(Color.BLACK);
		g2.drawOval(344, 62, 106, 16);

		// Left Eye
		g2.setColor(Color.BLACK);
		g2.fillOval(390, 175, 20, 20);
		g2.setColor(Color.WHITE);
		g2.fillOval(393, 178, 6, 6);

		// Right Eye
		g2.setColor(Color.BLACK);
		g2.fillOval(350, 176, 20, 20);
		g2.setColor(Color.WHITE);
		g2.fillOval(353, 179, 6, 6);

		// Smile
		g2.setColor(Color.BLACK);
		g2.fillOval(360, 226, 12, 12);
		g2.fillOval(374, 232, 12, 12);
		g2.fillOval(388, 231, 12, 12);
		g2.fillOval(402, 225, 12, 12);

		// Nose
		int[] xs2 = { 375, 356, 310, 310, 335, 378 };
		int[] ys2 = { 198, 203, 207, 212, 216, 218 };
		g2.setColor(new Color(254, 146, 0));
		g2.fillPolygon(xs2, ys2, xs2.length);
		g2.setColor(Color.BLACK);
		g2.drawPolygon(xs2, ys2, xs2.length);
		g2.fillArc(305, 206, 8, 8, 90, 180);// tip of nose
		g2.setColor(new Color(254, 146, 0));
		g2.fillOval(367, 200, 20, 17);
		g2.setColor(Color.BLACK);
		g2.drawArc(368, 198, 20, 21, -94, 188);// base of nose

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
	
	public void addRectangles(int numRectangles)
	{
	   for(int i = 0; i <= numRectangles; i++)
	   {
		  int rectW = (int)(Math.random()*101+20);
		  int rectH = (int)(Math.random()*61+20);
		  int rectX = (int)(Math.random()*(PREF_W-rectW));
		  int rectY = (int)(Math.random()*(PREF_H-rectH));
		  obstacles.add(new Rectangle(rectX, rectY, rectW, rectH));
	   }
	  
	}
	public void resetRectangles(int numRectangles)
	{
	   for(int i = 0; i < numRectangles; i++)
	   {
		if(obstacles.size()>=0)
		{
			int rectW = (int)(Math.random()*101+20);
			int rectH = (int)(Math.random()*61+20);
			int rectX = (int)(Math.random()*(PREF_W-rectW));
			int rectY = (int)(Math.random()*(PREF_H-rectH));
			obstacles.set(i,new Rectangle(rectX, rectY, rectW, rectH));
		} else {
			obstacles.remove(i);
	   		}
		}
	  
	}
	public void addEnemies(int numRectangles)
	{
	   for(int i = 0; i < numRectangles; i++)
	   {
			int rectY = (int)(Math.random()*(PREF_H));
		  	enemies.add(i, new Rectangle((int)rectX, rectY, 40, 40));
	   }
	  
	}
	public void resetEnemies(int numRectangles)
	{
	   for(int i = 0; i <= numRectangles-1; i++)
	   {
			if(enemies.size()>=0)
			{
		  		int rectY = (int)(Math.random()*(PREF_H));
				enemies.set(i,new Rectangle((int)rectX, rectY, 40, 40));
			} else {
				enemies.remove(i);
			}
	   }
	  
	}
	public void resetGame()
	{
		birdx = 75;
		birdy = 100;
	   	score = 0;
	   	time = 0;
		maxRectangles = 2;
	   	resetRectangles(maxRectangles);
		for(int i = 0;i<enemies.size()-1;i++)
	   		enemies.remove(i);
		resetEnemies(1);
	   	gameOver = false;
	   	playing = true;
	   	message = "Welcome Back! Press <Space> to Start!";

	}
}