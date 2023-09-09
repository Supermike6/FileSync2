import java.awt.BasicStroke;
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
    public void outlineCircle(Graphics2D g2) 
    {
        int borderDiff = 8;
        g2.setStroke(new BasicStroke(3));
        g2.setColor(new Color(c.getRed()/(borderDiff+1)*borderDiff, c.getGreen()/(borderDiff+1)*borderDiff, c.getBlue()/(borderDiff+1)*borderDiff));
        g2.drawOval(x-radius, y-radius, radius*2, radius*2);
    }
    
    @Override
    public String toString() {
        return "ColorCircle [c=" + c + ", x=" + x + ", y=" + y + ", radius=" + radius + "]";
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + r;
        result = prime * result + g;
        result = prime * result + b;
        result = prime * result + x;
        result = prime * result + y;
        result = prime * result + radius;
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ColorCircle other = (ColorCircle) obj;
        if (c == null) {
            if (other.c != null)
                return false;
        } else if (!c.equals(other.c))
            return false;
        if (r != other.r)
            return false;
        if (g != other.g)
            return false;
        if (b != other.b)
            return false;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        if (radius != other.radius)
            return false;
        return true;
    }
}
