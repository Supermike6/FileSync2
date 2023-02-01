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
        Dinosaur d = new Dinosaur();
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
}
