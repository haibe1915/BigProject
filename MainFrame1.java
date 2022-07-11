
package allAlgo;
import java.util.LinkedList;
import java.math.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import allAlgo.Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MainFrame1 extends JFrame {    

    private static final int FRAME_WIDTH = 900;
    private static final int FRAME_HEIGHT = 600;
    private static final int RODS_WIDTH = 550;
    private static final int RODS_HEIGHT = 400;
    private static final int INITIAL_NUMBER_OF_DISKS = 4;
    private static final int INITIAL_ROD = 0;
    private static final String TITLE = "Towers of Hanoi ";
    private static final String DISK_NUMBER_LABEL = "Select the number of disks:";
    private static int DELAY = 1000;
    private Thread thr;
    
    private JPanel panel;
    private JPanel panelControl;
    private JPanel panelHistory;
    private JButton nextButton;
    private JButton animateButton;
    private JButton btmenu;
    
    private JLabel diskNumberLabel,MH,N,Sp;
    public JComboBox<Integer> diskNumberSelection;
    public JComboBox<Integer> delaySelection;
    public JComboBox<String> history;
    private JComponent mainComponent;
    private Rods rods;
    private Timer timer;
    public LinkedList<Integer> movesToSolve;
    private JTextArea txt ;    
    private int cnt=1;
    
    public MainFrame1() {
        rods = new Rods(INITIAL_NUMBER_OF_DISKS, INITIAL_ROD);
        createComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("icon.png"));
		setIconImage(icon);
        setTitle(TITLE);
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setVisible(true);
        setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
    }
    
        private void createComponents() {
        	
        timer = new Timer(DELAY, new AnimationListener());
        nextButton = new JButton("Next");
        animateButton = new JButton("Animate");
        nextButton.addActionListener(new NextButtonListener());
        animateButton.addActionListener(new AnimateButtonListener());
        
        history = new JComboBox();
        history.setPreferredSize(new Dimension(250,20));
        
        txt = new JTextArea("Number of disk: 4\n",20,25);
        JScrollPane jScrollPane = new JScrollPane(txt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        panel = new JPanel();
        panelControl = new JPanel();
        panelHistory = new JPanel();
        panelHistory.setPreferredSize(new Dimension(300,400));
        
        mainComponent = new MainComponent(rods);
        
        mainComponent.setPreferredSize(new Dimension(RODS_WIDTH, RODS_HEIGHT));
        
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
       
        panel.add(mainComponent);
               
        diskNumberLabel = new JLabel(DISK_NUMBER_LABEL);
        MH=new JLabel("Moves history: ");
        N=new JLabel("      ");
        Sp=new JLabel("Speed: ");
        diskNumberSelection = new JComboBox<Integer>(new Integer[] {1, 2, 3, 4, 5, 6, 7,8,9,10,11});
        diskNumberSelection.setSelectedItem(4);
        diskNumberSelection.addActionListener(new DiskNumberChoiceListener());
        
        delaySelection = new JComboBox<Integer>(new Integer[] {1, 2, 3, 4, 5});
        delaySelection.setSelectedItem(1);
        delaySelection.addActionListener(new delayChoiceListener());
        
        btmenu = new JButton("Menu");
        
        btmenu.addActionListener(new btmenuChoiceListener());
      
        rods.solveTowersOfHanoi(rods.getRodArray()[INITIAL_ROD].getDisksOnTop().size(), INITIAL_ROD, 1, 2);
        rods.initializeRods((int) diskNumberSelection.getSelectedItem(), INITIAL_ROD);
        this.add(panel);
        FlowLayout fl=new FlowLayout();
        fl.setHgap(10);
        fl.setAlignment(FlowLayout.CENTER);
        panel.setLayout(fl);
        panelControl.setBorder(new EmptyBorder(0, 0, 50, 0));
        panelControl.add(N);
        panelControl.add(diskNumberLabel);
        panelControl.add(diskNumberSelection);
        panelControl.add(Sp);
        panelControl.add(delaySelection);
        panelControl.add(nextButton);
        panelControl.add(animateButton);
        panelControl.add(btmenu);
        panelHistory.add(N);
        panelHistory.add(MH);
        panelHistory.setBorder(new EmptyBorder(20,20,0,20));
        panelHistory.add(jScrollPane);
        add(panel,BorderLayout.CENTER);
        add(panelControl,BorderLayout.PAGE_END);
        add(panelHistory,BorderLayout.EAST);       
        
    }
    
    private class NextButtonListener extends Thread implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) { 
            movesToSolve = rods.getMovesToSolve();
            
            if (!movesToSolve.isEmpty()) {
            	for(int i=0;i<10;i++) {
            	((MainComponent) mainComponent).y++;
            	
            	((MainComponent) mainComponent).update();
            	}
            	
               rods.moveDisk(movesToSolve.removeFirst(), movesToSolve.removeFirst());   	
               ((MainComponent) mainComponent).update();
               
            }
            else return;
            history.addItem(rods.ntc);
            txt.append(rods.ntc);
            cnt++;
            ((MainComponent) mainComponent).y=0;
        }
    }
    
    private class AnimateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            timer.start();
        }
    }
    
    private class AnimationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            movesToSolve = rods.getMovesToSolve();
            if (!movesToSolve.isEmpty()) {
                rods.moveDisk(movesToSolve.removeFirst(), movesToSolve.removeFirst());
                
                	((MainComponent) mainComponent).update();                	               
            } 
            else return;
            history.addItem(rods.ntc);
            txt.append(rods.ntc);
            cnt++;
        }
    } 
    
    
    private class btmenuChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        	Menu menu = new Menu();
        	setVisible(false);
        }
    } 
    
    private class delayChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
        	String str = String.valueOf(delaySelection.getSelectedItem());
        	int x = Integer.parseInt(str);
        	if(x==1) DELAY = 1000;
        	if(x==2) DELAY = 250;
        	if(x==3) DELAY = 150;
        	if(x==4) DELAY = 50;
        	if(x==5) DELAY = 1;

            timer.stop();
            timer = new Timer(DELAY, new AnimationListener());
            cnt=1;
            rods = new Rods((int) diskNumberSelection.getSelectedItem(), INITIAL_ROD);
            ((MainComponent) mainComponent).updateRods(rods);
            history.removeAllItems();
            txt.setText("Number of disk: "+rods.getRodArray()[INITIAL_ROD].getDisksOnTop().size()+"\n");
            rods.solveTowersOfHanoi(rods.getRodArray()[INITIAL_ROD].getDisksOnTop().size(), INITIAL_ROD, 1, 2);
            rods.initializeRods((int) diskNumberSelection.getSelectedItem(), INITIAL_ROD);
        }
    } 
    
    private class DiskNumberChoiceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            timer.stop();
            timer = new Timer(DELAY, new AnimationListener());
            cnt=1;
            rods = new Rods((int) diskNumberSelection.getSelectedItem(), INITIAL_ROD);
            ((MainComponent) mainComponent).updateRods(rods);
            history.removeAllItems();
            txt.setText("Number of disk: "+rods.getRodArray()[INITIAL_ROD].getDisksOnTop().size()+"\n");
            rods.solveTowersOfHanoi(rods.getRodArray()[INITIAL_ROD].getDisksOnTop().size(), INITIAL_ROD, 1, 2);
            rods.initializeRods((int) diskNumberSelection.getSelectedItem(), INITIAL_ROD);
        }
    } 
    public int getDisk() {
    	return (int)diskNumberSelection.getSelectedItem();
    }
 
}