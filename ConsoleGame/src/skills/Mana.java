package skills;

import units.Units;
import elements.characters.Player;

public class Mana extends Offensive {
	
	public static final int ID = 4;
	
	private int damage = 1000;

	public Mana(Player owner) {
		super(owner);
		this.setId(4);
	}

	@Override public void cast(Player defender) {
		for (Units u : defender.getUnits()) {
			u.absorbeHit(this.damage);
			System.out.println(defender.getName() + " unit: " + u.getId() + " absorbed: "
					+  this.damage + " damage");
		}
	}

}
