
public class TraditionalCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {
		// TODO Auto-generated method stub
		return warriorOne.calculateAttack() > WarriorTwo.calculateDefense() ? warriorOne : WarriorTwo;
	}

}
