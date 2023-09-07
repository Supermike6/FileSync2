package Classes;

import java.math.BigInteger;

public interface Structure
{
    public Manager getManager();
    public void setManager(Manager m);

    public BigInteger getLevel();
    public void setLevel(BigInteger l);

    public BigInteger getCapacity();
    public void setCapacity(BigInteger c);

    public Outfit getOutfit();
    public void setOutfit(Outfit o);

}
