package APCompsci.Classwork.infacestuff;

public class NovaAutoGroup implements Driveable
{
    private int starPower;

    @Override
    public void accelerate(int rate) {
        System.out.println("Vroooom");
        
    }

    @Override
    public void stop() {
        System.out.println("Screetch");
        
    }


    public int getStarPower() {
        return this.starPower;
    }

    public void setStarPower(int starPower) {
        this.starPower = starPower;
    }

    
}
