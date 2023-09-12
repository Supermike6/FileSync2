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




public class ColorPickerGame extends JPanel implements KeyListener, MouseInputListener
{
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 1300;
    private static final int PREF_H = PREF_W/16*9;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private int mousex = 0;
    private int mousey = 0;
    private Color tc = new Color(255,255,255);
    private Color cc = new Color(255,255,255);
    private int smoothness = 10;
    private long frameCount = 0;
    private double CCrdiff = 0; double CCgdiff = 0; double CCbdiff = 0; long temp = 0; double CCrd = 0; double CCgd = 0; double CCbd = 0;
    private int numColors = 13;
    private int closeness = 10;
    ArrayList<ColorCircle> colorArray = makeColorArray(numColors);
    ArrayList<ColorCircle> flagged = makeColorArray(0);
    private Color correctColor = new Color((int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255));
    
    
   
   
   
    public ColorPickerGame()
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
        
        //bkg
        if(frameCount<temp)
        {
            CCrd-=CCrdiff;
            CCgd-=CCgdiff;
            CCbd-=CCbdiff;
            if(CCrd<0)CCrd = 0;
            if(CCgd<0)CCgd = 0;
            if(CCbd<0)CCbd = 0;
            if(CCrd>255)CCrd = 255;
            if(CCgd>255)CCgd = 255;
            if(CCbd>255)CCbd = 255;
            cc = new Color((int)(CCrd),(int)(CCgd),(int)(CCbd));
        } else {
            cc = tc;
            CCrd = cc.getRed();
            CCgd = cc.getGreen();
            CCbd = cc.getBlue();
        }
        g2.setColor(cc);
        g2.fillRect(0, 0, PREF_W, PREF_H);
        

        for(int i = 0; i<colorArray.size();i++)
        {
            colorArray.get(i).fillCircle(g2);
            if(flagged.contains(colorArray.get(i)))
            {
                new ColorCircle(new Color(255, 255, 255, 160), colorArray.get(i).getX(), colorArray.get(i).getY(), colorArray.get(i).getRadius()).fillCircle(g2);
                g2.setColor(colorArray.get(i).getC());
                g2.setStroke(new BasicStroke(5));
                g2.drawLine(colorArray.get(i).getX()-colorArray.get(i).getRadius()/2, colorArray.get(i).getY()-colorArray.get(i).getRadius()/2, colorArray.get(i).getX()+colorArray.get(i).getRadius()/2, colorArray.get(i).getY()+colorArray.get(i).getRadius()/2);
                g2.drawLine(colorArray.get(i).getX()+colorArray.get(i).getRadius()/2, colorArray.get(i).getY()-colorArray.get(i).getRadius()/2, colorArray.get(i).getX()-colorArray.get(i).getRadius()/2, colorArray.get(i).getY()+colorArray.get(i).getRadius()/2);
            }
            colorArray.get(i).outlineCircle(g2);
        }
        


        g2.setColor(Color.black);
        String message = "#888888";
        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = fm.stringWidth(message);
        int startX = getWidth()/2 - messageWidth/2;
        g2.drawString(message, startX, getHeight()/2);
        
        frameCount++;
   }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE)
        {

        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyChar();
        if(key == 'a')
        {
            numColors++;
        }
        
        if(key == 's')
        {
            numColors--;
        }
        if(key == ' ')
            colorArray = makeColorArray(numColors);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {        
        
    }

    private static void createAndShowGUI() {
        ColorPickerGame gamePanel = new ColorPickerGame();
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