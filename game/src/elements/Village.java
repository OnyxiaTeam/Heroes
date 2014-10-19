package elements;

import java.util.ArrayList;

import units.IWarrior;
import characters.Player;

public class Village implements IConquerable {
  
  private Player owner;
  
  private ArrayList<IWarrior> units = new ArrayList<IWarrior>();
  
  private int goldIncome;
  
  public static final int INITIAL_GOLD_INCOME = 1000;

  public Village(Player owner) {
    this.setOwner(owner);
  }

  @Override public void conquer(Player p) {
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
  
  public ArrayList<IWarrior> getUnits() {
    return this.units;
  }
  
  public void addUnit(IWarrior unit) {
    this.units.add(unit);
  }
  
}
