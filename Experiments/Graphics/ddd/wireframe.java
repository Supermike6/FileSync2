package Experiments.Graphics.ddd;

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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class wireframe extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	// Variables for the class
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 800;
	public static final int PREF_H = 600;

	public File points = new File("Experiments/Graphics/points.txt");
	public String pout = "";	
	public FileReader fr = new FileReader(points);
	public BufferedReader br = new BufferedReader(fr);
	public FileWriter fw = null;
	public BufferedWriter bw = null;
	public PrintWriter pw = null;
	public boolean thereAreLines = false;
	public double p = 0;

    private static cube c = new cube(1, 2, 3, new vector3(0, 0, 0));


	
	
	wireframe() throws IOException {
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





		repaint();
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Do You Want to Build a Snowman?");
		JPanel gamePanel = new wireframe();

		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
        System.out.println(c);
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
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

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
	public void mouseDragged(MouseEvent e)
    {

	}

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
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
		{
		}
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
		}

		if (e.getKeyCode() == KeyEvent.VK_UP)
		{
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			repaint();
		}
		
	}

	
	
	

}