package Homework; 

import java.util.ArrayList;

public class ProductTester_ArrayList
{
    public static void main(String[] args)
    {
        int numProducts = 100;

        Product p1 = new Product("iPhone", 800);
        Product p2 = new Product("iPhone", 800);
        Product p3 = new Product();

        ArrayList<Product> products = new ArrayList<Product>();
        for (int i = 0; i < numProducts; i++)
        {
            products.add(new Product());
        }
        // for(int i = 0; i<products.size(); i++)
        // {
        //     System.out.println(p1.sortByNameA(products).get(i).toString());
        // }
        for(int i = 0; i<p1.removeDuplicatesA(products).size(); i++)
        {
            if(p1.removeDuplicatesA(products).get(i) != null)
            {
                System.out.println(p1.removeDuplicatesA(products).get(i).toString());
            }
        }
    }
}
