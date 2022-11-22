package Something;



import java.awt.BorderLayout;
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
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Something.Clock;

public class gui extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 530;
	private static final int PREF_H = 310;
	private Timer timer;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private String message = "", tempString = "", today = rn.getDayOfWeek()+"";
	private boolean sp;
	private Scanner sc,sc1;
	private Double hr, min, sec;
	private ArrayList<String> cls = new ArrayList<>(8), fileLines = new ArrayList<>(0), rotation = new ArrayList<>(0), times = new ArrayList<>(0);
	private LocalTime tempTime;
	private int i = 0;
    private JButton b1 = new JButton("I am a button 1");
	private JButton b2 = new JButton("I am a button 2");
	private JButton b3 = new JButton("I am a button 3");
	private JButton b4 = new JButton("I am a button 4");
	private JButton b5 = new JButton("I am a button 5");
	private JButton b6 = new JButton("I am a button 6");


	private ArrayList<JButton> bs = new ArrayList<>(6);
	private JPanel clock = Clock.giveClock();
	
	gui()
	{

		bs.add(b1);
		bs.add(b2);
		bs.add(b3);
		bs.add(b4);
		bs.add(b5);
		bs.add(b6);
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);

		JPanel left = new JPanel(new BorderLayout());
		left.add(b5, BorderLayout.NORTH);
		left.add(b6, BorderLayout.WEST);
		
		JPanel right = new JPanel(new BorderLayout());
		right.add(b3, BorderLayout.SOUTH);
		right.add(b4, BorderLayout.EAST);


		this.setLayout(new BorderLayout());
      	this.add(b1, BorderLayout.SOUTH);
		this.add(b2, BorderLayout.NORTH);
		this.add(right, BorderLayout.EAST);
		this.add(left, BorderLayout.WEST);
		this.add(clock, BorderLayout.CENTER);


		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
			   System.out.println(1);
			}
		 }); 
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
			   System.out.println(2);
			}
		}); 
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
			   System.out.println(3);
			}
		}); 
		b4.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
			   System.out.println(4);
			}}); 
		b5.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
			   System.out.println(5);
			}}); 
		b6.addActionListener(new ActionListener(){@Override public void actionPerformed(ActionEvent e){
			   System.out.println(6);
			}}); 


		timer = new Timer(1000, new ActionListener()
		  {
			@Override
			public void actionPerformed(ActionEvent e)
			{

			}
		});
		timer.start();
	}

	public void paintComponent(Graphics g)
    {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
    }

	public Dimension getPreferredSize() {
		return new Dimension(PREF_W, PREF_H);
	}

	public static void createAndShowGUI() throws IOException {
		JFrame frame = new JFrame("Program");
		JPanel gamePanel = new gui();
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
		if(e.getKeyCode() == KeyEvent.VK_R)
		{
			
		}
		repaint();	
	}
}