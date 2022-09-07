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

public class BasicPanelCopy extends JPanel
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 800;
   private static final int PREF_H = 600;

   public BasicPanelCopy()
   {

   }
   public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      g2.drawOval((int)(Math.random()*PREF_W)+1, (int)(Math.random()*(PREF_H/2)+(PREF_H/2))+1, 5, 5);


   }
   
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Frame Title");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new BasicPanelCopy());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args)
   {
      for(int i = 0; i<20;i++)
      {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
   }
}