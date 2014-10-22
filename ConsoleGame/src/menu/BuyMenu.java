package menu;

import java.util.HashMap;
import java.util.Scanner;

import units.CrossbowArcher;
import units.Griffin;
import units.LongbowArcher;
import units.Pikeman;
import units.Swordsman;
import units.UnitsFactory;
import elements.Gold;
import elements.ICollectable;
import elements.characters.Player;

public class BuyMenu extends MenuAbstract {

	private HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();

	public BuyMenu(Player player) {
		super(player);
		items.put(Griffin.ID, 800);
		items.put(LongbowArcher.ID, 600);
		items.put(Pikeman.ID, 200);
		items.put(Swordsman.ID, 300);
		items.put(CrossbowArcher.ID, 500);

		String cmd = "";
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Welcome to the buy menu\n To buy an item enter 'buy'.\n "
						+ "To get menu list enter 'list'\n"
						+ "To go to Skills menu, enter 'skills' "
						+ "To exit - enter 'exit'\n");
		while (!cmd.equals("exit")) {
			cmd = sc.nextLine();
			if (cmd.equals("buy")) {
				System.out.println("Enter unit id (the one in the brackets)");
				int unitId = sc.nextInt();
				System.out.println("Enter amount");
				int amount = sc.nextInt();
				
				this.buy(unitId, amount);
			}
			
			if (cmd.equals("list")) {
				System.out.println(this.getMenu());
			}
			
			if (cmd.equals("skills")) {
				new SkillsMenu(this.getPlayer());
			}
		}
	}

	public void buy(int unitId, int amount) {
		ICollectable gold = new Gold(this.items.get(unitId) * amount);
		try {
			this.getPlayer().decreaseResource(gold);
			UnitsFactory.create(this.getPlayer(), amount, unitId);
			System.out.println("You have succesfully bought the units.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getMenu() {
		String response = "";

		response += "Griffin [" + Griffin.ID + "] ===> "
				+ items.get(Griffin.ID) + " Gold\n";
		response += "Longbow Archer [" + LongbowArcher.ID + "] ===> "
				+ items.get(LongbowArcher.ID) + " Gold\n";
		response += "Pikeman [" + Pikeman.ID + "] ===> "
				+ items.get(Pikeman.ID) + " Gold\n";
		response += "Sowrdsman [" + Swordsman.ID + "] ===> "
				+ items.get(Swordsman.ID) + " Gold\n";
		response += "Crossbow Archer [" + CrossbowArcher.ID + "] ===> "
				+ items.get(CrossbowArcher.ID) + " Gold\n";

		return response;
	}

}
