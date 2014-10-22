package units;

import elements.characters.Player;

public class Griffin extends Infantry {

	public static final int ID = 5;

	public Griffin(Player owner, int amount) {
		super(owner, amount);
		this.setAttack(80);
		this.setDefense(600);
		this.setInitialDefense(600);
	}
	
	@Override public int getId() {
		return 5;
	}
}
