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
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class orderWindow extends JFrame implements ActionListener{

	// big panels
	JPanel textFieldPanel = new JPanel();							
	JPanel pizzaPanel = new JPanel();
	JPanel orderPanel = new JPanel();
	JPanel orderButtonPanel = new JPanel();
	JPanel MainPanel = new JPanel();
	
	// textfields
	JPanel labels = new JPanel();									//panel for contact info titles 
	JPanel fields = new JPanel();									//panel for contact info fields
	JTextField vards = new JTextField(10);
	JTextField numurs = new JTextField(10);
	JTextField adrese = new JTextField(10);
	JTextField epasts = new JTextField(10);
	
	// radiobutton panels
	JPanel pizzaButtons = new JPanel();								//panel for pizza type buttons
	JPanel sizeButtons = new JPanel();								//panel for size buttons
	JPanel piedevasPanel = new JPanel();							//panel for topping buttons
	
	///// radiobuttons
	// pizzas
	JRadioButton peperoni = new JRadioButton("Peperoni");
	JRadioButton studenta = new JRadioButton("Studenta");
	JRadioButton vezuva = new JRadioButton("Vezuva");
	JRadioButton grieku = new JRadioButton("Grieíu");
	JRadioButton margarita = new JRadioButton("Margarita");
	
	///// piedevas
	JCheckBoxMenuItem bekons = new JCheckBoxMenuItem("Bekons");
	JCheckBoxMenuItem bbq = new JCheckBoxMenuItem("BBQ");
	JCheckBoxMenuItem ananasi = new JCheckBoxMenuItem("Ananasi");

	
	// sizes
	JRadioButton s20 = new JRadioButton("20cm");
	JRadioButton s30 = new JRadioButton("30cm");
	JRadioButton s50 = new JRadioButton("50cm");
	
	///// Buttons
	// pizza
	JButton seeDescription = new JButton("Picas apraksts");
	JButton delete = new JButton("Noòemt picu");
	JButton sendOrder = new JButton("Pasûtît");
	JButton addPizza = new JButton("Pievienot picu");
	
	///// Textarea
	JTextArea orderContents = new JTextArea();						//Order description
	JScrollPane scroll;												//Scrollable pane for order description
	
	ImageIcon picaPicture = new ImageIcon("pica.png"); 				//image icon
	ArrayList<Pica> orderList = new ArrayList<Pica>();				//Arraylist that will contain all created pizzas
	
	
	/*~-~-~-~-
	 * Initialize main window
	 */
	public orderWindow() {
		seeDescription.addActionListener(this);
		addPizza.addActionListener(this);
		sendOrder.addActionListener(this);
		delete.addActionListener(this);

		Border border = BorderFactory.createLineBorder(Color.BLACK);

		MainPanel.setLayout(new GridLayout(2, 2));
		textFieldPanel.setLayout(new FlowLayout());
		orderPanel.setLayout(new FlowLayout());
		orderButtonPanel.setLayout(new FlowLayout());

		textFieldPanel.setBorder(border);
		pizzaPanel.setBorder(border);
		orderPanel.setBorder(border);
		orderButtonPanel.setBorder(border);

		/*~-~-~-~-~-~-~-~-
		 * input fields
		 */
		labels.setLayout(new GridLayout(4, 1));
		fields.setLayout(new GridLayout(4, 1));

		JLabel ievadiVardu = new JLabel("Jûsu vârds: ");
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

		///// Picas un izmera izvele
		pizzaButtons.setLayout(new GridLayout(5, 1));
		sizeButtons.setLayout(new GridLayout(3, 1));
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
		piedevasPanel.setLayout(new GridLayout(3, 1));
		piedevasPanel.add(bekons);
		piedevasPanel.add(bbq);
		piedevasPanel.add(ananasi);

		pizzaPanel.add(pizzaButtons);
		pizzaPanel.add(sizeButtons);
		pizzaPanel.add(piedevasPanel);
		pizzaPanel.add(seeDescription);
		/*****************************************
		 * TEXTAREA AND SCROLLBAR
		 */
		scroll = new JScrollPane(orderContents);
		orderPanel.add(new JLabel("Pasûtîjuma apraksts:"));
		orderPanel.add(scroll);
		orderPanel.add(delete);
		orderPanel.setLayout(new FlowLayout());
		scroll.setPreferredSize(new Dimension(220, 100));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		/*	
		 * 
		 */
		JLabel picture = new JLabel(picaPicture);
		picture.setPreferredSize(new Dimension(200, 80));
		addPizza.setPreferredSize(new Dimension(200, 30));
		sendOrder.setPreferredSize(new Dimension(200, 30));

		orderButtonPanel.add(picture);
		orderButtonPanel.add(addPizza);
		orderButtonPanel.add(sendOrder);

		///// galvena loga parametri
		setTitle("Pasûtît picu");
		int x = 540, y = 370;
		setSize(x, y);
		setLocation(1920 / 2 - x / 2, 1080 / 2 - y / 2);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainPanel.add(textFieldPanel);
		MainPanel.add(pizzaPanel);
		MainPanel.add(orderPanel);
		MainPanel.add(orderButtonPanel);

		add(MainPanel);

	}

	@Override
	public void actionPerformed(ActionEvent button) {
		if (button.getSource() == seeDescription) {
			order.description();
		} else if (button.getSource() == delete) {
			order.deletePizza();
		} else if (button.getSource() == sendOrder) {
			order.pasutit();
		} else if (button.getSource() == addPizza) {
			order.addPizzaToList();
		}

	}
	
}
