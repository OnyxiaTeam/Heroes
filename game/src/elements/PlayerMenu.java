package elements;

import java.util.HashMap;

import characters.Player;
import units.CrossbowArcher;
import units.Griffin;
import units.LongbowArcher;
import units.Pikeman;
import units.Swordsman;
import units.UnitsFactory;

public class PlayerMenu {
	
	public int currentPrice=0;
	private HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
	
	public PlayerMenu() {
		items.put(Griffin.ID, 1000);
		items.put(LongbowArcher.ID,500);
		items.put(Pikeman.ID, 300);
		items.put(Swordsman.ID,400);
		items.put(CrossbowArcher.ID,700);
		
	}
	
	public void buy(Player p, int unitId){
		int price = this.items.get(unitId);
		IGood gold = new Gold();
		try {
			p.decreaseResource(gold, price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
