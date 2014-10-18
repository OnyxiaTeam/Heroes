package units;

public abstract class Ranged extends Units {
  
  protected int range;

  public Ranged() {
    // TODO Auto-generated constructor stub
  }
  
  public int getRange() {
    return this.range;
  }

  public void hit(Units unit) {
    unit.absorbeHit(this.getAttack());
  }
}
