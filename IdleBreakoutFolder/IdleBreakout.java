package IdleBreakoutFolder;





import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.BasicStroke;
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

import Classes.Brick;
import Classes.Ball;

public class IdleBreakout extends JPanel implements KeyListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 750;
    static final int PREF_H = 500;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    boolean debug = true;

    static int line = 50;

    static ArrayList<Brick> balls = new ArrayList<Brick>(1);
    static Brick testBall = new Brick(PREF_W/2-9, PREF_H/2-9, 18, 18, -1, -1, 0, PREF_W, 0, PREF_H, Color.YELLOW,3);
    static ArrayList<Brick> bricks = new ArrayList<Brick>(300);
    static Brick testBrick = new Brick(10,10,300,20,0,0,Color.RED);
    

    public IdleBreakout()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        balls.add(testBall);
        bricks.add(testBrick);
        for(int i = 0; i<bricks.size();i++)
        {
            
        }

        // balls.set(0, new Ball(PREF_W/2-10, PREF_H/2-10, 20, 20, 1, -1, 0, PREF_W, 0, PREF_H, Color.BLACK));
        

        
        timer = new Timer(1000/60, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                calculatePhysics();
            }
        });
        timer.start();

        // for(int i = 0; i<testBrick.brickStat().length;i++)
        // {
        //     System.out.print(testBrick.brickStat()[i]+" ");
        // }
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        g2.setStroke(new BasicStroke(2));


        testBall.fillOval(g2);
        testBall.setColor(Color.BLACK);
        testBall.fillOval(g2);
        testBall.setColor(Color.YELLOW);
        testBrick.fill(g2);

        for(int i = 0; i<bricks.size(); i++)
        { 
            // bricks[i][0].draw(g2);
        }
        if(debug)
        {
            
        }
        repaint();
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
   
    private static void calculatePhysics()
    {
        Brick.updateList(balls);
        Brick.updateList(bricks);
        for(int i = 0; i<bricks.size();i++)
        {
            for(int j = 0; j<balls.size();j++)
                if(balls.get(i).checkAndReactToCollisionWith(bricks.get(i)))
                {
                    System.out.println("colision");
                    balls.get(i).checkAndReactToCollisionWith(bricks.get(i));
                    // bricks.get(i).setHealth(bricks.get(i).getHealth()-1);
                }
        }
        

    }

}