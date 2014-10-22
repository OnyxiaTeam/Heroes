package elements.villages;

import elements.characters.Player;

public class VillageBuilder {

	private Village village;
	private Player player;

	public VillageBuilder() {
	}

	public VillageBuilder setPlayer(Player player) {
		this.player = player;

		return this;
	}

	public VillageBuilder create() {
		this.village = new Village(this.player);

		return this;
	}

	public VillageBuilder setInitialIncome() {
		this.village.setGoldIncome(Village.INITIAL_GOLD_INCOME);

		return this;
	}

	public Village get() {
		return this.village;
	}

}
