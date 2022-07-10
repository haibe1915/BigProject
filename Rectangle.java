package allAlgo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Rectangle extends JPanel{
	private List<Integer> numbers;
	
	private static int RED;
	private static int BLUE;
	private static int GREEN;
	
	private static int WIDTH;
	private static int HEIGHT;
	private static int PADDING;
	
	public void paint(Graphics g) {
	    super.paint(g);
	    
	    for(int i=0;i<numbers.size();i++) {
	    	colorRectangle(g,i);
		    g.fillRect(PADDING+WIDTH*i,410-HEIGHT*numbers.get(i),WIDTH,HEIGHT*numbers.get(i));
	    }
	  }

	private void colorRectangle(Graphics g,int i) {
		if(RED==i)
    		g.setColor(Color.red);
    	else if(BLUE==i)
    		g.setColor(Color.blue);
    	else if(GREEN==i)
    		g.setColor(Color.green);
    	else
    		g.setColor(Color.black);
	}

	public Rectangle(List<Integer> nums) {
		this.numbers = nums;
		calculateDimensions();
	}
	
	public void updateNums(int red,int blue,int green) {
		RED=red;
		BLUE=blue;
		GREEN=green;
		repaint();
	}
	
	public void setNums(List<Integer> nums) {
		this.numbers = nums;
		calculateDimensions();
		repaint();
	}

	private void calculateDimensions() {
		HEIGHT=(int) Math.ceil(400/numbers.size());
		WIDTH=(int) Math.ceil(800/numbers.size());
		PADDING=(int) Math.round((850-WIDTH*numbers.size())/2);
	}
}
