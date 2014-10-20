import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import maps.BattleMap;
import maps.GlobalMap;
import maps.OwnVillageMap;
import maps.Position;
import maps.Terrain;
import maps.TerrainFactory;
import characters.Player;
import characters.PlayerBuilder;
import elements.EmptyElement;
import elements.Gold;
import elements.Grass;
import elements.Village;
import elements.VillageBuilder;

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
	public int turns; // temporary turn counter
	Timer timer;
    Player attacker;
    Player defender;
    Terrain map;
    Player currentPlayer;
    ImageIcon buttonBg = new ImageIcon("images/end-turn-button.png");
	ImageIcon buttonHover = new ImageIcon("images/end-turn-button-hover.png");
	JButton endOfTurnButton = new JButton(buttonBg);
	JLabel turnsLabel = new JLabel();
	
	public Board () {
		this.attacker = new PlayerBuilder().create().setInitialVillages().setInitialTurns().get();
		this.defender = new PlayerBuilder().create().setInitialVillages().setInitialTurns().get();
		this.currentPlayer = attacker;
		this.map = TerrainFactory.Create(attacker, defender, GlobalMap.id);
		turns = 5;
		 map.setObjectOnMap(new Position(0,0),attacker);
		 map.setObjectOnMap(new Position(14,24),defender);
		 
		

	

		for (int col = 0; col < 25; col++) {
			for (int row = 0; row < 15; row++) {
				Position currentPos = new Position(col,row);
				char currentObj = mapTerrain[row].charAt(col);	
				map.setObjectOnMap(currentPos,generateObj(currentObj));
			}
				}

		
		setLayout(null);
		addKeyListener(new TAdapter());
		setFocusable(true);
		setDoubleBuffered(true);
		
		//set menu up
		endOfTurnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(currentPlayer == attacker) {
					currentPlayer = defender;
				} else {
					currentPlayer = attacker;
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
		
		//turns label
		turnsLabel.setText("<html><span style='font-size:20px;'>"+"Turns Left:"+turns+"</span></html>");
		turnsLabel.setBounds(1000, 0, 200, 100);
		add(turnsLabel);
		
		timer = new Timer(10, this);
        timer.start();
	}
	
	
	private class TAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent keyEvent) {
        	if (currentPlayer == attacker) {
	    		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
	    	        if(map.moveLeft(currentPlayer)){
	    	        	p1X -= 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	        if(map.moveRight(currentPlayer)){
	    	        	p1X += 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
	    	        if(map.moveTop(currentPlayer)){
	    	        	p1Y -= 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
	    	        if(map.moveBottom(currentPlayer)){
	    	        	p1Y += 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    
        	}
        	else {
        		if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT) {
	    	        if(map.moveLeft(currentPlayer)){
	    	        	p2X -= 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	        if(map.moveRight(currentPlayer)){
	    	        	p2X += 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_UP) {
	    	        if(map.moveTop(currentPlayer)){
	    	        	p2Y -= 1;
		    	        calculateTurns();
	    	        }
	    	    }
	    	    if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN) {
	    	        if(map.moveBottom(currentPlayer)){
	    	        	p2Y += 1;
		    	        calculateTurns();
	    	        }
	    	    }
        	}
        	if(keyEvent.getKeyCode() == KeyEvent.VK_A) {
    	        if(map.moveBottom(currentPlayer)){
    	        	new Battle(attacker, defender);
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
				g.drawImage(new ImageIcon("images/o-terrain.png").getImage(), col*SCALE,row*SCALE, null);
				
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
	
	public void calculateTurns(){
		turns--;
		if(turns==0){
			if(currentPlayer == attacker) {
				currentPlayer = defender;
			} else {
				currentPlayer = attacker;
			}
			turns=5;
		}
        turnsLabel.setText("<html><span style='font-size:20px'>"+"Turns Left:"+turns+"</span></html>");
	}
	
	public Object generateObj(char ch){
		switch (ch) {
		case 'o':
			return new Grass();
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case 'a':
			return new EmptyElement();
		case 'b':
			return new VillageBuilder().setPlayer(attacker).create().setInitialIncome().get();
		case 'r':
			return new VillageBuilder().setPlayer(defender).create().setInitialIncome().get();
		case 'g':
			return new Gold();
		case 't':
			return new Grass();
		}
		throw new IllegalArgumentException("The object type " + ch
				+ " is not recognized.");
	}
	
}
