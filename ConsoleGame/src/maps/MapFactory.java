package maps;

import elements.characters.Player;

public final class MapFactory {

	private MapFactory() { }
	
	public static MapAbstract create(Player p1, Player p2, int id) {
		switch (id) {
			case GlobalMap.ID:
				return new GlobalMap(p1, p2);
			default:
				throw new IllegalArgumentException();
		}
	}

}
