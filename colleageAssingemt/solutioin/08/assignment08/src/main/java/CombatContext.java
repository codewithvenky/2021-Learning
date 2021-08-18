
public class CombatContext {
	private CombatState state;

	public CombatContext() {
		state = null;
	}

	public void setState(CombatState state) {
		this.state = state;

	}

	public CombatState getState() {
		return state;

	}

	public Warrior fight(Warrior warriorOne, Warrior WarriorTwo) {
		// TODO Auto-generated method stub
		return state.fight(warriorOne, WarriorTwo);
	}

}
