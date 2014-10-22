package units;

import elements.characters.Player;

public abstract class Ranged extends Units {

	protected int range;

	public Ranged(Player owner, int amount) {
		super(owner, amount);
	}

	public int getRange() {
		return this.range;
	}
	
	protected void setRange(int range) {
		this.range = range;
	}

	public void hit(Units unit) {
		unit.absorbeHit(this.getAttack() * this.getAmount());
	}

	public void absorbeHit(int impact) {
		super.absorbeHit(impact);
	}
}
