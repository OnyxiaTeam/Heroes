package maps;

import java.util.ArrayList;
import java.util.HashMap;

import characters.Player;
import elements.IElements;

public abstract class Terrain {
		  
  protected HashMap<Position, Object> map = new HashMap<Position, Object>();
  public static final int MAP_X = 25;
  public static final int MAP_Y = 15;

  public Terrain(Player p1, Player p2) {

  }

  protected abstract boolean move(int col, int row, Object element);

  public abstract boolean moveRight(Object element);
  public abstract boolean moveLeft(Object element);

  public abstract boolean moveTop(Object element);
  public abstract boolean moveBottom(Object element);
  
  public void setObjectOnMap(Position pos, Object obj) {
	  this.map.put(pos, obj);
  }
   public void printMap(){
    for(Position name: this.map.keySet()){
      String key = name.getX()+" - "+name.getY();
      String value = this.map.get(name).toString();
      System.out.println(key + " :  " + value);
    }
   }
  public boolean isInRange(int col, int row) {
    if (isInCol(col) && isInRow(row)) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isInCol(int col) {

    if (col >= 0 && col <= Terrain.MAP_X) {
      return true;
    } else {
      return false;

    }
  }

  public boolean isInRow(int row) {

    if (row >= 0 && row <= Terrain.MAP_Y) {
      return true;
    } else {
      return false;
    }
  }

}
