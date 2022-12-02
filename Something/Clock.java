package Something;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Clock extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 250;
	private static final int PREF_H = 250;
	private Timer timer;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private String message = "", tempString = "", today = rn.getDayOfWeek()+"";
	private boolean sp;
	private Scanner sc,sc1;
	private Double hr, min, sec;
	private ArrayList<String> cls = new ArrayList<>(8), fileLines = new ArrayList<>(0), rotation = new ArrayList<>(0), times = new ArrayList<>(0);
	private LocalTime tempTime;
	private int i = 0;
	private int x = 0;

	
	
	Clock()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);
		
		try {
			sc = new Scanner(new File("Clock/Schedules/Monday.txt"));
			sc1 = new Scanner(new File("Clock/calendar.ics")); 
		} catch (Exception e){e.printStackTrace();}
		
		int i = 0;
		while(sc.hasNextLine())
		{
			cls.add(i, sc.nextLine());
			i++;
		}
		i=0;
		while(sc1.hasNextLine())
		{
			fileLines.add(i, sc1.nextLine());
			i++;
		}
		i=0;

		for(int k = 0; k<fileLines.size();k++)
		{
			if(fileLines.get(k).contains("DTEND;VALUE=DATE:"))
			{
				if(fileLines.get(k+4).contains("[HillsRotation]"))
				{
					rotation.add(""+fileLines.get(k+4).subSequence(8, fileLines.get(k+4).indexOf(" ")));
					times.add(fileLines.get(k).subSequence(21, 23)+"/"+fileLines.get(k).subSequence(23, 25)+"/"+fileLines.get(k).subSequence(17, 21));
					System.out.println(fileLines.get(k+4).subSequence(8, fileLines.get(k+4).indexOf(" "))+" - "+fileLines.get(k).subSequence(21, 23)+"/"+fileLines.get(k).subSequence(23, 25)+"/"+fileLines.get(k).subSequence(17, 21));
				}
			}
		}

        

		tempString = fix0(rn.getMonthValue())+"/"+fix0(rn.getDayOfMonth())+"/"+rn.getYear();
		
		// tempString = rotation.get(times.indexOf(tempString));
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				rn = Instant.now().atZone(ZoneId.systemDefault());
				today = ""+rn.getDayOfWeek();
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
		
		g2.setColor(Color.BLACK);
		
		g2.drawOval(PREF_W/2-100, PREF_H/2-100, 200, 200);

		//put schedule code here

		x++;
		
		FontMetrics fm = g2.getFontMetrics(); 
		int messageWidth = fm.stringWidth(message);
		int startX = PREF_W/2-messageWidth/2;
		g2.drawString(message, startX, 17);

		sec = (double) rn.getSecond()%60;
		min = rn.getMinute()%60+((double)rn.getSecond()/60);
		hr = rn.getHour()%12+(min/60);
		

		g2.setColor(Color.black);

		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((min)*6))*85+125), (int)(Math.cos(Math.toRadians((min)*6+180))*85+125));
		g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(hr*30)))*60+125), (int)(Math.cos(Math.toRadians((double)(hr*30)+180))*60+125));
		g2.setColor(Color.red);
		g2.setStroke(new BasicStroke(2));
		g2.drawLine(PREF_W/2, PREF_H/2, -(int)((Math.sin(Math.toRadians(sec*6+180)))*90)+125, (int)((Math.cos(Math.toRadians(sec*6+180)))*90)+125);
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
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_SPACE) sp = !sp;
		repaint();	
	}
	
	public String fix0(int num)
    {
        if(num<10) return "0"+num;
        return ""+num;
    }
	public static JPanel giveClock()
	{
		return new Clock();
	}
}