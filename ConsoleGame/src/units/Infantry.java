package units;

import skills.Offensive;
import elements.characters.Player;

public abstract class Infantry extends Units {

	public static final double CRITICAL_CHANCE = 0.5;
	public static final double CRITICAL_MULTIPLIER = 2;

	public Infantry(Player owner, int amount) {
		super(owner, amount);
	}

	public void hit(Units unit) {
		this.getOwner().getSkills()
			.stream()
			.filter(s -> (s instanceof Offensive))
			.forEach(s -> s.cast(unit.getOwner()));
		
		double chance = Math.random();

		int impact = this.getAttack() * this.getAmount();

		if (chance <= Infantry.CRITICAL_CHANCE) {
			impact *= Infantry.CRITICAL_MULTIPLIER;
			System.out.println("You have made a critical hit x" + Infantry.CRITICAL_MULTIPLIER);
		}

		unit.absorbeHit(impact);
	}

}
