
public interface Warrior {
	
	public int getLevel() ;
	public void setLevel(int level);
	public int getAttack();
	public void setAttack(int attack);
	public void setDefense(int defense);
	public int getDefense();
	int calculateAttack();
	int calculateDefense();
	double calculateBoost();
	double calculatePower();
}
