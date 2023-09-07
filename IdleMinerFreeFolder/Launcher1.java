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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.sound.sampled.AudioFileFormat.Type;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


import Classes.*;

public class Launcher1 extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    static final long serialVersionUID = 1L;
    static final double scale = .5;
    static final double scrollSpeed = 15;
    static final int fps = 60;
    static final int PREF_W = (int)(750 * scale);
    static final int PREF_H = (int)(1334 * scale);
    private int yOffset = 10;
    private boolean dragging = false;
    private int startY = 0;
    private String state = "test";


    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    
    public Launcher1()
    {
        super(new BorderLayout(),true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addMouseWheelListener(this);
        setFocusable(true);
        requestFocus();

        timer = new Timer(1000/fps, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(yOffset < 10) yOffset = (int)(20*scale);
                if(yOffset > PREF_H-(int)(60*scale)) yOffset = PREF_H-(int)(60*scale);
                
                
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

        g2.drawRect((int)(20*scale), (int)(yOffset), (int)(60*scale), (int)(40*scale));
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
      
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
      
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        if(e.getKeyChar() == ' ')
        {
            popup.setState(popup.TypeOfPopup.MONEYDISPLAY);
            popup.main(null);
        }
    }
    
    public static void main(String[] args)
    {

        System.out.println();

        // System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
   
    private static void createAndShowGUI() {
        Launcher1 gamePanel = new Launcher1();
        JFrame frame = new JFrame("Launcher1");
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

    @Override
    public void mouseDragged(MouseEvent e)
    {
        if(dragging)
        {
            yOffset -= (startY - e.getY())*scrollSpeed/5;
            startY = e.getY();
        }
    }
   
    @Override
    public void mouseMoved(MouseEvent e)
    {
        startY = e.getY();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON2)
        {
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON2)
        {
            dragging = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
     
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
       yOffset+=e.getWheelRotation()*scrollSpeed;
    }

}