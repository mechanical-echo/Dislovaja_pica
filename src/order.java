
import javax.swing.JFrame;

public class order {
	JFrame frame = new JFrame("Pasûtît picu");
	
	
	public order(){
		int x=1920/3, y=1080/3;
		frame.setSize(x, x);
		frame.setLocation(1920/2-x/2, 1080/2-y);
		
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
