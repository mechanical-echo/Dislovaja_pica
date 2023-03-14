
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class order extends JFrame implements ActionListener{
	
	JRadioButton s, m, l, thick, thin;
	//big panels
	JPanel textFieldPanel = new JPanel();
	JPanel pizzaPanel = new JPanel();
	JPanel orderPanel = new JPanel();
	JPanel orderButtonPanel = new JPanel();
	JPanel MainPanel = new JPanel();
	//subpanels
	JPanel labels = new JPanel();
	JPanel fields = new JPanel();
	//radiobuttons
	//pizzas
	JRadioButton peperoni = new JRadioButton();
	JRadioButton studenta = new JRadioButton();
	JRadioButton vezuva = new JRadioButton();
	JRadioButton grieku = new JRadioButton();
	JRadioButton margarita = new JRadioButton();
	public order(){
		setTitle("Pasûtît picu");
		int x=500, y=440;
		setSize(x, x);
		setLocation(1920/2-x/2, 1080/2-y/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		
		MainPanel.setLayout(new GridLayout(2,2));
		textFieldPanel.setLayout(new FlowLayout());
		orderPanel.setLayout(new FlowLayout());
		orderButtonPanel.setLayout(new FlowLayout());
		
		textFieldPanel.setBorder(border);
		pizzaPanel.setBorder(border);
		orderPanel.setBorder(border);
		orderButtonPanel.setBorder(border);
		
		MainPanel.add(textFieldPanel);
		MainPanel.add(pizzaPanel);
		MainPanel.add(orderPanel);
		MainPanel.add(orderButtonPanel);
		
		add(MainPanel);
		/*
		 * 
		 */
		
		labels.setLayout(new GridLayout(4,1));
		fields.setLayout(new GridLayout(4,1));
		JTextField vards = new JTextField(10);
		JTextField numurs = new JTextField(10);
		JTextField adrese = new JTextField(10);
		JTextField epasts = new JTextField(10);
		
		JLabel ievadiVardu  = new JLabel("Jûsu vârds: ");
		JLabel ievadiNumuru = new JLabel("Tal. numurs:");
		JLabel ievadiAdresi = new JLabel("Jûsu adrese:");
		JLabel ievadiEpastu = new JLabel("Jûsu epasts:");
		labels.add(ievadiVardu);
		fields.add(vards);
		labels.add(ievadiNumuru);
		fields.add(numurs);
		labels.add(ievadiAdresi);
		fields.add(adrese);
		labels.add(ievadiEpastu);
		fields.add(epasts);
		
		textFieldPanel.add(labels);
		textFieldPanel.add(fields);
		/*
		 * 
		 */
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
