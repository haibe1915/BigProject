package allAlgo;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class Menu extends JFrame {
	public Menu() {
        setTitle("MENU");
        setSize(970,625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        Font font = new Font("Times New Roman", Font.BOLD, 18);
        
        JLabel jl1 = new JLabel();
        JPanel jp2 = new JPanel();

		jl1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(Menu.class.getResource("menu.png"))));
		
		JButton jb1 = new JButton("Tower Of Ha Noi");
		jb1.setFocusable(false);
		JButton jb2 = new JButton("Sorting Visualization");
		jb2.setFocusable(false);
		JLabel jl2 = new JLabel("");
		JLabel jl3 = new JLabel("");

		

		jp2.setLayout(new GridLayout(1,4,40,40));
		jp2.add(jl2);
		jp2.add(jb1);
		jp2.add(jb2);
		jp2.add(jl3);
		
		jb1.setFont(font);
		jb2.setFont(font);

		
		
		
		class jb1ChoiceListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent event) {
	        	MainFrame1 mainFrame = new MainFrame1();
	        	setVisible(false);
	        }
	    } 
		
		class jb2ChoiceListener implements ActionListener {

	        @Override
	        public void actionPerformed(ActionEvent event) {
	        	MainFrame2.getInstance().setVisible(true);
	        	setVisible(false);
	        }
	    } 
		
		jb1.addActionListener(new jb1ChoiceListener());
		jb2.addActionListener(new jb2ChoiceListener());
		
		this.setLayout(new BorderLayout());
		this.add(jl1, BorderLayout.CENTER);	
		this.add(jp2, BorderLayout.SOUTH);	
	    setVisible(true);
    }
}
