package maps;

import java.util.ArrayList;

import characters.Player;
import elements.EmptyElement;
import elements.IElements;

public class BattleMap extends Terrain {

  public static final int id = 1;
  private Player p1;
  private Player p2;
  
  private boolean cantUseShop=true;
  private boolean noConfirmationDialogue=true;
    
  public BattleMap(Player p1, Player p2) {
    super(p1, p2);
    this.p1 = p1;
    this.p2 = p2;
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
      System.out.println("Current player position x :" + playerPosition.getX());
      System.out.println("New player position x :" + playerPosition.getX() + row);
      System.out.println("Current player position y :" + playerPosition.getY());
      System.out.println("New player position y :" + playerPosition.getY() + col);
      
//      Position pos = new Position(playerPosition.getX()+col, playerPosition.getY()+row);
//      Object TerrainPiece  = this.map.get(pos);
//        
//        if(TerrainPiece instanceof EmptyElement){
//          
//          this.map.put(playerPosition, new EmptyElement());
//          Position newPlayerPosition = new Position(playerPosition.getX() + col,
//              playerPosition.getY() + row);
//          this.map.put(newPlayerPosition, currentPlayer);
//          return true;
//        }else{
//          return false;
//        }
    }
    return false;
  }

}
