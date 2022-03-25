package Experiments.Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
// import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
// import java.util.Timer;

// import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class drawing extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	// Variables for the class
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 800;
	public static final int PREF_H = 600;
	public ArrayList<Integer> xs = new ArrayList<Integer>();
	public ArrayList<Integer> ys = new ArrayList<Integer>();
	public int ghostx1;
	public int ghosty1;
	public int ghostx2;
	public int ghosty2;
	public boolean sp = false;
	public static int[] ranx = new int[50];
	public static int[] rany = new int[101];
	public static ArrayList<int[]> rans = new ArrayList<int[]>();
	// private int cloud1X;
   	// private int cloud2X;
   	// private boolean snowmanVisible;
   	private ArrayList<Rectangle> obstacles = new ArrayList<Rectangle>();
   	private int maxRectangles;
   	// private int rectX;	

	   

	// private boolean playing;
  	// private boolean gameOver;
   	// private String message;
   	// private boolean isPaused;
   	// private int score, time;

	public int birdx,birdy,dx,dy,birdSpeed, w, h;
	public boolean isFacingRight;

	public File points = new File("Experiments/Graphics/points.txt");
	public String pout = "";	
	public FileReader fr = new FileReader(points);
	public BufferedReader br = new BufferedReader(fr);
	public FileWriter fw = null;
	public BufferedWriter bw = null;
	public PrintWriter pw = null;
	public boolean thereAreLines = false;
	public double p = 0;
	
	
	drawing() throws IOException {
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		
		xs.add(0, 0);
		ys.add(0, 0);
		xs.add(0, 0);
		ys.add(0, 0);

		// cloud1X = 400;
      	// cloud2X = 200;
		// snowmanVisible = true;
		birdx = 100;
      	birdy = 75;
     	dx = 0;
      	dy = 0;
     	isFacingRight = true;
      	birdSpeed = 5;
     	w = 65;
      	h = 45;

		 obstacles = new ArrayList<Rectangle>();
      maxRectangles = 2;
      resetRectangles(maxRectangles);
     
    //   boolean playing = false;
    //   gameOver = false;
    //   isPaused = false;
     
    //   message = "Press <Space> to play!";
     
    //   score = 0;
    //   time = 0;
     
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Scanner sc;
		try {
			sc = new Scanner(points);
		} catch (FileNotFoundException e1) {
			sc = new Scanner(System.in);
		}
		
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		//Makes Sky
		g2.setColor(new Color(156,207,237));
		g2.fillRect(0, 0, getWidth(), (getHeight()/2));

		g2.setStroke(new BasicStroke(4));

		g2.setColor(Color.black);
		
		while(sc.hasNextLine())
		{
		String[] ls = sc.nextLine().split(" ");
		g2.drawLine(Integer.parseInt(ls[0]), Integer.parseInt(ls[1]), Integer.parseInt(ls[2]), Integer.parseInt(ls[3]));
		}
		sc.reset();
	
		
		
		
		
		g2.drawLine(ghostx1, ghosty1, ghostx2, ghosty2);

		if (sp == true) {
			try {
				fw = new FileWriter("Experiments/Graphics/points.txt", true);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);

				pw.println(ghostx1 + " " + ghosty1+ " "+ ghostx2 + " " + ghosty2);

				System.out.println("Data Successfully added to file");
				pw.flush();

			} catch (IOException e) {

				e.printStackTrace();
			} finally {
				try {
					fr.close();
					pw.close();
					bw.close();
					fw.close();
					sc.close();
				} catch (IOException io) {
					System.out.println("Close failed");
				}
			}

			xs.add(ghostx1);
			xs.add(ghostx2);
			ys.add(ghosty1);
			ys.add(ghosty2);
		}
		sp = false;

		if (xs.size() > 2) {
			for (int i = 0; i < xs.size() - 1; i += 2) {
				g2.drawLine(xs.get(i), ys.get(i), xs.get(i + 1), ys.get(i + 1));
			}
		}

		repaint();
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Do You Want to Build a Snowman?");
		JPanel gamePanel = new drawing();

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

		for(int k =0; k<100; k++){
			for(int i =0; i<100; i++)
			{
				rany[i] = (int) (Math.random()*(-1000));
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		ghostx1 = e.getX();
		ghosty1 = e.getY();

		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		ghostx2 = e.getX();
		ghosty2 = e.getY();

		repaint();

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			sp = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			dx += -10;
			isFacingRight = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			dx += +10;
			isFacingRight = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			dy += -10;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			dy += +10;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			repaint();
		}
		
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
	
	// public void resetGame()
	// {
	//    score = 0;
	//    time = 0;
	//    maxRectangles = 10;
	//    resetRectangles(maxRectangles);
	//    gameOver = false;
	//    message = "Welcome Back! Press <Space> to Start!";
	// }
}