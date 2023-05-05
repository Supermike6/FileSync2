package APCompsci.Classwork.AnimalProjectAbstract;

public abstract class Animal implements Careable
{
    protected String species, birthday;
    protected double weight;
    
    public Animal(String species, String birthday, double weight) {
        this.species = species;
        this.birthday = birthday;
        this.weight = weight;
    }

    

    @Override
    public String toString() {
        return "[Species: " + species + ", Birthday: " + birthday + ", Weight: " + weight + "]";
    }



    public String getSpecies() {
        return species;
    }



    public void setSpecies(String species) {
        this.species = species;
    }



    public String getBirthday() {
        return birthday;
    }



    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }



    public double getWeight() {
        return weight;
    }



    public void setWeight(double weight) {
        this.weight = weight;
    }
    

    
}
