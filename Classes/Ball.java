package Classes;




import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Ball
{
// Variables for the class's object (instance variables)
    private int x, y, w, h, dx, dy, xmin, xmax, ymin, ymax;
    private Color color;
    
    //This is the constructor... it allows us to define values to the Ball object
    public Ball(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Ball(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public Ball(int x, int y, int w, int h, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    public Ball(int x, int y, int w, int h, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dx = dx;
        this.dy = dy;
    }
    public Ball(int x, int y, int w, int h, int dx, int dy, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }
    public Ball(int x, int y, int w, int h, int dx, int dy, int xmin, int xmax, int ymin, int ymax, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
    }

    //Methods for brick
    public String[] BallStat()
    {
        String[] strs = {this.x+"",this.y+"",this.w+"",this.h+"",this.dx+"",this.dy+"",this.color+""};

        return strs;
    }
    public void draw(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.drawRect(this.x, this.y, this.w, this.h);

        g2.setColor(prevColor);
    }
    public void fill(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.fillRect(this.x, this.y, this.w, this.h);

        g2.setColor(prevColor);
    }
    public void fillCircle(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.fillOval(this.x, this.y, this.w, this.h);

        g2.setColor(prevColor);
    }
    public void drawCircle(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.drawOval(this.x, this.y, this.w, this.h);

        g2.setColor(prevColor);
    }
    public void update()
    {
        this.x+=this.dx;
        if(this.x+this.w>this.xmax || x<xmin)
            this.dx = -this.dx;
        this.y+=this.dy;
        if(this.y+this.h>this.ymax || y<ymin)
            this.dy = -this.dy;
    }
    public void noYBounceUpdate()
    {
        this.x+=this.dx;
        if(this.x+this.w>this.xmax || x<xmin)
            this.dx = 0;
        this.y+=this.dy;
        if(this.y+this.h>this.ymax || y<ymin)
            this.y -= this.dy;
    }
    public void updateList(ArrayList<Ball> Balls)
    {

        for(int i = 0; i<Balls.size(); i++)
        {
            Balls.get(i).update();
        }
    }
    public void setRandomColor()
    {
        this.color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
    }

    //Setter Methods
    public void setX(int num)
    {
        this.x = num;
    } 
    public void setY(int num)
    {
        this.y = num;
    } 
    public void setW(int num)
    {
        this.w = num;
    } 
    public void setH(int num)
    {
        this.h = num;
    } 
    public void setDx(int num)
    {
        this.dx = num;
    } 
    public void setDy(int num)
    {
        this.dy = num;
    } 
    public void setColor(Color color)
    {
        this.color = color;
    } 
    public void setXmax(int num)
    {
        this.xmax=num;
    }
    public void setYmax(int num)
    {
        this.ymax=num;
    }
    public void setXmin(int num)
    {
        this.xmin=num;
    }
    public void setYmin(int num)
    {
        this.ymin=num;
    }

    //Getter Methods
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public int getW()
    {
        return this.w;
    }
    public int getH()
    {
        return this.h;
    }
    public int getDx()
    {
        return this.dx;
    }
    public int getDy()
    {
        return this.dy;
    }
    public Color getColor()
    {
        return this.color;
    }
    public int getXmin()
    {
        return this.xmin;
    }
    public int getYmin()
    {
        return this.ymin;
    }
    public int getXmax()
    {
        return this.xmax;
    }
    public int getYmax()
    {
        return this.ymax;
    }

    /** Determines the intersecting side for the brick in relation to another brick
*  return true for a collision and false otherwise
*/
    public boolean checkAndReactToCollisionWith(Ball r)
{
   int xm = x + w/2; //use the center of the moving brick as a reference
   int ym = y + h/2; //use the center of the moving brick as a reference
   
   int side = getSideForIntersection(r, xm, ym); //get the moving brick in relation to the other brick
   
   if(side == 0)      //Is the moving brick above the other brick?
      return checkCollisionTopOfRectangle(r);
   else if(side == 1) //Is the moving brick to the right of the other brick?
      return checkCollisionRightSideOfRectangle(r);
   else if(side == 2) //Is the moving brick below the other brick?
      return checkCollisionBottomOfRectangle(r);
   else if(side == 3) //Is the moving brick to the left of the other brick?
      return checkCollisionLeftSideOfRectangle(r);
   
   return false;
}

    /**Returns the side where a collision would occur if possible
*    0 = top
*    1 = right
*    2 = bottom
*    3 = left
*/
    private int getSideForIntersection(Ball r, int x1, int y1)
{
   double slopeMajor = (double) r.h / r.w;         //major diagonal slope
   double slopeMinor = (double) -r.h / r.w;        //minor diagonal slope
   double bMajor = r.y - slopeMajor * r.x;         //major diagonal y-intercept
   double bMinor = r.y - slopeMinor * (r.x + r.w); //minor diagonal y-intercept
   
   boolean aboveMajor = y1 < slopeMajor * x1 + bMajor; //Is the given point above the major diagonal
   boolean aboveMinor = y1 < slopeMinor * x1 + bMinor; //Is the given point above the minor diagonal
   
   if(aboveMajor  && aboveMinor)  return 0; //The point is above the other brick
   if(aboveMajor  && !aboveMinor) return 1; //The point is to the right of the other brick
   if(!aboveMajor && !aboveMinor) return 2; //The point is below the other brick
   if(!aboveMajor && aboveMinor)  return 3; //The point is to the left of the other brick
   
   return -1;   //Should never get here since "not above" is below OR ON a diagonal
}

    public boolean checkCollisionLeftSideOfRectangle(Ball r)
{
   boolean collision = false;
   
   if(y + h > r.y && y < r.y + r.h) {
      if(x + w > r.x) {
         dx = -Math.abs(dy);
         x = r.x - w;
         if(x <= xmin) {  //don't let the brick get bumped off the panel
            x = xmin;
            r.x = x + w;  //in case the colliding brick is moving, stop it from overlapping this brick the the edges of the panel
         }
         collision = true;
      }
   }
   return collision;
}

    public boolean checkCollisionRightSideOfRectangle(Ball r)
{
   boolean collision = false;
   
   if(y + h > r.y && y < r.y + r.h) {
   if(x < r.x + r.w) {
         dx = Math.abs(dy);
         x = r.x + r.w;
         if(x + w >= xmax) {  //don't let the brick get bumped off the panel
            x = xmax - w;
            r.x = x - r.w;       //in case the colliding brick is moving, stop it from overlapping this brick the the edges of the panel
         }
         collision = true;
      }
   }
   return collision;
}

    public boolean checkCollisionBottomOfRectangle(Ball r)
{
   boolean collision = false;
   
   if(x + w > r.x && x < r.x + r.w) {
      if(y < r.y + r.h) {
         dy = -Math.abs(dx);
         y = r.y + r.h;
         if(y + h >= ymax) { //don't let the brick get bumped off the panel
            y = ymax - h;
            r.y = y - r.h;   //in case the colliding brick is moving, stop it from overlapping this brick the the edges of the panel
         }
         collision = true;
      }
   }
   return collision;
}

    public boolean checkCollisionTopOfRectangle(Ball r)
{
    boolean collision = false;
   
   if(x + w > r.x && x < r.x + r.w) {
      if(y + h > r.y) {
         dy = -Math.abs(dx);
         y = r.y - h;
         if(y <= ymin) {  //don't let the brick get bumped off the panel
            y = ymin;
            r.y = y + h;  //in case the colliding brick is moving, stop it from overlapping this brick the the edges of the panel
         }
         collision = true;
      }
   }
   return collision;
}
}
