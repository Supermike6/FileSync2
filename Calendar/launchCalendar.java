package Calendar;

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
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
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


public class launchCalendar extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 250;
	private static final int PREF_H = 250;
	private Timer timer;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private String message = "";
	private boolean sp;
	private Scanner sc;
	private ArrayList<String> cls = new ArrayList<>(8), fileLines = new ArrayList<>(0), rotation = new ArrayList<>(0), times = new ArrayList<>(0),v = new ArrayList<>(0);
	private LocalTime tempTime;
	private int i = 0, ticks = 0, tickCount = 14;
	private static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	
	launchCalendar()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);

		try {
			sc = new Scanner(new File("Calendar/Robotics.ics"));
			i = 0;
			while(sc.hasNextLine())
			{
				cls.add(i, sc.nextLine());
				i++;
			}
			
			sc.reset();
			
			sc = new Scanner(new File("Calendar/Canvas.ics")); 
			i=0;
			while(sc.hasNextLine())
			{
				fileLines.add(i, sc.nextLine());
				i++;
			}
			i=0;
		
		} catch (FileNotFoundException e1) {e1.printStackTrace();}

		for(int k = 0; k<fileLines.size();k++)
		{
			if(fileLines.get(k).contains("DTSTART;VALUE=DATE:"))
			{
				if(fileLines.get(k+4).contains("[HillsRotation]"))
				{
					rotation.add(""+fileLines.get(k+4).subSequence(8, fileLines.get(k+4).indexOf(" ")));
					times.add(fileLines.get(k).subSequence(21, 23)+"/"+fileLines.get(k).subSequence(23, 25)+"/"+fileLines.get(k).subSequence(17, 21));
				}
			}
			System.out.println(times.get(k));
		}
		for(int x = 0; x<cls.size();x++)
		{
			for(int y = 0; y<cls.get(x).split(" ").length;y++)
			{
				for(int z = 0; z<cls.get(x).split(" ")[y].split("-").length;z++)
				{
					if(cls.get(x).split(" ")[y].split("-")[z].contains(":"))
					{
						String t = cls.get(x).split(" ")[y].split("-")[z].split(":")[0];
						int ti = Integer.parseInt(t);
						if(ti<8) ti+=12;
						String u = cls.get(x).split(" ")[y].split("-")[z].split(":")[1];
						String s = fix0(ti)+":"+fix0(Integer.parseInt(u));
						v.add(s);
					}
				}
			}
		}

		// tempString = rotation.get(times.indexOf(tempString));
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
		
		g2.drawOval(PREF_W/2-100, PREF_H/2-100, 200, 200);
		if(ticks == 1) {
			for(int t = 0;t<4; t++)
			{
				g2.drawLine((int)(125+90*Math.cos((t*Math.PI)/2)),(int)(125+90*Math.sin((t*Math.PI)/2)),(int)(125+100*Math.cos((t*Math.PI)/2)),(int)(125+100*Math.sin((t*Math.PI)/2)));
			}
		} else if(ticks == 3) {
			for(int t = 0;t<tickCount; t++)
			{
				if(Math.cos((t*Math.PI)/(tickCount/2))==1||Math.cos((t*Math.PI)/(tickCount/2))==-1||Math.sin((t*Math.PI)/(tickCount/2))==1||Math.sin((t*Math.PI)/(tickCount/2))==-1) {
					g2.setStroke(new BasicStroke(3));
					g2.drawLine((int)(125+90*Math.cos((t*Math.PI)/(tickCount/2))),(int)(125+90*Math.sin((t*Math.PI)/(tickCount/2))),(int)(125+99*Math.cos((t*Math.PI)/(tickCount/2))),(int)(125+99*Math.sin((t*Math.PI)/(tickCount/2))));
				} else {
					g2.setStroke(new BasicStroke(1));
					g2.drawLine((int)(PREF_W/2+90*Math.cos((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+90*Math.sin((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+99*Math.cos((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+99*Math.sin((t*Math.PI)/(tickCount/2))));
				}
				
			}
		} else if(ticks == 2) {
			tickCount = 12;
			for(int t = 0;t<tickCount; t++)
			{
				if(Math.cos((t*Math.PI)/(tickCount/2))==1||Math.cos((t*Math.PI)/(tickCount/2))==-1||Math.sin((t*Math.PI)/(tickCount/2))==1||Math.sin((t*Math.PI)/(tickCount/2))==-1) {
					g2.setStroke(new BasicStroke(3));
					g2.drawLine((int)(125+90*Math.cos((t*Math.PI)/(tickCount/2))),(int)(125+90*Math.sin((t*Math.PI)/(tickCount/2))),(int)(125+99*Math.cos((t*Math.PI)/(tickCount/2))),(int)(125+99*Math.sin((t*Math.PI)/(tickCount/2))));
				} else {
					g2.setStroke(new BasicStroke(1));
					g2.drawLine((int)(PREF_W/2+90*Math.cos((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+90*Math.sin((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+99*Math.cos((t*Math.PI)/(tickCount/2))),(int)(PREF_W/2+99*Math.sin((t*Math.PI)/(tickCount/2))));
				}
				
			}
		}
		g2.setStroke(new BasicStroke(3));
		// g2.setColor(Color.black);
		// g2.fillOval(PREF_W/2-90, PREF_H/2-90, 180, 180);

		//put schedule code here
		int num = 0;
		for(i=0;i<v.size();i++)
		{
			if(LocalTime.parse(v.get(i)+":00").compareTo(rn.toLocalTime())<0)
			{
				if(i>=v.size()-1) {
					tempTime = LocalTime.parse("00:00:00");
					message = "Out Of School";
				} else {
				tempTime = LocalTime.parse(v.get(i+1)+":00");
				}
				num = i;
			}
		}
		if(i<=v.size())
		for(i = 0; i<cls.size();i++)
		{
			if(cls.get(i).contains(v.get(num).substring(1)))
			{
				message = cls.get(i).split(" ")[0];
				if(cls.get(i).split(" ")[1].split(":")[0].equals(v.get(num).substring(1))) {
					message = "Inbetween "+cls.get(i).split(" ")[0]+" and "+cls.get(i).split(" ")[0];
				} else {
					message = "In "+cls.get(i).split(" ")[0];
				}

			}
		}
		
		if(sp)
		{
			
			
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Clock");
		JPanel gamePanel = new launchCalendar();
		frame.getContentPane().add(gamePanel);
		frame.pack();
		// frame.setLocation((int) (size.getWidth()-PREF_W),(int) (size.getHeight()-PREF_H));
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
		if(e.getKeyCode() == KeyEvent.VK_R)
		{		
				
			
		}
		if(e.getKeyCode() == KeyEvent.VK_T)
		{

			
		}
		repaint();	
	}
	
	public String fix0(int num)
    {
        if(num<10) return "0"+num;
        return ""+num;
    }
}