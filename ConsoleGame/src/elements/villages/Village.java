package elements.villages;

import java.util.ArrayList;

import menu.BuyMenu;
import units.Units;
import Battle.Battle;
import elements.IElement;
import elements.characters.Player;

public class Village implements IConquerable, IElement {

	private Player owner;

	private ArrayList<Units> units = new ArrayList<Units>();

	private int goldIncome;

	public static final int INITIAL_GOLD_INCOME = 1000;

	public Village(Player owner) {
		this.setOwner(owner);
	}

	@Override
	public void conquer(Player p) {
		this.setOwner(p);
	}

	public void setOwner(Player player) {
		this.owner = player;
	}

	public Player getOwner() {
		return this.owner;
	}

	public void setGoldIncome(int income) {
		this.goldIncome = income;
	}

	public int getGoldIncome() {
		return this.goldIncome;
	}

	public ArrayList<Units> getUnits() {
		return this.units;
	}

	public void addUnit(Units unit) {
		this.units.add(unit);
	}

	public void enter(Player p) {
		if (p.equals(this.getOwner())) {
			new BuyMenu(this.getOwner());
		} else {
			System.out.println("You have netered in hostile village. A battle has started");
			new Battle(p, this.getOwner(), this);
		}
	}

}
