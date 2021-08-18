
public class InverseCombatState implements CombatState{

	@Override
	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {

		return warriorOne.calculateDefense() >= WarriorTwo.calculateAttack() ? warriorOne : WarriorTwo;
	}
}
