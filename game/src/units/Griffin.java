package units;

import characters.Player;

public class Griffin extends Infantry {

  public static final int ID = 5;
  
  protected final int id = 5;
  
  protected int stackAttack = 80;
  protected int stackDefense = 600;
  
  protected final int defense = 600;
  
  public Griffin(Player owner, int amount) {
    super(owner, amount);
  }
}
