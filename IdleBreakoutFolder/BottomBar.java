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
import java.awt.BasicStroke;

public class BottomBar extends JPanel
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 25;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    public BottomBar()
    {
        setFocusable(true);
        requestFocus();
        
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);

        g2.setStroke(new BasicStroke(2));

        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(0, 0, PREF_W, PREF_H);

        for(int i = 0; i<10;i++)
        {
            g2.setColor(Color.WHITE);
            g2.fillRect(25+i*75, 0, 100+i*75, 12);
            g2.setColor(Color.BLACK);
            g2.drawRect(25+i*75, 0, 100+i*75, 12);
        }
        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(PREF_W-25, PREF_H-25,25,25);

        g2.setColor(Color.BLACK);
        g2.drawLine(PREF_W-26, PREF_H-25, PREF_W-26, PREF_H-25+12);

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
        BottomBar gamePanel = new BottomBar();
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