package skills;

import elements.characters.Player;

public final class SkillsFactory {

	private SkillsFactory() { }
	
	public static SkillsAbstract create(Player owner, int skillId) {
		switch (skillId) {
			case Resurect.ID:
				return new Resurect(owner);
			case Populator.ID:
				return new Populator(owner);
			case Mirror.ID:
				return new Mirror(owner);
			case Mana.ID:
				return new Mana(owner);
			default:
				throw new IllegalArgumentException();
		}
	}

}
