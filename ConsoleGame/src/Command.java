import elements.characters.Player;

public class Command extends CommandAbstract {

	private Starter app;
	
	public Command(Starter app, String command) {
		this.setCommand(command);
		this.app = app;
	}

	public Starter getApp() {
		return this.app;
	}

	public String getResponse() {
		switch (this.getCommand()) {
			case "move right":
				return this.getApp().getMap()
						.moveRight(this.getApp().getCurrentPlayer());
			case "move left":
				return this.getApp().getMap()
						.moveLeft(this.getApp().getCurrentPlayer());
			case "move up":
				return this.getApp().getMap()
						.moveTop(this.getApp().getCurrentPlayer());
			case "move down":
				return this.getApp().getMap()
						.moveBottom(this.getApp().getCurrentPlayer());
			case "map":
				return this.getApp().getMap()
						.getMapTable(this.getApp().getCurrentPlayer());
			default:
				return "";
		}
	}

}
