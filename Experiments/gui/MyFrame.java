//Victor Urumov
//Program description: 
//Nov 28, 2021

package Experiments.gui;

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
   MyPanel panel;
   
   MyFrame(String title)
   {
	  super(title);
	   
      panel = new MyPanel();
      
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.add(panel);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setVisible(true);
   }
   
}
