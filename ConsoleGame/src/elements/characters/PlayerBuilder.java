package elements.characters;

import elements.Gold;
import elements.ICollectable;
import elements.villages.VillageBuilder;

public class PlayerBuilder {

	private Player player;

	public PlayerBuilder() {
	}

	public PlayerBuilder create() {
		this.player = PlayerBuilder.create(PlayerBuilder
				.createGold(Player.INITIAL_GOLD));

		return this;
	}

	public static Player create(ICollectable gold) {
		return new Player(gold);
	}

	public static ICollectable createGold(int amount) {
		ICollectable gold = new Gold(amount);

		return gold;
	}

	public PlayerBuilder setInitialVillages() {
		for (int i = 0; i < Player.INITIAL_VILLAGES; i++) {
			this.player.setVillage(new VillageBuilder().setPlayer(this.player)
					.create().setInitialIncome().get());
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
