import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import maps.MapAbstract;

public class MapReader {

	private int mapId;
	private BufferedReader terrain;
	private String[] map = new String[MapAbstract.MAP_X];

	public MapReader(int mapId) throws IOException {
		this.mapId = mapId;
		this.terrain = new BufferedReader(new FileReader("src/resources/map-"
				+ this.mapId + ".txt"));
		
		this.parseMap();
	}

	private void parseMap() throws IOException {
		for (int i = 0; i < MapAbstract.MAP_X; i++) {
			this.map[i] = this.terrain.readLine();
		}
	}

	public String[] getParsedMap() {
		return this.map;
	}

}
