package Adam;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class adumGraphics extends JPanel implements KeyListener
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   public static int count = 0;
   public static int num = 0;
   public boolean done = false;
   private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

   public adumGraphics()
   {
      addKeyListener(this);
      setFocusable(true);
      requestFocus();
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   @Override
   public void paintComponent(Graphics g)
   {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHints(hints);
      if(done){
      g2.setColor(Color.cyan);
      g2.fillRect(0,0,255,255);
      }

      g2.setColor(Color.black);
      num = (int) (Math.random()*4000);
      g2.drawString(num+"", 50, 50);
      g2.drawString(count+"", 50, 100);
      count++;
      if(num!=20&& !done)
      {repaint();} else {done = true;}
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
   }

   @Override
   public void keyReleased(KeyEvent e){}

   @Override
   public void keyTyped(KeyEvent e){}

   private static void createAndShowGUI() {
      adumGraphics gamePanel = new adumGraphics();
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
            for(int i  = 0; i<10; i++)
            createAndShowGUI();
         }
      });
   }
}