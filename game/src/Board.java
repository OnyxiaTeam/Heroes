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
	String level = "1";
	String[] mapTerrain = new Map(level).getMapTerrain();
	String[] mapUnits = new Map(level).getMapUnits();
	public int SCALE = 40;
	
	public Board () {
		
	}

	//PAINTING METHOD
	@Override
	public void paintComponent(Graphics g) {
		for (int col = 0; col < 25; col++) {
			for (int row = 0; row < 15; row++) {
				//draw background
				g.drawImage(new ImageIcon("images/o-terrain.png").getImage(), col*SCALE, row*SCALE, null);
				
				//draw road
				g.drawImage(new ImageIcon("images/".concat(""+mapTerrain[row].charAt(col)).concat("-terrain.png")).getImage(), 
						col*SCALE, row*SCALE, null);
				
				//draw gold - this is temporary just to see the graphics
				//draw gold - actual painting should be made from the object, when created
				if (mapUnits[row].charAt(col) == '1') {
					g.drawImage(new ImageIcon("images/g-terrain.png").getImage(), 
							col*SCALE, row*SCALE, null);
				}
			}
		}
    }
}
