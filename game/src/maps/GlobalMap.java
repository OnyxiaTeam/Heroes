package maps;

import java.util.ArrayList;

import characters.Player;
import elements.IElements;

public class GlobalMap extends Terrain {

	public static final int id = 2;

  public GlobalMap(ArrayList<IElements> elements, Player p1, Player p2, Player current) {
    super(elements, p1, p2, current);
  }

}
