package swingUITest;
 
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import Clock.Clock3;


 
public class HelloWorldSwing extends JPanel implements ActionListener{
    protected JMenuBar menuBar = new JMenuBar();
    protected JToolBar toolBar = new JToolBar();
    protected Clock3 c3 = new Clock3();
    protected int menus = 4, itemsPerMenu = 10;
    protected static JFrame frame;
    protected static JPanel panel;
    private int PREF_W = Clock3.PREF_W+350;
    private int PREF_H = Clock3.PREF_H+23;
    
    protected int num = 0;
    
    public HelloWorldSwing()
    {
        super(new BorderLayout(),true);

        menuBar = new JMenuBar();
        

        for(int i = 1; i<=menus;i++)
        {
            JMenu menu = new JMenu("Menu "+i);
            menu.setHorizontalAlignment(SwingConstants.CENTER);

            for(int j = 1; j<=itemsPerMenu;j++)
            {
                JMenuItem item = new JMenuItem("Item "+i+"."+j);
                item.setHorizontalAlignment(SwingConstants.CENTER);
                item.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println(menu.getSize());
                        System.out.println(menuBar.getSize());
                    }
                });
                menu.add(item);
            }
            menu.setPreferredSize(new Dimension(PREF_W/menus, 23));
            
            menuBar.add(menu);
        }
        
        this.add(menuBar, BorderLayout.NORTH);
        this.add(new Clock3(), BorderLayout.WEST);
        
        Timer timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                for(int i = 0; i<menus;i++)
                {
                    JMenu menu = (JMenu) menuBar.getMenu(i);
                    menu.setPreferredSize(new Dimension(PREF_W/menus, 23));
                }
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