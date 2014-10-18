package units;

import characters.Player;
import elements.Village;

public abstract class Units implements IWarrior {

  protected Player owner;
  protected Village village;
  
  protected int amount;
  
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
  
  
}
