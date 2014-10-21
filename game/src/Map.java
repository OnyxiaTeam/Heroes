import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Map {
	
	private String map[] = new String[15];
	BufferedReader terrain;
	BufferedReader units;
	
	public Map(String level) {
		try {
			terrain = new BufferedReader(new FileReader("maps/level".concat(level).concat("-terrain.txt")));
			units = new BufferedReader(new FileReader("maps/level".concat(level).concat("-units.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("Wrong file name be batka!");
		}
	}
	
	public String[] getMapTerrain() {
		try {
			for (int i = 0; i < 15; i++) {
				map[i] = terrain.readLine();
			}
		} catch (IOException e) {
			System.out.println("Not enough lines be batka!");
		}
		return map;
	}
	
	public String[] getMapUnits() {
		try {
			for (int i = 0; i < 15; i++) {
				map[i] = units.readLine();
			}
		} catch (IOException e) {
			System.out.println("Not enough lines be batka!");
		}
		System.out.println(map.toString());
		
		return map;
	}
	
	
}
