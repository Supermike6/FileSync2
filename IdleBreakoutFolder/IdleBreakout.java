package IdleBreakoutFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import Classes.Brick;
import Classes.Ball;

public class IdleBreakout extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 750;
    static final int PREF_H = 500;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    boolean debug = false;
    static ArrayList<Brick> balls = new ArrayList<Brick>(1);
    static ArrayList<Brick> bricks = new ArrayList<Brick>(300);
    static int money = 24, level = 0;
    static int bs = 0;
    static int mouseX = 0, mouseY = 0;
    static int clickPower = 1;
    static int fps = 30;
    TopBar tb;
    static boolean render = false;
    int tim = 0;

    // KeyListener keyList = this.getKeyListeners()[0];

    

    public IdleBreakout()
    {
        super(new BorderLayout(),true);
        this.addKeyListener(this);
        this.addMouseListener(this);
		this.addMouseMotionListener(this);
        setFocusable(true);
        requestFocus();

       
        timer = new Timer(1000/60, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                if(tim%1==0)
                    calculatePhysics();
                if(bs==0)
                {
                    bricks = new ArrayList<Brick>(bs);
                    level++;
                    for(int j = 0; j<20;j++)
                        for(int i = 0; i<15;i++)
                        {
                            bs++;
                            bricks.add(new Brick(i*(PREF_W/15), j * (PREF_H/20), (PREF_W/15), (PREF_H/20), 0, 0, 0, 0, 0, 0, getBrickColor(level), level, 0));
                        }
                }
                repaint();
                TopBar.correctValues(money, level);
                tim++;
            }
        });
        timer.start();
    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);

        if(render)
        {
            g2.setColor(new Color(243,239,217));
            g2.fillRect(0, 0, PREF_W, PREF_H);
            g2.setStroke(new BasicStroke(3));

            for(int i = 0; i<balls.size();i++)
                balls.get(i).fillOval(g2);
            for(int i = 0; i<bricks.size(); i++)
            { 
                if(bricks.get(i).getHealth()>0)
                {
                    bricks.get(i).setColor(getBrickColor(bricks.get(i).getHealth()));
                    bricks.get(i).fill(g2);
                    bricks.get(i).setColor(Color.black);
                    bricks.get(i).draw(g2);
                    g2.setColor(Color.BLACK);
                    FontMetrics fm = g2.getFontMetrics(); 
                    int messageWidth = fm.stringWidth(bricks.get(i).getHealth()+"");
                    int startX = bricks.get(i).getX() + bricks.get(i).getW()/2 - messageWidth/2;
                    g2.drawString(bricks.get(i).getHealth()+"", startX, (int) (bricks.get(i).getY()+bricks.get(i).getH()/1.7));
                }
            }
            if(debug)
            {
                g2.setColor(Color.BLACK);
                g2.drawString(mouseX+", "+mouseY, mouseX, mouseY);
                clickPower = Short.MAX_VALUE;

                for(int j = 0; j<balls.size();j++){
                    //Plasma ball debug
                    if(balls.get(j).getEnum()==2){
                        g2.setColor(Color.RED);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2,4,4);
                        g2.drawRect(-2+balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, -2+balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2,4,4);
                    }
                }
            }

        } else {
            g2.drawString("No Render",10, 20);
        }

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
        IdleBreakout gamePanel = new IdleBreakout();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }
    
    public Dimension getPreferredSize()
    {
        return new Dimension(PREF_W, PREF_H);
    }
   
    private void calculatePhysics()
    {
        for(int i = 0; i<balls.size();i++)
        {
                balls.get(i).update();
        }

        for(int i = 0; i<bricks.size();i++)
        {
            for(int j = 0; j<balls.size();j++){

                if(balls.get(j).checkAndReactToCollisionWith(bricks.get(i)))
                {
                    if(bricks.get(i).getHealth()>0)
                        if(bricks.get(i).getHealth()<balls.get(j).getBallPower())
                        {
                            money+=bricks.get(i).getHealth();
                        } else {
                            money+=balls.get(j).getBallPower();
                        }


                    if(balls.get(j).getEnum() == 1) //Standard ball
                    {
                        bricks.get(i).setHealth(bricks.get(i).getHealth()-1);
                    }
                    if(balls.get(j).getEnum() == 2) //Plasma ball 
                    {
                        bricks.get(i).setHealth(bricks.get(i).getHealth()-balls.get(j).getBallPower());
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2-bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2+bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                        findAndDamageBox(balls.get(j).getX()+balls.get(j).getW()/2+bricks.get(0).getW()/2, balls.get(j).getY()+balls.get(j).getH()/2-bricks.get(0).getW()/2, balls.get(j).getBallPower()/4);
                    }
                    
                }
            }
            if(bricks.get(i).getHealth()<=0)
            {
                bricks.remove(i);
                bs--;
            }

        }
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_SPACE)
        {
            debug = !debug;
        }
        if(key == KeyEvent.VK_BACK_SPACE)
        {
            bs = 0;
        }
        if(key == KeyEvent.VK_A)
        {
            balls.add(new Brick(PREF_W/2-9, PREF_H/2-9, 18, 18, (int)(Math.random()*6)-3, (int)(Math.random()*6)-3, 0, PREF_W, 0, PREF_H, Color.YELLOW,3,(int)(Math.random()*2)+1,4));
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
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
        findAndDamageBox(e.getX(), e.getY(),clickPower);
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override 
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public Color getBrickColor(int health)
    {
        if(health<1)
            return new Color(243,239,217);
        int index = (health%9);
        Color[] colors = { new Color(177, 253, 112),new Color(123,210,251), new Color(219,96,247), new Color(239,136,96), new Color(254,255,115), new Color(138,252,179), new Color(96, 141, 234), new Color(235, 98, 177), new Color(236,98,92)};
        return colors[index];
    }

    public int getSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }

    private void findAndDamageBox(int x, int y, int damageAmount)
    {
        for(int i = 0; i<bricks.size();i++){
            if((x>bricks.get(i).getX() && x<bricks.get(i).getX()+bricks.get(i).getW()) && (y>bricks.get(i).getY() && y<bricks.get(i).getY()+bricks.get(i).getH()))
            {
                if(bricks.get(i).getHealth()>0)
                    money+=damageAmount;
                bricks.get(i).setHealth(bricks.get(i).getHealth()-damageAmount);
            }
        }
    }
    public static void setRender(boolean val)
    {
        render = val;
    }

}