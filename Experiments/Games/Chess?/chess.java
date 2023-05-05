

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


//Mr. Uhl's Honors Computer Science
//Description: A simple template for constructing a basic JPanel class
//             This can be used to add other panels and buttons
//             or a paintComponent method can be added for painting on the panel
public class chess extends JPanel
{
   private JPanel other;
   private JPanel game;
   private static final long serialVersionUID = 1L;
   private static int rows = 8;
   private static int cols = 8;
   private static final int PREF_W = cols*70;
   private static final int PREF_H = rows*70;
   private int r = 0;
   private int c = 0;
   private int j = 0;
   
   private static int ranMove = 10;
   private JButton[][] b;

   public chess()
   {
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
            makeBoard();
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
            System.out.println(r+", "+c);
            b[r][c].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    System.out.println(((char)(97+cols))+""+(8-rows));
                    System.out.println(rows+", "+cols);
                }
            }); 
                game.add(b[r][c]);
            }
        }
        makeBoard();
    }

    public static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Frame Title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new chess());
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
    private void makeMove(int r, int c)
    {
      
    }
    public void makeBoard()
    {
        for(int r = 0; r < rows; r++)
        {
            for(int c = 0; c < cols; c++)
            {
                b[r][c].setBackground(new Color(238,238,238));
                if((r*9+c)%2==1)
                    b[r][c].setBackground(Color.DARK_GRAY);
            }
        }
        for(int r = 1; r<8; r+=8)
            for(int c = 0; c<8; c++)
                b[r][c].setIcon(new ImageIcon("Experiments/Games/Chess?/PieceImages/bp.png"));
        for(int r = 6; r<8; r+=8)
            for(int c = 0; c<8; c++)
                b[r][c].setIcon(new ImageIcon("Experiments/Games/Chess?/PieceImages/wp.png"));
        for(int r = 0; r<8; r+=7)
            for(int c = 0; c<8; c+=7)
                b[r][c].setIcon(new ImageIcon("Experiments/Games/Chess?/PieceImages/br.png"));
        for(int r = 7; r<8; r+=7)
            for(int c = 0; c<8; c+=7)
                b[r][c].setIcon(new ImageIcon("Experiments/Games/Chess?/PieceImages/wr.png"));
    }
}