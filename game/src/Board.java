import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Board extends JPanel {
	JPanel board = new JPanel();
	ImageIcon ii = new ImageIcon("images/icon.png");
	Image image = ii.getImage();
	String[] map = new Map("1").getMap();
	public Board () {
		for (String strr : map) {
			System.out.println(strr);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 25; i++) {
			for (int j = 0; j < 15; j++) {
				//draw terrain
				g.drawImage(new ImageIcon("images/0-terrain.png").getImage(), i*40, j*40, null);
				
//				draw path
				g.drawImage(new ImageIcon("images/".concat(""+map[j].charAt(i)).concat("-terrain.png")).getImage(), 
						i*40, j*40, null);
			}
		}
    }
}
