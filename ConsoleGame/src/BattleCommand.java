import Battle.Battle;
import units.CrossbowArcher;
import elements.characters.Player;

public class BattleCommand extends CommandAbstract {

	private Battle battle;
	private Player player;
	private Player attacked;

	public BattleCommand(Player player, Player attacked, Battle battle,
			String command) {
		this.setCommand(command);
		this.battle = battle;
		this.player = player;
		this.attacked = attacked;
	}

	public Battle getBattle() {
		return this.battle;
	}

	public Player getPlayer() {
		return this.player;
	}

	@Override
	public String getResponse() {
		return null;
	}

}
