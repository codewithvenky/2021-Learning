
public class ArmoredWarriorDecorator extends WarriorDecorator {

	public ArmoredWarriorDecorator(Warrior warrior) {
		super(warrior);
		setDefense(getDefense()*2);
	}
	
	@Override
	public void setDefense(int defense) {

		super.setDefense(defense);
	}
}
