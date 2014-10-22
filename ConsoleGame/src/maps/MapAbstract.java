package maps;

import java.util.HashMap;
import java.util.Map;

import coordinates.Position;
import elements.EmptyElement;
import elements.ICollectable;
import elements.IElement;
import elements.Obstacle;
import elements.characters.Player;
import elements.villages.IConquerable;

public abstract class MapAbstract {

	public static final int MAP_X = 25;
	public static final int MAP_Y = 15;

	protected int id = 8;

	private HashMap<Position, IElement> terrain = new HashMap<Position, IElement>();

	private Player p1;
	private Player p2;

	public MapAbstract(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public int getId() {
		return this.id;
	}

	public Player getPlayerOne() {
		return this.p1;
	}

	public Player getPlayerTwo() {
		return this.p2;
	}

	protected boolean isInCol(int col) {
		if (col >= 0 && col < MapAbstract.MAP_X) {
			return true;
		}

		return false;
	}

	protected boolean isInRow(int row) {
		if (row >= 0 && row < MapAbstract.MAP_Y) {
			return true;
		}

		return false;
	}

	protected boolean isInRange(int row, int col) {
		return this.isInRow(row) && this.isInCol(col);
	}

	public void render(int x, int y, IElement element) {
		Position pos = new Position(x, y);
		this.terrain.put(pos, element);
	}

	public String moveRight(IElement currentPlayer) {
		return this.move(1, 0, currentPlayer);
	}

	public String moveLeft(IElement currentPlayer) {
		return this.move(-1, 0, currentPlayer);
	}

	public String moveTop(IElement currentPlayer) {
		return this.move(0, -1, currentPlayer);
	}

	public String moveBottom(IElement currentPlayer) {
		return this.move(0, 1, currentPlayer);
	}

	protected String move(int row, int col, IElement currentPlayer) {
		Position playerPosition = this.terrain.entrySet().stream()
				.filter(t -> t.getValue().equals(currentPlayer)).findFirst()
				.get().getKey();

		if (isInRange(playerPosition.getY() + row, playerPosition.getX() + col)) {
			Position newPosition = new Position(0, 0);

			Position leftPosition = new Position(0, 0);
			Position rightPosition = new Position(0, 0);
			Position bottomPosition = new Position(0, 0);
			Position upperPosition = new Position(0, 0);

			for (Map.Entry<Position, IElement> es : this.terrain.entrySet()) {
				if (es.getKey().getX() == (playerPosition.getX() + col)
						&& es.getKey().getY() == (playerPosition.getY() + row)) {
					newPosition = es.getKey();
				}
			}

			IElement nextField = this.terrain.get(newPosition);

			String response = "";

			if (nextField instanceof ICollectable) {
				ICollectable field = (ICollectable) nextField;
				Player p = (Player) currentPlayer;

				field.collect(p);

				response += "You have collected : " + field.getAmount() + " "
						+ field.getClass();
			}

			if (nextField instanceof IConquerable) {
				IConquerable field = (IConquerable) nextField;
				Player p = (Player) currentPlayer;

				field.enter(p);
			}

			if (nextField instanceof Obstacle) {
				return "Field with coordinates " + newPosition.getX() + " : "
						+ newPosition.getY() + " is not empty";
			}

			this.terrain.put(playerPosition, new EmptyElement());
			this.terrain.put(newPosition, currentPlayer);

			for (Map.Entry<Position, IElement> es : this.terrain.entrySet()) {
				if (es.getKey().getX() == (newPosition.getX() + 0)
						&& es.getKey().getY() == (newPosition.getY() - 1)) {
					leftPosition = es.getKey();
				}

				if (es.getKey().getX() == (newPosition.getX() + 0)
						&& es.getKey().getY() == (newPosition.getY() + 1)) {
					rightPosition = es.getKey();
				}

				if (es.getKey().getX() == (newPosition.getX() + 1)
						&& es.getKey().getY() == (newPosition.getY() + 0)) {
					bottomPosition = es.getKey();
				}

				if (es.getKey().getX() == (newPosition.getX() - 1)
						&& es.getKey().getY() == (newPosition.getY() + 0)) {
					upperPosition = es.getKey();
				}
			}

			String left = this.terrain.containsKey(leftPosition) ? this
					.getElement(this.terrain.get(leftPosition).getClass()
							.toString()) : "Wall";
			String right = this.terrain.containsKey(rightPosition) ? this
					.getElement(this.terrain.get(rightPosition).getClass()
							.toString()) : "Wall";
			String up = this.terrain.containsKey(upperPosition) ? this
					.getElement(this.terrain.get(upperPosition).getClass()
							.toString()) : "Wall";
			String down = this.terrain.containsKey(bottomPosition) ? this
					.getElement(this.terrain.get(bottomPosition).getClass()
							.toString()) : "Wall";

			((Player) currentPlayer).decrementTurn();

			return response + "Moved on " + newPosition.getX() + " : "
					+ newPosition.getY() + "\n" + "Objects around you: \n"
					+ "Left: " + left + "\n" + "Right: " + right + "\n"
					+ "Up: " + up + "\n" + "Down: " + down + "\n";
		}

		return "Out of map range";
	}

	private String getElement(String elementClass) {
		return elementClass.split("\\.")[1];
	}

	public void print() {
		for (Map.Entry<Position, IElement> es : this.terrain.entrySet()) {
			System.out.println("X: " + es.getKey().getX() + " _ Y: "
					+ es.getKey().getY());
			System.out.println(es.getValue().getClass());
		}
	}

}
