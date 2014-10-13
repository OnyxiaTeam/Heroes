package maps;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

import characters.Player;
import elements.IElements;

public final class TerrainFactory {

	private TerrainFactory() {
	};

	public static Terrain Create(Player p1, Player p2, int terrainId) {
		switch (terrainId) {
		case BattleMap.id:
			return new BattleMap(p1, p2);
		case GlobalMap.id:
			return new GlobalMap(p1, p2);
		case OwnVillageMap.id:
			return new OwnVillageMap(p1, p2);
		}
		throw new IllegalArgumentException("The terrain type " + terrainId
				+ " is not recognized.");

	}

}
