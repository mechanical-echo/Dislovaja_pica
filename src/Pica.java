import java.util.ArrayList;

public class Pica {
	String name;
	int size;
	double price;
	ArrayList<String> piedevas;
	public boolean irPiedevas;
	public Pica(String n, int s, double p){
		name = n;
		size = s;
		price= p;
		irPiedevas = false;
	}
	public Pica(String n, int s, double p, ArrayList<String> piedevas){
		name = n;
		size = s;
		price= p;
		this.piedevas = piedevas;
		irPiedevas = true;
	}
	
	public String getName(){
		return name;
	}
	public double getPrice(){
		return price;
	}
	public int getSize(){
		return size;
	}
	
	public String descr(){
		return "\""+name+"\", "+size+"cm, cena: "+price+"€";
	}
}
