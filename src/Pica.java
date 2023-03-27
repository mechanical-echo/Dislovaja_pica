import java.util.ArrayList;

public class Pica {
	String name;
	int size;
	double price;
	
	ArrayList<String> piedevas;					//list of toppings
	public boolean irPiedevas;					//is there any toppings at all

	public Pica(String n, int s, double p) {	//constructor (when there is no toppings)
		name = n;
		size = s;
		price = p;
		irPiedevas = false;
	}

	public Pica(String n, int s, double p, ArrayList<String> piedevas) { //constructor (when there is toppings)
		name = n;
		size = s;
		price = p;
		this.piedevas = piedevas;
		irPiedevas = true;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getSize() {
		return size;
	}

	public String descr() {
		return "\"" + name + "\", " + size + "cm, cena: " + price + "€";
	}
}
