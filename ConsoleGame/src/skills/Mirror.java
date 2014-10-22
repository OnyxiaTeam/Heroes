package skills;

import java.util.ArrayList;

import units.Units;
import elements.characters.Player;

public class Mirror extends Defensive {
	
	public static final int ID = 3;

	public Mirror(Player owner) {
		super(owner);
		this.setId(3);
	}

	@Override
	public void cast(Player defender) {
		ArrayList<Units> attackers = this.getOwner().getUnits();
		ArrayList<Units> defenders = defender.getUnits();
		
		attackers.get((int)(Math.random() * attackers.size())).hit(
				defenders.get((int)(Math.random() * attackers.size()))
		);
		
		System.out.println("Random unit from : " + this.getOwner().getName() + " attacked defender");
	}

}
