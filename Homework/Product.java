package Homework;

import java.util.ArrayList;

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
        price = 100.00;
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

    public String toString()
    { 
        return "Name: " + name+", Price: " + price;
    }

    public boolean equals(Product p)
    {
        return (this.name.equals(p.name) && this.price==p.price);
    }

    //sort by name
    public ArrayList<Product> sortByNameA(ArrayList<Product> products)
    {
        ArrayList<Product> sorted = products;

        for(int i = 0; i<sorted.size(); i++)
        {
            for(int j = 0; j<sorted.size()-1; j++)
            {
                if(sorted.get(j).getName().compareTo(sorted.get(j+1).getName())>0)
                {
                    Product temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1, temp);
                }
            }
        }
        return sorted;
    }
    
}
