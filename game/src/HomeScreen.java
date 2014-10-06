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
		
		//create the font
		try {
			fontURL = new URL("file:fonts/CF.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			font = font.deriveFont(Font.PLAIN,36);
		} catch (MalformedURLException e) {
			System.out.println("URL greshen");
		} catch (FontFormatException e) {
			System.out.println("Font Format Exception");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		//print on screen
		player1Label.setFont(font);
		player1Label.setBounds(400, 50, 400, 50);
		player1Label.setForeground(java.awt.Color.RED);
		add(player1Label);

		player1.setFont(font);
		player1.setBounds(400, 100, 400, 50);
		add(player1);

		player2Label.setFont(font);
		player2Label.setBounds(400, 160, 400, 50);
		player2Label.setForeground(java.awt.Color.BLUE);
		add(player2Label);

		player2.setFont(font);
		player2.setBounds(400, 210, 400, 50);
		add(player2);
		
		startGame.setFont(font);
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Start.startGame();
			}
		});
		startGame.setBounds(400, 270, 400, 60);
		startGame.setBackground(java.awt.Color.BLACK);
		startGame.setForeground(java.awt.Color.WHITE);
		add(startGame);
	}
}
