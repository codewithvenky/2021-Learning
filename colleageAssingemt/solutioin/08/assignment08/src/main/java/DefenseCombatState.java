
public class DefenseCombatState  implements CombatState{

	@Override
	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {
		// TODO Auto-generated method stub
		return warriorOne.calculateDefense() > WarriorTwo.calculateDefense() ? warriorOne : WarriorTwo;
	}

}
