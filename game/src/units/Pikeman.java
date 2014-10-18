package units;

import characters.Player;

public class Pikeman extends Infantry {
  
  public static final int ID = 4;
  
  protected final int id = 4;
  
  protected int stackAttack = 40;
  protected int stackDefense = 120;
  
  protected final int defense = 120;
  
  public Pikeman(Player owner, int amount) {
    super(owner, amount);
  }

}
