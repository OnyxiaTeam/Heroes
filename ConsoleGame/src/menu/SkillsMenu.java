package menu;

import java.util.HashMap;
import java.util.Scanner;

import skills.Mana;
import skills.Mirror;
import skills.Populator;
import skills.Resurect;
import skills.SkillsFactory;
import units.CrossbowArcher;
import units.Griffin;
import units.LongbowArcher;
import units.Pikeman;
import units.Swordsman;
import units.UnitsFactory;
import elements.Gold;
import elements.ICollectable;
import elements.characters.Player;


public class SkillsMenu extends MenuAbstract {

	private HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
	
	public SkillsMenu(Player player) {
		super(player);
		items.put(Resurect.ID, 10000);
		items.put(Populator.ID, 10000);
		items.put(Mirror.ID, 10000);
		items.put(Mana.ID, 10000);
		
		String cmd = "";
		Scanner sc = new Scanner(System.in);
		System.out
				.println("Welcome to the skills menu\n To buy an item enter 'buy'.\n "
						+ "To get menu list enter 'list'\n"
						+ "To go back to units buy menu - enter 'exit'\n");
		
		while (!cmd.equals("exit")) {
			cmd = sc.nextLine();
			if (cmd.equals("buy")) {
				System.out.println("Enter skill id (the one in the brackets)");
				int unitId = sc.nextInt();
				
				this.buy(unitId, 1);
			}
			
			if (cmd.equals("list")) {
				System.out.println(this.getMenu());
			}
		}
	}
	
	public void buy(int skillId, int amount) {
		ICollectable gold = new Gold(this.items.get(skillId));
		try {
			this.getPlayer().decreaseResource(gold);
			SkillsFactory.create(this.getPlayer(), skillId);
			System.out.println("You have succesfully bought the skill.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String getMenu() {
		String response = "";

		response += "Resurect [" + Resurect.ID + "] ===> "
				+ items.get(Resurect.ID) + " Gold\n";
		response += "Populator [" + Populator.ID + "] ===> "
				+ items.get(Populator.ID) + " Gold\n";
		response += "Mirror [" + Mirror.ID + "] ===> "
				+ items.get(Mirror.ID) + " Gold\n";
		response += "Mana [" + Mana.ID + "] ===> "
				+ items.get(Mana.ID) + " Gold\n";
		
		return response;
	}

}
