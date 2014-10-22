package elements;

import elements.characters.Player;

public class Gold implements IElement, ICollectable {

	private int amount;

	public Gold(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return this.amount;
	}

	public void collect(Player p) {
		p.increaseResource(this);
	}

	public void increase(int i) {
		if (i < 0) {
			throw new IllegalArgumentException();
		}

		this.amount += i;
	}

	public void decrease(int i) {
		if (i < 0) {
			throw new IllegalArgumentException();
		}

		this.amount -= i;
	}

}
