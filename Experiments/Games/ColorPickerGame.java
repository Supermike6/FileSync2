package Games;

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
   private int smoothness = 50;
   
   
   public ColorPickerGame()
   {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
      
      
    //     Timer timer= new Timer((int)(1000/60), new ActionListener() {
    //      public void actionPerformed(ActionEvent e)
    //      {
    //         repaint();
    //      }
    //   });
    //  timer.start();
   }


   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
      
        smootheBKGChange(g2, cc, tc, smoothness);

        g2.setColor(Color.black);
        String message = "#888888";
        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = fm.stringWidth(message);
        int startX = getWidth()/2 - messageWidth/2;
        g2.drawString(message, startX, getHeight()/2);
        
   
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

public void smootheBKGChange(Graphics2D g2, Color CC, Color TC, int smoothness)
{
    double ccr = CC.getRed();
    double ccg = CC.getGreen();
    double ccb = CC.getBlue();
    for(int i = 0; i<smoothness;i++)
    {
        if(CC.getRed()!=TC.getRed())
            ccr+=(TC.getRed()-CC.getRed())/smoothness;
        if(CC.getGreen()!=TC.getGreen())
            ccg+=(TC.getGreen()-CC.getGreen())/smoothness;
        if(CC.getBlue()!=TC.getBlue())
            ccb+=(TC.getBlue()-CC.getBlue())/smoothness;
        CC = new Color((int)ccr, (int)ccg, (int) ccb);
        System.out.println("Color changed");
        g2.setColor(CC);
        g2.fillRect(0, 0, PREF_W, PREF_H);
        repaint();
    }
    cc = TC;
}

public int giveOneWSign(int num)
{
    if(num<0) return -1;
    return 1;
}

}