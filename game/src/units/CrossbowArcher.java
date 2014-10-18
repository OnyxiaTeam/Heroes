package units;

import characters.Player;

public class CrossbowArcher extends Ranged {

  public static final int ID = 1;
  
  protected final int id = 1;
  
  protected int stackAttack = 50;
  protected int stackDefense = 300;
  protected int range = 3;
  
  protected final int defense = 300;
  
  public CrossbowArcher(Player owner, int amount) {
    super(owner, amount);
  }

}
