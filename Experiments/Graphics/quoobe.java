package Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class quoobe extends JPanel implements MouseListener, MouseMotionListener,KeyListener {
	// Variables for the class
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 1000;
	public static final int PREF_H = 700;
	private int mainSideLength = 100;
	private int mainX = PREF_W/2-mainSideLength/2;
	private int mainY = PREF_H/2-mainSideLength/2;
	private Rectangle mainRect = new Rectangle(mainX,mainY,mainSideLength,mainSideLength);
	private int rotation = 0;
	private boolean sp = false;
	private int rX,rY;
	// private int minorSideLength = 150;
	// private int minorX = PREF_W/2-minorSideLength/2;
	// private int minorY = PREF_H/2-minorSideLength/2;
	// private Rectangle minorRect = new Rectangle(minorX,minorY,minorSideLength,minorSideLength);
	
	quoobe()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		Image guide = new ImageIcon(this.getClass().getResource("guide.png")).getImage();
		g2.drawString(mainSideLength+"",50,50);

		mainRect = new Rectangle(mainX,mainY,mainSideLength,mainSideLength);

		g2.drawLine(PREF_W/2, PREF_H/2,(int)mainRect.getX(),(int)mainRect.getY());
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()));
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()),(int)(mainRect.getY()+mainRect.getHeight()));
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()+mainRect.getHeight()));
		g2.drawLine((int)mainRect.getX(),(int)mainRect.getY(), (int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()));
		g2.drawLine((int)(mainRect.getX()),(int)(mainRect.getY()+mainRect.getHeight()), (int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()));
		g2.drawLine((int)(mainRect.getX()),(int)(mainRect.getY()+mainRect.getHeight()), (int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()+mainRect.getHeight()));
		g2.drawLine((int)mainRect.getX(),(int)mainRect.getY(), (int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()+mainRect.getHeight()));
		


		g2.rotate(rotation*(Math.PI/180),rX,rY);
		// g2.draw(mainRect);
		// g2.drawImage(guide, mainX, mainY, mainSideLength, mainSideLength, this);
		g2.rotate(-rotation*(Math.PI/180),rX,rY);
		
		// g2.drawOval(rX-mainSideLength,rY-mainSideLength,(int) Math.sqrt(2*(Math.pow(mainSideLength,2))),(int) Math.sqrt(2*(Math.pow(mainSideLength,2))));

		repaint();
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("3D?");
		JPanel gamePanel = new quoobe();
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
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		mainX+=10;
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
	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

		if(sp)
		{
		mainX = PREF_W-e.getX()-mainSideLength/2;
		mainY = PREF_H-e.getY()-mainSideLength/2;
		} else {
		mainX = e.getX()-mainSideLength/2;
		mainY = e.getY()-mainSideLength/2;	
		}

		rX=e.getX();
		rY=e.getY();

		System.out.println(rotation);

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();

		if(keyCode == KeyEvent.VK_UP)
		{
			if(mainSideLength==PREF_H)
			{
				System.out.println("Can not go Higher.");
			}
			else
			{
				mainSideLength+=5;
			}
		}
		if(keyCode == KeyEvent.VK_DOWN)
		{
			if(mainSideLength==5)
			{
				System.out.println("Can not go lower.");
			}
			else
			{
				mainSideLength-=5;
			}
		}
		if(keyCode == KeyEvent.VK_LEFT)
		{
			rotation-=30;
		}
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			rotation+=30;
		}
		if(keyCode == KeyEvent.VK_SPACE)
		{
			sp=!sp;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

		
	}

}