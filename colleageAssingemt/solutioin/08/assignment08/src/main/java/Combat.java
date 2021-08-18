
public class Combat {
	CombatContext combatContext;

	Combat(CombatContext combatContext) {
		this.combatContext = combatContext;

	}

	public Warrior duel(Warrior warriorOne, Warrior warriorTwo) {
		int attackerCounter = 0, deffenderCounter = 0;
		combatContext.setState(new PowerCombatState());
		if (warriorOne == combatContext.fight(warriorOne, warriorTwo)) {
			attackerCounter++;
		} else {
			deffenderCounter++;
		}
		combatContext.setState(new AttackCombadtState());
		if (warriorOne == combatContext.fight(warriorOne, warriorTwo)) {
			attackerCounter++;
		} else {
			deffenderCounter++;
		}
		combatContext.setState(new DefenseCombatState());
		if (warriorOne == combatContext.fight(warriorOne, warriorTwo)) {
			attackerCounter++;
		} else {
			deffenderCounter++;
		}
		combatContext.setState(new TraditionalCombatState());
		if (warriorOne == combatContext.fight(warriorOne, warriorTwo)) {
			attackerCounter++;
		} else {
			deffenderCounter++;
		}
		combatContext.setState(new InverseCombatState());
		if (warriorOne == combatContext.fight(warriorOne, warriorTwo)) {
			attackerCounter++;
		} else {
			deffenderCounter++;
		}

		return attackerCounter > deffenderCounter ? warriorOne : warriorTwo;
	}
}
