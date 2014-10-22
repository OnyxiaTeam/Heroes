package elements;

import elements.characters.Player;

public interface ICollectable {
	
	void collect(Player p);
	
	int getAmount();
	
	void increase(int i);
	
	void decrease(int i);
	
}
