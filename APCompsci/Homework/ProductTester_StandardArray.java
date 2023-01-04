package APCompsci.Homework; 

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
            if(p1.removeDuplicatesS(products)[i] != null)
            {
                System.out.println(p1.removeDuplicatesS(products)[i].toString());
            }
        }

    }
}