package Experiments.Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Clock extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 250;
	public static final int PREF_H = 250;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	Clock()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		Timer timer = new javax.swing.Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				repaint();	
			}
		 });
		 timer.start();
	
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
       	
		g2.setStroke(new BasicStroke(3));

		g2.setColor(Color.black);
		
		g2.fillRect(0,0,PREF_W,PREF_H);
		
		g2.setColor(new Color(219,200,175));

		rn = java.time.Instant.now().atZone(ZoneId.systemDefault());
		
		g2.drawOval(PREF_W/2-100, PREF_W/2-100, 200, 200);

        // g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getNano()/10000000)*3.6))*100+125), (int)(Math.cos(Math.toRadians(-(rn.getNano()/10000000)*3.6+180))*100+125));
		// g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getSecond())*6))*99+125), (int)(Math.cos(Math.toRadians((rn.getSecond())*6+180))*99+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getMinute())*6))*85+125), (int)(Math.cos(Math.toRadians((rn.getMinute())*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(rn.getHour()*30)))*60+125), (int)(Math.cos(Math.toRadians((double)(rn.getHour()*30)+180))*60+125));
		g2.setColor(Color.RED);
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(rn.getHour()*30))*60+125+(int)(rn.getMinute())+125)), (int)(Math.cos(Math.toRadians((double)(rn.getHour()*30)+180))*60+125)+(int)Math.cos(Math.toRadians((double)(rn.getMinute()))*60+125));

		// g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians(-rn.getHour()*6+rn.getMinute()))*60+125), (int)(Math.cos(-Math.toRadians(rn.getHour()*6+rn.getMinute()))*60+125));
		
		// System.out.println(rn.getHour()%12);
		
		// System.out.println(Math.sin(Math.toRadians((double)(rn.getHour()*30)))*60+125);
		// System.out.println(Math.cos(Math.toRadians((double)(rn.getHour()*30)))*60+125);

	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Clock");
		JPanel gamePanel = new Clock();
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		System.out.println(e.getX()+", "+e.getY());
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		System.out.println((int)(Math.sin(Math.toRadians((double)(rn.getHour()*30))*60+125+(int)(rn.getMinute())+125))+", "+(int)(Math.cos(Math.toRadians((double)(rn.getHour()*30)+180))*60+125)+(int)Math.cos(Math.toRadians((double)(rn.getMinute()))+125));
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}