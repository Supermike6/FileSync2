package Homework;

public class RationalNumber implements Comparable<RationalNumber>
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

    public Double asDecimal() {
        return (a/(b+0.0));
    }

    public void add(RationalNumber r2)
    {
        //makes everything have common denominator
        int num1 = this.getB()*r2.getA();
        int num2 = this.getA()*r2.getB();
        //adds the numerators
        this.setA(num1+num2);
        //sets the denominator
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
        //makes everything have common denominator
        int num1 = this.getB()*r2.getA();
        int num2 = this.getA()*r2.getB ();
        //subbtracts
        this.setA(num2-num1);
        //sets new denominator
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
        int num = this.getA();
        int denom = this.getB();
        int gcd = GCD(num, denom);
        this.setA(num/gcd);
        this.setB(denom/gcd);
    }

    public int GCD(int a, int b){
        if (b==0) return a;
        return GCD(b,a%b);
    }

    
    public boolean equals(RationalNumber rn)
    {
        //checks if the simplified fractions are equal
        this.simplify();
        rn.simplify();
        if(this.getA()==rn.getA() && this.getB()==rn.getB()) return true;
        return false;
    }

    @Override
    public int compareTo(RationalNumber rn) {
        if(this.asDecimal()>rn.asDecimal()) return 1;
        if(this.asDecimal()<rn.asDecimal()) return -1;
        return 0;
    }

}
