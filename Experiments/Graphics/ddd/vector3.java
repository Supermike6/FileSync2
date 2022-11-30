package Experiments.Graphics.ddd;

public class vector3
{
    int x;
    int y;
    int z;
    vector3(int x, int y, int z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public String toString() {
        
        return "vector3[x="+x+",y="+y+",z="+z+"]";
    }



}
