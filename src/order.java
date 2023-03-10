
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class order extends JFrame{
	
	JRadioButton s, m, l, thick, thin;
	JPanel panel = new JPanel();
	
	public order(){
		setTitle("Pasûtît picu");
		
		JTextField name,address;
		JPanel namePan = new JPanel();
		JLabel nameLab = new JLabel("Jûsu vârds:");
		namePan.setLayout(new FlowLayout());
		name=new JTextField();   
		name.setPreferredSize(new Dimension(100, 20));
		nameLab.setPreferredSize(new Dimension(70,20));
		namePan.add(nameLab);
		namePan.add(name);
	    add(namePan); 
	    address=new JTextField();  
	    address.setBounds(50,150, 200,30);  
	    add(address);  
	    
	    setLayout(new FlowLayout());
		
	    int x=1920/3, y=1080/3;
	    setSize(x, x);
	    setLocation(1920/2-x/2, 1080/2-y);
	    setVisible(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
