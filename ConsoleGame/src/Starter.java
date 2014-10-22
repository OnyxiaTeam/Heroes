import java.io.IOException;
import java.util.Scanner;

import units.UnitsFactory;
import maps.GlobalMap;
import maps.MapAbstract;
import maps.MapFactory;
import elements.EmptyElement;
import elements.Gold;
import elements.IElement;
import elements.Obstacle;
import elements.characters.Player;
import elements.characters.PlayerBuilder;

public class Starter {

	private Player p1;
	private Player p2;

	private Player currentPlayer;

	private MapAbstract map;

	public Starter() {
		this.p1 = new PlayerBuilder().create().setInitialTurns()
				.setInitialVillages().get();
		this.p2 = new PlayerBuilder().create().setInitialTurns()
				.setInitialVillages().get();

		this.p1.setName("Player 1");
		this.p2.setName("Player 2");

		this.currentPlayer = p1;

		this.map = MapFactory.create(p1, p2, GlobalMap.ID);
	}

	public MapAbstract getMap() {
		return this.map;
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Starter inst = new Starter();
		inst.render();

		System.out
				.println("Welcome to the game.\n"
						+ "You are now on the global map and the game is waiting for your commands\n"
						+ "Allowed commands: 'move right', 'move left', 'move up', 'move down', 'map'\n");

		UnitsFactory.create(inst.p2, 10, 1);
		
		while (!inst.isFinished()) {
			System.out.print("You have : ");
			inst.currentPlayer
					.getResources()
					.stream()
					.forEach(
							t -> System.out.println(t.getAmount()
									+ " "
									+ inst.getResourceType(t.getClass()
											.toString())));

			Command cmd = new Command(inst, sc.nextLine());
			Response resp = cmd.execute();
			System.out.println(resp.getMessage());

			System.out.println("You have : "
					+ inst.getCurrentPlayer().getTurns() + " turns left");

			inst.changePlayer();

			inst.finishCycle();
		}
	}

	public void render() throws IOException {
		MapReader reader = new MapReader(this.getMap().getId());
		for (int i = 0; i < MapAbstract.MAP_X; i++) {
			for (int j = 0; j < reader.getParsedMap()[i].length(); j++) {
				char ch = reader.getParsedMap()[i].charAt(j);
				IElement el = this.getParsedObject(ch);

				this.getMap().render(i, j, el);
			}
		}
	}

	public IElement getParsedObject(char ch) {
		switch (ch) {
			case 'a':
				return this.p1;
			case 'e':
				return new EmptyElement();
			case 't':
				return new Obstacle();
			case 'g':
				return new Gold((int) (Math.random() * 1000));
			case 'b':
				return this.p2;
			case 'v':
				return (IElement) this.p1.getNextVillage();
			case 'f':
				return (IElement) this.p2.getNextVillage();
			default:
				throw new IllegalArgumentException();
		}
	}

	public void changePlayer() {
		if (!this.getCurrentPlayer().hasTurnsLeft()) {
			if (this.getCurrentPlayer().equals(this.p1)) {
				this.currentPlayer = this.p2;
				this.p1.resetTurns();
				System.out.println("It's Player 2's turn");
			} else {
				this.currentPlayer = this.p1;
				this.p2.resetTurns();
				System.out.println("It's Player 1's turn");
			}
		}
	}

	public boolean isFinished() {
		return !this.p1.hasVillages() || !this.p2.hasVillages();
	}

	public void finishCycle() {
		if (!this.isFinished()) return;
		
		String winner = "";
		if (!this.p1.hasVillages()) {
			winner = this.p2.getName();
		} else if (!this.p2.hasVillages()) {
			winner = this.p1.getName();
		}

		System.out.println(winner + " has win the game");
	}

	public String getResourceType(String resourceClass) {
		return resourceClass.split("\\.")[1];
	}
}
