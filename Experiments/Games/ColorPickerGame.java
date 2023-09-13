import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.MouseInputListener;




public class ColorPickerGame extends JPanel implements KeyListener, MouseInputListener
{
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 1300;
    private static final int PREF_H = PREF_W/16*9;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private int mousex = 0;
    private int mousey = 0;
    private Color tc = new Color(255,255,255);
    private Color cc = new Color(255,255,255);
    private int smoothness = 10;
    private long frameCount = 0;
    private double CCrdiff = 0; double CCgdiff = 0; double CCbdiff = 0; long temp = 0; double CCrd = 0; double CCgd = 0; double CCbd = 0;
    private int numColors = 2;
    private int closeness = 72;
    private Font font = new Font("Lekton", Font.PLAIN, 67);
    private ArrayList<ColorCircle> colorArray = makeColorArray(numColors);
    private ArrayList<ColorCircle> flagged = makeColorArray(0);
    private ArrayList<ColorCircle> menuArray = makeColorArray(6);
    private ColorCircle correctColor = colorArray.get((int)(Math.random()*numColors)).seperate();
    private boolean doAnim = false;
    private boolean doFlagging = true;

    
    private String state = "menu";
    

   
    public ColorPickerGame()
    {
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);


      
        for(int i = 0; i<6;i++)
        {
            menuArray.get(i).setRadius(40);
            menuArray.get(i).setX(PREF_W/2+40+(menuArray.get(i).getRadius()*2+10)*(i-3));
            menuArray.get(i).setY(PREF_H/2);
        }
        menuArray.get(0).setC(new Color(0,255,0));
        menuArray.get(1).setC(new Color(160,255,0));
        menuArray.get(2).setC(new Color(224,255,0));
        menuArray.get(3).setC(new Color(255,224,0));
        menuArray.get(4).setC(new Color(255,160,0));
        menuArray.get(5).setC(new Color(255,0,0));


