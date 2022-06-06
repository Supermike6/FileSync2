package Clock;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
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

public class Clock2 extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private static final int PREF_W = 250;
	private static final int PREF_H = 250;
	private Timer timer;
	private ZonedDateTime rn = Instant.now().atZone(ZoneId.systemDefault());
	private LocalTime current = LocalTime.now();
	private String message = "", tempString = "", today = rn.getDayOfWeek()+"";
	private boolean sp;
	private Scanner sc,sc1;
	private Double hr, min, sec;
	private ArrayList<String> cls = new ArrayList<>(8), fileLines = new ArrayList<>(0), rotation = new ArrayList<>(0), times = new ArrayList<>(0);
	private LocalTime tempTime;
	private int i = 0;
	
	
	Clock2()
	{
		
		this.setFocusable(true);
		this.setBackground(Color.WHITE);
		this.addKeyListener(this);

		try {
			sc = new Scanner(new File("Clock/Schedules/Monday.txt"));
			sc1 = new Scanner(new File("Clock/calendar.ics")); 
		} catch (Exception e){e.printStackTrace();}
		
		i = 0;
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

		for(int k = 0; k<fileLines.size();k++)
		{
			if(fileLines.get(k).contains("DTEND;VALUE=DATE:"))
			{
				if(fileLines.get(k+4).contains("[HillsRotation]"))
				{
					rotation.add(""+fileLines.get(k+4).subSequence(8, fileLines.get(k+4).indexOf(" ")));
					times.add(fileLines.get(k).subSequence(21, 23)+"/"+fileLines.get(k).subSequence(23, 25)+"/"+fileLines.get(k).subSequence(17, 21));
				}
			}
		}

		if(rn.getDayOfMonth()<10)
		{
			tempString = rn.getMonthValue()+"/0"+rn.getDayOfMonth()+"/"+rn.getYear();
			if(rn.getMonthValue()<10)
				tempString = "0"+rn.getMonthValue()+"/0"+rn.getDayOfMonth()+"/"+rn.getYear();
		} else {
				tempString = rn.getMonthValue()+"/"+rn.getDayOfMonth()+"/"+rn.getYear();
				if(rn.getMonthValue()<10)
					tempString = "0"+rn.getMonthValue()+"/"+rn.getDayOfMonth()+"/"+rn.getYear();
		}
		tempString = rotation.get(times.indexOf(tempString));
		timer = new Timer(1000, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				current = LocalTime.now();
				rn = Instant.now().atZone(ZoneId.systemDefault());
				today = ""+rn.getDayOfWeek();
				
				repaint();	
			}
		});
		timer.start();
	}
	
	public Double getSec() {
		return sec;
	}

	public void setSec(Double sec) {
		this.sec = sec;
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

		

		tempTime = LocalTime.parse("08:00:00");
		
		if(tempString.equals("R1")){
			if(current.compareTo(LocalTime.parse("08:00:00"))>0){
				if(current.compareTo(LocalTime.parse("08:56:00"))>0){
					if(current.compareTo(LocalTime.parse("09:00:00"))>0){
						if(current.compareTo(LocalTime.parse("09:58:00"))>0){
							if(current.compareTo(LocalTime.parse("10:02:00"))>0){
								if(current.compareTo(LocalTime.parse("10:58:00"))>0){
									if(current.compareTo(LocalTime.parse("11:02:00"))>0){
										if(current.compareTo(LocalTime.parse("11:53:00"))>0){	
											if(current.compareTo(LocalTime.parse("11:57:00"))>0){
												if(current.compareTo(LocalTime.parse("12:53:00"))>0){
													if(current.compareTo(LocalTime.parse("12:57:00"))>0){
														if(current.compareTo(LocalTime.parse("13:53:00"))>0){
															if(current.compareTo(LocalTime.parse("13:57:00"))>0){
																if(current.compareTo(LocalTime.parse("14:53:00"))>0){
																	message = "School Over";tempTime = LocalTime.parse("00:00:00");
																}else{message = "In "+cls.get(6);tempTime = LocalTime.parse("14:53:00");}
															}else{message = "Inbetween "+cls.get(5)+" and "+cls.get(6);tempTime = LocalTime.parse("13:57:00");}
														}else{message = "In "+cls.get(5);tempTime = LocalTime.parse("13:53:00");}
													}else{message = "Inbetween "+cls.get(4)+" and "+cls.get(5);tempTime = LocalTime.parse("12:57:00");}
												}else{message = "In "+cls.get(4);tempTime = LocalTime.parse("12:53:00");}
											}else{message = "Inbetween Lunch and "+cls.get(4);tempTime = LocalTime.parse("11:57:00");}
										}else{message = "In Lunch";tempTime = LocalTime.parse("11:53:00");}
									}else{message = "Inbetween "+cls.get(2)+" and Lunch";tempTime = LocalTime.parse("11:02:00");}			
								}else{message = "In "+cls.get(2);tempTime = LocalTime.parse("10:58:00");}
							}else{message = "Inbetween "+cls.get(1)+" and "+cls.get(2);tempTime = LocalTime.parse("10:02:00");}
						}else{message = "In "+cls.get(1);tempTime = LocalTime.parse("09:58:00");}
					}else{message = "Inbetween "+cls.get(0)+" and "+cls.get(1);tempTime = LocalTime.parse("09:00:00");}
				}else{message = "In "+cls.get(0);tempTime = LocalTime.parse("08:56:00");}
			}else{message = "Before School";tempTime = LocalTime.parse("08:00:00");}
		}
		if(tempString.equals("R4")){
			if(current.compareTo(LocalTime.parse("08:00:00"))>0){
				if(current.compareTo(LocalTime.parse("08:56:00"))>0){
					if(current.compareTo(LocalTime.parse("09:00:00"))>0){
						if(current.compareTo(LocalTime.parse("09:58:00"))>0){
							if(current.compareTo(LocalTime.parse("10:02:00"))>0){
								if(current.compareTo(LocalTime.parse("10:58:00"))>0){
									if(current.compareTo(LocalTime.parse("11:02:00"))>0){
										if(current.compareTo(LocalTime.parse("11:53:00"))>0){	
											if(current.compareTo(LocalTime.parse("11:57:00"))>0){
												if(current.compareTo(LocalTime.parse("12:53:00"))>0){
													if(current.compareTo(LocalTime.parse("12:57:00"))>0){
														if(current.compareTo(LocalTime.parse("13:53:00"))>0){
															if(current.compareTo(LocalTime.parse("13:57:00"))>0){
																if(current.compareTo(LocalTime.parse("14:53:00"))>0){
																	message = "School Over";tempTime = LocalTime.parse("00:00:00");
																}else{message = "In "+cls.get(5);tempTime = LocalTime.parse("14:53:00");}
															}else{message = "Inbetween "+cls.get(4)+" and "+cls.get(5);tempTime = LocalTime.parse("13:57:00");}
														}else{message = "In "+cls.get(4);tempTime = LocalTime.parse("13:53:00");}
													}else{message = "Inbetween "+cls.get(7)+" and "+cls.get(4);tempTime = LocalTime.parse("12:57:00");}
												}else{message = "In "+cls.get(7);tempTime = LocalTime.parse("12:53:00");}
											}else{message = "Inbetween Lunch and "+cls.get(7);tempTime = LocalTime.parse("11:57:00");}
										}else{message = "In Lunch";tempTime = LocalTime.parse("11:53:00");}
									}else{message = "Inbetween "+cls.get(1)+" and Lunch";tempTime = LocalTime.parse("11:02:00");}			
								}else{message = "In "+cls.get(1);tempTime = LocalTime.parse("10:58:00");}
							}else{message = "Inbetween "+cls.get(0)+" and "+cls.get(1);tempTime = LocalTime.parse("10:02:00");}
						}else{message = "In "+cls.get(0);tempTime = LocalTime.parse("09:58:00");}
					}else{message = "Inbetween "+cls.get(3)+" and "+cls.get(0);tempTime = LocalTime.parse("09:00:00");}
				}else{message = "In "+cls.get(3);tempTime = LocalTime.parse("08:56:00");}
			}else{message = "Before School";tempTime = LocalTime.parse("08:00:00");}
		}
		if(tempString.equals("R3")){
			if(current.compareTo(LocalTime.parse("08:00:00"))>0){
				if(current.compareTo(LocalTime.parse("08:56:00"))>0){
					if(current.compareTo(LocalTime.parse("09:00:00"))>0){
						if(current.compareTo(LocalTime.parse("09:58:00"))>0){
							if(current.compareTo(LocalTime.parse("10:02:00"))>0){
								if(current.compareTo(LocalTime.parse("10:58:00"))>0){
									if(current.compareTo(LocalTime.parse("11:02:00"))>0){
										if(current.compareTo(LocalTime.parse("11:53:00"))>0){	
											if(current.compareTo(LocalTime.parse("11:57:00"))>0){
												if(current.compareTo(LocalTime.parse("12:53:00"))>0){
													if(current.compareTo(LocalTime.parse("12:57:00"))>0){
														if(current.compareTo(LocalTime.parse("13:53:00"))>0){
															if(current.compareTo(LocalTime.parse("13:57:00"))>0){
																if(current.compareTo(LocalTime.parse("14:53:00"))>0){
																	message = "School Over";tempTime = LocalTime.parse("00:00:00");
																}else{message = "In "+cls.get(4);tempTime = LocalTime.parse("14:53:00");}
															}else{message = "Inbetween "+cls.get(7)+" and "+cls.get(4);tempTime = LocalTime.parse("14:57:00");}
														}else{message = "In "+cls.get(7);tempTime = LocalTime.parse("13:53:00");}
													}else{message = "Inbetween "+cls.get(6)+" and "+cls.get(7);tempTime = LocalTime.parse("12:57:00");}
												}else{message = "In "+cls.get(6);tempTime = LocalTime.parse("12:53:00");}
											}else{message = "Inbetween Lunch and "+cls.get(6);tempTime = LocalTime.parse("11:57:00");}
										}else{message = "In Lunch";tempTime = LocalTime.parse("11:53:00");}
									}else{message = "Inbetween "+cls.get(0)+" and Lunch";tempTime = LocalTime.parse("11:02:00");}			
								}else{message = "In "+cls.get(0);tempTime = LocalTime.parse("10:58:00");}
							}else{message = "Inbetween "+cls.get(3)+" and "+cls.get(0);tempTime = LocalTime.parse("10:02:00");}
						}else{message = "In "+cls.get(3);tempTime = LocalTime.parse("09:58:00");}
					}else{message = "Inbetween "+cls.get(2)+" and "+cls.get(3);tempTime = LocalTime.parse("09:00:00");}
				}else{message = "In "+cls.get(2);tempTime = LocalTime.parse("08:56:00");}
			}else{message = "Before School";tempTime = LocalTime.parse("08:00:00");}
		}
		if(tempString.equals("R2")){
			if(current.compareTo(LocalTime.parse("08:00:00"))>0){
				if(current.compareTo(LocalTime.parse("08:56:00"))>0){
					if(current.compareTo(LocalTime.parse("09:00:00"))>0){
						if(current.compareTo(LocalTime.parse("09:58:00"))>0){
							if(current.compareTo(LocalTime.parse("10:02:00"))>0){
								if(current.compareTo(LocalTime.parse("10:58:00"))>0){
									if(current.compareTo(LocalTime.parse("11:02:00"))>0){
										if(current.compareTo(LocalTime.parse("11:53:00"))>0){	
											if(current.compareTo(LocalTime.parse("11:57:00"))>0){
												if(current.compareTo(LocalTime.parse("12:53:00"))>0){
													if(current.compareTo(LocalTime.parse("12:57:00"))>0){
														if(current.compareTo(LocalTime.parse("13:53:00"))>0){
															if(current.compareTo(LocalTime.parse("13:57:00"))>0){
																if(current.compareTo(LocalTime.parse("14:53:00"))>0){
																	message = "School Over";tempTime = LocalTime.parse("00:00:00");
																}else{message = "In "+cls.get(7);tempTime = LocalTime.parse("14:53:00");}
															}else{message = "Inbetween "+cls.get(6)+" and "+cls.get(7);tempTime = LocalTime.parse("13:57:00");}
														}else{message = "In "+cls.get(6);tempTime = LocalTime.parse("13:53:00");}
													}else{message = "Inbetween "+cls.get(5)+" and "+cls.get(6);tempTime = LocalTime.parse("12:57:00");}
												}else{message = "In "+cls.get(5);tempTime = LocalTime.parse("12:53:00");}
											}else{message = "Inbetween Lunch and "+cls.get(5);tempTime = LocalTime.parse("11:57:00");}
										}else{message = "In Lunch";tempTime = LocalTime.parse("11:53:00");}
									}else{message = "Inbetween "+cls.get(3)+" and Lunch";tempTime = LocalTime.parse("11:02:00");}			
								}else{message = "In "+cls.get(3);tempTime = LocalTime.parse("10:58:00");}
							}else{message = "Inbetween "+cls.get(2)+" and "+cls.get(3);tempTime = LocalTime.parse("10:02:00");}
						}else{message = "In "+cls.get(2);tempTime = LocalTime.parse("09:58:00");}
					}else{message = "Inbetween "+cls.get(1)+" and "+cls.get(2);tempTime = LocalTime.parse("09:00:00");}
				}else{message = "In "+cls.get(1);tempTime = LocalTime.parse("08:56:00");}
			}else{message = "Before School";tempTime = LocalTime.parse("08:00:00");}
		}
		if(tempString.equals("ALL")){
			if(current.compareTo(LocalTime.parse("08:00:00"))>0){
				if(current.compareTo(LocalTime.parse("08:41:00"))>0){
					if(current.compareTo(LocalTime.parse("08:45:00"))>0){
						if(current.compareTo(LocalTime.parse("09:28:00"))>0){
							if(current.compareTo(LocalTime.parse("09:32:00"))>0){
								if(current.compareTo(LocalTime.parse("10:13:00"))>0){
									if(current.compareTo(LocalTime.parse("10:17:00"))>0){
										if(current.compareTo(LocalTime.parse("10:58:00"))>0){	
											if(current.compareTo(LocalTime.parse("11:02:00"))>0){
												if(current.compareTo(LocalTime.parse("11:53:00"))>0){
													if(current.compareTo(LocalTime.parse("11:57:00"))>0){
														if(current.compareTo(LocalTime.parse("12:38:00"))>0){
															if(current.compareTo(LocalTime.parse("12:42:00"))>0){
																if(current.compareTo(LocalTime.parse("13:23:00"))>0){
																	if(current.compareTo(LocalTime.parse("13:27:00"))>0){
																		if(current.compareTo(LocalTime.parse("14:08:00"))>0){
																			if(current.compareTo(LocalTime.parse("14:12:00"))>0){
																				if(current.compareTo(LocalTime.parse("14:53:00"))>0){
																					message = "School Over";tempTime = LocalTime.parse("00:00:00");
																				}else{message = "In "+cls.get(7);tempTime = LocalTime.parse("14:53:00");}
																			}else{message = "Inbetween "+cls.get(6)+" and "+cls.get(7);tempTime = LocalTime.parse("14:12:00");}
																		}else{message = "In "+cls.get(6);tempTime = LocalTime.parse("14:08:00");}
																	}else{message = "Inbetween "+cls.get(5)+" and "+cls.get(6);tempTime = LocalTime.parse("13:27:00");}
																}else{message = "In "+cls.get(5);tempTime = LocalTime.parse("13:23:00");}
															}else{message = "Inbetween "+cls.get(4)+" and "+cls.get(5);tempTime = LocalTime.parse("13:42:00");}
														}else{message = "In "+cls.get(4);tempTime = LocalTime.parse("12:38:00");}
													}else{message = "Inbetween Lunch and "+cls.get(4);tempTime = LocalTime.parse("11:57:00");}
												}else{message = "In Lunch";tempTime = LocalTime.parse("11:53:00");}
											}else{message = "Inbetween "+cls.get(3)+" and Lunch";tempTime = LocalTime.parse("11:02:00");}
										}else{message = "In "+cls.get(3);tempTime = LocalTime.parse("10:58:00");}
									}else{message = "Inbetween "+cls.get(2)+" and "+cls.get(3);tempTime = LocalTime.parse("10:17:00");}			
								}else{message = "In "+cls.get(2);tempTime = LocalTime.parse("10:13:00");}
							}else{message = "Inbetween "+cls.get(1)+" and "+cls.get(2);tempTime = LocalTime.parse("09:32:00");}
						}else{message = "In "+cls.get(1);tempTime = LocalTime.parse("09:28:00");}
					}else{message = "Inbetween "+cls.get(0)+" and "+cls.get(1);tempTime = LocalTime.parse("08:45:00");}
				}else{message = "In "+cls.get(0);tempTime = LocalTime.parse("08:41:00");}
			}else{message = "Before School";tempTime = LocalTime.parse("08:00:00");}
		}

		
		FontMetrics fm = g2.getFontMetrics(); 
		int messageWidth = fm.stringWidth(message);
		int startX = PREF_W/2-messageWidth/2;
		g2.drawString(message, startX, 17);

		if(sp)
		{
			setSec((double) (rn.getSecond()-tempTime.getSecond()));
			min = tempTime.getMinute()%60+((double)tempTime.getSecond()/60);
			hr = tempTime.getHour()%12+(min/60);
			g2.setColor(Color.RED);

			g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((min)*6))*85+125), (int)(Math.cos(Math.toRadians((min)*6+180))*85+125));
			g2.drawLine(PREF_W/2, PREF_H/2, (int)(Math.sin(Math.toRadians((double)(hr*30)))*60+125), (int)(Math.cos(Math.toRadians((double)(hr*30)+180))*60+125));

			int tempInt1 = (tempTime.getHour()-rn.getHour())*3600+(tempTime.getMinute()-rn.getMinute())*60+(-tempTime.getSecond()-rn.getSecond());
			int tempInt2 = tempInt1%60;
			int tempInt3 = (tempInt1-tempInt2)/60;
			fm = g2.getFontMetrics(); 

			messageWidth = fm.stringWidth("Time Left: Minutes "+tempInt3+", Seconds "+tempInt2);
			startX = PREF_W/2-messageWidth/2;
			g2.drawString("Time Left: Minutes "+tempInt3+", Seconds "+tempInt2, startX, PREF_H-7);
			
		}
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
		JPanel gamePanel = new Clock2();
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
			try {
				sc = new Scanner(new File("Clock/Schedules/"+today+".txt"));
				sc1 = new Scanner(new File("Clock/calendar.ics")); 
			} catch (Exception o){o.printStackTrace();}
			
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
	
			for(int k = 0; k<fileLines.size();k++)
			{
				if(fileLines.get(k).contains("DTEND;VALUE=DATE:"))
				{
					if(fileLines.get(k+4).contains("[HillsRotation]"))
					{
						rotation.add(""+fileLines.get(k+4).subSequence(8, fileLines.get(k+4).indexOf(" ")));
						times.add(fileLines.get(k).subSequence(21, 23)+"/"+fileLines.get(k).subSequence(23, 25)+"/"+fileLines.get(k).subSequence(17, 21));
					}
				}
			}
	
			if(rn.getDayOfMonth()<10)
			{
				tempString = rn.getMonthValue()+"/0"+rn.getDayOfMonth()+"/"+rn.getYear();
				if(rn.getMonthValue()<10)
					tempString = "0"+rn.getMonthValue()+"/0"+rn.getDayOfMonth()+"/"+rn.getYear();
			} else {
					tempString = rn.getMonthValue()+"/"+rn.getDayOfMonth()+"/"+rn.getYear();
					if(rn.getMonthValue()<10)
						tempString = "0"+rn.getMonthValue()+"/"+rn.getDayOfMonth()+"/"+rn.getYear();
			}
			tempString = rotation.get(times.indexOf(tempString));
		
			current = LocalTime.now();
			rn = Instant.now().atZone(ZoneId.systemDefault());
			System.out.println("Updated");
		}
		repaint();
	}
}