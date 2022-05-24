package Experiments.Graphics;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


import java.util.ArrayList;


//Mr. Uhl's Honors Computer Science
//Description: A simple template for constructing a basic JPanel class
//             This can be used to add other panels and buttons
//             or a paintComponent method can be added for painting on the panel
public class BasicPanel extends JPanel
{
   private static final long serialVersionUID = 1L;
   private static final int PREF_W = 500;
   private static final int PREF_H = 500;
   private int rows = 3;
   private int cols = 4;
   private JButton[][] b;
   
   public BasicPanel()
   {
      this.setLayout(new GridLayout(rows,cols));

      b = new JButton[5][5];
      for(int r = 0; r<b.length;r++)
      {
         for(int c = 0; c < b[r].length;c++)
         {
            b[r][c]=new JButton("Click Me");
            b[r][c].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                  System.out.println("("+r+", "+c+")");
               }
            }); 
         }
      }
   }
   
     

   public Dimension getPreferredSize()
   {
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