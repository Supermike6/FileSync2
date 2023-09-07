import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;

import Classes.CoalMine;
import Classes.Elevator;
import Classes.Manager;
import Classes.Outfit;
import Classes.level;

public class ElevatorMineSimulation {
    public static void main(String[] args) {
        // Create an ExecutorService with a thread pool
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Elevator elevator = new Elevator(new Manager(), BigInteger.valueOf(1), BigInteger.valueOf(164), 2.9f, BigInteger.valueOf(10), new Outfit());
        
        ArrayList<level> tempL = new ArrayList<level>();
        tempL.add(new level(new Manager(), BigInteger.valueOf(1), BigInteger.valueOf(10), 2, 1.3f, BigInteger.valueOf(4), BigInteger.valueOf(8), BigInteger.valueOf(10), new Outfit()));
        tempL.add(new level(new Manager(), BigInteger.valueOf(2), BigInteger.valueOf(100), 5, 1.5f, BigInteger.valueOf(40), BigInteger.valueOf(80), BigInteger.valueOf(100), new Outfit()));
        CoalMine.setLevels(tempL);


        
        // Runnable for elevator simulation
        Runnable elevatorSimulation = () -> {
            try {
                elevator.run();
            } catch (InterruptedException e){}
            System.out.println("Elevator simulation completed.");
        };
        
        // Runnable for mine simulation
        Runnable mineSimulation = () -> {
            try {
                Thread.sleep((long)(500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Mine simulation completed.");
        };

        Runnable transportSimulation = () -> {
            // try {
            //     transportation.run();
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
            System.out.println("Transport simulation completed.");
        };
        
        // Submit tasks to the executor
        executorService.submit(elevatorSimulation);
        executorService.submit(mineSimulation);
        executorService.submit(transportSimulation);
        
        // Continue with graphics or other tasks
        
        // Shutdown the executor when you're done
        executorService.shutdown();
    }
}