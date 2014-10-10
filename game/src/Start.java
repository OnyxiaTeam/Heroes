import java.awt.Dimension;

import javax.swing.*;

public class Start extends JFrame {
	
	private int WIDTH = 1206;
	private int HEIGHT = 629;
	
	public Start() {
		addToHomeScreen();
		add(new Board());
		setLocation(100,100);
        setTitle("START");
        setSize(WIDTH, HEIGHT);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
		pack();
        setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

	private void addToHomeScreen() {
		HSDialog homeScreen = new HSDialog(this, true);
		homeScreen.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Start();
            }
        });
	}
}
