package menu;

import elements.characters.Player;

public abstract class MenuAbstract {

	private Player player;
	
	public MenuAbstract(Player player) {
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public abstract String getMenu();
	
	public abstract void buy(int id, int amount);
}
