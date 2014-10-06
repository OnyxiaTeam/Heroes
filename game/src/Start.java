import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

public class Start extends JFrame{
	
	private int WIDTH = 1206;
	private int HEIGHT = 629;
	static JPanel game = new Board();
	static JPanel hs = new JPanel();
	public Font font;
	
	public Start() {
		addToHomeScreen();
        pack();
        setTitle("START");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

	private void addToHomeScreen() {
		JLabel player1Label = new JLabel("Insert Player 1 Name:");
		JTextField player1 = new JTextField("", 20);
		JLabel player2Label = new JLabel("Insert Player 2 Name:");
		JTextField player2 = new JTextField("", 20);
		JButton startGame = new JButton("START!!!");
		URL fontURL;
		add(hs);
		hs.setLayout(null);
		//create the font
		try {
			fontURL = new URL("file:fonts/CF.ttf");
			font = Font.createFont(Font.TRUETYPE_FONT, fontURL.openStream());
			font = font.deriveFont(Font.PLAIN, 36);
		} catch (MalformedURLException e) {
			System.out.println("Wrong font URL");
		} catch (FontFormatException e) {
			System.out.println("Wrong Font Format");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		//print on screen
		player1Label.setFont(font);
		player1Label.setBounds(400, 50, 400, 50);
		player1Label.setForeground(java.awt.Color.RED);
		hs.add(player1Label);

		player1.setFont(font);
		player1.setBounds(400, 100, 400, 50);
		hs.add(player1);

		player2Label.setFont(font);
		player2Label.setBounds(400, 160, 400, 50);
		player2Label.setForeground(java.awt.Color.BLUE);
		hs.add(player2Label);

		player2.setFont(font);
		player2.setBounds(400, 210, 400, 50);
		hs.add(player2);
				
		startGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(game);
				repaint();
				printAll(getGraphics());
			}
		});
		startGame.setBounds(400, 270, 400, 60);
		startGame.setBackground(java.awt.Color.BLACK);
		startGame.setForeground(java.awt.Color.WHITE);
		hs.add(startGame);
	}

	public static void main(String[] args) {
		Start start = new Start();
	}
	
}
