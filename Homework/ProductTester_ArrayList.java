package Homework; 

import java.util.ArrayList;
import java.util.Collections;
import Homework.Product;

public class ProductTester_ArrayList
{
    public static void main(String[] args)
    {
        int numProducts = 30;

        Product p1 = new Product("iPhone", 800);
        Product p2 = new Product("iPhone", 800);
        Product p3 = new Product();

        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < numProducts; i++)
        {
            products.add(new Product());
        }
        for(int i = 0; i<products.size(); i++)
        {
            System.out.println(p1.sortByNameA(products).get(i).toString());
        }
    }
}
