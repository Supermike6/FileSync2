package Games;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//Mr. Uhl's Honors Computer Science
//Description: A simple template for constructing a basic JPanel class
//             This can be used to add other panels and buttons
//             or a paintComponent method can be added for painting on the panel
public class tictactoe extends JPanel
{
   private JPanel other;
   private JPanel game;
   private static final long serialVersionUID = 1L;
   private static int rows = 3;
   private static int cols = 3;
   private static final int PREF_W = cols*102;
   private static final int PREF_H = rows*102;
   private int r = 0;
   private int c = 0;
   private int j = 0;
   private JButton[][] b;
   private boolean player = true; //true = X, false = O

   public tictactoe()
   {
      this.setBackground(Color.blue);
      
      game = new JPanel(new GridLayout(rows,cols,2,2))
      {
         @Override
         public Dimension getPreferredSize() {
            return new Dimension(PREF_W, PREF_H);
         }
      };

      other = new JPanel(new GridLayout(1, 3, 2, 0))
      {
         @Override
         public Dimension getPreferredSize() {
            return new Dimension(PREF_W, 25);
         }
      };

      this.setLayout(new BorderLayout());
      this.add(game, BorderLayout.CENTER);
      this.add(other, BorderLayout.SOUTH);
      JButton restart = new JButton("Restart");
      restart.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e)
         {
            j=0;
            reset();
         }
      }); 
      other.add(restart);
      

      b = new JButton[rows][cols];
      for(r = 0; r<b.length;r++)
      {
         for(c = 0; c < b[r].length;c++)
         {
            int rows = r;
            int cols = c;
            b[r][c]=new JButton();
            b[r][c].setOpaque(true);
            b[r][c].setBorderPainted(false);
            b[r][c].setText((char)((int)(Math.random()*r*c))+"");
            b[r][c].addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e)
               {
                  if(b[rows][cols].getText().equals(""))
                  {
                     if(player)
                  {
                     b[rows][cols].setText("X");
                     b[rows][cols].setBackground(Color.red);
                     b[rows][cols].setForeground(Color.white);
                     player = false;
                     j++;
                  }
                  else
                  {
                     b[rows][cols].setText("O");
                     b[rows][cols].setBackground(Color.blue);
                     b[rows][cols].setForeground(Color.white);
                     player = true;
                     j++;
                  }
                     j++;
                     if(j==9)
                     {
                        JOptionPane.showMessageDialog(null, "Tie!");
                        reset();
                     }
                     // else if(checkWin())
                     // {
                     //    JOptionPane.showMessageDialog(null, "Player "+(player?"X":"O")+" wins!");
                     //    // reset();*
                     // }
                  }
                  
                  
               }

               
            }); 

            game.add(b[r][c]);
         }
      }
      reset();
   }
   // private boolean checkWin() //return true if X wins and true if O wins
   // {
      
   // }

   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Frame Title");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new tictactoe());
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

   // private void switchLight(int r, int c)
   // {
   //    if(b[r][c].getBackground().equals(Color.red))
   //    {
   //       b[r][c].setBackground(new Color(238,238,238));
   //    } else {
   //       b[r][c].setBackground(Color.red);
   //    }
      
   // }
   // private void makeMove(int r, int c)
   // {
   //    switchLight(r, c);//clicked light
   // }
   public void reset()
   {
      for(r = 0; r<b.length;r++)
      {
         for(c = 0; c < b[r].length;c++)
         {
            b[r][c].setBackground(new Color(238,238,238));
            b[r][c].setText("");
         }
      }
   }
}