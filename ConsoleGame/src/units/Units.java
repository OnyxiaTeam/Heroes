package units;

import elements.characters.Player;
import elements.villages.IConquerable;

public abstract class Units implements IWarrior {

	public static final int ID = -1;

	protected int id;

	protected Player owner;
	protected IConquerable village;

	protected int amount;

	protected int stackAttack = -1;
	protected int stackDefense = -1;

	protected int defense = -1;

	public Units(Player owner, int amount) {
		this.owner = owner;
		this.amount = amount;
		this.stackDefense = this.getAmount() * this.defense;

		this.getOwner().addUnit(this);
	}

	public void setVillage(IConquerable village) {
		this.village = village;
	}

	public int getAmount() {
		return this.amount;
	}

	public void setAmount(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}

		this.amount = amount;
	}

	public void increaseAmount(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		}

		this.amount += amount;
	}

	public int getAttack() {
		return this.stackAttack;
	}

	public int getDefense() {
		return this.stackDefense;
	}

	public int getId() {
		return this.id;
	}

	public Player getOwner() {
		return this.owner;
	}

	public IConquerable getVillage() {
		return this.village;
	}

	abstract public void hit(Units u);

	public void absorbeHit(int impact) {
		this.setDefense((-1) * impact);

		if (impact > this.defense) {
			int unitsToDie = Math.round(impact / this.defense);
			this.amount -= unitsToDie;
			this.setDefense(this.getAmount() * this.defense);
			
			System.out.println(unitsToDie + " units dies from " + this.getOwner().getName());

			if (this.amount <= 0) {
				this.amount = 0;
				this.getOwner().killUnit(this);
				System.out.println("All units from this type has died");
			}
		}
		
		System.out.println(this.getOwner().getName() + " left with " + this.getAmount() + " units");
	}
	
	protected void setDefense(int defense) {
		this.stackDefense = defense;
	}
	
	protected void setAttack(int attack) {
		this.stackAttack = attack;
	}
	
	protected void setInitialDefense(int defense) {
		this.defense = defense;
	}
	
}
