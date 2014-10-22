package skills;

import elements.characters.Player;

public abstract class SkillsAbstract {
	
	public static final int ID = -1;
	
	private int id = -1;

	private Player owner;
	
	public SkillsAbstract(Player owner) {
		this.owner = owner;
		this.getOwner().addSkill(this);
	}
	
	public Player getOwner() {
		return this.owner;
	}
	
	protected void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public abstract void cast(Player defender);
}
