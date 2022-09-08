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
	private static ArrayList<String> cls = new ArrayList<>(8);
	public static ArrayList<String> fileLines = new ArrayList<>(1);
	private ArrayList<String> rotation = new ArrayList<>(1);
	private ArrayList<String> times = new ArrayList<>(1);
	private ArrayList<String> v = new ArrayList<>(1);
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
			
			sc = new Scanner(new File("Calendar/test.ics")); 
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
			if(fileLines.get(k).contains("BEGIN:")&&fileLines.get(k+3).contains("2022"))
			{
				// for(i = 0;i<11;i++)
				// {
				// 	System.out.println(fileLines.get(k+i));
				// }
			}
			
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
		// for(String s:cls) System.out.println(s);
		System.out.println(event("09/01/2022"));	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));

		g2.setStroke(new BasicStroke(3));
		
		g2.setColor(Color.black);
		
		
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
	public static void main(String[] args)
	{
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createAndShowGUI();
				} catch (IOException e)
				{
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
	public static String fix0s(CharSequence num)
    {
        if(Integer.parseInt((String)num)<10) return "0"+num;
        return ""+num;
    }
	public static String fixYear(int num)
	{
		String numS = num+"";
		if(numS.length()>=2)
			return "20"+num;
		return num+"";
	}
	public static String event(String date)
	{
		//9/8/22
		String dump = "";
		String output = "";
		String month = fix0s(date.subSequence(0, date.indexOf("/")));
		String day = fix0s(date.subSequence(date.indexOf("/")+1, date.indexOf("/", date.indexOf("/")+2)));
		String year = fixYear(Integer.parseInt(date.substring(date.indexOf("/", date.indexOf("/", date.indexOf("/")+3))+3,date.length())));
		String aioFileLines = "";
		for(String s:fileLines) aioFileLines+=s;
		if(day.contains("00"))
			day = day.substring(1);
		if(month.contains("00"))
			month = month.substring(1);
		
			for(int i = 0;i<fileLines.size()-4;i++)
			{
				if(fileLines.get(i).contains(year+month+day)&&fileLines.get(i).contains("START"))
				{
					for(int j=0; j<fileLines.indexOf("END:VEVENT");j++)
						dump+=fileLines.get(i+j);

					if(dump.length()>0)return dump;
					output+="Event Date: "+month+"/"+day+"/"+year+"\n";
					//Title and class

					output+=("Class: "+dump.substring(dump.indexOf("[")+1,dump.indexOf("]")))+"\n";

					output+=("Title: "+dump.substring(dump.indexOf("SUMMARY:")+8,dump.indexOf("[")))+"\n";
					
					//Description
					if(dump.contains("DESCRIPTION:"))
						output+="Description: "+dump.substring(dump.indexOf("DESCRIPTION:")+"DESCRIPTION".length(),dump.indexOf("["));
					
					//Location
					if(dump.subSequence(dump.indexOf("LOCATION:")+9, dump.indexOf("SEQUENCE:")).length()==0)
					{
						output+="Location: None\n";
					} else {
						output+="Location: "+dump.subSequence(dump.indexOf("LOCATION:")+9, dump.indexOf("SEQUENCE:"));
					}
					

					return output;
				}
			}

		System.out.println("_"+year+"_"+month+"_"+day+"_");
		System.out.println(year+month+day);
		return "Nothing on date";
	}
}