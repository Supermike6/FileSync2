package Classes;

import java.util.ArrayList;

public class CoalMine
{
    private Elevator elevator;
    private ArrayList<Transport> transports;
    private static ArrayList<level> levels;
    private ArrayList<level> levelsWorking;
    private ArrayList<level> levelsIdle;
    private int presteige;
    private int yOffset = 0;

    public CoalMine(Elevator elevator, ArrayList<Transport> transports, ArrayList<level> levels, ArrayList<level> levelsWorking, ArrayList<level> levelsIdle, float presteige)
    {
        this.elevator = elevator;
        this.transports = transports;
        this.levels = levels;
        this.levelsWorking = levelsWorking;
        this.levelsIdle = levelsIdle;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public ArrayList<Transport> getTransports() {
        return transports;
    }

    public void setTransports(ArrayList<Transport> transports) {
        this.transports = transports;
    }

    public static ArrayList<level> getLevels() {
        return levels;
    }

    public static void setLevels(ArrayList<level> l) {
        levels = l;
    }

    public ArrayList<level> getLevelsWorking() {
        return levelsWorking;
    }

    public void setLevelsWorking(ArrayList<level> levelsWorking) {
        this.levelsWorking = levelsWorking;
    }

    public ArrayList<level> getLevelsIdle() {
        return levelsIdle;
    }

    public void setLevelsIdle(ArrayList<level> levelsIdle) {
        this.levelsIdle = levelsIdle;
    }
    
   
}
