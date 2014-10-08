package maps;

import java.util.ArrayList;

import characters.Player;
import elements.IElements;

public class TerrainFactory {

	public enum TerrainType {
		BattleMap,
		GlobalMap,
		OwnVillageMap
	}
	public static Terrain chooseMap(TerrainType,terrainType){
		switch(terrainType){
		case BattleMap
			return new BattleMap();
		case GlobalMap
			return new GlobalMap();
		case OwnVillageMap();
		}
		throw new IllegalArgumentException("The terrain type " + terrainType + " is not recognized.");
	}
}
