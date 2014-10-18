package units;

import characters.Player;

public class Swordsman extends Infantry {

  public static final int ID = 3;

  protected final int id = 3;
  
  protected int stackAttack = 30;
  protected int stackDefense = 100;
  
  protected final int defense = 100;

  public Swordsman(Player owner, int amount) {
    super(owner, amount);
  }

}
