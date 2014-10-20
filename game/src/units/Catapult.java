package units;

import characters.Player;

public class Catapult extends Cavalry {

  public static final int ID = 6;

  protected final int id = 6;
  
  protected int stackAttack = 70;
  protected int stackDefense = 150;
  
  protected final int defense = 150;

  public Catapult(Player owner, int amount) {
    super(owner, amount);
  }

}