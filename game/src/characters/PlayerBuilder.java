package characters;

import java.awt.Image;

import javax.swing.ImageIcon;

import elements.Gold;
import elements.IGood;
import elements.Village;
import elements.VillageBuilder;

public class PlayerBuilder {
  
  private Player player;
  public int x;
  public int y;
  private ImageIcon img = new ImageIcon("images/p1");

  public PlayerBuilder() { }
  
  public PlayerBuilder create() {
    this.player = PlayerBuilder.create(
        PlayerBuilder.createGold(Player.INITIAL_GOLD)
    );
    
    return this;
  }
  
  public static Player create(IGood gold) {
    return new Player(gold);
  }
  
  public static IGood createGold(int amount) {
    IGood gold = new Gold();
    gold.setAmount(amount);
    
    return gold;
  }
  
  public PlayerBuilder setInitialVillages() {
    for (int i = 0; i < Player.INITIAL_VILLAGES; i++) {
      this.player.setVillage(
          new VillageBuilder()
            .setPlayer(this.player)
            .create()
            .setInitialIncome()
            .get()
      );
    }
    
    return this;
  }
  
  public PlayerBuilder setInitialTurns() {
    this.player.resetTurns();
    
    return this;
  }
  
  public Player get() {
    return this.player;
  }


}
