import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import characters.Player;
import characters.PlayerBuilder;
import elements.IGood;

public class Board extends JPanel implements ActionListener {
	
	JPanel board = new JPanel();
	String level = "1";
	String[] mapTerrain = new Map(level).getMapTerrain();
	String[] mapUnits = new Map(level).getMapUnits();
	public int SCALE = 40;
	public int p1X = 0;
	public int p1Y = 0;
	public int p2X = 24;
	public int p2Y = 14;
	Timer timer;
    int currentPlayer = 1;
	JButton endOfTurnButton = new JButton(new ImageIcon("images/end-turn-button.png"));
	
	public Board () {
		setLayout(null);
		addKeyListener(new TAdapter());
		setFocusable(true);
		isFocusable();
		setDoubleBuffered(true);
		
		//set menu up
		endOfTurnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer == 1) {
					currentPlayer = 2;
				}
				else {
					currentPlayer = 1;
				}
				
			}
		});
		endOfTurnButton.setBorder(null);
		endOfTurnButton.setBackground(null);
		endOfTurnButton.setBounds(1000, 550, 200, 50);
		add(endOfTurnButton);
		
		timer = new Timer(5, this);
        timer.start();
	}
	
	private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
    		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
    	        p1X -= 1;
    	    }
    	    if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
    	        p1X += 1;
    	    }
    	    if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
    	        p1Y += 1;
    	    }
    	    if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
    	        p1Y -= 1;
    	    }
            System.out.println("SOMETHING");
    	}
    }
	
	//PAINTING BACKGROUND
	@Override
	public void paintComponent(Graphics g) {
		for (int col = 0; col < 25; col++) {
			for (int row = 0; row < 15; row++) {
				//draw background
				g.drawImage(new ImageIcon("images/o-terrain.png").getImage(), col*SCALE, row*SCALE, null);
				
				//draw road
				g.drawImage(new ImageIcon("images/".concat(""+mapTerrain[row].charAt(col)).concat("-terrain.png")).getImage(), col*SCALE, row*SCALE, null);	
			}
		}
		
		//draw menu background
		g.drawImage(new ImageIcon("images/menu-bg.png").getImage(), 1000, 0, null);
		
		g.drawImage(new ImageIcon("images/p1.png").getImage(), p1X*SCALE, p1Y*SCALE, this);	
		g.drawImage(new ImageIcon("images/p2.png").getImage(), p2X*SCALE, p2Y*SCALE, this);
		
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
}
