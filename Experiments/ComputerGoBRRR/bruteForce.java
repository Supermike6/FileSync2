package Experiments.ComputerGoBRRR;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class bruteForce extends JPanel
{
    private static final long serialVersionUID = 1L;
    public static final int PREF_W = 200;
    public static final int PREF_H = 100;
    
    public File points = new File("Experiments/ComputerGoBRRR/output.txt");
    static Scanner sc = new Scanner(System.in);
    public static FileWriter fw = null;
	public static BufferedWriter bw = null;
	public static PrintWriter pw = null;
    static String passwd = "";
    static String guess = "";
    static ArrayList<Integer> nums = new ArrayList<>(1);
    static ArrayList<String> tries = new ArrayList<>(1);
    static int temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0, temp5 = 0, temp6 = 0, temp7 = 0, temp8 = 0, temp9 = 0, temp10 = 0, temp11 = 0;
    static int cycles = 0;
    static boolean done = false;

    public bruteForce()
    {
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawString(temp1+"", 20, 50);
    }

   public Dimension getPreferredSize()
   {
      return new Dimension(PREF_W, PREF_H);
   }
   
   public static void createAndShowGUI()
   {
      JFrame frame = new JFrame("Stuff");
      JPanel gamePanel = new bruteForce();
      
      frame.getContentPane().add(gamePanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
    public static void main(String[] args) throws IOException
    {
        System.out.print("Password Length : ");
        int passwdLength = Integer.parseInt(sc.next());

        for(int i = 0;i<passwdLength;i++)
            passwd+=(char)((int)(Math.random()*94+32));
        
            fw = new FileWriter("Experiments/ComputerGoBRRR/output.txt", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            
        System.out.println(passwd);
        pw.println(passwd);
        pw.flush();
        System.out.println("Data Successfully added to file");

        Double startTime = System.currentTimeMillis()+0.0;
        Double endTime;
        
        for(temp11 = 0; temp11<95;temp11++)
        for(temp10 = 0; temp10<95;temp10++)
        for(temp9 = 0; temp9<95;temp9++)
        for(temp8 = 0; temp8<95;temp8++)
        for(temp7 = 0; temp7<95;temp7++)
        for(temp6 = 0; temp6<95;temp6++)
        for(temp5 = 0; temp5<95;temp5++)
        for(temp4 = 0; temp4<95;temp4++)
        for(temp3 = 0; temp3<95;temp3++)
        for(temp2 = 0; temp2<95;temp2++)
        for(temp1 = 0; temp1<95;temp1++)
        {
            guess=(char)(temp11+32)+""+(char)(temp10+32)+""+(char)(temp9+32)+""+(char)(temp8+32)+""+(char)(temp7+32)+""+(char)(temp6+32)+""+(char)(temp5+32)+""+(char)(temp4+32)+""+(char)(temp3+32)+""+(char)(temp2+32)+""+(char)(temp1+32);
            cycles++;
            if(passwd.equals(guess.strip()))
            {
                System.out.println("Runs: "+cycles);
                endTime = System.currentTimeMillis()+0.0;
                Double timeneeded = (endTime - startTime);
                System.out.println("Time taken(s): "+timeneeded/1000);
                String s = "LLLLLLLLLLLLL";
                // SwingUtilities.invokeLater(new Runnable() {
                //     public void run() {
                //        createAndShowGUI();
                //     }
                // });

                while(true)s+=s;
            }
        }
    
        
    
    }
}