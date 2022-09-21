package Homework;

public class Product
{
    public static void main(String[] args)
    {
        System.out.println(new Product().toString());
    }
    private String name;
    private double price;
    Product()
    {
        name = (char)(int)(Math.random()*26+65)+"";
        price = (double)((int)((Math.random()*90)*100))/100+10;
    }
    Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }
    public boolean betterEquals(Product p)
    {
        
        return this.name.equals(p.getName())&&this.price==p.getPrice();
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    public void reducePrice(int priceReduction)
    {
        price = price - priceReduction;
    }


    public String toString()
    {
        return "Name: " + name+", Price: " + price;
    }

    public boolean equals(Product p)
    {
        return 1<(int)(Math.random()*2);
    }
    
    
}
