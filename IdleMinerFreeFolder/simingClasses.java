
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;

import Classes.Mine;
import Classes.Outfit;
import Classes.Elevator;
import Classes.Manager;
import Classes.Transport;
import Classes.level;


public class simingClasses
{

    

    public static void main(String[] args) throws InterruptedException
    {
        ArrayList<level> levels = new ArrayList<level>();
        ArrayList<level> levelsWorking = new ArrayList<level>();
        ArrayList<level> levelsIdle = new ArrayList<level>();
        ArrayList<Transport> transports = new ArrayList<Transport>();
        Elevator elevator = new Elevator(new Manager(), BigInteger.valueOf(1), BigInteger.valueOf(164), 2.9f, BigInteger.valueOf(10), new Outfit());
        Mine coalMine = new Mine(elevator, transports, levels, levelsWorking, levelsIdle, 1);

        

        elevator.run();

        System.out.println(elevator.toString());



    }
}
