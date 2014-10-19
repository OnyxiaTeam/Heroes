package units;

import characters.Player;

public abstract class Infantry extends Units {

  public static final double CRITICAL_CHANCE = 0.5;
  public static final double CRITICAL_MULTIPLIER = 2;
  
  public Infantry(Player owner, int amount) {
    super(owner, amount);
  }
  
  public void hit(Units unit) {
    double chance = Math.random();
    
    int impact = this.getAttack();
    
    if (chance <= Infantry.CRITICAL_CHANCE) {
      impact *= Infantry.CRITICAL_MULTIPLIER;
    }
    
    unit.absorbeHit(impact);
  }

}
