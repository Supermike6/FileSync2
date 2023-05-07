package swingUITest;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import Clock.Clock3;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



 
public class Drawing extends JPanel implements ActionListener{
    protected JMenuBar menuBar = new JMenuBar();
    protected Clock3 c3 = new Clock3();
    protected int menus = 4, itemsPerMenu = 10;
    private int PREF_W = Clock3.PREF_W*3;
    private int PREF_H = Clock3.PREF_H+23;
    
    protected int num = 0;
    
    public Drawing()
    {
        super(new BorderLayout(),true);
       
        
        JMenu menu = new JMenu("File");
        
        JMenuItem item = new JMenuItem("Save");
        
        menu.add(item);
        
        menu.setPreferredSize(new Dimension(PREF_W/menus, 23));
        
        menuBar.add(menu);
        

        this.add(menuBar, BorderLayout.NORTH);
        this.add(new Clock3(), BorderLayout.WEST);
        this.add(new Clock3(), BorderLayout.EAST);

    } 
    
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Hello World");
        JPanel panel = new Drawing();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);

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
}