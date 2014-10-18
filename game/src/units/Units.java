package units;

import characters.Player;
import elements.IConquerable;
import elements.Village;

public abstract class Units implements IWarrior {

  public static final int ID = -1;
  
  protected final int id = -1;
  
  protected Player owner;
  protected IConquerable village;
  
  protected int amount;
  
  protected int stackAttack = -1;
  protected int stackDefense = -1;
  
  protected final int defense = -1;
  
  public Units(Player owner, int amount) {
    this.owner = owner;
    this.amount = amount;
    this.getOwner().setUnit(this, amount);
    
    this.stackDefense = this.getAmount() * this.defense;
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
    this.stackDefense -= impact;
    
    if (impact > this.defense) {
      int unitsToDie = Math.round(impact/this.defense);
      this.amount -= unitsToDie;
      this.stackDefense = this.getAmount() * this.defense;
      
      if (this.amount <= 0) {
        this.getOwner().killUnit(this);
      }
    }
  }
}
