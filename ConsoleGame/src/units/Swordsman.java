package units;

import elements.characters.Player;

public class Swordsman extends Infantry {

	public static final int ID = 3;

	protected int id = 3;

	protected int stackAttack = 30;
	protected int stackDefense = 100;

	protected final int defense = 100;

	public Swordsman(Player owner, int amount) {
		super(owner, amount);
		this.setAttack(30);
		this.setDefense(100);
		this.setInitialDefense(100);
	}
	
	@Override public int getId() {
		return 3;
	}

}
