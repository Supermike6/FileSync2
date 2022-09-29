package Homework; 

public class ProductTester_StandardArray
{
    public static void main(String[] args)
    {
        int numProducts = 100;

        Product p1 = new Product("iPhone", 800);
        Product p2 = new Product("iPhone", 800);

        Product[] products = new Product[numProducts];
        for (int i = 0; i < numProducts; i++)
        {
            products[i] = new Product();
        }

        for(int i = 0; i<products.length; i++)
        {
            System.out.println(products.sortByName().get(i).toString());
        }
    }
}