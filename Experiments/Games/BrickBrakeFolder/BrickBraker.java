package BrickBrakeFolder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
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



import Experiments.Classes.Brick;

public class BrickBraker extends JPanel implements KeyListener
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 1000;
    static final int PREF_H = 700;
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Timer timer;
    int playerSpeed = 7, ballSpeed = 4, level = 0, score = 0, lives = 3, bs = 0;
    double angle = 0, aangle;
    boolean debug, bot,p=true,og;
    Color prevColor;
    Clip colide;
    String state = "start";
    String message = "Press Space to Play";
    Brick ball = new Brick(PREF_W/2, PREF_H/2-300, 20, 20, ballSpeed, ballSpeed, 0, PREF_W, 0, PREF_H, Color.WHITE);
    Brick player = new Brick(PREF_W/2, 660, 80, 21, 0, 0, 0, PREF_W, 0, PREF_H-30, Color.CYAN);
    ArrayList<Brick> bricks = new ArrayList<Brick>(bs);
    Image sky = new ImageIcon(this.getClass().getResource("sky.gif")).getImage();
    Image Sky = new ImageIcon(this.getClass().getResource("skyFrozen.png")).getImage();
    Image a1 = new ImageIcon(this.getClass().getResource("asteroid.png")).getImage();
    Image a2 = new ImageIcon(this.getClass().getResource("asteroid2.png")).getImage();
    Image rocket = new ImageIcon(this.getClass().getResource("rocket.png")).getImage();
    Image satelite = new ImageIcon(this.getClass().getResource("satelite.png")).getImage();

    public BrickBraker()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();

        try {
            System.out.println("Audio making");
            URL file = this.getClass().getResource("ex-fl-2.wav");
            AudioInputStream audio = AudioSystem.getAudioInputStream(file);
            colide = AudioSystem.getClip();
            colide.open(audio);
            System.out.println("Audio made");
        } catch (Exception e) {
            System.out.println("Audio failed");
            e.printStackTrace();
        }

        og = false;

        player.setX(PREF_W/2-player.getW()/2);
        ball.setY(player.getY()-ball.getH());
        ball.setYmax(PREF_H+ball.getH()+10000);

      
        timer = new Timer(16, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                player.noBounceUpdate();
                ball.update();
                ball.checkAndReactToCollisionWith(player);
                aangle++;
                aangle=aangle%360;
                
                
                if(state.equals("start"))
                {
                    ball.setX(player.getX()+player.getW()/2-ball.getW()/2);
                    ball.setY(player.getY()-ball.getH());
                    angle=0;
                    message = "Press Space to Play";
                    if(lives==0)
                    message = "Game Over, Press Space to Play";
                }
                if(state.equals("playing"))
                {
                    og = true;
                    if(getSign(ball.getDx())==1&&getSign(ball.getDy())==-1){angle = 45;}
                    if(getSign(ball.getDx())==-1&&getSign(ball.getDy())==-1){angle = 315;}
                    if(getSign(ball.getDx())==-1&&getSign(ball.getDy())==1){angle = 225;}
                    if(getSign(ball.getDx())==1&&getSign(ball.getDy())==1){angle = 135;}
                    message = "";
                }
                if(ball.getY()>PREF_H)
                {
                    state = "game over";
                }
                if(state.equals("game over"))
                {
                    lives--;
                    if(lives==0)
                    message = "Game Over, Press Space to Play";
                    state = "start";
                }

                System.out.println(state);

                for(int i = 0; i<bricks.size();i++)
                {
                    if(ball.checkAndReactToCollisionWith(bricks.get(i)))
                    {
                        bricks.get(i).setHealth(bricks.get(i).getHealth()-1);
                        colide.flush();
                        colide.setFramePosition(0);
                        colide.start();
                    }

                    if(bricks.get(i).getHealth()==0)
                    {
                        score++;
                        bricks.remove(i);
                        bs--;
                    }
                }

                if(bs==0)
                {
                    bricks = new ArrayList<Brick>(bs);
                    level++;
                    for(int j = 0; j<level;j++)
                        for(int i = 0; i<18;i++)
                        {
                            
                            bs++;
                            bricks.add(i, new Brick(PREF_W/20+i*(PREF_W/20), 50+j*50, (PREF_W/20), 50, new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)), (int)(Math.random()*level+1),(int)(Math.random()*2)));
                        }
                }
                if(bot)
                {
                    player.setX(ball.getX());
                }

                repaint();
            }
        });
        timer.start();
    }
   
    public Dimension getPreferredSize()
    {
        return new Dimension(PREF_W, PREF_H);
    }
   
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        g2.setBackground(Color.WHITE);

        g2.drawImage(Sky, 0, 0, PREF_W, PREF_H, this);
        g2.drawImage(sky, 0, 0, PREF_W, PREF_H, this);

        for(int i = 0; i<bricks.size();i++)
        {
            if(bricks.get(i).getEnum()>0.5)
            {
                g2.drawImage(a1, bricks.get(i).getX(), bricks.get(i).getY(), bricks.get(i).getW(), bricks.get(i).getH(), null);
            } else {
                g2.drawImage(a2, bricks.get(i).getX(), bricks.get(i).getY(), bricks.get(i).getW(), bricks.get(i).getH(), null);
            }
            g2.setColor(Color.WHITE);
            FontMetrics fm = g2.getFontMetrics(); 
            int messageWidth = fm.stringWidth(bricks.get(i).getHealth()+"");
            int startX = bricks.get(i).getX() + bricks.get(i).getW()/2 - messageWidth/2;
            g2.drawString(bricks.get(i).getHealth()+"", startX, (int) (bricks.get(i).getY()+bricks.get(i).getH()/1.7));
            
            if(debug)
            {
                Color c = player.getColor();
                bricks.get(i).setColor(Color.WHITE);
                bricks.get(i).draw(g2);
                player.setColor(c);
            }
        }

        g2.setColor(Color.WHITE);
        
        g2.drawImage(satelite, player.getX(), player.getY()-11, player.getW(), player.getH(), null);
        
        g2.rotate(Math.toRadians(angle), ball.getX()+ball.getW()/2, ball.getY()+ball.getH()/2);
        g2.drawImage(rocket, ball.getX(), ball.getY(), ball.getW(), ball.getH(), null);
        g2.rotate(-Math.toRadians(angle), ball.getX()+ball.getW()/2, ball.getY()+ball.getH()/2);
        
        g2.setColor(Color.WHITE);
        if(debug)
        {
            ball.draw(g2);
            player.setColor(Color.WHITE);
            // player.draw(g2);
            // player.setColor(c);
            g2.drawString(ball.getDx()+", "+ball.getDy()+", "+Math.tan(ball.getY()/ball.getX()), 50, 50);
        }
        g2.setFont(new Font("Minecraft", Font.PLAIN, 32));

        if(og)
        {
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString("Score: "+score, 20, PREF_H-20);
            int messageWidth1 = fm.stringWidth("Lives: "+lives);
            g2.drawString("Lives: "+lives, PREF_W-20-messageWidth1, PREF_H-20);
        }

        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = fm.stringWidth(message);
        int startX = getWidth()/2 - messageWidth/2;
        g2.drawString(message, startX, getHeight()/2);
    
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
      
        if(key == KeyEvent.VK_SPACE)
        {
            if(state.equals("start"))
            {
                if(lives==0)
                {
                    level = 0;
                    score = 0;
                    player.setX(PREF_W/2-player.getW()/2);
                    ball.setX(player.getX()+player.getW()/2-ball.getW()/2);
                    ball.setY(player.getY()-ball.getH());
                    angle=0;
                    bs=0;
                    lives=3;
                } 
                state = "playing";
            }
        }

        if(key == KeyEvent.VK_P)
        {
            p = !p;
        }
        if(key == KeyEvent.VK_A)
        {
            player.setDx(-playerSpeed);
        }
        if(key == KeyEvent.VK_D)
        {
            player.setDx(playerSpeed);
        }
        if(key == KeyEvent.VK_UP)
        {
            timer.setDelay(1);
        }
        if(key == KeyEvent.VK_DOWN)
        {
            timer.setDelay(20);
        }
        if(key == KeyEvent.VK_F)
        {
            debug = !debug;
        }
        if(key == KeyEvent.VK_B)
        {
            bot = !bot;
        }
    
        if(!p)
        {
            timer.stop();
            repaint();
        }

        if(p)
        {
            timer.start();
            repaint();
        }
    
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        if(key == KeyEvent.VK_A)
        {
            player.setDx(0);
        }
        if(key == KeyEvent.VK_D)
        {
            player.setDx(0);
        }
        if(key == KeyEvent.VK_UP)
        {
            timer.setDelay(10);
        }
        if(key == KeyEvent.VK_DOWN)
        {
            timer.setDelay(10);
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
   
    private static void createAndShowGUI() {
        BrickBraker gamePanel = new BrickBraker();
        JFrame frame = new JFrame("Breakout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    

    public int getSign(int num)
    {
        if(num<0) return -1;
        return 1;

    }
}