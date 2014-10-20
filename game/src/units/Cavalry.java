package units;

import characters.Player;

public abstract class Cavalry extends Units {

  public static final double CRITICAL_CHANCE = 0.2;
  public static final double CRITICAL_MULTIPLIER = 1;
  
  public Cavalry(Player owner, int amount) {
    super(owner, amount);
  }
  
  public void hit(Units unit) {
    double chance = Math.random();
    
    int impact = this.getAttack();
    
    if (chance <= Cavalry.CRITICAL_CHANCE) {
      impact *= Cavalry.CRITICAL_MULTIPLIER;
    }
    
    unit.absorbeHit(impact);
  }

}
