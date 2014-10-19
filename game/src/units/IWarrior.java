package units;

public interface IWarrior {
  
  public int getAmount();

  public void setAmount(int amount);
  
  public void increaseAmount(int amount);
  
  public void hit(Units u);
  
  public void absorbeHit(int impact);
  
  public int getId();
}
