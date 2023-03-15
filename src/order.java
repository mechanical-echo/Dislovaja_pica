
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
	JRadioButton grieku = new JRadioButton("Grieíu");
	JRadioButton margarita = new JRadioButton("Margarita");
	//sizes
	JRadioButton s20 = new JRadioButton("20cm");
	JRadioButton s30 = new JRadioButton("30cm");
	JRadioButton s50 = new JRadioButton("50cm");
	/////Buttons
	//pizza
	JButton seeDescription = new JButton("Picas apraksts");
	JButton delete = new JButton("Noòemt picu");
	JButton sendOrder = new JButton("Pasûtît");
	JButton addPizza = new JButton("Pievienot picu");
	/////Textarea
	JTextArea orderContents = new JTextArea();
	JScrollPane scroll = new JScrollPane(orderContents);
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
		
		
		/*
		 * 
		 */
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	
		orderContents.setPreferredSize(new Dimension(220,100));
	    orderContents.setEditable(false);
	    orderContents.setBorder(border);
		scroll.setBorder(border);
		JLabel scrollLabel = new JLabel("Pasûtîjuma apraksts:");
		
//		scroll.setPreferredSize(new Dimension(300, 150));
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
		setTitle("Pasûtît picu");
		int x=500, y=370;
		setSize(x, y);
		setLocation(1920/2-x/2, 1080/2-y/2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	ArrayList<Pica> orderList = new ArrayList<Pica>();
	@Override
	public void actionPerformed(ActionEvent button) {
		if(button.getSource()==seeDescription){
			description();
		}else if(button.getSource()==delete){
			//deletePizza();
		}else if(button.getSource()==sendOrder){
//			pasutit();
		}else if(button.getSource()==addPizza){
			addPizzaToList();
		}
	}
	double[] peperoniCenas = {7.39, 12.99, 21.99};
	double[] studentaCenas = {6.59, 11.99, 18.99};
	double[] vezuvaCenas =   {6.59, 11.99, 18.99};
	double[] griekuCenas =   {6.59, 11.99, 18.99};
	double[] margaritaCenas= {4.19, 7.69,  13.99};
	double[][] cenas = {peperoniCenas, studentaCenas, vezuvaCenas, griekuCenas, margaritaCenas}; 
	void addPizzaToList(){
		String name;
		int size, i;
		double price;
		if(peperoni.isSelected()){
			name = "Peperoni"; i =0;
		}else
		if(studenta.isSelected()){
			name = "Studenta";i =1;
		}else
		if(vezuva.isSelected()){
			name = "Vezuva";i =2;
		}else
		if(grieku.isSelected()){
			name = "Grieíu";i =3;
		}else
		if(margarita.isSelected()){
			name = "Margarita";i =4;
		}else{
			JOptionPane.showMessageDialog(null, "Pica nav izvçlçta", "Kïûda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(s20.isSelected()){
			size = 20;price = cenas[i][0];
		}else
		if(s30.isSelected()){
			size = 30;price = cenas[i][1];
		}else
		if(s50.isSelected()){
			size = 50;price = cenas[i][2];
		}else{
			JOptionPane.showMessageDialog(null, "Izmçrs nav izvçlçts", "Kïûda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		orderList.add(new Pica(name, size, price));
		printOrder();
		
	}
	void printOrder(){
		String str = "";
		for(int i=0; i<orderList.size(); i++){
			str+=orderList.get(i).getName()+", "+orderList.get(i).getSize()+"cm, cena: "+orderList.get(i).getPrice()+"€\n";
		}
		System.out.println(str);
		orderContents.setText(str);
		System.out.println("parbaude: "+orderContents.getText());
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
			JOptionPane.showMessageDialog(null, gDesc, "Grieíu pica", JOptionPane.PLAIN_MESSAGE);
		}else
		if(margarita.isSelected()){
			JOptionPane.showMessageDialog(null, mDesc, "Margarita pica", JOptionPane.PLAIN_MESSAGE);
		}else{
			JOptionPane.showMessageDialog(null, "Pica nav izvçlçta", "Kïûda", JOptionPane.ERROR_MESSAGE);
		}
}
	String pDesc = "\"Pepperoni\" desa, mocarella, kûpinâts kausçtais siers, \"Taco\" mçrce, sîpolu èipsi, rukola, tomâtu mçrce, íiploku mçrce, oregano";
	String stDesc = "Ðíiòíis, cîsiòi, mocarella, tomâtu mçrce, eïïas un íiploku mçrce, oregano";
	String vDesc = "Ðíiòíis, mocarella, tomâtu mçrce, eïïas un íiploku mçrce, oregano";
	String gDesc= "Svaigais siers, spinâti, skâbâ krçjuma un íiploku mçrce, tomâtu mçrce, mocarella, eïïas un íiploku mçrce, oregano";
	String mDesc = "Mocarella, tomâtu mçrce, eïïas un íiploku mçrce, oregano";
}
