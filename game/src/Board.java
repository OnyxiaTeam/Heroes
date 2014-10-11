import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Board extends JPanel implements ActionListener {
	
	JPanel board = new JPanel();
	static String level = "1";
	static String[] mapTerrain = new Map(level).getMapTerrain();
	String[] mapUnits = new Map(level).getMapUnits();
	public int SCALE = 40;
	public int p1X = 0;
	public int p1Y = 0;
	public int p2X = 24;
	public int p2Y = 14;
	Timer timer;
    int currentPlayer = 1;
    ImageIcon buttonBg = new ImageIcon("images/end-turn-button.png");
	ImageIcon buttonHover = new ImageIcon("images/end-turn-button-hover.png");
	JButton endOfTurnButton = new JButton(buttonBg);
	
	public Board () {
		setLayout(null);
		addKeyListener(new TAdapter());
		setFocusable(true);
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
		endOfTurnButton.setFocusable(false);
		endOfTurnButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				endOfTurnButton.setIcon(buttonHover);
			}
			public void mouseExited(MouseEvent evt) {
				endOfTurnButton.setIcon(buttonBg);
			}
		});
		add(endOfTurnButton);
		
		timer = new Timer(10, this);
        timer.start();
	}
	
	private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
        	if (currentPlayer == 1) {
	    		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && isFree(p1X-1, p1Y)) {
	    	        p1X -= 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && isFree(p1X+1, p1Y)) {
	    	        p1X += 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_UP && isFree(p1X, p1Y-1)) {
	    	        p1Y -= 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN && isFree(p1X, p1Y+1)) {
	    	        p1Y += 1;
	    	    }
        	}
        	else {
        		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT && isFree(p2X-1, p2Y)) {
	    	        p2X -= 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT && isFree(p2X+1, p2Y)) {
	    	        p2X += 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_UP && isFree(p2X, p2Y-1)) {
	    	        p2Y -= 1;
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN && isFree(p2X, p2Y+1)) {
	    	        p2Y += 1;
	    	    }
        	}
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
	
	public static boolean isFree(int x, int y) {
		if (x >= 0 && y >= 0 && x <= 24 && y <= 14) {
			if (mapTerrain[y].charAt(x) != 't') {
				return true;
			}
		}
			
		return false;
	}
	
}
