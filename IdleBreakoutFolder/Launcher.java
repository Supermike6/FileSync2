package IdleBreakoutFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;

import IdleBreakoutFolder.IdleBreakout;

public class Launcher extends JPanel implements KeyListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 600;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    JButton button = new JButton("Hello");

    public Launcher()
    {
        super(new BorderLayout(),true);
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        
        this.add(new IdleBreakout(), BorderLayout.CENTER);
        this.add(new TopBar(), BorderLayout.NORTH);
        this.add(new LeftBar(), BorderLayout.WEST);
        this.add(new RightBar(), BorderLayout.EAST);
        this.add(new BottomBar(), BorderLayout.SOUTH);



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
       
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
        Launcher gamePanel = new Launcher();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false);
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