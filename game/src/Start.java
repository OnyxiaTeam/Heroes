import java.awt.Container;
import java.awt.Image;
import javax.swing.*;

public class Start extends JFrame{
	
	private int WIDTH = 1206;
	private int HEIGHT = 629;
	static Board game = new Board();
	static HomeScreen hs = new HomeScreen();
	
	public Start() {
		//to see the homescreen uncomment the following line
//		add(hs);
		add(game);
        pack();
        setTitle("START");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

	public static void main(String[] args) {
		Start start = new Start();
	}
	
	public static void startGame() {
		game.setVisible(true);
		hs.setVisible(false);
	}
}
