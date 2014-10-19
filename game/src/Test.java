import characters.Player;
import characters.PlayerBuilder;


public class Test {

  public static void main(String[] args) {
    Player p1 = new PlayerBuilder().create().setInitialTurns().setInitialVillages().get();
    

  }

}
