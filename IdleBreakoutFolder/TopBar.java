package IdleBreakoutFolder;





import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.*;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Classes.Brick;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class TopBar extends JPanel implements MouseListener, MouseMotionListener 
{
    static final long serialVersionUID = 1L;
    static final int PREF_W = 800;
    static final int PREF_H = 75;
   
    RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private static int numBasic = 0;
    private static int numPlasma = 0;
    private static int numSniper = 0;
    private static int numScatter = 0;
    private static int numCanon = 0;
    private static int numVirus = 0;
    private static int ballsAllowed = 1000;
    private static int myLevel = 1;
    private static int myMoney = 24;
    private static boolean render = true;
    private static Rectangle toggleRenderBox = new Rectangle(740,18,50,25);
    private static Rectangle moneyOuterBox = new Rectangle(610,18,125,25);
    private static Rectangle moneyInnerBox = new Rectangle(613+25,21,119-25,19);
    private static Rectangle buyBasicBox = new Rectangle(10,5,50,50);
    private static Rectangle buyPlasmaBox = new Rectangle(60,5,50,50);
    private static Rectangle buySniperBox = new Rectangle(110,5,50,50);
    private static Rectangle buyScatterBox = new Rectangle(160,5,50,50);
    private static Rectangle buyCanonBox = new Rectangle(210,5,50,50);
    private static Rectangle buyVirusBox = new Rectangle(260,5,50,50);
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
        // try {
        //     Font f = Font.createFont(Font.TRUETYPE_FONT, new File("Seven Segment.ttf")).deriveFont(Font.BOLD, 15);
        //     g2.setFont(f);
        // } catch (FontFormatException | IOException e) {
        //     e.printStackTrace();
        // }
        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(0, 0, PREF_W, PREF_H);

        g2.setStroke(new BasicStroke(2));

        for(int i = 0; i<10;i++)
        {
            g2.setColor(Color.WHITE);
            g2.fillRect(25+i*75, PREF_H-12, 100+i*75, 12);
            g2.setColor(Color.BLACK);
            g2.drawRect(25+i*75, PREF_H-12, 100+i*75, 12);
        }
        g2.setColor(new Color(231, 221, 180));
        g2.fillRect(PREF_W-25, PREF_H-25,25,25);

        g2.setColor(Color.BLACK);
        g2.drawLine(PREF_W-26, PREF_H-25+24, PREF_W-26, PREF_H-12);

        //Render bricks and balls?
        IdleBreakout.setRender(render);
        if(render){ g2.setColor(Color.WHITE); } else { g2.setColor(Color.RED); }
        g2.fill(toggleRenderBox);
        g2.setColor(Color.BLACK);
        g2.draw(toggleRenderBox);  
        String message = "On/Off";
        FontMetrics fm = g2.getFontMetrics(); 
        int messageWidth = fm.stringWidth(message);
        int startX = (int)(toggleRenderBox.getX()+toggleRenderBox.getWidth()/2) - messageWidth/2;
        int startY = (int)(toggleRenderBox.getY()+toggleRenderBox.getHeight()/2) + 5;
        g2.drawString(message, startX, startY);

        // g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.WHITE);
        g2.fill(moneyOuterBox);
        g2.setColor(new Color(110, 210, 60));
        g2.fill(moneyInnerBox);
        g2.setColor(Color.BLACK);
        g2.draw(moneyOuterBox);
        g2.draw(moneyInnerBox);

        // g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(243,242,242));
        g2.fill(buyBasicBox);
        g2.fill(buyPlasmaBox);
        g2.fill(buySniperBox);
        g2.fill(buyScatterBox);
        g2.fill(buyCanonBox);
        g2.fill(buyVirusBox);
        
        g2.setColor(new Color(110, 210, 60));
        g2.fillRect((int) buyBasicBox.getX(), (int)buyBasicBox.getY()+30, (int)buyBasicBox.getWidth(), (int)buyBasicBox.getHeight()-30);
        g2.fillRect((int) buyPlasmaBox.getX(), (int)buyPlasmaBox.getY()+30, (int)buyPlasmaBox.getWidth(), (int)buyPlasmaBox.getHeight()-30);
        g2.fillRect((int) buySniperBox.getX(), (int)buySniperBox.getY()+30, (int)buySniperBox.getWidth(), (int)buySniperBox.getHeight()-30);
        g2.fillRect((int) buyScatterBox.getX(), (int)buyScatterBox.getY()+30, (int)buyScatterBox.getWidth(), (int)buyScatterBox.getHeight()-30);
        g2.fillRect((int) buyCanonBox.getX(), (int)buyCanonBox.getY()+30, (int)buyCanonBox.getWidth(), (int)buyCanonBox.getHeight()-30);
        g2.fillRect((int) buyVirusBox.getX(), (int)buyVirusBox.getY()+30, (int)buyVirusBox.getWidth(), (int)buyVirusBox.getHeight()-30);
        
        g2.setColor(Color.BLACK);
        g2.draw(buyBasicBox);
        g2.draw(buyPlasmaBox);
        g2.draw(buySniperBox);
        g2.draw(buyScatterBox);
        g2.draw(buyCanonBox);
        g2.draw(buyVirusBox);
        g2.drawRect((int) buyBasicBox.getX(), (int)buyBasicBox.getY()+30, (int)buyBasicBox.getWidth(), (int)buyBasicBox.getHeight()-30);
        g2.drawRect((int) buyPlasmaBox.getX(), (int)buyPlasmaBox.getY()+30, (int)buyPlasmaBox.getWidth(), (int)buyPlasmaBox.getHeight()-30);
        g2.drawRect((int) buySniperBox.getX(), (int)buySniperBox.getY()+30, (int)buySniperBox.getWidth(), (int)buySniperBox.getHeight()-30);
        g2.drawRect((int) buyScatterBox.getX(), (int)buyScatterBox.getY()+30, (int)buyScatterBox.getWidth(), (int)buyScatterBox.getHeight()-30);
        g2.drawRect((int) buyCanonBox.getX(), (int)buyCanonBox.getY()+30, (int)buyCanonBox.getWidth(), (int)buyCanonBox.getHeight()-30);
        g2.drawRect((int) buyVirusBox.getX(), (int)buyVirusBox.getY()+30, (int)buyVirusBox.getWidth(), (int)buyVirusBox.getHeight()-30);
        
        g2.setColor(Color.YELLOW);
        g2.fillOval((int)(buyBasicBox.getX()+buyBasicBox.getWidth()/2-9), (int)(buyBasicBox.getY()+buyBasicBox.getHeight()/3-10), 18, 18);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buyBasicBox.getX()+buyBasicBox.getWidth()/2-9), (int)(buyBasicBox.getY()+buyBasicBox.getHeight()/3-10), 18, 18);
        message = "$"+ballCost(1, numBasic);
        fm = g2.getFontMetrics(); 
        messageWidth = fm.stringWidth(message);
        startX = (int)(buyBasicBox.getX()+buyBasicBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);
        
        g2.setColor(Color.MAGENTA);
        g2.fillOval((int)(buyPlasmaBox.getX()+buyPlasmaBox.getWidth()/2-9), (int)(buyPlasmaBox.getY()+buyPlasmaBox.getHeight()/3-10), 18, 18);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buyPlasmaBox.getX()+buyPlasmaBox.getWidth()/2-9), (int)(buyPlasmaBox.getY()+buyPlasmaBox.getHeight()/3-10), 18, 18);
        message = "$"+ballCost(2, numPlasma);
        fm = g2.getFontMetrics(); 
        messageWidth = fm.stringWidth(message);
        startX = (int)(buyPlasmaBox.getX()+buyPlasmaBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);

        g2.setColor(Color.WHITE);
        g2.fillOval((int)(buySniperBox.getX()+buySniperBox.getWidth()/2-9), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3-10), 18, 18);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buySniperBox.getX()+buySniperBox.getWidth()/2-9), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3-10), 18, 18);
        g2.setStroke(new BasicStroke(2));
        g2.drawLine((int)(buySniperBox.getX()+buySniperBox.getWidth()/2-5), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3-1), (int)(buySniperBox.getX()+buySniperBox.getWidth()/2+5), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3-1));
        g2.drawLine((int)(buySniperBox.getX()+buySniperBox.getWidth()/2), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3-6), (int)(buySniperBox.getX()+buySniperBox.getWidth()/2), (int)(buySniperBox.getY()+buySniperBox.getHeight()/3+4));
        message = "$"+ballCost(3, numSniper);
        fm = g2.getFontMetrics(); 
        messageWidth = fm.stringWidth(message);
        startX = (int)(buySniperBox.getX()+buySniperBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);

        g2.setColor(new Color(243,131,61));
        g2.fillOval((int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2-9), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3-10), 18, 18);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2-9), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3-10), 18, 18);
        g2.setStroke(new BasicStroke(1));
        g2.drawLine((int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3-5), (int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3+3));
        g2.drawLine((int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2+2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3-5), (int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2+2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3+3));
        g2.drawLine((int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2-2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3-5), (int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2-2), (int)(buyScatterBox.getY()+buyScatterBox.getHeight()/3+3));
        message = "$"+ballCost(4, numScatter);
        fm = g2.getFontMetrics();
        messageWidth = fm.stringWidth(message);
        startX = (int)(buyScatterBox.getX()+buyScatterBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);


        //draw the canon ball
        g2.setStroke(new BasicStroke(2));
        g2.setColor(Color.GRAY);
        g2.fillOval((int)(buyCanonBox.getX()+buyCanonBox.getWidth()/2-11), (int)(buyCanonBox.getY()+buyCanonBox.getHeight()/3-12), 22, 22);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buyCanonBox.getX()+buyCanonBox.getWidth()/2-11), (int)(buyCanonBox.getY()+buyCanonBox.getHeight()/3-12), 22, 22);
        message = "$"+ballCost(5, numCanon);
        fm = g2.getFontMetrics();
        messageWidth = fm.stringWidth(message);
        startX = (int)(buyCanonBox.getX()+buyCanonBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);


        //draw the virus ball
        g2.setColor(new Color(232,50,35));
        g2.fillOval((int)(buyVirusBox.getX()+buyVirusBox.getWidth()/2-9), (int)(buyVirusBox.getY()+buyVirusBox.getHeight()/3-10), 18, 18);
        g2.setColor(Color.BLACK);
        g2.drawOval((int)(buyVirusBox.getX()+buyVirusBox.getWidth()/2-9), (int)(buyVirusBox.getY()+buyVirusBox.getHeight()/3-10), 18, 18);
        message = "$"+ballCost(6, numVirus);
        fm = g2.getFontMetrics();
        messageWidth = fm.stringWidth(message);
        startX = (int)(buyVirusBox.getX()+buyVirusBox.getWidth()/2) - messageWidth/2;
        g2.drawString(message, startX, 50);

        g2.drawString(myMoney+"", 500, 20);

        if(myMoney<0)
        {
            System.out.println("Terminating program due to negative money: "+myMoney);
            System.exit(0);
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
        myMoney += money;
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

        //buy basic
        if((x>buyBasicBox.getX() && x<buyBasicBox.getX()+buyBasicBox.getWidth()) && (y>buyBasicBox.getY() && y<buyBasicBox.getY()+buyBasicBox.getHeight()))
        {
            System.out.println("buy basic");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(1, numBasic))
            {
                IdleBreakout.spawnBall(1);
                myMoney -= ballCost(1, numBasic);
                numBasic++;
            }
        }
    
        //buy plasma
        if((x>buyPlasmaBox.getX() && x<buyPlasmaBox.getX()+buyPlasmaBox.getWidth()) && (y>buyPlasmaBox.getY() && y<buyPlasmaBox.getY()+buyPlasmaBox.getHeight()))
        {
            System.out.println("buy plasma");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(2, numPlasma))
            {
                IdleBreakout.spawnBall(2);
                myMoney -= ballCost(2, numPlasma);
                numPlasma++;
            }
        }
    
        //buy sniper
        if((x>buySniperBox.getX() && x<buySniperBox.getX()+buySniperBox.getWidth()) && (y>buySniperBox.getY() && y<buySniperBox.getY()+buySniperBox.getHeight()))
        {
            System.out.println("buy sniper");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(3, numSniper))
            {
                IdleBreakout.spawnBall(3);
                myMoney -= ballCost(3, numSniper);
                numSniper++;
            }
        }
    
        //buy scatter
        if((x>buyScatterBox.getX() && x<buyScatterBox.getX()+buyScatterBox.getWidth()) && (y>buyScatterBox.getY() && y<buyScatterBox.getY()+buyScatterBox.getHeight()))
        {
            System.out.println("buy scatter");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(4, numScatter))
            {
                IdleBreakout.spawnBall(4);
                myMoney -= ballCost(4, numScatter);
                numScatter++;
            }
        }

        //buy canon
        if((x>buyCanonBox.getX() && x<buyCanonBox.getX()+buyCanonBox.getWidth()) && (y>buyCanonBox.getY() && y<buyCanonBox.getY()+buyCanonBox.getHeight()))
        {
            System.out.println("buy canon");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(5, numCanon))
            {
                IdleBreakout.spawnBall(5);
                myMoney -= ballCost(5, numCanon);
                numCanon++;
            }
        }

        //buy virus
        if((x>buyVirusBox.getX() && x<buyVirusBox.getX()+buyVirusBox.getWidth()) && (y>buyVirusBox.getY() && y<buyVirusBox.getY()+buyVirusBox.getHeight()))
        {
            System.out.println("buy virus");
            if(numBasic+numPlasma+numSniper+numScatter+numCanon+numVirus<ballsAllowed && myMoney>=ballCost(6, numVirus))
            {
                IdleBreakout.spawnBall(6);
                myMoney -= ballCost(6, numVirus);
                numVirus++;
            }
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
    
    public int ballCost(int ballType, int numOfBall)
    {
        if(ballType==1)
        {
            return (int)Math.round(25*Math.pow(1.5, numOfBall));
        }
        if(ballType==2)
        {
            return (int)Math.round(200*Math.pow(1.4, numOfBall));
        }
        if(ballType==3)
        {
            return (int)Math.round(1500*Math.pow(1.35, numOfBall));
        }
        if(ballType==4)
        {
            return (int)Math.round(10000*Math.pow(1.35, numOfBall));
        }
        if(ballType==5)
        {
            return (int)Math.round(75000*Math.pow(1.3, numOfBall));
        }
        if(ballType==6)
        {
            return (int)Math.round(90000*Math.pow(1.25, numOfBall));
        }
        return 0;
    }
}