package units;

import elements.characters.Player;

public class CrossbowArcher extends Ranged {

	public static final int ID = 1;

	public CrossbowArcher(Player owner, int amount) {
		super(owner, amount);
		this.setAttack(50);
		this.setDefense(300);
		this.setInitialDefense(300);
		this.setRange(3);
	}

	@Override public int getId() {
		return 1;
	}
}
