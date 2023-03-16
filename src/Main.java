import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main implements ActionListener{
	
	public static void main(String[] args) {
		new order();
	}
	
	public static void checkout(String str){
		try{
			FileWriter fw = new FileWriter("Receipts.txt", true);
			PrintWriter writer = new PrintWriter(fw);
			
			writer.println(str);
			
			writer.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kluda ierakstot failu", "Kluda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	static JFrame frame = new JFrame("Visi pasûtîjumi");
	static void readFile(){
		String fileName = "Receipts.txt";
		try{
			FileReader fr = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fr);
			
			String line, str="";
			while( (line=reader.readLine()) != null ){
				str += line + "\n";
			}
			JPanel panel = new JPanel();
			panel.setLayout(null);
			JTextArea area = new JTextArea();
			area.setText(str);
			JScrollPane scroll = new JScrollPane(area);
			
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			scroll.setBounds(40,50, 300,300);
			panel.add(scroll);
			
			JLabel label =new JLabel("Visi pasûtîjumi:");
			
			label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
			label.setBounds(40,10, 300, 30);
			panel.add(label);
			
			next.setBounds(40,370 ,300, 30);
			panel.add(next);
			next.addActionListener(new Main());
			frame.add(panel);
			
			frame.setVisible(true);
			frame.setSize(400,460);
			frame.setLocation(1920/2 -200, 1080/2 - 200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			reader.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Kïûda 'readFile' iekðâ", "Kïûda", JOptionPane.ERROR_MESSAGE);
		}
	}
	static JButton next = new JButton("Turpinât");
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==next){
			frame.dispose();
			new order();
		}
	}
	
}
