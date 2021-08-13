
public class StrongWarriorDecorator extends WarriorDecorator {



	StrongWarriorDecorator(Warrior warrior) {

				super(warrior);	
				setAttack(getAttack()*2);
	}
	
	@Override
	public void setAttack(int attack) {
		// TODO Auto-generated method stub
		super.setAttack(attack);
	}
	

}
