package skills;

import units.Units;
import elements.characters.Player;

public class Populator extends Offensive {
	
	public static final int ID = 2;

	private int population = 100;
	
	public Populator(Player owner) {
		super(owner);
		this.setId(2);
	}

	@Override
	public void cast(Player defender) {
		Units unit = this.getOwner().getUnits().iterator().next();
		unit.increaseAmount((int) (Math.random() * this.population));
		
		System.out.println(unit.getId() + " unit has increased its population");
	}

}
