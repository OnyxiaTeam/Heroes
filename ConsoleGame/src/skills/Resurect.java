package skills;

import elements.characters.Player;

public class Resurect extends Defensive {

	public static final int ID = 1;
	
	public Resurect(Player owner) {
		super(owner);
		this.setId(1);
	}

	@Override
	public void cast(Player defender) {
		int percentage = (int) (Math.random() * 100);
		this.getOwner().resurectUnits(percentage);
		
		System.out.println(this.getOwner().getName() + " resurected some dead units");
	}

}
