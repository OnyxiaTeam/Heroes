package game;

import java.awt.Menu;
import java.util.List;

import characters.Player;
import maps.Terrain;

public class Game {
	  private Player playerOne;
	  private Player playerTwo;
	 
	  private Player currentPlayer;

	  private List<Terrain> maps;

	  private Menu mainMenu;
	  private Menu buyMenu;

	 // private ViewStrategy visualization;

	  private static Game inst = null;
	  
	  private Player[] playerList = {playerOne, playerTwo};

	  private Game(Player playerOne, Player playerTwo) {
		  this.playerOne = playerOne;
		  this.playerTwo = playerTwo;
	  }

	//  public static Game getInstance() {
		  
	//  }

	  public void run() {
		  // event loop maybe?
	  }

	//  public void setVisualizationStrategy(ViewStrategy strategy) {
		  // the idea behind this is to give the front-end guys opportunity to make a wrapper over the Swing lib (or whatever they use) and inject it to the game object for later use
	  //}

	//  public ViewStrategy getVisualization() {
		  
	 // }

	 // public Terrain getCurrentField() {
		
//	  }

	  public Player getCurrentPlayer()  // determines the current player on seat
	  {
		  if(parseInt(currentPlayer) + 1 == playerList.length) {
			  for (int i = 0; i < playerList.length; i++) {
				if (playerList[i].equals(true)) {
				//	currentPlayer = i;
					break;
				}
			}
		  }
		  return currentPlayer;
	  }

	private int parseInt(Player currentPlayer2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void changeField(Terrain field) {
		
	}

	  public void changePlayer(Player p) {
		  for (int i = 0; i < playerList.length; i++) {
			if(p.equals(playerOne)) {
				p = this.playerTwo;
			}
			else {
				p = this.playerOne;
			}
		}
	  }

	  public boolean canOpenBuyMenu() {
		  int currentMoney = 0;
		  if(currentMoney < 0) {
			  return false;
		  }
		return true;
		  
	  }

	  public Menu getBuyMenu() {
		  buyMenu.add("XP");
		  buyMenu.add("Archers");
		  buyMenu.add("Griffin");
		  buyMenu.add("Crossbow");
		  //any other things that you can buy
		  
		  return buyMenu;
		  
	  }

	  public Menu getMainMenu() {
		  mainMenu.add("New game");
		  mainMenu.add("Records");
		  mainMenu.add("Saved games");
		  mainMenu.add("Options");
		  mainMenu.add("Exit");
		  //any other elements that could be added
		  
		  return mainMenu;
	  }

	public static Game getInst() {
		return inst;
	}

	public static void setInst(Game inst) {
		Game.inst = inst;
	}

	//public void setVisualization(ViewStrategy visualization) {
	//	this.visualization = visualization;
	//}
}

