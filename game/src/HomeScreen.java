import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomeScreen extends JPanel{
	
	JPanel panel = new JPanel();
	JLabel player1Label = new JLabel("Insert Player 1 Name:");
	JTextField player1 = new JTextField("", 20);
	JLabel player2Label = new JLabel("Insert Player 2 Name:");
	JTextField player2 = new JTextField("", 20);
	JButton startGame = new JButton("START!!!");
	URL fontURL;
	Font font;
	
	public HomeScreen () {
		
		setLayout(null);
		
	}
}