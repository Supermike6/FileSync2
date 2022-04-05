package Experiments.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

public class Clockmax extends JPanel {
	private static final long serialVersionUID = 1L;
	public static final int PREF_W = 250;
	public static final int PREF_H = 250;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	Clockmax()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		Timer timer = new javax.swing.Timer(2000, new ActionListener() {

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
		rn = java.time.Instant.now().atZone(ZoneId.systemDefault());
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((rn.getMinute())*6))*85+125), (int)(Math.cos(Math.toRadians((rn.getMinute())*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((-rn.getHour())*6))*60+125), (int)(Math.cos(Math.toRadians((rn.getHour())*6+180))*60+125));
		g2.drawOval(PREF_W/2-100, PREF_W/2-100, 200, 200);
	}
	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}
	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Clock");
		JPanel gamePanel = new Clockmax();
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