package Homework;

public class RationalNumber
{
    private Integer a;
    private Integer b;
    RationalNumber(int nume, int denom)
    {
        this.a = nume;
        this.b = denom;
    }

    @Override
    public String toString()
    {
        return "RationalNumber [numerator = "+a+", denominator = "+b+"]";
    }

    public String asDecimal() {
        return (a/(b+0.0))+"";
    }

    public void add(RationalNumber r2)
    {
        int num1 = this.getB()*r2.getA();
        int num2 = this.getA()*r2.getB();
        this.setA(num1+num2);
        this.setB(this.getB()*r2.getB());
    }

    public Integer getA() {
        return this.a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return this.b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public void subtract(RationalNumber r2)
    {
        int num1 = this.getB()*r2.getA();
        int num2 = this.getA()*r2.getB ();
        this.setA(num2-num1);
        this.setB(this.getB()*r2.getB());
    }

    public void multiply(RationalNumber r2)
    {
        this.setA(this.getA()*r2.getA());
        this.setB(this.getB()*r2.getB());
    }

    public void divide(RationalNumber r2)
    {
        int num1 = this.getB()*r2.getA();
        int num2 = this.getA()*r2.getB();
        this.setA(num2);
        this.setB(num1);
    }

}
