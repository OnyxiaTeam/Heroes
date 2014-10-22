package elements.characters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import skills.SkillsAbstract;
import units.Units;
import elements.Gold;
import elements.ICollectable;
import elements.IElement;
import elements.villages.IConquerable;

public class Player implements IElement {

	private ArrayList<ICollectable> resources = new ArrayList<ICollectable>();
	private ArrayList<IConquerable> villages = new ArrayList<IConquerable>();
	private ArrayList<Units> units = new ArrayList<Units>();
	
	private HashMap<Integer, Integer> deadUnits = new HashMap<Integer, Integer>();
	private ArrayList<SkillsAbstract> skills = new ArrayList<SkillsAbstract>();

	private int turns;
	private String name;
	public static final int INITIAL_TURNS = 5;
	public static final int INITIAL_VILLAGES = 6;
	public static final int INITIAL_GOLD = 19000;

	public Player(ICollectable gold) {
		this.resources.add(gold);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void increaseResource(ICollectable res) {
		this.getResources().stream()
				.filter(r -> r.getClass() == res.getClass()).findFirst().get()
				.increase(res.getAmount());
	}

	public ArrayList<ICollectable> getResources() {
		return this.resources;
	}

	/**
	 * @return list with player's villages
	 */
	public ArrayList<IConquerable> getVillages() {
		return this.villages;
	}

	/**
	 * Adds village to the player's list and notifies the IConquerable object
	 * about the change
	 * 
	 * @param village
	 *            The village to conquer
	 */
	public void conquerVillage(IConquerable village) {
		village.conquer(this);
		this.setVillage(village);
	}

	public void setVillage(IConquerable village) {
		this.getVillages().add(village);
	}

	/**
	 * Removes a village from the player's list. The global game object should
	 * call this method from opponent context in order to conquer from current
	 * player
	 * 
	 * @param village
	 *            The village to remove
	 */
	public void removeVillage(IConquerable village) {
		this.getVillages().remove(village);
	}

	public boolean hasVillages() {
		return this.getVillages().size() > 0;
	}

	public int getTurns() {
		return this.turns;
	}

	/**
	 * Sets player turns to the default configuration
	 */
	public void resetTurns() {
		this.turns = Player.INITIAL_TURNS;
	}

	/**
	 * Decrements a turn
	 */
	public void decrementTurn() {
		this.turns -= 1;
	}

	public boolean hasTurnsLeft() {
		return this.turns > 0;
	}

	public boolean hasEnoughTurns(int turns) {
		return this.turns >= turns;
	}

	public IConquerable getNextVillage() {
		return this.getVillages().iterator().next();
	}

	public ArrayList<Units> getUnits() {
		return this.units;
	}

	public void addUnit(Units unit) {
		if (!this.hasUnit(unit)) {
			this.getUnits().add(unit);
		} else {
			this.getUnitFromType(unit).increaseAmount(unit.getAmount());
		}
	}

	public Units getUnitFromType(Units unit) {
		return this.getUnits().stream()
				.filter(u -> u.getClass() == unit.getClass()).findFirst().get();
	}

	public boolean hasUnit(Units unit) {
		return this.getUnits().stream()
				.filter(u -> u.getClass() == unit.getClass()).count() > 0;
	}

	public void killUnit(Units unit) {
		this.getUnits().removeIf(t -> t.getClass() == unit.getClass());
	}

	public boolean hasAliveUnits() {
		return this.getUnits().stream().filter(u -> u.getAmount() > 0).count() > 0;
	}

	public void loseBattle() {
		ICollectable gold = this.getResources().stream()
				.filter(r -> r.getClass() == new Gold(1000).getClass())
				.findFirst().get();

		gold.decrease(gold.getAmount() / 2);
	}
	
	public Units getUnitById(int id) {
		return this.getUnits()
				.stream()
				.filter(u -> u.getId() == id)
				.findFirst()
				.get();
	}
	
	public void decreaseResource(ICollectable resource) throws Exception {
		ICollectable res = getResources()
			.stream()
			.filter(r -> r.getClass() == resource.getClass())
			.findFirst()
			.get();
		
		if (res.getAmount() <= resource.getAmount()) {
			throw new Exception("You do not have that much resources");
		}
		
		res.decrease(resource.getAmount());
	}
	
	public String getUnitsTable() {
		String response = "[Id] Unit   ==>   Count\n";
		response += "--------------------------\n";
		
		for (Units u : this.getUnits()) {
			String[] unitName = u.getClass().toString().split("\\.");
			response += "[" + u.getId() + "] " + unitName[1] + "   ==>   " + u.getAmount() + "\n";
		}
		
		return response;
	}
	
	public void addDeadUnit(int unitId, int amount) {
		Integer count = this.deadUnits.get(unitId);
		if (count == null) {
			this.deadUnits.put(unitId, amount);
		} else {
			this.deadUnits.put(unitId, amount + count);
		}
	}
	
	public HashMap<Integer, Integer> getDeadUnits() {
		return this.deadUnits;
	}
	
	public void resurectUnits(int percentage) {
		for (Map.Entry<Integer, Integer> es : this.getDeadUnits().entrySet()) {
			if (this.getUnitById(es.getKey()) != null) {
				Units unit = this.getUnitById(es.getKey());
				int cnt = (int)(es.getValue() * (percentage / 100));
				
				unit.increaseAmount(cnt);
				this.deadUnits.put(es.getKey(), (es.getValue()-cnt));
			}
		}
	}
	
	public ArrayList<SkillsAbstract> getSkills() {
		return this.skills;
	}
	
	public void addSkill(SkillsAbstract skill) {
		this.skills.add(skill);
	}
}
