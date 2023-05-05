package APCompsci.Classwork.DynoGame;

public class Dinosaur extends Sprite
{
    private int jumpKey, duckKey;
    private boolean jumping, ducking, falling;
    private double gravity, jumpspeed;

    public Dinosaur()
    {
        super(30,100,50,50,0,0);
        jumpKey = 38;
        duckKey = 40;
    
    
    
    }    

    public static void main(String[] args)
    {
        Sprite d = new Dinosaur();
        d.update();
        System.out.println(d);
    }

    public void keyWasPressed(int key)
    {
        if(key == jumpKey)
            this.setDy(-10);
        else if(key == duckKey)
            System.out.println("DUCK!");
    }

    public void keyWasReleased(int key)
    {
        if(key == jumpKey)
            this.setDy(0);
    else if(key == duckKey)
        System.out.println("DUCK!");
    }

    @Override
    public void update()
    {
        if(jumping)
        {
            dy = -1;
            jumping = false;
            falling = true;
        } else if(falling)
        {
            dy+= 0.5;
        }

        if(y>200)
        {
            y=200;
            falling = false;
            dy=0;
        }

        y+=dy;
    }
}
