package APCompsci.Classwork.PictureLab;

import java.awt.Color;

public class Pixel
{
    int Red,Green,Blue,Alpha;
    public Pixel(int r, int g, int b, int a) {
        this.Red = r;
        this.Green = g;
        this.Blue = b;
        this.Alpha = a;
    }
    public Pixel(int r, int g, int b) {
        this.Red = r;
        this.Green = g;
        this.Blue = b;
    }

    public Color getColor() {
        return new Color(Red,Green,Blue,Alpha);
    }

    public void setColor(int r, int g, int b) {
        this.Red = r;
        this.Green = g;
        this.Blue = b;
    }
    public void setToGray() {
        int avg = (this.Red+this.Green+this.Blue)/3;
        this.Red = avg;
        this.Green = avg;
        this.Blue = avg;
    }
    public void setToEven() {
        if(Red%2==1) Red--;
        if(Green%2==1) Green--;
        if(Blue%2==1) Blue--;
        Red = Red - Red % 2;
    }
    public void setNegative() {
        this.Red = 255-Red;
        this.Green = 255-Green;
        this.Blue = 255-Blue;
    }
    public double colorDistance(Color c)
    {
        return Math.sqrt(Math.pow(c.getRed()-this.Red,2)+Math.pow(c.getGreen()-this.Green,2)+Math.pow(c.getBlue()-this.Blue,2));
    }
    
    public int getRed() {
        return this.Red;
    }

    public void setRed(int r) {
        this.Red = r;
    }

    public int getGreen() {
        return this.Green;
    }

    public void setGreen(int g) {
        this.Green = g;
    }

    public int getBlue() {
        return this.Blue;
    }

    public void setBlue(int b) {
        this.Blue = b;
    }

    public int getAlpha() {
        return this.Alpha;
    }

    public void setAlpha(int a) {
        this.Alpha = a;
    }


    @Override
    public String toString() {
        return "{" +
            " r='" + getRed() + "'" +
            ", g='" + getGreen() + "'" +
            ", b='" + getBlue() + "'" +
            ", a='" + getAlpha() + "'" +
            "}";
    }

    
}
