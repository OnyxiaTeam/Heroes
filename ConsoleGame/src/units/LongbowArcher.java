package units;

import elements.characters.Player;

public class LongbowArcher extends Ranged {

	public static final int ID = 2;

	protected int id = 2;

	public LongbowArcher(Player owner, int amount) {
		super(owner, amount);
		this.setAttack(110);
		this.setDefense(800);
		this.setInitialDefense(800);
		this.setRange(5);
	}

	@Override public int getId() {
		return 2;
	}
}
