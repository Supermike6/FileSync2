package APCompsci.Classwork.AnimalProjectAbstract;

public class Bird extends Pet
{
    public boolean exotic = false;

    public Bird(String name, String birthday, double weight, boolean exotic) {
        super("bird", birthday, weight, name);
        this.exotic = exotic;
    }

    public Bird() {
        super("bird", "01-01-2016", 0.0, "Default Bird");
    }

    public Bird(String name) {
        super("bird", "01-01-2016", 0.0, "Default Bird");
        this.name = name;
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
        // return "[Species: "+this.species+", Born: "+this.birthday+", Weight: "+this.weight+"][Name: "+this.name+"][Exotic: " + exotic + "]";
        return super.toString()+"[Exotic: "+this.exotic+"]";
    }

}