        Timer timer= new Timer((int)(1000/60), new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                repaint();
            }
        });
        timer.start();
   }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        
        String message = "";
        FontMetrics fm = g2.getFontMetrics();
        int messageWidth = 0;
        int startX = 0;

        

        //Games menu
        if(state.equals("menu"))
        {
            g2.setColor(Color.black);
            for(int i = 0; i<menuArray.size();i++)
            {
                menuArray.get(i).fillCircle(g2);
                menuArray.get(i).outlineCircle(g2);
                g2.setColor(Color.BLACK);
                message = (int)Math.pow(2,i+1)+"";
                fm = g2.getFontMetrics();
                messageWidth = fm.stringWidth(message);
                startX = menuArray.get(i).getX() - messageWidth/2;
                g2.drawString(message, startX, getHeight()/2+5);
            }
            return;
        }

        
        
        
        //bkg
        if(doAnim)
        {
            if(frameCount<temp)
            {
                CCrd-=CCrdiff;
                CCgd-=CCgdiff;
                CCbd-=CCbdiff;
                if(CCrd<0)CCrd = 0;
                if(CCgd<0)CCgd = 0;
                if(CCbd<0)CCbd = 0;
                if(CCrd>255)CCrd = 255;
                if(CCgd>255)CCgd = 255;
                if(CCbd>255)CCbd = 255;
                cc = new Color((int)(CCrd),(int)(CCgd),(int)(CCbd));
                g2.setColor(cc);
                g2.fillRect(0, 0, PREF_W, PREF_H);
            } else {
                cc = tc;
                CCrd = cc.getRed();
                CCgd = cc.getGreen();
                CCbd = cc.getBlue();
                g2.setColor(cc);
                g2.fillRect(0, 0, PREF_W, PREF_H);
            }
        }
        
        
        int sBase = 10;
        int dBase = 16;
        String number = correctColor.getC().getRed()+"";
        String display = "#"+Integer.toString(Integer.parseInt(number, sBase), dBase).toUpperCase();
        number = correctColor.getC().getGreen()+"";
        display+=Integer.toString(Integer.parseInt(number, sBase), dBase).toUpperCase();
        number = correctColor.getC().getBlue()+"";
        display+=Integer.toString(Integer.parseInt(number, sBase), dBase).toUpperCase();
        
        //Draw Circle
        for(int i = 0; i<colorArray.size();i++)
        {
            colorArray.get(i).fillCircle(g2);
            if(flagged.contains(colorArray.get(i)))
            {
                new ColorCircle(new Color(255, 255, 255, 120), colorArray.get(i).getX(), colorArray.get(i).getY(), colorArray.get(i).getRadius()).fillCircle(g2);
                g2.setColor(colorArray.get(i).getC());
                g2.setStroke(new BasicStroke(5));
                g2.drawLine(colorArray.get(i).getX()-colorArray.get(i).getRadius()/2, colorArray.get(i).getY()-colorArray.get(i).getRadius()/2, colorArray.get(i).getX()+colorArray.get(i).getRadius()/2, colorArray.get(i).getY()+colorArray.get(i).getRadius()/2);
                g2.drawLine(colorArray.get(i).getX()+colorArray.get(i).getRadius()/2, colorArray.get(i).getY()-colorArray.get(i).getRadius()/2, colorArray.get(i).getX()-colorArray.get(i).getRadius()/2, colorArray.get(i).getY()+colorArray.get(i).getRadius()/2);
            }
            colorArray.get(i).outlineCircle(g2);
        }
        
        g2.setColor(Color.black);
        if(state.equals("Over"))
        {
            message = "Play Again";
            fm = g2.getFontMetrics();
            messageWidth = fm.stringWidth(message);
            startX = getWidth()/3 - messageWidth/2;
            g2.drawString(message, startX, getHeight()/5);
            message = "Back to menu";
            fm = g2.getFontMetrics();
            messageWidth = fm.stringWidth(message);
            startX = getWidth()/3*2 - messageWidth/2;
            g2.drawString(message, startX, getHeight()/5);
            g2.setColor(correctColor.getC());
            
        }
        g2.setFont(font);
        message = display;
        fm = g2.getFontMetrics();
        messageWidth = fm.stringWidth(message);
        startX = getWidth()/2 - messageWidth/2;
        g2.drawString(message, startX, getHeight()/5);
        
        //Template - remove
        // g2.setColor(Color.black);
        // String message = "";
        // FontMetrics fm = g2.getFontMetrics();
        // int messageWidth = fm.stringWidth(message);
        // int startX = getWidth()/2 - messageWidth/2;
        // g2.drawString(message, startX, getHeight()/2);
        
        g2.drawString(""+closeness, 10, 100);

        frameCount++;
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_Q)
        {
            state = "menu";
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyChar();
        if(key == 'a')
        {
            numColors++;
        }
        
        if(key == 's')
        {
            numColors--;
        }
        if(key == ' ')
        {
            colorArray = makeColorArray(numColors);
            state = "Game";
        }

        if(key=='z')
            closeness-=8;
        if(key=='x')
            closeness+=8;
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e)
    {        
        
    }

    private static void createAndShowGUI() {
        ColorPickerGame gamePanel = new ColorPickerGame();
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });     
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if(getIntersectingColorCircle(mousex,mousey,colorArray)!=null || getIntersectingColorCircle(mousex,mousey,menuArray)!=null)
        {
            if(state.equals("menu"))
            {
                if(menuArray.indexOf(getIntersectingColorCircle(mousex,mousey,menuArray))!=-1)
                    numColors = (int) Math.pow(2, menuArray.indexOf(getIntersectingColorCircle(mousex,mousey,menuArray))+1);
                colorArray = makeColorArray(numColors);
                state = "game";
                correctColor = colorArray.get((int)(colorArray.size()*Math.random())).seperate();
                return;
            }

            switch(e.getButton())
            {
                case 1:
                    if(getIntersectingColorCircle(mousex,mousey,colorArray).getX()==correctColor.getX() && getIntersectingColorCircle(mousex,mousey,colorArray).getY()==correctColor.getY())
                    {
                        for(int i = 0; i<colorArray.size();i++)
                        {
                            colorArray.remove(i);
                            i--;
                        }
                        colorArray.add(correctColor);
                        state = "Over";
                    } else {
                        colorArray.remove(getIntersectingColorCircle(mousex,mousey,colorArray));
                    }

                    break;
                case 2:
                    System.out.println("goofy middle click");
                    break;
                case 3:
                    if(!flagged.contains(getIntersectingColorCircle(mousex,mousey,colorArray)))
                        flagged.add(getIntersectingColorCircle(mousex,mousey,colorArray));
                    else flagged.remove(getIntersectingColorCircle(mousex,mousey,colorArray));
                    break;
                default:
                    System.out.println("unknown");
                    break;
            }
        } else System.out.println("not over circle");
        mouseMoved(e);
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {
        mousex = e.getX();
        mousey = e.getY();

        if(!flagged.contains(getIntersectingColorCircle(mousex,mousey,colorArray)) && getIntersectingColorCircle(mousex,mousey,colorArray)!=null)
        {
            tc = getIntersectingColorCircle(mousex,mousey,colorArray).getC();
        } else tc = Color.white;
        beginAnim();
        
    }

    public int giveOneWSign(int num)
    {
        if(num<0) return -1;
        return 1;
    }

    public ArrayList<ColorCircle> makeColorArray(int numColors)
    {
        ArrayList<ColorCircle> colorArrayT = new ArrayList<ColorCircle>();
        
        int circlesPerRow = 14;  // Maximum number of circles in a row
        int circleSpacing = 10;  // Spacing between circles
        int rowSpacing = 20;     // Spacing between rows
        int circleDiam = 80;   // Radius of each circle

        double ran1 = Math.random();
        double ran2 = Math.random();
        double ran3 = Math.random();
        for(int i = 0; i < numColors; i++)
        {
            ColorCircle circle = new ColorCircle();
            int x = 0;
            
            if(i>=numColors-numColors%14)
            {
                x=(PREF_W/2+circleDiam/2+(circleDiam+circleSpacing)*(i%14))-((circleDiam+circleSpacing)*(numColors%14)/2)+circleSpacing/2;
            } else {
                x=(PREF_W/2+circleDiam/2+(circleDiam+circleSpacing)*(i%14))-((circleDiam+circleSpacing)*(circlesPerRow)/2)+circleSpacing/2;
            }
            int y = PREF_H/3+(circleDiam+rowSpacing)*(i/circlesPerRow);
            
            if(closeness<numColors)
                closeness = numColors+2;
            if(closeness>255)
                closeness = 253;
            int ranR = (int)(Math.random() * closeness) + (int)((254-closeness)*ran1);
            int ranG = (int)(Math.random() * closeness) + (int)((254-closeness)*ran2);
            int ranB = (int)(Math.random() * closeness) + (int)((254-closeness)*ran3);
            circle.setC(new Color(ranR, ranG, ranB));
            circle.setRadius(circleDiam/2);
            circle.setX(x);
            circle.setY(y);
            colorArrayT.add(circle);
        }
        
        
        // Traverse through the first list
        for (ColorCircle ccccc : colorArrayT) {

            // If this element is not present in newList
            // then add it
            if (!colorArrayT.contains(ccccc)) {

                colorArrayT.add(ccccc);
            }
        }
        
        return colorArrayT;
    }

    public ColorCircle getIntersectingColorCircle(int x, int y, ArrayList<ColorCircle> arrayUsed)
    {
        for(int i = 0; i<arrayUsed.size();i++)
        {
            if(arrayUsed.get(i).intersects(x, y))
            {
                return arrayUsed.get(i);
            }
        }
        return null;
    }
    
    public void beginAnim()
    {
        CCrdiff = (cc.getRed()-tc.getRed()+0.0)/(smoothness+0.0);
        CCgdiff = (cc.getGreen()-tc.getGreen()+0.0)/(smoothness+0.0);
        CCbdiff = (cc.getBlue()-tc.getBlue()+0.0)/(smoothness+0.0);
        temp = frameCount+smoothness;
    }

}