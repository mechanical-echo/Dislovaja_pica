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

public class Main implements ActionListener {
	/*~-~-~-
	 * Main
	 */
	public static void main(String[] args) {
		new order();
	}

	
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Write receipt into a file
	 */
	public static void checkout(String str) {
		try {
			FileWriter fw = new FileWriter("Receipts.txt", true);
			PrintWriter writer = new PrintWriter(fw);

			writer.println(str);

			writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kluda ierakstot failu", "Kluda", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//Recipt window
	static JFrame frame = new JFrame("Visi pasûtîjumi");

	
	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Read file and paste result in window
	 */
	static void readFile() {
		String fileName = "Receipts.txt";						//File path/name
		try {
			FileReader fr = new FileReader(fileName);			//Finds file
			BufferedReader reader = new BufferedReader(fr);		//Writes everything inside

			String line, str = "";								//line - current line that being read, str - saves everything that been read
			while ((line = reader.readLine()) != null) {		//do that until the end of file
				str += line + "\n";								//add read result to str
			}
			JPanel panel = new JPanel();						//panel that will contain TextArea and Scroll
			JTextArea area = new JTextArea();					//TextArea will contain read result (str)
			JScrollPane scroll = new JScrollPane(area);			//Adding textArea into scrollable pane
			JLabel label = new JLabel("Visi pasûtîjumi:");		//Window title

			area.setText(str);									

			panel.setLayout(null);								//layout = null, it means that we can use .setBounds()
			
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//ScrollBar will appear even, if text isn't that big to scroll
			scroll.setBounds(40, 50, 300, 300);					//setting x,y coordinates and width, height for Scroll pane
			
			panel.add(scroll);									//adding scrollable pane to panel

			label.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25)); //setting font for title
			label.setBounds(40, 10, 300, 30);					//setting coordinates and size for title
			
			panel.add(label);									//adding title to panel

			next.setBounds(40, 370, 300, 30);					//adding button 'next'
			next.addActionListener(new Main());					//adding ActionListener to button 'next', so we could track if button is clicked

			panel.add(next);									//adding button to panel
			
			frame.add(panel);									//adding panel with all objects inside into the window

			/*
			 * window settings
			 */
			frame.setVisible(true);							
			frame.setSize(400, 460);
			frame.setLocation(1920 / 2 - 200, 1080 / 2 - 200);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			reader.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Kïûda 'readFile' iekðâ", "Kïûda", JOptionPane.ERROR_MESSAGE);
		}
	}
	//Button 'next'
	static JButton next = new JButton("Turpinât");

	/*~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-~-
	 * Actions for when button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == next) {
			frame.dispose();									//close window
			new orderWindow();										//start new order
		}
	}

}
