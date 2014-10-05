import java.awt.Image;

import javax.swing.*;

public class Start extends JFrame{
	
	private int WIDTH = 1006;
	private int HEIGHT = 629;
	
	public Start() {
		add(new Board());
        pack();

        setTitle("START");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
    }

	public static void main(String[] args) {
		Start start = new Start();
		start.setVisible(true);
	}

}
