package Experiments.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;

public class imageThing extends JPanel implements KeyListener, MouseMotionListener, MouseListener
{
    private static final long serialVersionUID = 1L;
    private static final int PREF_W = 600;
    private static final int PREF_H = 600;
    private RenderingHints hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    private static int FPSCap = 6000;
    private String input = "";
    private Image img = new ImageIcon(this.getClass().getResource("img.jpg")).getImage();
    private BufferedImage bimg = toBufferedImage(img) ;
    private int x = bimg.getWidth();
    private int y = bimg.getHeight();
    private Color c;
    private int[] colorsArray = new int[1];

    public imageThing()
    {
        addKeyListener(this);
        addMouseMotionListener(this);
        addMouseListener(this);
        setFocusable(true);
        requestFocus();



    }
    
    public Dimension getPreferredSize() {
        return new Dimension(PREF_W, PREF_H);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //keep this for program to work
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);
        g2.drawString(input, 10, 50);
        g2.drawImage(bimg, 0, 0, 200, 200, null);
        for(int i=0;i<bimg.getWidth(); i++)
            for(int j=0;j<bimg.getHeight();j++)
            {
                bimg.getRGB(0, 0, x, y, colorsArray, 0,1);

                g2.setColor(c);
                g2.fillRect(0, 0, 300, 300);
            }
        //keep this for program to work
        FPSCap = 1000;

        long millis = System.currentTimeMillis();
        try
        {
        Thread.sleep((long) ((1000/FPSCap) - millis % (1000/FPSCap)));
        this.repaint();
        g2.drawString(""+(long) ((1000/FPSCap) - millis % (1000/FPSCap)), 400, 50);

        return;
        } catch (InterruptedException e) {System.out.println(e);}
    }

    

    private static void createAndShowGUI() {
        imageThing gamePanel = new imageThing();
        JFrame frame = new JFrame("My Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gamePanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.WHITE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    @Override
    public void keyPressed(KeyEvent e)
    {
        if(!e.isActionKey())
        input+=e.getKeyChar();
        if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			repaint();
		}
    }

    @Override
    public void keyReleased(KeyEvent e){}

    @Override
    public void keyTyped(KeyEvent e){}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static BufferedImage toBufferedImage(Image img)
    {
        if(img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }

        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img,0,0,null);
        bGr.dispose();

        return bimage;

    }

}