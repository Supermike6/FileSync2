package APCompsci.Classwork.DynoGame;

import java.awt.Graphics2D;
import java.util.Objects;

public class Sprite
{
    protected double x,y,dx,dy;
    protected int w,h;

    public Sprite(double x, double y, int w, int h, double dx, double dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.w = w;
        this.h = h;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDx() {
        return this.dx;
    }

    public void setDx(double dx) {
        this.dx = dx;
    }

    public double getDy() {
        return this.dy;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public int getW() {
        return this.w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return this.h;
    }

    public void setH(int h) {
        this.h = h;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Sprite)) {
            return false;
        }
        Sprite sprite = (Sprite) o;
        return x == sprite.x && y == sprite.y && dx == sprite.dx && dy == sprite.dy && w == sprite.w && h == sprite.h;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, dx, dy, w, h);
    }

    @Override
    public String toString() {
        return super.getClass().getName()+" [" +
            " x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", dx='" + getDx() + "'" +
            ", dy='" + getDy() + "'" +
            ", w='" + getW() + "'" +
            ", h='" + getH() + "'" +
            "]";
    }

    public void update()
    {
        
    }

    public void draw(Graphics2D g2)
    {
        g2.drawRect((int)x, (int)y, w, h);
    }

    public boolean isCollidingWith(Sprite s)
    {
        return false;

    }

    public void reset() {
    }


}