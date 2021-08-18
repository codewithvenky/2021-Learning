
public class PowerCombatState implements CombatState {

	@Override
	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {
		return warriorOne.calculatePower() > WarriorTwo.calculatePower() ? warriorOne : WarriorTwo;
	}

}
