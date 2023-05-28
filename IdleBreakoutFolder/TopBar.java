package IdleBreakoutFolder;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TopBar extends JPanel
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 75;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    JButton button = new JButton("Hover over me!");

    int num = 0;
    public TopBar()
    {
        this.setLayout(new GridLayout());
        setFocusable(true);
        requestFocus(); 


        this.add(button);
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));

        
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(0, 0, PREF_W, PREF_H);

        g2.setStroke(new BasicStroke(2));

        num++;
        button.setToolTipText("<html>This is a<br>multiline<br>tooltip<br>"+num+"<html>");

        repaint();
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
        TopBar gamePanel = new TopBar();
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