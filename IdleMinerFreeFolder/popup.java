

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

public class popup extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    static final long serialVersionUID = 1L;
    static final double scale = .5;
    static final double scrollSpeed = 15;
    static final int fps = 60;
    static final int PREF_W = (int)(750 * scale * 2 / 3);
    static final int PREF_H = (int)(1334 * scale * 2 / 3);
    private int yOffset = 10;
    private boolean dragging = false;
    private int startY = 0;
    private static TypeOfPopup state;
   
    public static void setState(TypeOfPopup newState) {
        state = newState;
    }
    public enum TypeOfPopup
    {
        MONEYDISPLAY,
        MINEUPGRADE,
        MINEMANAGER,
        ELEVATORUPGRADE,
        ELEVATORMANAGER,
        TRANSPORTUPGRADE,
        TRANSPORTMANAGER,
        BOOSTS,
        NONE
    }
    
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    
    public popup()
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

        switch (state) {
            case MONEYDISPLAY:
                System.out.println("MONEYDISPLAY");
                break;
            case MINEUPGRADE:
                System.out.println("MINEUPGRADE");
                break;
            case MINEMANAGER:
                System.out.println("MINEMANAGER");
                break;
            case ELEVATORUPGRADE:
                System.out.println("ELEVATORUPGRADE");
                break;
            case ELEVATORMANAGER:
                System.out.println("ELEVATORMANAGER");
                break;      
            case TRANSPORTUPGRADE:
                System.out.println("TRANSPORTUPGRADE");
                break;
            case TRANSPORTMANAGER:
                System.out.println("TRANSPORTMANAGER");
                break;
            case BOOSTS:  
                System.out.println("BOOSTS");
                break;
            default:
                break;
        }
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
        popup gamePanel = new popup();
        JFrame frame = new JFrame("thing");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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