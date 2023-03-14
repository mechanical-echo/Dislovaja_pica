
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
	JRadioButton grieku = new JRadioButton("Grie�u");
	JRadioButton margarita = new JRadioButton("Margarita");
	//sizes
	JRadioButton s20 = new JRadioButton("20cm");
	JRadioButton s30 = new JRadioButton("30cm");
	JRadioButton s50 = new JRadioButton("50cm");
	/////Buttons
	//pizza
	JButton seeDescription = new JButton("Picas apraksts");
	JButton delete = new JButton("No�emt picu");
	JButton sendOrder = new JButton("Pas�t�t");
	JButton addPizza = new JButton("Pievienot picu");
	/////Textarea
	JTextArea orderContents = new JTextArea();
	JScrollPane scroll = new JScrollPane();
	public order(){
		seeDescription.addActionListener(this);
		addPizza.addActionListener(this);
		sendOrder.addActionListener(this);
		delete.addActionListener(this);
		
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
		
		JLabel ievadiVardu  = new JLabel("J�su v�rds: ");
		JLabel ievadiNumuru = new JLabel("Tal. numurs:");
		JLabel ievadiAdresi = new JLabel("J�su adrese:");
		JLabel ievadiEpastu = new JLabel("J�su epasts:");
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
		
		
		/*
		 * 
		 */
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.add(orderContents);
		scroll.setBorder(border);
		JLabel scrollLabel = new JLabel("Pas�t�juma apraksts:");
		scroll.setPreferredSize(new Dimension(200, 100));
		orderPanel.add(scrollLabel);
		orderPanel.add(scroll);
		orderPanel.add(delete);
		/*
		 * 
		 */
		ImageIcon picaPicture = new ImageIcon("pica.png");
		JLabel picture = new JLabel(picaPicture);
		picture.setPreferredSize(new Dimension(200,80));
		addPizza.setPreferredSize(new Dimension(200,30));
		sendOrder.setPreferredSize(new Dimension(200,30));
		
		
		orderButtonPanel.add(picture);
		orderButtonPanel.add(addPizza);
		orderButtonPanel.add(sendOrder);
		/*
		 * 
		 */
		setTitle("Pas�t�t picu");
		int x=500, y=370;
		setSize(x, y);
		setLocation(1920/2-x/2, 1080/2-y/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent button) {
		if(button.getSource()==seeDescription){
			description();
		}else if(button.getSource()==delete){
			//deletePizza();
		}else if(button.getSource()==sendOrder){
//			pasutit();
		}else if(button.getSource()==addPizza){
//			addPizzaToList();
		}
	}
	void description(){
		if(peperoni.isSelected()){
			JOptionPane.showMessageDialog(null, pDesc, "Peperoni pica", JOptionPane.PLAIN_MESSAGE);
		}else
		if(studenta.isSelected()){
			JOptionPane.showMessageDialog(null, stDesc, "Studenta pica", JOptionPane.PLAIN_MESSAGE)	;	
		}else
		if(vezuva.isSelected()){
			JOptionPane.showMessageDialog(null, vDesc, "Vezuva pica", JOptionPane.PLAIN_MESSAGE);
		}else
		if(grieku.isSelected()){
			JOptionPane.showMessageDialog(null, gDesc, "Grie�u pica", JOptionPane.PLAIN_MESSAGE);
		}else
		if(margarita.isSelected()){
			JOptionPane.showMessageDialog(null, mDesc, "Margarita pica", JOptionPane.PLAIN_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Pica nav izv�l�ta", "K��da", JOptionPane.ERROR_MESSAGE);
		}
}
	String pDesc = "\"Pepperoni\" desa, mocarella, k�pin�ts kaus�tais siers, \"Taco\" m�rce, s�polu �ipsi, rukola, tom�tu m�rce, �iploku m�rce, oregano";
	String stDesc = "��i��is, c�si�i, mocarella, tom�tu m�rce, e��as un �iploku m�rce, oregano";
	String vDesc = "��i��is, mocarella, tom�tu m�rce, e��as un �iploku m�rce, oregano";
	String gDesc= "Svaigais siers, spin�ti, sk�b� kr�juma un �iploku m�rce, tom�tu m�rce, mocarella, e��as un �iploku m�rce, oregano";
	String mDesc = "Mocarella, tom�tu m�rce, e��as un �iploku m�rce, oregano";
}
