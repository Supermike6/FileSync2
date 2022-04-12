package Games.BrickBrakeFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Experiments.Classes.Brick;

public class BrickBraker extends JPanel implements KeyListener
{
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 1000;
    private static final int PREF_H = 700;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private Timer timer;
    int playerSpeed = 7, ballSpeed = 3, level = 0;
    boolean debug, bot;
    Color prevColor;
    String state, message;
    Brick ball = new Brick(PREF_W/2, PREF_H/2-300, 16, 16, ballSpeed, ballSpeed, 0, PREF_W, 0, PREF_H, Color.black);
    Brick player = new Brick(PREF_W/2, 660, 80, 30, 0, 0, 0, PREF_W, 0, PREF_H-30, Color.CYAN);
    ArrayList<Brick> bricks = new ArrayList<Brick>(0);

    public BrickBraker()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        player.setX(PREF_W/2-player.getW()/2);
        ball.setY(player.getY()-ball.getH());
        ball.setYmax(PREF_H+ball.getH()+5);
      
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                player.noBounceUpdate();
                ball.update();
                ball.checkAndReactToCollisionWith(player);
                
                
            
                for(int i = 0; i<bricks.size();i++)
                {
                    if(ball.checkAndReactToCollisionWith(bricks.get(i)))
                    bricks.remove(i);
                }

                if(bricks.size()==0)
                {
                    level++;
                    for(int j = 0; j<level;j++)
                        for(int i = 0; i<18;i++)
                            bricks.add(new Brick(PREF_W/20+i*(PREF_W/20), 50+j*50, (PREF_W/20), 50, new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
                }
                if(bot)
                {
                    player.setX(ball.getX());
                }
                repaint();
            }
        });
        timer.start();
    }
   
    public Dimension getPreferredSize()
    {
        return new Dimension(PREF_W, PREF_H);
    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        g2.setBackground(Color.WHITE);

        for(int i = 0; i<bricks.size();i++)
        {
            bricks.get(i).fill(g2);
            prevColor = bricks.get(i).getColor();
            bricks.get(i).setColor(Color.black);
            bricks.get(i).draw(g2);
            bricks.get(i).setColor(prevColor);
        }

        player.fill(g2);
        ball.fillOval(g2);

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
      
        if(key == KeyEvent.VK_A)
        {
            player.setDx(-playerSpeed);
        }
        if(key == KeyEvent.VK_D)
        {
            player.setDx(playerSpeed);
        }
        if(key == KeyEvent.VK_UP)
        {
            timer.setDelay(1);
        }
        if(key == KeyEvent.VK_DOWN)
        {
            timer.setDelay(20);
        }
        if(key == KeyEvent.VK_F)
        {
            debug = !debug;
        }
        if(key == KeyEvent.VK_B)
        {
            bot = !bot;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A)
        {
            player.setDx(0);
        }
        if(key == KeyEvent.VK_D)
        {
            player.setDx(0);
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
   
    private static void createAndShowGUI() {
        BrickBraker gamePanel = new BrickBraker();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    public void playSound(Clip sound)
    {
        sound.setFramePosition(0);
        sound.start();
    }
    
    public int getSign(int num)
    {
        if(num<0) return -1;
        return 1;

    }
}