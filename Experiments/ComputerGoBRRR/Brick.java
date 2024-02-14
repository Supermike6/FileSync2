package Experiments.ComputerGoBRRR;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Brick
{
// Variables for the class's object (instance variables)
    private int x, y, w, h, dx, dy, xmin, xmax, ymin, ymax, health, Enum, ballPower,arcSize = 12;
    public double sniperDx = -1, sniperDy = 1;
    private Color color;
    public boolean air;


    //This is the constructor... it allows us to define values to the brick object
    public Brick(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Brick(int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    public Brick(int x, int y, int w, int h, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }
    public Brick(int x, int y, int w, int h, int dx, int dy)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dx = dx;
        this.dy = dy;
    }
    public Brick(int x, int y, int w, int h, int dx, int dy, Color color)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.dx = dx;
        this.dy = dy;
        this.color = color;
    }
    public Brick(int x, int y, int w, int h, Color color, int health, int Enum)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
        this.health = health;
        this.Enum = Enum;

    }
    public Brick(int x, int y, int w, int h, int dx, int dy, int xmin, int xmax, int ymin, int ymax, Color color)
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
    public Brick(int x, int y, int w, int h, int dx, int dy, int xmin, int xmax, int ymin, int ymax, Color color, int health, int Enum)
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
        this.health = health;
        this.Enum = Enum;
    }
    public Brick(int x, int y, int w, int h, int dx, int dy, int xmin, int xmax, int ymin, int ymax, Color color, int health, int Enum,  int ballPower)
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
        this.health = health;
        this.Enum = Enum;
        this.ballPower = ballPower;
    }

    //Methods for brick
    public String[] brickStat()
    {
        String[] strs = {this.x+"",this.y+"",this.w+"",this.h+"",this.dx+"",this.dy+"",this.color+""};

        return strs;
    }
    public void draw(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.drawRoundRect(this.x, this.y, this.w, this.h,arcSize,arcSize);

        g2.setColor(prevColor);
    }
    public void fill(Graphics2D g2)
    {   
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.fillRoundRect(this.x, this.y, this.w, this.h,arcSize,arcSize);

        g2.setColor(prevColor);
    }
    public void fillOval(Graphics2D g2)
    {
        Color prevColor = g2.getColor();

        g2.setColor(this.color);
        g2.fillOval(this.x, this.y, this.w, this.h);

        g2.setColor(prevColor); 
    }
    public void update()
    {
        this.x+=this.dx;
        if(this.x+this.w>this.xmax || x<=0)
            this.dx = -this.dx;
        this.y+=this.dy;
        if(this.y+this.h>this.ymax || y<=0)
            this.dy = -this.dy;
    }

    public void noBounceUpdate()
    {
        this.x+=this.dx;
        if(this.x+this.w>this.xmax || x<xmin)
            this.x -= this.dx;
        this.y+=this.dy;
        if(this.y+this.h>this.ymax || y<ymin)
            this.y -= this.dy;
    }
    public static void updateList(ArrayList<Brick> bricks)
    {

        for(int i = 0; i<bricks.size(); i++)
        {
            bricks.get(i).update();
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
    public void setHealth(int num)
    {
        this.health=num;
    }
    public void setExnum(int num)
    {
        this.Enum=num;
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
    public int getHealth()
    {
        return this.health;
    }
    public int getEnum()
    {
        return this.Enum;
    }
    

    /** Determines the intersecting side for the brick in relation to another brick
*  return true for a collision and false otherwise
*/
    public boolean checkAndReactToCollisionWith(Brick r)
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
    private int getSideForIntersection(Brick r, int x1, int y1)
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

    private boolean checkCollisionLeftSideOfRectangle(Brick r)
{
   boolean collision = false;
   
   if(y + h > r.y && y < r.y + r.h) {
      if(x + w > r.x) {
         dx = -dx;
         sniperDx = -sniperDx;
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

    private boolean checkCollisionRightSideOfRectangle(Brick r)
{
   boolean collision = false;
   
   if(y + h > r.y && y < r.y + r.h) {
   if(x < r.x + r.w) {
         dx = -dx;
         sniperDx = -sniperDx;
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

    private boolean checkCollisionBottomOfRectangle(Brick r)
{
    boolean collision = false;
   
    if(x + w > r.x && x < r.x + r.w) {
        if(y < r.y + r.h) {
            dy = -dy;
            sniperDy = -sniperDy;
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

    private boolean checkCollisionTopOfRectangle(Brick r)
{
   boolean collision = false;
   
   if(x + w > r.x && x < r.x + r.w) {
      if(y + h > r.y) {
         dy = -dy;
         sniperDy = -sniperDy;
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
    public int getBallPower() {
        return ballPower;
    }
    public int getArcSize() {
        return arcSize;
    }
    public boolean isAir() {
        return air;
    }
    public void setEnum(int enum1) {
        Enum = enum1;
    }
    public void setBallPower(int ballPower) {
        this.ballPower = ballPower;
    }
    public void setArcSize(int arcSize) {
        this.arcSize = arcSize;
    }
    public void setAir(boolean air) {
        this.air = air;
    }

    public Brick findClosestBrick(ArrayList<Brick> bricks)
    {
        for(int i = 0; i<bricks.size();i++)
        {
            if(bricks.get(i).getHealth()<1)
            {
                bricks.remove(i);
                i--;
            }
        }
        //using the list of bircks find the birck that a center closest to the player's center
        if(bricks.size()==0)
        {
            System.out.println("Error avoided");
        }
        Brick closestBrick = bricks.get(0);
        int closestBrickX = closestBrick.getX()+closestBrick.getW()/2;
        int closestBrickY = closestBrick.getY()+closestBrick.getH()/2;
        int ballX = this.x+this.w/2;
        int ballY = this.y+this.h/2;
        int closestDistance = (int)Math.sqrt(Math.pow(ballX-closestBrickX,2)+Math.pow(ballY-closestBrickY,2));
        for(int i = 0; i<bricks.size();i++)
        {
            Brick tempBrick = bricks.get(i);
            int tempBrickX = tempBrick.getX()+tempBrick.getW()/2;
            int tempBrickY = tempBrick.getY()+tempBrick.getH()/2;
            int tempDistance = (int)Math.sqrt(Math.pow(ballX-tempBrickX,2)+Math.pow(ballY-tempBrickY,2));
            if(tempDistance<closestDistance)
            {
                closestBrick = tempBrick;
                closestDistance = tempDistance;
            }
        }
        return closestBrick;        
    }
    @Override
    public String toString() {
        return "Brick [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + ", dx=" + dx + ", dy=" + dy + ", xmin=" + xmin
                + ", xmax=" + xmax + ", ymin=" + ymin + ", ymax=" + ymax + ", health=" + health + ", Enum=" + Enum
                + ", ballPower=" + ballPower + ", arcSize=" + arcSize + ", color=" + color + ", air=" + air + "]";
    }

    

}
