package Experiments.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.awt.Rectangle;

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

		g2.drawString(mainSideLength+"",50,50);

		g2.drawLine(PREF_W/2, PREF_H/2,(int)mainRect.getX(),(int)mainRect.getY());
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()));
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()),(int)(mainRect.getY()+mainRect.getHeight()));
		g2.drawLine(PREF_W/2, PREF_H/2,(int)(mainRect.getX()+mainRect.getWidth()),(int)(mainRect.getY()+mainRect.getHeight()));
		mainRect = new Rectangle(mainX,mainY,mainSideLength,mainSideLength);
		g2.draw(mainRect);
		// g2.draw(minorRect);
		
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
		mainX = PREF_W-e.getX()-mainSideLength/2;
		mainY = PREF_H-e.getY()-mainSideLength/2;
		System.out.println(mainRect.getLocation());

		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}