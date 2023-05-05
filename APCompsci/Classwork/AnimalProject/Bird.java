package APCompsci.Classwork.AnimalProject;

public class Bird extends Pet
{
    public boolean exotic;

    public Bird()
    {
        this.name = "Default Bird";
        this.birthday = "01-01-2016";
        this.weight = 0.0;
        this.exotic = false;
    }

    public Bird(boolean exotic)
    {
        this.name = "Default Bird";
        this.birthday = "01-01-2016";
        this.weight = 0.0;
        this.exotic = exotic;
    }

    public Bird(String name)
    {
        this.name = name;
        this.birthday = "01-01-2016";
        this.weight = 0.0;
        this.exotic = false;
    }

    public Bird(String name, String bdate, double weight, boolean exotic)
    {
        this.name = name;
        this.birthday = bdate;
        this.weight = weight;
        this.exotic = exotic;
    }

    @Override
    public void feed()
    {
        System.out.println(this.name+" eating bird food.");
    }

    @Override
    public void groom()
    {
        System.out.println(this.name+" taking a bird bath and filing beak.");
    }

    @Override
    public void checkUp()
    {
        System.out.println(this.name+" getting bird parts examined.");
    }



    @Override
    public String toString() {
        return "[Species: bird, Born: "+this.birthday+", Weight: "+this.weight+"][Name: "+this.name+"][Exotic: " + exotic + "]";
    }

}
