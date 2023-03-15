
public class Pica {
	String name;
	int size;
	double price;
	public Pica(String n, int s, double p){
		name = n;
		size = s;
		price= p;
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
