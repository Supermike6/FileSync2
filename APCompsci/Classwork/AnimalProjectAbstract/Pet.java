package APCompsci.Classwork.AnimalProjectAbstract;

public abstract class Pet extends Animal
{
    protected String name;

    public Pet(String species, String birthday, double weight, String name) {
        super(species, birthday, weight);
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString()+"[Name: " + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    
}
  