package IdleBreakoutFolder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Launcher extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 600;
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    IdleBreakout ib = new IdleBreakout();
    TopBar tb = new TopBar();

    public Launcher()
    {
        super(new BorderLayout(),true);
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();

        this.add(ib, BorderLayout.CENTER);
        this.add(tb, BorderLayout.NORTH); 
        this.add(new LeftBar(), BorderLayout.WEST);
        this.add(new RightBar(), BorderLayout.EAST);
        this.add(new BottomBar(), BorderLayout.SOUTH);


    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);

    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        ib.keyPressed(e);
        if(e.getKeyCode()==KeyEvent.VK_E)
        {

        }
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        ib.keyReleased(e);
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        ib.keyTyped(e);
    }
    
    public static void main(String[] args)
    {
        // System.setProperty("sun.java2d.opengl", "true");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        Launcher gamePanel = new Launcher();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false); 
    }
    public int getSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }
    public Dimension getPreferredSize()
    {
        return new Dimension(PREF_W, PREF_H);
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }


    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

}