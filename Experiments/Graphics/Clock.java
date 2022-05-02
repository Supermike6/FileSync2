package Experiments.Graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Clock extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 250;
	private static final int PREF_H = 250;
	private Timer timer;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private LocalTime current = LocalTime.now();
	private String message = "";
	private boolean sp;
	private int per = 0;
	private Scanner sc;
	private Double hr, min;
	private ArrayList<String> cls = new ArrayList<>(8);
	private LocalTime tempTime;
	
	
	Clock()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);

		try {
			sc = new Scanner(new File("Experiments/Graphics/schedule.txt"));
		} catch (Exception e){e.printStackTrace();}
		
		int i = 0;
		while(sc.hasNextLine())
		{
			cls.add(i, sc.nextLine());
			i++;
		}
		
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rn = Instant.now().atZone(ZoneId.systemDefault());
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
		
		g2.drawOval(PREF_W/2-100, PREF_W/2-100, 200, 200);

		if(sp)
		System.out.println(rn.getDayOfWeek().toString());

		tempTime = LocalTime.parse("08:00:00");
		if(!rn.getDayOfWeek().toString().equals("MONDAY"))
		{
			if(current.compareTo(LocalTime.parse("08:00:00"))>0)
			{
				
				if(current.compareTo(LocalTime.parse("08:56:00"))>0&&current.compareTo(LocalTime.parse("09:00:00"))<0)
				{
					
				} else {
					tempTime = LocalTime.parse("08:56:00");
				}
			} else {
				message = "Before School";
			}

		} else {

		}

		

		tempTime = LocalTime.parse("13:53:00");

		min = tempTime.getMinute()%60+((double)tempTime.getSecond()/60);
		hr = tempTime.getHour()%12+(min/60);

		g2.setColor(Color.RED);

		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((min)*6))*85+125), (int)(Math.cos(Math.toRadians((min)*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(hr*30)))*60+125), (int)(Math.cos(Math.toRadians((double)(hr*30)+180))*60+125));

		min = rn.getMinute()%60+((double)rn.getSecond()/60);
		hr = rn.getHour()%12+(min/60);

		g2.setColor(new Color(219,200,175));

		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((min)*6))*85+125), (int)(Math.cos(Math.toRadians((min)*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(hr*30)))*60+125), (int)(Math.cos(Math.toRadians((double)(hr*30)+180))*60+125));

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
		frame.setAlwaysOnTop(true);
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE) sp = !sp;
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}