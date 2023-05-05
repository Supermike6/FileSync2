package APCompsci.Classwork.AnimalProjectAbstract;

public class Dog extends Pet
{
    public int liscenseNumber;
    private static int nextLicense = 10000;

    

    public Dog(String name, String bdate, int weight)
    {
        super("dog", bdate, weight, name);
        this.liscenseNumber = nextLicense;
        nextLicense++;
    }

    public Dog()
    {
        super("dog", "01-01-2016", 0.0, "Default Dog");
        this.liscenseNumber = nextLicense;
        nextLicense++;
    }

    public Dog(String name)
    {
        super("dog", "01-01-2016", 0.0, name);
        this.liscenseNumber = nextLicense;
        nextLicense++;
    }

    @Override
    public void feed()
    {
        System.out.println(this.name+" eating dog food.");
    }

    @Override
    public void groom()
    {
        System.out.println(this.name+" getting a bath and clipping nails.");
    }

    @Override
    public void checkUp()
    {
        System.out.println(this.name+" getting dog stuff examined.");
    }

    @Override
    public String toString() {
        return super.toString()+"[License# "+this.liscenseNumber+"]";
    }

    


}
