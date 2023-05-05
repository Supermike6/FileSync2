package APCompsci.Classwork.AnimalProject;

public class Dog extends Pet
{
    public int liscenseNumber;
    private static int nextLicense = 10000;

    

    public Dog(String name, String bdate, int weight)
    {
        this.name = name;
        this.birthday = bdate;
        this.weight = weight;
        this.liscenseNumber = nextLicense;
        nextLicense++;
    }

    public Dog()
    {
        this.name = "Default Dog";
        this.birthday = "01-01-2016";
        this.weight = 0.0;
        this.liscenseNumber = nextLicense;
        nextLicense++;
    }

    public Dog(String name)
    {
        this.name = name;
        this.birthday = "01-01-2016";
        this.weight = 0.0;
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
        return "[Species: dog, Born: "+this.birthday+", Weight: "+this.weight+"][Name: "+this.name+"][License# " + liscenseNumber + "]";
    }

    


}
