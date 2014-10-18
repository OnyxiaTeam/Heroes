package units;

import characters.Player;

public final class UnitsFactory {

  private UnitsFactory() { }
  
  public static IWarrior create(Player owner, int amount, int id) {
    switch (id) {
      case CrossbowArcher.ID:
        return new CrossbowArcher(owner, amount);
      case LongbowArcher.ID:
        return new LongbowArcher(owner, amount);
      case Pikeman.ID:
        return new Pikeman(owner, amount);
      case Swordsman.ID:
        return new Swordsman(owner, amount);
      case Griffin.ID:
        return new Griffin(owner, amount);
      default:
        throw new IllegalArgumentException();
    }
  }
}
