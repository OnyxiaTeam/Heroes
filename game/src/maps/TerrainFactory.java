package maps;

import java.util.ArrayList;

import characters.Player;
import elements.IElements;

public class TerrainFactory {

	public static Terrain chooseMap(int id, ArrayList<IElements> elements, Player p1, Player p2, Player current){
		switch (id) {
  		case BattleMap.id:
  			return new BattleMap(elements, p1, p2, current);

  		case GlobalMap.id:
  			return new GlobalMap(elements, p1, p2, current);

  		case OwnVillageMap.id:
  			return new OwnVillageMap(elements, p1, p2, current);

  		default: throw new IllegalArgumentException("The terrain id " + id + " is not recognized.");

		}
	}
}
