package IdleBreakoutFolder;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class TopBar extends JPanel implements MouseListener, MouseMotionListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 75;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    JButton button = new JButton("Hover over me!");
    private static int numBasic = 0;
    private static int numPlasma = 0;
    private static int numSniper = 0;
    private static int numScatter = 0;
    private static int numCanon = 0;
    private static int numVirus = 0;
    private static int ballsAllowed = 50;
    private static int myLevel = 1;
    private static int myMoney = 24;
    private static boolean render = true;
    private static Rectangle toggleRenderBox = new Rectangle(740,5,50,25);
    private static int mouseX = 0, mouseY = 0;


    int num = 0;
    public TopBar() 
    {
        this.setLayout(new GridLayout());
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setFocusable(true);
        requestFocus(); 

        // this.add(button);
        // this.add(new JButton("2"));
        // this.add(new JButton("3"));
        // this.add(new JButton("4"));
        // this.add(new JButton("5"));
        // this.add(new JButton("6"));
        // this.add(new JButton("7"));
        // this.add(new JButton("8"));
    }
   
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(0, 0, PREF_W, PREF_H);

        g2.setStroke(new BasicStroke(2));

        num++;
        button.setToolTipText("<html>This is a<br>m<b>ultil</b>ine<br>tooltip<br>"+num+"<html>");

        g2.setColor(Color.BLACK);
        g2.drawString("Money: "+myMoney+", Level: "+myLevel, 10, 20);

        //Render bricks and balls?
        if(render)
        {
            g2.setColor(Color.WHITE);
            g2.fill(toggleRenderBox);
            IdleBreakout.setRender(render);
        } else {
            g2.setColor(Color.RED);
            g2.fill(toggleRenderBox);
            IdleBreakout.setRender(render);
        }


        repaint();
    }
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    private static void createAndShowGUI() {
        TopBar gamePanel = new TopBar();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
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
    public static void correctValues(int money, int level)
    {
        myMoney = money;
        myLevel = level;
    }

    private void clickRegion(int x, int y, Rectangle rect)
    {
        //toggle render
        if((x>rect.getX() && x<rect.getX()+rect.getWidth()) && (y>rect.getY() && y<rect.getY()+rect.getHeight()))
        {
            IdleBreakout.setRender(render);
            render = !render;
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mousePressed(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        clickRegion(mouseX, mouseY, toggleRenderBox);
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }


    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }
}