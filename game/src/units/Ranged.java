package units;

import characters.Player;

public abstract class Ranged extends Units {
  
  protected int range;
  
  public Ranged(Player owner, int amount) {
    super(owner, amount);
  }
  
  public int getRange() {
    return this.range;
  }

  public void hit(Units unit) {
    unit.absorbeHit(this.getAttack());
  }
  
  public void absorbeHit(int impact) {
    super.absorbeHit(impact);
  }
}
