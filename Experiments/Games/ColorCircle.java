import java.awt.Color;
import java.awt.Graphics2D;

public class ColorCircle {
    public Color c = new Color(0,0,0);
    public int r = c.getRed();
    public int g = c.getGreen();
    public int b = c.getBlue();
    public int x;
    public int y;
    public int radius;
    
    public ColorCircle()
    {
        this.c = new Color(0,0,0);
        this.r = c.getRed();
        this.g = c.getGreen();
        this.b = c.getBlue();
        this.x = 0;
        this.y = 0;
        this.radius = 0;
    }
    public ColorCircle(Color c, int x, int y, int radius)
    {
        this.c = c;
        this.r = c.getRed();
        this.g = c.getGreen();
        this.b = c.getBlue();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public boolean intersects(int x2, int y2)
    {
        return Math.sqrt(Math.pow(x2-x,2)+Math.pow(y2-y,2))<radius;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public void fillCircle(Graphics2D g2)
    {
        g2.setColor(c);
        g2.fillOval(x-radius, y-radius, radius*2, radius*2);
    }
    
}
