package APCompsci.Classwork.infacestuff;

import java.util.ArrayList;

public class TrafficManager
{
    public static void main(String[] args)
    {
        Driveable cw = new ChuckWagon();
        // cw.setHorsePowers(10);
        // System.out.println(cw.getHorsePowers());
        cw.accelerate(5);

        ArrayList<Driveable> traffic = new ArrayList<Driveable>();
        traffic.add(cw);
        traffic.add(new NovaAutoGroup());
        traffic.add(new NovaAutoGroup());
        traffic.add(new Zoomeez());
        traffic.add(new Zoomeez());
        traffic.add(new ChuckWagon());
        
    
    }    
}
