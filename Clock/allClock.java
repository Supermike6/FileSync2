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
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class allClock extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 250;
	private static final int PREF_H = 250;
	private int margin = 25;
	private Timer timer;
	private LocalTime now = LocalDateTime.now(ZoneId.systemDefault()).toLocalTime();
	private String curHour = DateTimeFormatter.ofPattern("HH").format(now);
	private String curMin = DateTimeFormatter.ofPattern("mm").format(now);
	private String curSec = DateTimeFormatter.ofPattern("ss").format(now);
	
	
	
	allClock()
	{
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);
		
		
		timer = new Timer(200, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				now = LocalDateTime.now(ZoneId.systemDefault()).toLocalTime();
				setSize(PREF_W, PREF_H);
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
		
		g2.drawOval(margin, margin, getWidth()-2*margin, getHeight()-2*margin);
		
		Double curMin = Double.parseDouble(now.toString().substring(3,5));
		Double combMin = curMin+(Double.parseDouble(now.toString().substring(6,8))/60);
		Double curHour = Double.parseDouble(now.toString().substring(0,2));
		Double combHour = curHour+combMin/60; 

		int xEnd = (int)((85*getWidth()/PREF_W)*Math.cos(Math.toRadians(combMin*6-90)))+getWidth()/2;
		int yEnd = (int)((85*getHeight()/PREF_H)*Math.sin(Math.toRadians(combMin*6-90)))+getHeight()/2;
		g2.drawLine(getWidth()/2, getHeight()/2, xEnd, yEnd);
		xEnd = (int)((60*getWidth()/PREF_W)*Math.cos(Math.toRadians((combHour%12)*30-90)))+getWidth()/2;
		yEnd = (int)((60*getHeight()/PREF_H)*Math.sin(Math.toRadians((combHour%12)*30-90)))+getHeight()/2;
		g2.drawLine(getWidth()/2, getHeight()/2, xEnd, yEnd);
		
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Clock");
		JPanel gamePanel = new allClock();
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
			
	}
	
	public String fix0(int num)
    {
        if(num<10) return "0"+num;
        return ""+num;
    }
}