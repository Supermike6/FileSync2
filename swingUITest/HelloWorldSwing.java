package swingUITest;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.basic.*;
import javax.swing.*;

import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import Clock.Clock3;


 
public class HelloWorldSwing extends JPanel implements ActionListener{
    protected static JMenuBar menuBar = new JMenuBar();
    protected JToolBar toolBar = new JToolBar();
    protected JColorChooser cc = new JColorChooser();
    protected Clock3 c3 = new Clock3();
    protected int menus = 4, itemsPerMenu = 7;
    protected static JFrame frame;
    protected static JPanel panel;
    // private int PREF_W = Clock3.PREF_W+(new JColorChooser().getPreferredSize().width);
    // private int PREF_H = Clock3.PREF_H+23;
    private int PREF_W = 800;
    private int PREF_H = 600;
    private Dimension currentSize;
    
    protected int num = 0;
    
    public HelloWorldSwing()
    {
        super(new BorderLayout(),true);
        currentSize = getSize();
        menuBar = new JMenuBar();
        
        
        
        for(int i = 1; i<=menus;i++)
        {
            JMenu menu = new JMenu("<html><div style='text-align: center;'>Menu "+i+"</div></html>");

            

            for(int j = 1; j<=itemsPerMenu;j++)
            {
                JMenuItem item = new JMenuItem("Item "+i+"."+j);
                item.setHorizontalAlignment(SwingConstants.RIGHT);
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(menu.getSize());
                        System.out.println(menuBar.getSize());
                    }
                });
                menu.add(item);
            }
            menu.setPreferredSize(new Dimension(200, 23));
            
            menuBar.add(menu);
        }
        


        this.add(menuBar, BorderLayout.NORTH);
        this.add(c3, BorderLayout.WEST);
        this.add(cc, BorderLayout.EAST);
        
        Timer timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                c3.setColorOfClock(cc.getColor());
                doLayout();
            }
         });
   
        timer.start();
        
    } 
    
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGUI() {
        frame = new JFrame("Hello World");
        panel = new HelloWorldSwing();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setResizable(true);
        // System.setProperty("apple.laf.useScreenMenuBar", "true");
        // frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HelloWorldSwing Action Preformed");
    }


    @Override
    public Dimension getSize() {
        return super.getSize();
    }
    
    @Override
    public void doLayout() {
        super.doLayout();
        if (!getSize().equals(currentSize)) {
            currentSize = getSize();
            // Panel size has changed, do something here if needed
        }
    }
    
    public Dimension getCurrentSize() {
        return currentSize;
    }

}
