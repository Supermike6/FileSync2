package fnaf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class fnaf  extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 1600;
   private static final int PREF_H = 900;
   private int frames = 1;
   private int backX = 0;
   private javax.swing.Timer timer;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
   private Font font = new Font("Cooper Black", Font.PLAIN, 25);

   public fnaf()
   {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e)
            {
                repaint();  
            
                if(backX>400) backX=400;
            
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
    frames++;

    g2.setFont(font);
    g2.setColor(Color.RED);
    g2.drawString(frames+"", 50, 50);
    Image backdrop = new ImageIcon(this.getClass().getResource("backdrop.jpg")).getImage();
   
    g2.drawImage(backdrop, 0-backX, 0 , PREF_W,PREF_H, null);
}
   @Override
   public void keyPressed(KeyEvent e)
   {
      int key = e.getKeyCode();
      if(key == KeyEvent.VK_SPACE)
         System.out.println("Pressing Space...");
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
      fnaf gamePanel = new fnaf();
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
public void mouseDragged(MouseEvent e) {
    // TODO Auto-generated method stub
    
}

@Override
public void mouseMoved(MouseEvent e)
{
    System.out.println(e.getX()+", "+e.getY());
    if(e.getX()>1350) backX+=1;
}

@Override
public void mouseClicked(MouseEvent e) {
    // TODO Auto-generated method stub
    
}

@Override
public void mousePressed(MouseEvent e) {
    // TODO Auto-generated method stub
    
}

@Override
public void mouseReleased(MouseEvent e) {
    // TODO Auto-generated method stub
    
}

@Override
public void mouseEntered(MouseEvent e) {
    // TODO Auto-generated method stub
    
}

@Override
public void mouseExited(MouseEvent e) {
    // TODO Auto-generated method stub
    
}
}