package Homework;

public class Product
{
    private String name;
    private double price;
    Product()
    {
        name = "";
        price = 0.0;
    }
    Product(String name, double price)
    {
        this.name = name;
        this.price = price;
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


    public void printCard()
    {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
    
}
