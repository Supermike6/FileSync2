package Classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.Timer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import Classes.*;

public class Elevator implements Structure
{
    private Manager manager;
    private BigInteger level;
    private BigInteger totalTransportation;
    private BigInteger capacity;
    private Float speed;
    private BigInteger loadingSpeed;
    private Outfit outfit;
    private String state;
    private Float timingNum;
    private int currentFloor;

    public Elevator(Manager manager, BigInteger level, BigInteger capacity, Float speed,
            BigInteger loadingSpeed, Outfit outfit) {
        this.manager = manager;
        this.level = level;
        this.totalTransportation = totalTransportation;
        this.capacity = capacity;
        this.speed = speed;
        this.loadingSpeed = loadingSpeed;
        this.outfit = outfit;
    }

    @Override
    public Manager getManager() {
        return manager;
    }

    @Override
    public void setManager(Manager m) {
        
    }

    @Override
    public BigInteger getLevel() {
        return level;
    }

    @Override
    public void setLevel(BigInteger l) {
       this.level = l; 
    }

    @Override
    public BigInteger getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(BigInteger c) {
       capacity = c;
    }

    @Override
    public Outfit getOutfit() {
        return outfit;
    }

    @Override
    public void setOutfit(Outfit o) {
        outfit = o;
    }
    
    public void run() throws InterruptedException {
        int i = 0;
        for(i = 0; i < CoalMine.getLevels().size(); i++) {
            state = "starting to move down for: "+1/speed;
            System.out.println(state);
            Thread.sleep((long)(1000/speed));
            state = "finished moving down for: "+1/speed;
            System.out.println(state);
            state = "starting to obtain material from level: "+(i+1)+" for:" +CoalMine.getLevels().get(i).getStoredMoney().divide(loadingSpeed);
            System.out.println(state);
            Thread.sleep((long)(CoalMine.getLevels().get(i).getStoredMoney().divide(loadingSpeed).multiply(BigInteger.valueOf(1000)).floatValue()));
            state = "finished obtaining material from level: "+(i+1)+" for:" +CoalMine.getLevels().get(i).getStoredMoney().divide(loadingSpeed);
            System.out.println(state);
        }
        System.out.println(i);
        state = "Strating to move up for: "+i/speed;
        System.out.println(state);
        Thread.sleep((long)(1000*i/speed));
        state = "Fnished moving up for: "+i/speed;
        System.out.println(state);
    }

    @Override
    public String toString() {
        return "Elevator [manager=" + manager + ", level=" + level + ", totalTransportation="
                + totalTransportation + ", capacity=" + capacity + ", speed=" + speed + ", loadingSpeed=" + loadingSpeed
                + ", outfit=" + outfit + ", state=" + state + ", timingNum=" + timingNum + "]";
    }

    

}
