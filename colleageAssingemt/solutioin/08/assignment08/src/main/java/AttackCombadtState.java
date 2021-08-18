
public class AttackCombadtState implements CombatState{

	@Override
	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {
		return warriorOne.calculateAttack() > WarriorTwo.calculateAttack() ? warriorOne : WarriorTwo;
	}

}
