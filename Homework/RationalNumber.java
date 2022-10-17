package Homework;

import java.util.ArrayList;

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

    public String getRationalForm() {
        if(this.getB()==1) return this.getA()+"";

        return this.getA()+"/"+this.getB();
    }

    public RationalNumber getReciprocal() {
        return new RationalNumber(this.getB(), this.getA());
    }

    public void simplify()
    {
        int i;
        int num = this.getB();
        for(i = this.getB(); i>0;i--)
        {
            if((this.getA()+0.00/i)%1==0 && (this.getA()+0.00/i)<num)
            {
                num = (int)(this.getA()+0.00/i);
                this.setA(num);
                this.setB(i);
            }   
        }
        
    }

    public int GCD(int a, int b){
        if (b==0) return a;
        return GCD(b,a%b);
    }

    public void sort(ArrayList<RationalNumber> rns)
    {
        ArrayList<RationalNumber> out = new ArrayList<RationalNumber>();
            
    }
    
    public boolean equals(RationalNumber rn)
    {
        return (this.getA()==rn.getA())&&(this.getB()==rn.getB());
    }

}
