package maps;

import java.util.ArrayList;

import characters.Player;
import elements.IElements;

public class TerrainFactory {

    private static ArrayList<IElements> elements;
    private static Player p1;
    private static Player p2;
    private static Player current;
	private static int terrainType;
	
    public TerrainFactory(ArrayList<IElements> elements,Player p1,Player p2,Player current,int terrainType ){
		TerrainFactory.elements = elements;
		TerrainFactory.p1 = p1;
		TerrainFactory.p2 = p2;
		TerrainFactory.current = current;
		TerrainFactory.terrainType = terrainType;
	}
	
	
	public static Terrain chooseMap(int terrainType){
		switch(TerrainFactory.terrainType){
		case 1 :
			return new BattleMap(elements, p1, p2, current);
		case 2:
			return new GlobalMap(elements, p1, p2, current);
		case 3:
			return new OwnVillageMap(elements, p1, p2, current);
		}
		throw new IllegalArgumentException("The terrain type " + terrainType + " is not recognized.");
	}
}

