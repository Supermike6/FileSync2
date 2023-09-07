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
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

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

public class IdleBreakout extends JPanel implements KeyListener, MouseListener, MouseMotionListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 750;
    static final int PREF_H = 500;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    boolean debug = false;
    static ArrayList<Brick> balls = new ArrayList<Brick>(1);
    public static ArrayList<Brick> bricks = new ArrayList<Brick>(300);
    static int money = 0, level = 0;
    static int mouseX = 0, mouseY = 0;
    public static int clickPower = 1;
    static int fps = 30;
    TopBar tb;
    static boolean render = true;

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
                regenerateBricks();
                calculatePhysics();
                regenerateBricks();
                repaint();
                TopBar.correctValues(money, level);
                money = 0;
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
        
        // try {
        //     Font f = Font.createFont(Font.TRUETYPE_FONT, new File("Seven Segment.ttf")).deriveFont(Font.BOLD, 20);
        //     g2.setFont(f);
        // } catch (FontFormatException | IOException e) {
        //     e.printStackTrace();
        // }

        if(!render)
        {
            g2.drawString("No Render",10, 20);
        } else {
            g2.setColor(new Color(243,239,217));
            g2.fillRect(0, 0, PREF_W, PREF_H);
            g2.setStroke(new BasicStroke(2));

            for(int i = 0; i<balls.size();i++)
            {
                if(balls.get(i).getEnum()==1)
                { 
                    g2.setColor(Color.YELLOW);
                    g2.fillOval(balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getW(),balls.get(i).getH());
                    g2.setColor(Color.BLACK);
                    g2.drawOval(balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getW(),balls.get(i).getH());
                }


                if(balls.get(i).getEnum()==2)
                { 
                    g2.setColor(Color.MAGENTA);
                    g2.fillOval(balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getW(),balls.get(i).getH());
                    g2.setColor(Color.BLACK);
                    g2.drawOval(balls.get(i).getX(), balls.get(i).getY(), balls.get(i).getW(),balls.get(i).getH());
                }

                if(balls.get(i).getEnum()==3)
                { 
                    g2.setColor(Color.WHITE);
                    g2.fillOval(balls.get(i).getX()+balls.get(i).getW()/2-9, balls.get(i).getY()+balls.get(i).getH()/2-9, 18, 18);
                    g2.setColor(Color.BLACK);
                    g2.drawOval(balls.get(i).getX()+balls.get(i).getW()/2-9, balls.get(i).getY()+balls.get(i).getH()/2-9, 18, 18);
                    g2.setStroke(new BasicStroke(2));
                    g2.drawLine((int)(balls.get(i).getX()+balls.get(i).getW()/2-5), (int)(balls.get(i).getY()+balls.get(i).getH()/2), (int)(balls.get(i).getX()+balls.get(i).getW()/2+5), (int)(balls.get(i).getY()+balls.get(i).getH()/2));
                    g2.drawLine((int)(balls.get(i).getX()+balls.get(i).getW()/2), (int)(balls.get(i).getY()+balls.get(i).getH()/2-5), (int)(balls.get(i).getX()+balls.get(i).getW()/2), (int)(balls.get(i).getY()+balls.get(i).getH()/2+5));
                }
                
            }
               
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
                    g2.drawString(bricks.get(i).getHealth()+"", startX, (int) (bricks.get(i).getY()+20));
                } else {
                    bricks.get(i).setColor(Color.BLACK);
                    bricks.get(i).fill(g2);
                }
            }
            g2.drawLine(mouseX-6, mouseY+6, mouseX+6, mouseY-6);
            g2.drawLine(mouseX-6, mouseY-6, mouseX+6, mouseY+6);
            if(debug)
            {
                g2.setColor(Color.BLACK);

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
                    //Sniper ball debug
                    if(balls.get(j).getEnum()==3)
                    { 
                        g2.setColor(Color.RED);
                        g2.fillRect(balls.get(j).findClosestBrick(IdleBreakout.bricks).getX(), balls.get(j).findClosestBrick(IdleBreakout.bricks).getY(), balls.get(j).findClosestBrick(IdleBreakout.bricks).getW(), balls.get(j).findClosestBrick(IdleBreakout.bricks).getH());
                    }
                }

            }
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
            if(balls.get(i).getEnum() == 3)
            {
                balls.get(i).sniperUpdate();
            } else {
                balls.get(i).update();
            }
        }
        int i = 0;
        while(i<bricks.size())
        {
            for(int j = 0; j<balls.size();j++){

                if(balls.get(j).checkAndReactToCollisionWith(bricks.get(i)))
                {
                    if(balls.get(j).getBallPower()>bricks.get(i).getHealth())
                    {
                        money+=bricks.get(i).getHealth();
                    } else {
                        money+=balls.get(j).getBallPower();
                    }


                    if(balls.get(j).getEnum() == 1 || balls.get(j).getEnum() == 3) //Standard ball
                    {
                        bricks.get(i).setHealth(bricks.get(i).getHealth()-balls.get(j).getBallPower());
                        
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
                        if(i!=0)
                            i--;
                    }
                }
            }
            if(bricks.get(i).getHealth()<=0)
            {
                bricks.remove(i);
            } else {
                i++;
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
            bricks.clear();
            regenerateBricks();
        }
        if(key == KeyEvent.VK_1)
        {
            spawnBall(1);
        }
        if(key == KeyEvent.VK_2)
        {
            spawnBall(2);
        }
        if(key == KeyEvent.VK_3)
        {
            spawnBall(3);
        }
        if(key == KeyEvent.VK_4)
        {
            spawnBall(4);
        }
        if(key == KeyEvent.VK_5)
        {
            spawnBall(5);
        }
        if(key == KeyEvent.VK_6)
        {
            spawnBall(6);
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
        if(debug)
            findAndDamageBox(mouseX, money, clickPower);
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

    public static Color getBrickColor(int health)
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
        int i = 0;
        while(i<bricks.size()){
            if((x>bricks.get(i).getX() && x<bricks.get(i).getX()+bricks.get(i).getW()) && (y>bricks.get(i).getY() && y<bricks.get(i).getY()+bricks.get(i).getH()))
            {
                if(bricks.get(i).getHealth()>0)
                {
                    if(bricks.get(i).getHealth()<damageAmount)
                    {
                        money+=bricks.get(i).getHealth();
                    } else {
                        money+=damageAmount;
                    }
                }
                bricks.get(i).setHealth(bricks.get(i).getHealth()-damageAmount);
                if(bricks.get(i).getHealth()<=0)
                {
                    bricks.remove(i);
                    if(i!=0)
                        i--;
                }
            }
            i++;
        }
    }
    public static void setRender(boolean val)
    {
        render = val;
    }
    public static void spawnBall(int i)
    {
        if(i == 1)
            balls.add(new Brick(PREF_W/2-9, PREF_H/2-9, 18, 18, -1, -1, 0, PREF_W, 0, PREF_H, Color.YELLOW,3,1,1));
        if(i == 2)
            balls.add(new Brick(PREF_W/2-9, PREF_H/2-9, 18, 18, 1, -1, 0, PREF_W, 0, PREF_H, Color.MAGENTA,3,2,4));
        if(i == 3)
            balls.add(new Brick(PREF_W/2-9, PREF_H/2-9, 18, 18, -5, 5, 0, PREF_W, 0, PREF_H, Color.WHITE,3,3,4));
        if(i == 7)
            clickPower+=1;
    }
    public static void regenerateBricks()
    {
        if(bricks.size()==0)
        {
            level++;
            for(int a = 0; a<2; a++)
                for(int b = 0; b<2; b++)
                    for(int j = 0; j<6;j++)
                        for(int i = 0; i<5;i++)
                        {
                            bricks.add(new Brick(75+i*50 + a*7*(PREF_W/15), 50+j*25 + b*9*(PREF_H/20), (PREF_W/15), (PREF_H/20), 0, 0, 0, 0, 0, 0, getBrickColor(level), level, 0));
                        }
        }
    }
}