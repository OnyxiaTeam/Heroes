package units;

import elements.characters.Player;

public class Pikeman extends Infantry {

	public static final int ID = 4;

	public Pikeman(Player owner, int amount) {
		super(owner, amount);
		this.setAttack(40);
		this.setDefense(120);
		this.setInitialDefense(120);
	}

	@Override public int getId() {
		return 4;
	}
}
