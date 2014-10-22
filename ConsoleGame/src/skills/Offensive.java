package skills;

import units.Units;
import elements.characters.Player;

public abstract class Offensive extends SkillsAbstract {

	public Offensive(Player owner) {
		super(owner);
	}
	
	public abstract void cast(Player defender);

}
