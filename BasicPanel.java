import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

//Mr. Uhl's Honors Computer Science
//Description: A simple template for constructing a basic JPanel class
//             This can be used to add other panels and buttons
//             or a paintComponent method can be added for painting on the panel

public class BasicPanel extends JPanel
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 500;
   private static final int PREF_H = 500;

   public BasicPanel()
   {

   }
   public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      // draw a tictactoe board
      int w = getWidth();
      int h = getHeight();

      // draw a grid
      g2.setColor(Color.BLACK);
      g2.drawLine(w/3, 0, w/3, h);
      g2.drawLine(w*2/3, 0, w*2/3, h);
      g2.drawLine(0, h/3, w, h/3);
      g2.drawLine(0, h*2/3, w, h*2/3);
      repaint();
   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Frame Title");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new BasicPanel());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}