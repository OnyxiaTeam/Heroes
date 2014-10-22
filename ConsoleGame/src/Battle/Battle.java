package Battle;
import java.util.Scanner;

import skills.Offensive;
import skills.SkillsAbstract;
import units.Units;
import elements.characters.Player;
import elements.villages.IConquerable;

public class Battle {

	private Player attacker;
	private Player defender;

	private Player winner;

	private Player currentPlayer;
	private Player oppositeSide;

	private IConquerable village;

	private boolean isFinished;

	public Battle(Player attacker, Player defender, IConquerable village) {
		this.attacker = attacker;
		this.defender = defender;
		this.village = village;

		this.currentPlayer = this.getAttacker();
		this.oppositeSide = this.getDefender();

		this.checkResult();

		Scanner sc = new Scanner(System.in);

		while (!this.isFinished) {
			System.out.println("Your units:\n");
			System.out.println(this.getCurrentPlayer().getUnitsTable());
			System.out.println("-------------------\n");
			System.out.println("Opponent - " + this.getOppositeSide().getName()
					+ "'s units:'n");
			System.out.println(this.getOppositeSide().getUnitsTable());
			
			System.out.println("Enter attacking unit ID");
			Units attackingUnit = this.getCurrentPlayer().getUnitById(sc.nextInt());
			
			System.out.println("Enter opponent unit ID to attack");
			Units defendingUnit = this.getOppositeSide().getUnitById(sc.nextInt());
			
			this.hit(attackingUnit, defendingUnit);
			
			if (this.getCurrentPlayer().equals(this.getAttacker())) {
				this.currentPlayer = this.getDefender();
				this.oppositeSide = this.getAttacker();
			} else {
				this.currentPlayer = this.getAttacker();
				this.oppositeSide = this.getDefender();
			}

		}
	}

	public Player getAttacker() {
		return this.attacker;
	}

	public Player getDefender() {
		return this.defender;
	}

	public Player getCurrentPlayer() {
		return this.currentPlayer;
	}

	public Player getOppositeSide() {
		return this.oppositeSide;
	}

	public IConquerable getVillage() {
		return this.village;
	}

	public void finish(Player winner) {
		this.winner = winner;
		this.isFinished = true;

		if (this.winner.equals(this.getAttacker())) {
			this.getAttacker().conquerVillage(this.getVillage());
			System.out.println("Attacker is a winner and conquered the defender's village");
		} else {
			this.getAttacker().loseBattle();
			System.out.println("Defender is a winner. Attacker lost half of its gold");
		}
	}

	public void hit(Units attackingUnit, Units defendingUnit) {
		defendingUnit.getOwner().getSkills()
			.stream()
			.filter(s -> (s instanceof Offensive))
			.forEach(s -> s.cast(attackingUnit.getOwner()));
		
		attackingUnit.hit(defendingUnit);

		this.checkResult();
	}

	private void checkResult() {
		if (!this.getAttacker().hasAliveUnits()) {
			this.finish(this.getDefender());
		} else if (!this.getDefender().hasAliveUnits()) {
			this.finish(this.getAttacker());
		}
	}
}
