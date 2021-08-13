
public abstract class WarriorDecorator  implements Warrior{
	
	protected Warrior  warrior;

	public WarriorDecorator(Warrior warrior) {
		this.warrior = warrior;
	}
	
	@Override
	public int getLevel() {
		// TODO Auto-generated method stub
		return warrior.getLevel();
	}

	@Override
	public void setLevel(int level) {
		warrior.setLevel(level);
		
	}

	@Override
	public int getAttack() {
		// TODO Auto-generated method stub
		return warrior.getAttack();
	}

	@Override
	public void setAttack(int attack) {
		// TODO Auto-generated method stub
		warrior.setAttack(attack);
		
	}

	@Override
	public void setDefense(int defense) {
		// TODO Auto-generated method stub
		warrior.setDefense(defense);
		
	}

	@Override
	public int getDefense() {
		// TODO Auto-generated method stub
		return warrior.getDefense();
	}

	@Override
	public int calculateAttack() {
		// TODO Auto-generated method stub
		return warrior.calculateAttack();
	}

	@Override
	public int calculateDefense() {
		// TODO Auto-generated method stub
		return warrior.calculateDefense();
	}

	@Override
	public double calculateBoost() {
		// TODO Auto-generated method stub
		return warrior.calculateBoost();
	}

	@Override
	public double calculatePower() {
		// TODO Auto-generated method stub
		return warrior.calculatePower();
	}

}
