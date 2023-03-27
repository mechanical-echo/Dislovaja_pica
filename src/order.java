
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class order extends JFrame{
	static orderWindow ow = new orderWindow();
	static boolean irPiegade;		//used to check what type of delivery is used
	static double[] piedevuCenas = { 1.60, 0.85, 1.10 }; //prices for toppings
	
	/*~-~-~-~-~-~-
	 * Make order
	 */
	static void pasutit() {
		double deliveryPrice;								//full price for order

		String[] optionsDelivery = { "Saņemt restauranā", "Piegāde līdz mājām" };	
		int index = JOptionPane.showOptionDialog(
				null, 
				"Izvēlies piegādes veidu:", 
				"Piegāde", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				optionsDelivery, 
				optionsDelivery[0]
		);

		if (index == 0) {									//if user chose "sanemt restaurana"
			deliveryPrice = 0;
			irPiegade = false;
		} else {											//if user chose "pigade lidz majam"
			deliveryPrice = 3.50;
			irPiegade = true;
		}
		if (ow.orderList.size() < 1) {						//if there is nothing in order
			JOptionPane.showMessageDialog(
					null, 
					"Pasūtījumā nekas nemaz nav!", 
					"Klūda", 
					JOptionPane.ERROR_MESSAGE
			);
			return;
		}
		if (noContactData()) {								//if there is errors inside contact info
			JOptionPane.showMessageDialog(
					null, 
					"Kontaktinformācija nav aizpildīta līdz galām!", 
					"Kļūda",
					JOptionPane.ERROR_MESSAGE
			);
			return;
		}

		double summary = sum(deliveryPrice);				//count order summary price

		String str = "";
		
		str += "Vārds: " + ow.vards.getText() + "\n";
		str += "Talr.: " + ow.numurs.getText() + "\n";
		if (irPiegade) {
			str += "Adrese: " + ow.adrese.getText() + "\n";
			str += "Email: " + ow.epasts.getText() + "\n\n";
		}

		for (int i = 0; i < ow.orderList.size(); i++) {
			if (ow.orderList.get(i).irPiedevas) {
				str += ow.orderList.get(i).getName() 
					+ ", " + ow.orderList.get(i).getSize() 
					+ "cm, cena: "
					+ ow.orderList.get(i).getPrice() 
					+ "€\nPiedēvas:\n" 
					+ visasPiedevas(ow.orderList.get(i)
			);
			} else {
				str += ow.orderList.get(i).getName() 
					+ ", " + ow.orderList.get(i).getSize() 
					+ "cm, cena: "
					+ ow.orderList.get(i).getPrice() 
					+ "€\n";
			}
			str += "-~-~-~-~-~-~-~-~-~-\n";
		}
		for (int i = 0; i < ow.orderList.size(); i++) {
			if (ow.orderList.get(i).irPiedevas) {
				for (String j : ow.orderList.get(i).piedevas) {
					switch (j) {
					case "Bekons":
						summary += piedevuCenas[0];
						break;
					case "BBQ":
						summary += piedevuCenas[1];
						break;
					case "Ananasi":
						summary += piedevuCenas[2];
						break;
					}
				}
			}
		}
		
		summary *= 100;
		summary = Math.round(summary);						//round up summary to x.xx
		summary /= 100;

		str += "Piegādes cena: " + deliveryPrice + "€\n";
		str += "Kopā: " + summary + "€\n";
		str += "-~-~---------~-~-~-\n";
		str += "-~-~-~-~-~-~-~-~-~-\n";
		
		String[] optionsPayment = { "Apmaksāt", "Atcelt" };
		
		index = JOptionPane.showOptionDialog(
				null, 
				str, 
				"Pasūtījums", 
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				optionsPayment, 
				optionsPayment[0]
		);
		if (index == 0) {
			ow.dispose();
			Main.checkout(str);
			Main.readFile();
		}
	}

	/*~-~-~-~-~-~-~-~-~-~-~-~-
	 * delete pizza from list
	 */
	static void deletePizza() {
		if (ow.orderList.size() < 1) {			//if there is no pizza in list
			JOptionPane.showMessageDialog(
					null, 
					"Pasūtījumā nekas nemaz nav!", 
					"Kļūda", 
					JOptionPane.ERROR_MESSAGE
			);
			return;
		}
		String[] str = new String[ow.orderList.size()]; //used to list pizzas in dropdown and to get index of chosen pizza
		
		for (int i = 0; i < ow.orderList.size(); i++) {	//adding all pizza names to array
			str[i] = ow.orderList.get(i).getName();
		}
		
		String choice = (String) JOptionPane.showInputDialog(
				null, 
				"Izvēlies picu, kuru dzest: ", 
				"Izvēle",
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				str, 
				str[0]);
		int index = Arrays.asList(str).indexOf(choice);
		ow.orderList.remove(index);
		printOrder();
	}
	
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Check all selected options and add pizza according to them
	 */
	static void addPizzaToList() {
		String name;
		int size, i;
		double price;
		
		//check pizza buttons
		if (ow.peperoni.isSelected()) {
			name = "Peperoni";
			i = 0;
		} else if (ow.studenta.isSelected()) {
			name = "Studenta";
			i = 1;
		} else if (ow.vezuva.isSelected()) {
			name = "Vezuva";
			i = 2;
		} else if (ow.grieku.isSelected()) {
			name = "Grieķu";
			i = 3;
		} else if (ow.margarita.isSelected()) {
			name = "Margarita";
			i = 4;
		} else {
			JOptionPane.showMessageDialog(null, "Pica nav izvēlēta", "Kļūda", JOptionPane.ERROR_MESSAGE);
			return;
		}

		//check size buttons
		if (ow.s20.isSelected()) {
			size = 20;
			price = cenas[i][0];
		} else if (ow.s30.isSelected()) {
			size = 30;
			price = cenas[i][1];
		} else if (ow.s50.isSelected()) {
			size = 50;
			price = cenas[i][2];
		} else {
			JOptionPane.showMessageDialog(null, "Izmērs nav izvēlēts", "Kļūda", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		//list with toppings
		ArrayList<String> piedevas = new ArrayList<String>(); 
		
		//Check toppings
		if (ow.bekons.isSelected()) {
			piedevas.add("Bekons");
		}
		if (ow.bbq.isSelected()) {
			piedevas.add("BBQ");
		}
		if (ow.ananasi.isSelected()) {
			piedevas.add("Ananasi");
		}
		
		if (!ow.bekons.isSelected() && !ow.ananasi.isSelected() && !ow.bbq.isSelected()) {
			//if toppings are not chosen
			ow.orderList.add(new Pica(name, size, price));
		} else {
			//if there is toppings chosen
			ow.orderList.add(new Pica(name, size, price, piedevas));
		}

		//unselect everything 
		ow.peperoni.setSelected(false);
		ow.studenta.setSelected(false);
		ow.vezuva.setSelected(false);
		ow.grieku.setSelected(false);
		ow.margarita.setSelected(false);

		ow.s20.setSelected(false);
		ow.s30.setSelected(false);
		ow.s50.setSelected(false);

		ow.bekons.setSelected(false);
		ow.bbq.setSelected(false);
		ow.ananasi.setSelected(false);

		//reprint textArea
		printOrder();

	}

	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Get string with all topping descriptions
	 */
	static String visasPiedevas(Pica p) {
		String str = "";
		ArrayList<String> al = p.piedevas;
		for (String pied : al) {
			int i = 0;
			switch (pied) {
			case "Bekons":
				i = 0;
				break;
			case "BBQ":
				i = 1;
				break;
			case "Ananasi":
				i = 2;
				break;
			}
			str += ">" + pied + " = " + piedevuCenas[i] + "€\n";
		}
		return str;
	}
	
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Print order contents inside TextArea 
	 */
	static void printOrder() {
		String str = "";
		for (int i = 0; i < ow.orderList.size(); i++) {
			if (ow.orderList.get(i).irPiedevas) {
				str += ow.orderList.get(i).getName() + ", " + ow.orderList.get(i).getSize() + "cm, cena: "
						+ ow.orderList.get(i).getPrice() + "€\nPiedēvas:\n" + visasPiedevas(ow.orderList.get(i));
			} else {
				str += ow.orderList.get(i).getName() + ", " + ow.orderList.get(i).getSize() + "cm, cena: "
						+ ow.orderList.get(i).getPrice() + "€\n";
			}
			str += "-~-~-~-~-~-~-~-~-~-\n";

		}
		System.out.println(str);
		ow.orderContents.setText(str);
		ow.orderContents.updateUI();
	}
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Show window with pizza descriptions
	 */
	static void description() {
		if (ow.peperoni.isSelected()) {
			JOptionPane.showMessageDialog(null, pDesc, "Peperoni pica", JOptionPane.PLAIN_MESSAGE);
		} else if (ow.studenta.isSelected()) {
			JOptionPane.showMessageDialog(null, stDesc, "Studenta pica", JOptionPane.PLAIN_MESSAGE);
		} else if (ow.vezuva.isSelected()) {
			JOptionPane.showMessageDialog(null, vDesc, "Vezuva pica", JOptionPane.PLAIN_MESSAGE);
		} else if (ow.grieku.isSelected()) {
			JOptionPane.showMessageDialog(null, gDesc, "Grieķu pica", JOptionPane.PLAIN_MESSAGE);
		} else if (ow.margarita.isSelected()) {
			JOptionPane.showMessageDialog(null, mDesc, "Margarita pica", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Pica nav izvēlēta", "Kļūda", JOptionPane.ERROR_MESSAGE);
		}
	}

	/*********************
	 * Check phone number 
	 */
	static boolean checkNumurs(String num) {
		if (num.length() != 8) {
			JOptionPane.showMessageDialog(
					null, 
					"Numurā jābut 8 cipari!", 
					"Kļūda", 
					JOptionPane.ERROR_MESSAGE
			);
			return true;
		}

		for (int i = 0; i < num.length(); i++) {
			int x = num.charAt(i);
			if (x < 48 || x > 57) {
				JOptionPane.showMessageDialog(
						null, 
						"Numurs nav ievadīts korekti", 
						"Kļūda", 
						JOptionPane.ERROR_MESSAGE
				);
				return true;
			} else if (x >= 48 && x <= 57 && i == 0 && x != 50) {
				JOptionPane.showMessageDialog(
						null, 
						"Numura pirmam ciparam jābut 2", 
						"Kļūda",
						JOptionPane.ERROR_MESSAGE
				);
				return true;
			}
		}
		return false;
	}
	
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Check contact data for errors
	 */
	static boolean noContactData() {
		if (ow.vards.getText().length() < 1) {
			return true;
		} else if (ow.adrese.getText().length() < 1 && irPiegade) {
			return true;
		} else if (ow.epasts.getText().length() < 1 && irPiegade) {
			return true;
		}
		if (ow.numurs.getText().length() < 1) {
			return true;
		} else if (ow.numurs.getText().length() > 0) {
			return checkNumurs(ow.numurs.getText());
		} else {
			return false;
		}
	}

	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Get summary price of order
	 */
	static double sum(double del) {
		double a = 0;
		for (int i = 0; i < ow.orderList.size(); i++) {
			a += ow.orderList.get(i).getPrice();
		}
		a += del;
		return a;
	}

	static double[] peperoniCenas = { 7.39, 12.99, 21.99 }; 		
	static double[] studentaCenas = { 6.59, 11.99, 18.99 };
	static double[] vezuvaCenas = { 6.59, 11.99, 18.99 };
	static double[] griekuCenas = { 6.59, 11.99, 18.99 };
	static double[] margaritaCenas = { 4.19, 7.69, 13.99 };
	static double[][] cenas = { peperoniCenas, studentaCenas, vezuvaCenas, griekuCenas, margaritaCenas };
	static String pDesc = "\"Pepperoni\" desa, mocarella, kūpināts kausētais siers, \"Taco\" mērce, sīpolu čipsi, rukola, tomļātu mērce, ķiploku mērce, oregano";
	static String stDesc = "Šķiņķis, cīsiņi, mocarella, tomātu mērce, eļļas un ķiploku mērce, oregano";
	static String vDesc = "Šķiņķis, mocarella, tomātu mērce, eļļas un ķiploku mērce, oregano";
	static String gDesc = "Svaigais siers, spināti, skābā krējuma un ķiploku mērce, tomātu mērce, mocarella, eļļas un ķiploku mērce, oregano";
	static String mDesc = "Mocarella, tomātu mērce, eļļas un ķiploku mērce, oregano";
}
