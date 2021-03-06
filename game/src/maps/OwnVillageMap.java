package maps;

import java.util.ArrayList;

import characters.Player;
import elements.EmptyElement;
import elements.IElements;

public class OwnVillageMap extends Terrain {
	public static final int id = 3;

    
	  private boolean cantUseShop=false;
	  private boolean noConfirmationDialogue=false;

	
	public OwnVillageMap(Player p1, Player p2) {
		super(p1, p2);
	}
	
   	  @Override
	  public boolean moveRight(Object currentPlayer) {
	    return this.move(1, 0, currentPlayer);
	  }

	  @Override
	  public boolean moveLeft(Object currentPlayer) {
	    return this.move(-1, 0, currentPlayer);
	  }

	  @Override
	  public boolean moveTop(Object currentPlayer) {
	    return this.move(0, 1, currentPlayer);
	  }

	  @Override
	  public boolean moveBottom(Object currentPlayer) {
	    return this.move(0, -1, currentPlayer);
	  }

	  @Override
	  protected boolean move(int col, int row, Object currentPlayer) {
	    Position playerPosition = this.map.entrySet().stream()
	        .filter(t -> t.getValue().equals(currentPlayer)).findFirst().get()
	        .getKey();
	    if (isInRange(playerPosition.getX() + col, playerPosition.getY() + row)) {
	      this.map.put(playerPosition, new EmptyElement());
	      Position newPlayerPosition = new Position(playerPosition.getX() + col,
	          playerPosition.getY() + row);
	      this.map.put(newPlayerPosition, currentPlayer);
	      return true;
	    }
	    return false;
	  }
}
