package elements;

public class Gold implements ICollectable, IGood {

  protected int amount;
  
  @Override public int getAmount() {
    return this.amount;
  }

  @Override public void setAmount(int amount) {
    this.amount = amount;
  }
  
  @Override public void increaseAmount(int amount) {
    this.amount += amount;
  }
  
}
