package Clock;

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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Clock3 extends JPanel{
	private static final long serialVersionUID = 1L;
	public static final int START_W = 250;
	public static final int START_H = 250;
	public static int PREF_W = START_W;
	public static int PREF_H = START_H;
	private int margin = (PREF_W+PREF_H)/2/10;
	private Timer timer;
	private LocalTime now = LocalDateTime.now(ZoneId.systemDefault()).toLocalTime();
	private ArrayList<Reminder> rems = new ArrayList<>();
	private int ticks = 12;
	private double frames = 0;
	private Color bkgColor = new Color(255, 255, 255);
	private Dimension currentSize;
	

	
	
	
	public Clock3()
	{
		currentSize = getSize();
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		ArrayList<String> lines = new ArrayList<>();
		try {
			Scanner sc = new Scanner(new File("Clock/Schedule.txt"));
			while(sc.hasNextLine())
			{
				String nl = sc.nextLine();
				lines.add(nl);
			}
		} catch (FileNotFoundException e1) {e1.printStackTrace();}


		for(int i = 0;i<lines.size();i+=4)
		{
			rems.add(new Reminder(lines.get(i), lines.get(i+1), lines.get(i+2)));
		}

		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				now = LocalDateTime.now(ZoneId.systemDefault()).toLocalTime();
			}
			
		});
		timer.start();

		Timer timer2 = new Timer(1, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				doLayout();
				PREF_W = getCurrentSize().width;
				PREF_H = getCurrentSize().height;
				repaint();
			}
			
		});
		timer2.start();
	}

	public void setColorOfClock(Color c)
	{
		bkgColor = c;
		repaint();

	}
	public void setClockSpeed(int timesPerSecond)
	{
			timer.setDelay((int)(1/(timesPerSecond/1000.0)));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		g2.setStroke(new BasicStroke(3));

		int PREF = Math.min(PREF_W, PREF_H);
		Dimension center = new Dimension(getWidth(), getHeight());

		margin = PREF/10;

		Color temp = g2.getColor();
		g2.setColor(bkgColor);
		g2.fillRect(0, 0, PREF, PREF);
		g2.setColor(temp);

		g2.drawOval(margin, margin, PREF-2*margin, PREF-2*margin);
		
		Double curMin = Double.parseDouble(now.toString().substring(3,5));
		Double combMin = curMin+(Double.parseDouble(now.toString().substring(6,8))/60);
		Double curHour = Double.parseDouble(now.toString().substring(0,2));
		Double combHour = curHour+combMin/60; 
		Double sec = Double.parseDouble(now.toString().substring(6));
		int xEnd = (int)((85*PREF/PREF)*Math.cos(Math.toRadians(combMin*6-90)))+PREF/2;
		int yEnd = (int)((85*PREF/PREF)*Math.sin(Math.toRadians(combMin*6-90)))+PREF/2;
		g2.drawLine(PREF/2, PREF/2, xEnd, yEnd);
		xEnd = (int)((60*PREF/PREF)*Math.cos(Math.toRadians((combHour%12)*30-90)))+PREF/2;
		yEnd = (int)((60*PREF/PREF)*Math.sin(Math.toRadians((combHour%12)*30-90)))+PREF/2;
		g2.drawLine(PREF/2, PREF/2, xEnd, yEnd);
		xEnd = (int)((85*PREF/PREF)*Math.cos(Math.toRadians((sec)*6-90)))+PREF/2;
		yEnd = (int)((85*PREF/PREF)*Math.sin(Math.toRadians((sec)*6-90)))+PREF/2;
		g2.setStroke(new BasicStroke(1));
		g2.setColor(Color.RED);
		g2.drawLine(PREF/2, PREF/2, xEnd, yEnd);
		
		g2.setStroke(new BasicStroke(3));
		String time = Reminder.getCurrent(rems).end;
		curMin = Double.parseDouble(time.toString().substring(2,4));
		combMin = curMin+(Double.parseDouble(time.toString().substring(0,2))/60);
		curHour = Double.parseDouble(time.toString().substring(0,2));
		combHour = curHour+combMin/60; 
		sec = Double.parseDouble(time.toString().substring(4,6));
		g2.setColor(Color.GRAY);
		xEnd = (int)((85*PREF/PREF)*Math.cos(Math.toRadians(combMin*6-90)))+PREF/2;
		yEnd = (int)((85*PREF/PREF)*Math.sin(Math.toRadians(combMin*6-90)))+PREF/2;
		g2.drawLine(PREF/2, PREF/2, xEnd, yEnd);
		xEnd = (int)((60*PREF/PREF)*Math.cos(Math.toRadians((combHour%12)*30-90)))+PREF/2;
		yEnd = (int)((60*PREF/PREF)*Math.sin(Math.toRadians((combHour%12)*30-90)))+PREF/2;
		g2.drawLine(PREF/2, PREF/2, xEnd, yEnd);

		g2.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(1));
		for(int i = 0;i<360; i+=(360/ticks))
		{
			int xEnd1 = (int)((94)*Math.cos(Math.toRadians(i-90)))+PREF/2;
			int yEnd1 = (int)((94)*Math.sin(Math.toRadians(i-90)))+PREF/2;
			int xEnd2 = (int)((100)*Math.cos(Math.toRadians(i-90)))+PREF/2;
			int yEnd2 = (int)((100)*Math.sin(Math.toRadians(i-90)))+PREF/2;
			g2.drawLine(xEnd2, yEnd2, xEnd1, yEnd1);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(START_W, START_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Clock");
		JPanel gamePanel = new Clock3();
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
    public Dimension getSize() {
        return super.getSize();
    }
    
    @Override
    public void doLayout() {
        super.doLayout();
        if (!getSize().equals(currentSize)) {
            currentSize = getSize();
			repaint();
            // Panel size has changed, do something here if needed
        }
    }
    
    public Dimension getCurrentSize() {
        return currentSize;
    }
}