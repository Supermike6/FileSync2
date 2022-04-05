package Games.BrickBrakeFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
   Brick player = new Brick(20, 200, 80, 40, Color.PINK);
   int playerSpeed = 5, ballSpeed = 2;
   boolean debug;
   Rectangle rplayer = new Rectangle(10, 10, 80, 30);
   
   public BrickBraker()
   {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        player.setXmax(PREF_W);
        player.setYmax(PREF_H);
      
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                player.noBounceUpdate();
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
        player.fill(g2);
        g2.draw(rplayer);
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
        if(key == KeyEvent.VK_F)
        {
            debug = !debug;
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
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
   
    private static void createAndShowGUI() {
        BrickBraker gamePanel = new BrickBraker();
        JFrame frame = new JFrame("My Frame");
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