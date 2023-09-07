package Classes;

import java.math.BigInteger;

public class Transport implements Structure
{
    private Manager manager;
    private BigInteger level;
    private BigInteger totalTransportation;
    private int transporters;
    private BigInteger capacity;
    private BigInteger loadingSpeed;
    private Float walkinSpeed;
    private Outfit outfit;
    private String state;
   
    public void run() throws InterruptedException {

    }

    @Override
    public Manager getManager() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getManager'");
    }

    @Override
    public void setManager(Manager m) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setManager'");
    }

    @Override
    public BigInteger getLevel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLevel'");
    }

    @Override
    public void setLevel(BigInteger l) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setLevel'");
    }

    @Override
    public BigInteger getCapacity() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCapacity'");
    }

    @Override
    public void setCapacity(BigInteger c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCapacity'");
    }

    @Override
    public Outfit getOutfit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOutfit'");
    }

    @Override
    public void setOutfit(Outfit o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOutfit'");
    }

    


    public BigInteger getTotalTransportation() {
        return totalTransportation;
    }

    public void setTotalTransportation(BigInteger totalTransportation) {
        this.totalTransportation = totalTransportation;
    }

    public int getTransporters() {
        return transporters;
    }

    public void setTransporters(int transporters) {
        this.transporters = transporters;
    }

    public BigInteger getLoadingSpeed() {
        return loadingSpeed;
    }

    public void setLoadingSpeed(BigInteger loadingSpeed) {
        this.loadingSpeed = loadingSpeed;
    }

    public Float getWalkinSpeed() {
        return walkinSpeed;
    }

    public void setWalkinSpeed(Float walkinSpeed) {
        this.walkinSpeed = walkinSpeed;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
