/**
 * The main component, where the objects are drawn.
 * @author EFE ACER
 * @version 1.0
 */
package allAlgo;
import javax.swing.JComponent;
import javax.swing.Timer;
import java.util.Stack;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainComponent extends JComponent {
    //Constants
    private static final Color[] COLOR_ARRAY = {Color.BLUE, Color.CYAN, Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED,
    		Color.PINK, Color.GRAY, Color.DARK_GRAY, Color.MAGENTA , Color.LIGHT_GRAY, Color.blue};
    private static final int X_START = 50;
    private static final int X_END = 500;
    private static final int Y_END = 300;
    private static final int ROD_LENGTH = 200;
    private static final int ROD_GAP = 150;
    private static final int SIDE_GAP = 75;
    private static final int THICKNESS = 3;
    private static final int STRING_ADJUST = 30;
	
    
    private Rods rods;
    public int x=0,y=0;
    
    public MainComponent(Rods rods) {
        this.rods = rods;
    }
    public void update() {
    	removeAll();
        revalidate();
        repaint();
        
    }
    
    public void updateRods(Rods newRods) {
        rods = newRods;
        removeAll();
        revalidate();
        repaint();
    }

    public void paintComponentAni(Graphics g) {
        paintRods(g);
        
        Rod[] rodArray =  rods.getRodArray();
        for (int i = 0; i < rodArray.length; i++) {
            Stack<Disk> disksOnTop  = rodArray[i].getDisksOnTop();
            for (int j = 0; j < disksOnTop.size(); j++) {
                paintDisk(disksOnTop.get(j), i, 1 + j, g);
            }
        } 
        
        g.setColor(Color.GRAY);
        g.drawString("start", X_START + SIDE_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST);
        g.drawString("spare", X_START + SIDE_GAP + ROD_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST);
        g.drawString("destination", X_END - SIDE_GAP - STRING_ADJUST, Y_END + STRING_ADJUST);
    }
    public void paintComponent(Graphics g) {
        paintRods(g);
        
        Rod[] rodArray =  rods.getRodArray();
        for (int i = 0; i < rodArray.length; i++) {
            Stack<Disk> disksOnTop  = rodArray[i].getDisksOnTop();
            for (int j = 0; j < disksOnTop.size(); j++) {
            	 paintDiskAni(disksOnTop.get(j), i, 1 + j, g,y);
            }
        } 
        
        g.setColor(Color.GRAY);
        g.drawString("start", X_START + SIDE_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST);
        g.drawString("spare", X_START + SIDE_GAP + ROD_GAP - STRING_ADJUST / 2, Y_END + STRING_ADJUST);
        g.drawString("destination", X_END - SIDE_GAP - STRING_ADJUST, Y_END + STRING_ADJUST);
    }
    
    private void paintRods(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(THICKNESS));
        g.setColor(Color.DARK_GRAY);
        
        g.drawLine(X_START, Y_END, X_END, Y_END);
        g.drawLine(X_START + SIDE_GAP, Y_END - ROD_LENGTH, X_START + SIDE_GAP, Y_END);
        g.drawLine(X_START + SIDE_GAP + ROD_GAP, Y_END - ROD_LENGTH, X_START + SIDE_GAP + ROD_GAP, Y_END);
        g.drawLine(X_END - SIDE_GAP, Y_END - ROD_LENGTH, X_END - SIDE_GAP, Y_END);
    }

    private void paintDisk(Disk toDraw, int rodNumber, int order, Graphics g) {
        int diskSize = toDraw.getSize();
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(THICKNESS - 1));
        g.setColor(Color.BLACK);
        
        g.drawRect(X_START + SIDE_GAP + ROD_GAP * rodNumber - ((2*diskSize-(diskSize-6)) * Disk.THICKNESS / 4),Y_END - Disk.THICKNESS * order, (2*diskSize-(diskSize-6)) * Disk.THICKNESS/2, Disk.THICKNESS-1);
        //g.setColor(Color.ORANGE);
        g.setColor(COLOR_ARRAY[COLOR_ARRAY.length - diskSize-5]);
        g.fillRect(X_START + SIDE_GAP + ROD_GAP * rodNumber - ((2*diskSize-(diskSize-6)) * Disk.THICKNESS / 4), Y_END - Disk.THICKNESS * order, (2*diskSize-(diskSize-6)) * Disk.THICKNESS/2, Disk.THICKNESS-1);
    }
    private void paintDiskAni(Disk toDraw, int rodNumber, int order, Graphics g, int y) {
        int diskSize = toDraw.getSize();
        Graphics2D g2D = (Graphics2D) g;
        g2D.setStroke(new BasicStroke(THICKNESS - 1));
        g.setColor(Color.BLACK);
        g.drawRect(X_START + SIDE_GAP + ROD_GAP * rodNumber - ((2*diskSize-(diskSize-6)) * Disk.THICKNESS / 4),Y_END - Disk.THICKNESS * (order+y), (2*diskSize-(diskSize-6)) * Disk.THICKNESS/2, Disk.THICKNESS-1);
        //g.drawString(diskSize+4+"", X_START + SIDE_GAP + ROD_GAP * rodNumber - ((2*diskSize-(diskSize-6)) * Disk.THICKNESS / 4)-11, Y_END - Disk.THICKNESS * (order+y));
        
        g.setColor(COLOR_ARRAY[COLOR_ARRAY.length - diskSize-5]);
        g.fillRect(X_START + SIDE_GAP + ROD_GAP * rodNumber - ((2*diskSize-(diskSize-6)) * Disk.THICKNESS / 4), Y_END - Disk.THICKNESS * (order+y), (2*diskSize-(diskSize-6)) * Disk.THICKNESS/2, Disk.THICKNESS-1);
        
        }
}