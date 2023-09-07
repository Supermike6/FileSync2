import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
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
   private int smoothness = 20;
   private boolean click = false;
   private long frameCount = 0;
   private int CCrdiff = 0; int CCgdiff = 0; int CCbdiff = 0; int temp = 0;
   
   
   
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
        
        if(click == true)
        {
            
            CCrdiff = (cc.getRed()-tc.getRed())/smoothness;
            CCgdiff = (cc.getGreen()-tc.getGreen())/smoothness;
            CCbdiff = (cc.getBlue()-tc.getBlue())/smoothness;
            temp = (int) (frameCount+smoothness);
            click = false;
        }
        System.out.println(frameCount+", "+temp);
        if(frameCount<temp)
        {
            cc = new Color(cc.getRed()-CCrdiff,cc.getGreen()-CCgdiff,cc.getBlue()-CCbdiff);
        } else {
            cc = tc;
        }
        g2.setColor(cc);
        g2.fillRect(0, 0, PREF_W, PREF_H);

        

        g2.setColor(Color.white);
        g2.fillRect(0, 0, PREF_W/2, PREF_H/2);
        g2.setColor(tc);
        g2.fillRect(PREF_W/2, 0, PREF_W, PREF_H/2);
        
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
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_RIGHT)
      {

      }

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
    tc = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
    System.out.println(tc.toString());
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

}

public int giveOneWSign(int num)
{
    if(num<0) return -1;
    return 1;
}

}