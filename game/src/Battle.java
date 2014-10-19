import units.IWarrior;
import units.Units;
import characters.Player;
import elements.IConquerable;


public class Battle {

  private Player attacker;
  private Player defender;
  
  private Player winner;
  
  private IConquerable village;
  
  private boolean isFinished;
  
  public Battle(Player attacker, Player defender
//		  , IConquerable village
		  ) {
    this.attacker = attacker;
    this.defender = defender;
    this.village = village;
  }
  
  public Player getAttacker() {
    return this.attacker;
  }
  
  public Player getDefender() {
    return this.defender;
  }
  
  public IConquerable getVillage() {
    return this.village;
  }
  
  public void finish(Player winner) {
    this.winner = winner;
    this.isFinished = true;
    
    if (this.winner.equals(this.getAttacker())) {
      this.getAttacker().conquerVillage(this.getVillage());
    } else {
      this.getAttacker().loseBattle();
    }
  }

  public void hit(Units attackingUnit, Units defendingUnit) {
    attackingUnit.hit(defendingUnit);
    
    this.checkResult();
  }
  
  private void checkResult() {
    if (!this.getAttacker().hasAliveUnits()) {
      this.finish(this.getDefender());
    } else if (!this.getDefender().hasAliveUnits()) {
      this.finish(this.getAttacker());
    }
  }
}
