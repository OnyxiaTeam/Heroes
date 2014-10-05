import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Map {
	String map[] = new String[15];
	BufferedReader reader;
	
	public Map(String level) {
		try {
			reader = new BufferedReader(new FileReader("maps/level".concat(level).concat("-terrain.txt")));
		} catch (FileNotFoundException e) {
			System.out.println("Wrong file name be batka!");
		}
	}
	
	public String[] getMap() {
		try {
			for (int i = 0; i < 15; i++) {
				map[i] = reader.readLine();
			}
		} catch (IOException e) {
			System.out.println("Not enough lines be batka!");
		}
		return map;
	}
}
