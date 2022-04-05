package Experiments.Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Clock extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 250;
	public static final int PREF_H = 250;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private Timer timer;

	Clock()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		timer = new javax.swing.Timer(1000, new ActionListener() {

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

        // g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getNano()/10000000)*3.6))*100+125), (int)(Math.cos(Math.toRadians(-(rn.getNano()/10000000)*3.6+180))*100+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getMinute())*6))*85+125), (int)(Math.cos(Math.toRadians((rn.getMinute())*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((-rn.getHour())*6))*60+125), (int)(Math.cos(Math.toRadians((rn.getHour())*6+180))*60+125));

		g2.drawOval(PREF_W/2-100, PREF_W/2-100, 200, 200);

		// repaint();
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


}