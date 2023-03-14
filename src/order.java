
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
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
	/////subpanels
	//textfields
	JPanel labels = new JPanel();
	JPanel fields = new JPanel();
	//radiobuttons
	JPanel pizzaButtons = new JPanel();
	JPanel sizeButtons = new JPanel();
	/////radiobuttons
	//pizzas
	JRadioButton peperoni = new JRadioButton("Peperoni");
	JRadioButton studenta = new JRadioButton("Studenta");
	JRadioButton vezuva = new JRadioButton("Vezuva");
	JRadioButton grieku = new JRadioButton("Grieíu");
	JRadioButton margarita = new JRadioButton("Margarita");
	//sizes
	JRadioButton s20 = new JRadioButton("20cm");
	JRadioButton s30 = new JRadioButton("30cm");
	JRadioButton s50 = new JRadioButton("50cm");
	/////Buttons
	//pizza
	JButton seeDescription = new JButton("Picas apraksts");
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
		pizzaButtons.setLayout(new GridLayout(5,1));
		sizeButtons.setLayout(new GridLayout(3,1));
		ButtonGroup pB = new ButtonGroup();
		ButtonGroup sB = new ButtonGroup();
		pB.add(peperoni);
		pB.add(studenta);
		pB.add(vezuva);
		pB.add(grieku);
		pB.add(margarita);
		
		pizzaButtons.add(peperoni);
		pizzaButtons.add(studenta);
		pizzaButtons.add(vezuva);
		pizzaButtons.add(grieku);
		pizzaButtons.add(margarita);
		
		sB.add(s20);
		sB.add(s30);
		sB.add(s50);
		
		sizeButtons.add(s20);
		sizeButtons.add(s30);
		sizeButtons.add(s50);
		
		pizzaPanel.add(pizzaButtons);
		pizzaPanel.add(sizeButtons);
		pizzaPanel.add(seeDescription);
		
		seeDescription.addActionListener(this);
		/*
		 * 
		 */
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
