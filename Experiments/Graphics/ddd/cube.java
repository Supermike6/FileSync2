package Experiments.Graphics.ddd;

import java.awt.Graphics2D;

public class cube
{
    int l;
    int w;
    int h;
    vector3 v;
    cube(int length, int width, int height, vector3 v3)
    {
        this.l = length;
        this.w = width;
        this.h = height;
        this.v = v3;
    }

    @Override
    public String toString() {
        
        return "cube[length="+l+",width="+w+",height="+h+",v3="+v+"]";
    }
    
    public void drawCube(Graphics2D g2)
    {
        // g2.drawLine(x, y, x, y);
    }
}
