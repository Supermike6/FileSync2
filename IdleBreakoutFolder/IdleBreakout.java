package IdleBreakoutFolder;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;



import IdleBreakoutFolder.Ball;

public class IdleBreakout extends JPanel implements KeyListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 1200;
    static final int PREF_H = 900;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    int ballSpeed = 4, level = 1, score = 0;
    boolean debug;
    Color prevColor;
    Clip colide;
    String message = "";



    ArrayList<Ball> balls = new ArrayList<Ball>(1);
    Brick[][] bricks = new Brick[15][20];

    

    public IdleBreakout()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        //sound
        // try {
        //     System.out.println("Audio making");
        //     URL file = this.getClass().getResource("ex-fl-2.wav");
        //     AudioInputStream audio = AudioSystem.getAudioInputStream(file);
        //     colide = AudioSystem.getClip();
        //     colide.open(audio);
        //     System.out.println("Audio made");
        // } catch (Exception e) {
        //     System.out.println("Audio failed");
        //     e.printStackTrace();
        // }
      
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {

            
                
                System.out.println(timer.getDelay());
                repaint();
            }
        });
        timer.start();
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        
        if(debug)
        {
            
        }
        
        
        
        g2.setFont(new Font("Minecraft", Font.PLAIN, 32));
        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = fm.stringWidth(message);
        int startX = getWidth()/2 - messageWidth/2;
        g2.drawString(message, startX, getHeight()/2);
    
        
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_A)
        {
            
        }
        if(key == KeyEvent.VK_D)
        {
            
        }
        if(key == KeyEvent.VK_UP)
        {
            timer.setDelay(10);
        }
        if(key == KeyEvent.VK_DOWN)
        {
            timer.setDelay(10);
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        IdleBreakout gamePanel = new IdleBreakout();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }
    public int getSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(PREF_W, PREF_H);
    }
}