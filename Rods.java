/**
 * This class represents the Rods consisting of three seperate Rod with disks on top. It involves
 * methods to move the disks from one rod to another in certain patterns.
 * @author EFE ACER
 * @version 1.0
 */
package allAlgo;
import java.util.Stack;
import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.*;
public class Rods {
    private static final int NUMBER_OF_RODS = 4;
    private int cnt=1;
    private Rod[] rodArray;
    private LinkedList<Integer> movesToSolve;
    public String ntc;
    public Graphics grp;
    
    public Rods(int numberOfDisks, int initialRod) {
        Rod initial = new Rod(numberOfDisks);
        rodArray = new Rod[NUMBER_OF_RODS];
        for (int i = 0; i < NUMBER_OF_RODS; i++) {
            if (i == initialRod) {
                rodArray[i] = initial;
            } else { 
                rodArray[i] = new Rod();
            }
        }
        rodArray[initialRod] = initial;
        movesToSolve = new LinkedList<Integer>(); 
    }
    
    public void initializeRods(int numberOfDisks, int initialRod) {
        Rod initial = new Rod(numberOfDisks);
        rodArray = new Rod[NUMBER_OF_RODS];
        for (int i = 0; i < NUMBER_OF_RODS; i++) {
            if (i == initialRod) {
                rodArray[i] = initial;
            } else { 
                rodArray[i] = new Rod();
            }
        }
        rodArray[initialRod] = initial;
    }
    
    public Rod[] getRodArray() {
        return rodArray;
    }
    
    public void moveDisk(int from, int destination) {
        Stack<Disk> fromStack = rodArray[from].getDisksOnTop();
        String a="Start",b="Start";
        switch (from) {
        case 0:
        	{
        		a=	"Start";
        		break;
        	}
        case 1:{
        	a="Spare";
        	break;
        	}
        case 2:{
        	a="Destination";
        	break;
        	}
        }
        switch (destination) {
        case 0:
        	{
        		b=	"Start";
        		break;
        	}
        case 1:{
        	b="Spare";
        	break;
        	}
        case 2:{
        	b="Destination";
        	break;
        	}
        }
        if (fromStack.isEmpty()) {
        	
            return;
           
        } else {
        	ntc=cnt+". Move a disk"+" from rod "+ a + " to rod "+b+"\n";
            rodArray[destination].getDisksOnTop().push(fromStack.pop());
        }        
        cnt++;
    }
    public void moveDiskTmp(int from, int destination) {
        Stack<Disk> fromStack = rodArray[from].getDisksOnTop();
        if (!fromStack.isEmpty()) {
        	
            rodArray[destination].getDisksOnTop().push(fromStack.pop());
           
        } else {
            System.out.println("Rod is empty, no disks to move...");
        }        
        
    }
    
    public void solveTowersOfHanoi(int disksOnTop, int from, int spare, int destination) {
        if (disksOnTop >= 1) {
        	
            solveTowersOfHanoi(disksOnTop - 1, from, destination, spare);
            moveDiskTmp(from, destination);
            movesToSolve.addLast(from);
            movesToSolve.addLast(destination);
            
            solveTowersOfHanoi(disksOnTop - 1, spare, from, destination);
        } 
    }
    
    public LinkedList<Integer> getMovesToSolve() {
        return movesToSolve;
    }
    public String getNtc() {
    	return ntc;
    }
}