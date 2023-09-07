package Classes;

import java.math.BigInteger;

public class level implements Structure
{
    private Manager manager;
    private BigInteger level;
    private BigInteger totalExtraction;
    private int miners;
    private float walkingSpeed;
    private BigInteger miningSpeed;
    private BigInteger workerCapacity;
    private BigInteger storedMoney;
    private Outfit outfit;
    
    

    

    public level(Manager manager, BigInteger level, BigInteger totalExtraction, int miners, float walkingSpeed,
            BigInteger miningSpeed, BigInteger workerCapacity, BigInteger storedMoney, Outfit outfit) {
        this.manager = manager;
        this.level = level;
        this.totalExtraction = totalExtraction;
        this.miners = miners;
        this.walkingSpeed = walkingSpeed;
        this.miningSpeed = miningSpeed;
        this.workerCapacity = workerCapacity;
        this.storedMoney = storedMoney;
        this.outfit = outfit;
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public void setManager(Manager m) {
        manager = m;
    }

    @Override
    public BigInteger getLevel() {
        return level;
    }

    @Override
    public void setLevel(BigInteger l) {
        level = l;
    }

    @Override
    public BigInteger getCapacity() {
        return workerCapacity;    
    }

    @Override
    public void setCapacity(BigInteger c) {
        workerCapacity = c;
    }

    

    @Override
    public Outfit getOutfit() {
        return outfit;    
    }

    @Override
    public void setOutfit(Outfit o) {
       }

    public BigInteger getMoney() {
        return BigInteger.valueOf(0);
        }

    public void setMoney(BigInteger m) {
       }

    public BigInteger getTotalExtraction() {
        return totalExtraction;
    }

    public int getMiners() {
        return miners;
    }

    public float getWalkingSpeed() {
        return walkingSpeed;
    }

    public BigInteger getMiningSpeed() {
        return miningSpeed;
    }

    public BigInteger getWorkerCapacity() {
        return workerCapacity;
    }

    public BigInteger getStoredMoney() {
        return storedMoney;
    }

    public void setTotalExtraction(BigInteger totalExtraction) {
        this.totalExtraction = totalExtraction;
    }

    public void setMiners(int miners) {
        this.miners = miners;
    }

    public void setWalkingSpeed(float walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public void setMiningSpeed(BigInteger miningSpeed) {
        this.miningSpeed = miningSpeed;
    }

    public void setWorkerCapacity(BigInteger workerCapacity) {
        this.workerCapacity = workerCapacity;
    }

    public void setStoredMoney(BigInteger storedMoney) {
        this.storedMoney = storedMoney;
    }

    
    




}
