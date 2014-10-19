package units;

import characters.Player;

public class LongbowArcher extends Ranged {

  public static final int ID = 2;
  
  protected final int id = 2;
  
  protected int stackAttack = 110;
  protected int stackDefense = 800;
  protected int range = 5;
  
  protected final int defense = 800;
  
  public LongbowArcher(Player owner, int amount) {
    super(owner, amount);
  }

}
