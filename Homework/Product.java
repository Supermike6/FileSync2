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
        return "Name: " + name + " Price: " + price;

    }

    public boolean equals(Product p)
    {
        return (this.name.equals(p.name) && this.price==p.price);
    }

    //sort by name using standard array
    public Product[] sortByNameS(Product[] products)
    {
        Product temp;
        for(int i = 0; i<products.length; i++)
        {
            for(int j = i+1; j<products.length; j++)
            {
                if(products[i].getName().compareTo(products[j].getName())>0)
                {
                    temp = products[i];
                    products[i] = products[j];
                    products[j] = temp;
                }
            }
        }
        return products;
    }
    //sort by name using ArrayList
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
    
    
    public ArrayList<Product> removeDuplicatesA(ArrayList<Product> products)
    {
        ArrayList<Product> noDuplicates = new ArrayList<Product>();
        ArrayList<Product> sorted = sortByNameA(products);
        for(int i = 0; i<sorted.size(); i++)
        {
            if(i==0)
            {
                noDuplicates.add(sorted.get(i));
            }
            else if(!sorted.get(i).equals(sorted.get(i-1)))
            {
                noDuplicates.add(sorted.get(i));
            }
        }
        return noDuplicates;
    }







    //remove duplicates from standard array
    public Product[] removeDuplicatesS(Product[] products)
    {
        Product[] noDuplicates = new Product[products.length];
        Product[] sorted = sortByNameS(products);
        int count = 0;
        for(int i = 0; i<sorted.length; i++)
        {
            if(i==0)
            {
                noDuplicates[count] = sorted[i];
                count++;
            }
            else if(!sorted[i].equals(sorted[i-1]))
            {
                noDuplicates[count] = sorted[i];
                count++;
            }
        }
        return noDuplicates;
    }

}
