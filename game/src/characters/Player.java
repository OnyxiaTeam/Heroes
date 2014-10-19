package characters;


import java.util.ArrayList;

import maps.*;
import elements.Gold;
import elements.IConquerable;
import elements.IGood;
import units.IWarrior;
import units.Units;

public class Player {

  private ArrayList<IWarrior> units = new ArrayList<IWarrior>();
  private ArrayList<IConquerable> villages = new ArrayList<IConquerable>();
  private ArrayList<IGood> resources = new ArrayList<IGood>();

  private int turns;
  public static final int INITIAL_TURNS = 50;
  public static final int INITIAL_VILLAGES = 6;
  public static final int INITIAL_GOLD = 1000;
  
  private Terrain currentTerrain;
  
  
  public Player(IGood gold) {
    this.resources.add(gold);
  }
  
  public Terrain getCurrentMap() {
    return this.currentTerrain;
  }
  
  public void changeMap(Terrain map) {
    this.currentTerrain = map;
  }

  /**
   * If player does not have this type of resource, adds it, otherwise - increase the amount
   * 
   * @param resource  The resource type
   * @param count     The resource count
   * @throws InvallidArgumentException if the count is zero or less
   */
  public void setResource(IGood resource, int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("Count should be positive number");
    }
    
    if (!this.hasResource(resource)) {
      this.addResource(resource);
    } else {
      this.increaseResource(resource, count);
    }
  }
  
  /**
   * @return the list of player's resources
   */
  public ArrayList<IGood> getResources() {
    return this.resources;
  }
  
  /**
   * @return the list of player's units
   */
  public ArrayList<IWarrior> getUnits() {
    return this.units;
  }
  
  /**
   * If player does not have this kind of unit - adds it, otherwise - increase the count
   * 
   * @param unit  The unit type
   * @param count The unit count
   * @throws InvallidArgumentException if the count is zero or less
   */
  public void setUnit(IWarrior unit, int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("Count should be positive number");
    }
    
    if (!this.hasUnit(unit)) {
      this.addUnit(unit);
    } else {
      this.increaseUnit(unit, count);
    }
  }
  
  /**
   * Decreases unit count from player's units list
   * If unit becomes zero or less - kill the particular unit
   * 
   * @param unit  The type of unit
   * @param count Amount to remove
   * @throws InvallidArgumentException if the count is zero or less
   */
  public void removeUnit(IWarrior unit, int count) {
    if (count <= 0) {
      throw new IllegalArgumentException("Count should be positive number");
    }
    
    this.decreaseUnit(unit, count);
    
    if (this.isUnitDead(unit)) {
      this.killUnit(unit);
    }
  }
  
  /**
   * @return list with player's villages
   */
  public ArrayList<IConquerable> getVillages() {
    return this.villages;
  }
  
  /**
   * Adds village to the player's list and notifies the IConquerable object about the change
   * @param village The village to conquer
   */
  public void conquerVillage(IConquerable village) {
    village.conquer(this);
    this.setVillage(village);
  }
  
  public void setVillage(IConquerable village) {
    this.getVillages().add(village);
  }
  
  /**
   * Removes a village from the player's list.
   * The global game object should call this method from opponent context
   * in order to conquer from current player
   * 
   * @param village The village to remove
   */
  public void removeVillage(IConquerable village) {
    this.getUnits().remove(village);
  }
  
  public boolean hasVillages() {
    return this.getVillages().isEmpty();
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
	  if(currentTerrain instanceof BattleMap){
	    this.turns -= 1;
	  }
  }

  public boolean hasTurnsLeft() {
    return this.turns > 0;
  }
  
  public boolean hasEnoughTurns(int turns) {
    return this.turns >= turns;
  }
  
  private void addResource(IGood resource) {
    this.getResources().add(resource);
  }
  
  private void increaseResource(IGood resource, int amount) {
    this.getResources().
      stream().
      filter(r -> r.getClass() == resource.getClass()).
      forEach(r -> r.increaseAmount(amount));
  }
  
  public void decreaseResource(IGood resource, int amount) throws Exception {
   
    for(IGood res : this.resources) {
    	if(res.getClass()==resource.getClass()){
    		if(amount<res.getAmount()){
    			 amount *= -1;
    			 this.increaseResource(resource, amount);
    		}
    	}
    }
    
   throw new Exception();
    
  }
  
  private boolean hasResource(IGood resource) {
    return this.getResources().
      stream().
      anyMatch(r -> r.getClass() == resource.getClass());
  }
  
  private boolean hasUnit(IWarrior unit) {
    return this.getUnits().
      stream().
      anyMatch(u -> u.getClass() == unit.getClass());
  }
  
  private void addUnit(IWarrior unit) {
    this.getUnits().add(unit);
  }
  
  private IWarrior getUnitFromType(IWarrior type) {
    return this.getUnits()
    .stream()
    .filter(u -> u.getClass() == type.getClass())
    .findFirst()
    .get();
  }
  
  private void increaseUnit(IWarrior unit, int amount) {
    this.getUnits().
      stream().
      filter(u -> u.getClass() == unit.getClass()).
      forEach(u -> u.increaseAmount(amount));
  }
  
  private void decreaseUnit(IWarrior unit, int amount) {
    amount *= -1;
    this.increaseUnit(unit, amount);
  }
  
  private boolean isUnitDead(IWarrior unit) {
    return this.getUnitFromType(unit).getAmount() <= 0;
  }
  
  public void killUnit(IWarrior unit) {
    this.getUnits().removeIf(t -> t.getClass() == unit.getClass());
  }
  
  public boolean hasAliveUnits() {
    return this.getUnits()
      .stream()
      .filter(u -> u.getAmount() > 0)
      .count() > 0;
  }
  
  public void loseBattle() {
    IGood gold = this.getResources()
      .stream()
      .filter(r -> r.getClass() == new Gold().getClass())
      .findFirst()
      .get();
    
    gold.setAmount(gold.getAmount() / 2);
  }

}