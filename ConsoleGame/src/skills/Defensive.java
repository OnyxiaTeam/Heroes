package skills;

import elements.characters.Player;

public abstract class Defensive extends SkillsAbstract {

	public Defensive(Player owner) {
		super(owner);
	}

	public abstract void cast(Player defender);
	
}
