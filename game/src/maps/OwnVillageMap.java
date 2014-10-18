package maps;

import java.util.ArrayList;

import characters.Player;
import elements.IElements;

public class OwnVillageMap extends Terrain {
	public static final int id = 3;

    
	  private boolean cantUseShop=false;
	  private boolean noConfirmationDialogue=false;

	
	public OwnVillageMap(Player p1, Player p2) {
		super(p1, p2);
	}

}
