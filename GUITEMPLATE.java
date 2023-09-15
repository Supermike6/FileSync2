import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;




public class GUITEMPLATE extends JPanel implements KeyListener, MouseInputListener
{
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 1300;
    private static final int PREF_H = PREF_W/16*9;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private int mousex = 0;
    private int mousey = 0;
    
   
    public GUITEMPLATE()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        
        
      
        Timer timer= new Timer((int)(1000/60), new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                repaint();
            }
        });
        timer.start();
   }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
   }

    @Override
    public void keyPressed(KeyEvent e)
    {
        // int key = e.getKeyCode();
        // if(key == KeyEvent.VK_SPACE)
        // {

        // }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
       
    }

    @Override
    public void keyTyped(KeyEvent e)
    {        
        
    }

    private static void createAndShowGUI() {
        GUITEMPLATE gamePanel = new GUITEMPLATE();
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });     
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(getIntersectingColorCircle(mousex,mousey)!=null)
        {
            switch(e.getButton())
            {
                case 1:
                    System.out.println("left");
                    break;
                case 2:
                    System.out.println("middle");
                    break;
                case 3:
                    System.out.println("right");
                    if(!flagged.contains(getIntersectingColorCircle(mousex,mousey)))
                        flagged.add(getIntersectingColorCircle(mousex,mousey));
                    else flagged.remove(getIntersectingColorCircle(mousex,mousey));
                    break;
                default:
                    System.out.println("unknown");
                    break;
            }
        } else System.out.println("not over circle");
        mouseMoved(e);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("release");
        for(int i = 0; i<flagged.size();i++)
            System.out.println(flagged.get(i).toString());
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousex = e.getX();
        mousey = e.getY();
    }

    public int giveOneWSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }
}