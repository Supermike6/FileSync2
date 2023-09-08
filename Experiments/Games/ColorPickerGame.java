import java.awt.AWTException;
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
    private Color tc = new Color(8*16+8,8*16+8,8*16+8);
    private Color cc = new Color(255,255,255);
    private int smoothness = 10;
    private boolean click = false;
    private long frameCount = 0;
    private double CCrdiff = 0; double CCgdiff = 0; double CCbdiff = 0; double temp = 0; double CCrd = 0; double CCgd = 0; double CCbd = 0;
    private int numColors = 10;
    private int closeness = 10;
    ArrayList<ColorCircle> colorArray = makeColorArray(numColors);
    private boolean hoverColor = true;
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

        System.out.println(correctColor);
        
        if(frameCount<temp)
        {
            CCrd-=CCrdiff;
            CCgd-=CCgdiff;
            CCbd-=CCbdiff;
            cc = new Color((int)(CCrd),(int)(CCgd),(int)(CCbd));
        } else {
            cc = tc;
            CCrd = cc.getRed();
            CCgd = cc.getGreen();
            CCbd = cc.getBlue();
        }
        g2.setColor(cc);
        g2.fillRect(0, 0, PREF_W, PREF_H);

        

        g2.setColor(Color.green);
        g2.fillRect(0, 0, PREF_W, PREF_H/2);
        // g2.setColor(tc);
        // g2.fillRect(PREF_W/2, 0, PREF_W, PREF_H/2);
        
        for(int i = 0; i<colorArray.size();i++)
        {
            colorArray.get(i).fillCircle(g2);
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
        click = true;
        repaint();
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

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

        if(getIntersectingColorCircle(mousex,mousey)!=null)
        {
            tc = getIntersectingColorCircle(mousex,mousey).getC();
        } else tc = Color.white;
        beginAnim();
        
    }

    public int giveOneWSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }

    public ArrayList<ColorCircle> makeColorArray(int numColors)
    {
        ArrayList<ColorCircle> colorArray = new ArrayList<ColorCircle>(numColors);
        
        for(int i = 0; i<numColors+1;i++)
        {
            colorArray.add(new ColorCircle());
            colorArray.get(i).setC(new Color((255/numColors)*i, (255/numColors)*i, (255/numColors)*i));
            colorArray.get(i).setRadius(40);
            colorArray.get(i).setX(PREF_W/2+(colorArray.get(i).getRadius()*2+10)*(i-numColors/2));
            colorArray.get(i).setY(PREF_H/2);
        }

        return colorArray;
    }

    
    public ColorCircle getIntersectingColorCircle(int x, int y)
    {
        for(int i = 0; i<colorArray.size();i++)
        {
            if(colorArray.get(i).intersects(x, y))
            {
                return colorArray.get(i);
            }
        }
        return null;
    }
    
    public void beginAnim()
    {
        CCrdiff = (cc.getRed()-tc.getRed()+0.0)/(smoothness+0.0);
        CCgdiff = (cc.getGreen()-tc.getGreen()+0.0)/(smoothness+0.0);
        CCbdiff = (cc.getBlue()-tc.getBlue()+0.0)/(smoothness+0.0);
        temp = (int) frameCount+smoothness;
    }

}