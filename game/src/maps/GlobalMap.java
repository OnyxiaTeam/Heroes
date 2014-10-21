package maps;

import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import units.IWarrior;
import characters.Player;
import elements.EmptyElement;
import elements.IElements;
import elements.Village;

public class GlobalMap extends Terrain {

  private boolean cantUseShop = false;
  private boolean noConfirmationDialogue = false;

  public static final int id = 2;

  public GlobalMap(Player p1, Player p2) {
    super(p1, p2);
  }

  public boolean setElement(int col, int row, Object element) {
    if (isInRange(col, row)) {
      this.map.put(new Position(col, row), element);
      return true;
    }
    return false;
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
    return this.move(0, -1, currentPlayer);
  }

  @Override
  public boolean moveBottom(Object currentPlayer) {
    return this.move(0, 1, currentPlayer);
  }

  @Override
  protected boolean move(int col, int row, Object currentPlayer) {
   // for(int clear = 0; clear < 1000; clear++)
   // {
    //   System.out.println("\b") ;
  //  }
 //   System.out.println("----------");
  //  System.out.println(col + " - " + row);
  //  System.out.println("----------");
     printMap();
    Position playerPosition = this.map.entrySet().stream()
        .filter(t -> t.getValue().equals(currentPlayer)).findFirst().get()
        .getKey();
    int npy =  playerPosition.getY() + col;
    int npx = playerPosition.getX() + row;
 
    if (isInRange(npy,npx)) {
      Position pos = new Position(0, 0);

      // (.)(.) + $$ == ( . )( . );

      for (Map.Entry<Position, Object> es : this.map.entrySet()) {
        if (es.getKey().getX() == npy
            && es.getKey().getY() == npx) {
          pos = es.getKey();
        }
      }

      Object TerrainPiece = this.map.get(pos);
      System.out.println(TerrainPiece.getClass());
     if (TerrainPiece instanceof EmptyElement || TerrainPiece instanceof  Village) {
     
       this.map.remove(playerPosition);
       this.map.put(playerPosition, new EmptyElement());
       Position newPlayerPosition = new Position(npx,
           npy);
       this.map.remove(newPlayerPosition);
       this.map.put(newPlayerPosition, currentPlayer);
       return true;
    }else{
      return false;
    }
   //   System.out.println("Current player position x :" + playerPosition.getX());
    //  System.out.println("Current player position y :" + playerPosition.getY());
     // System.out.println("New player position x :" + (npx));
     // System.out.println("New player position y :" + (npy));
     
    }
    return false;
  }

}
