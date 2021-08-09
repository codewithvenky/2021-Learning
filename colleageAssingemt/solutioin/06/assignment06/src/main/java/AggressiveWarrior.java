
public class AggressiveWarrior implements Warrior {
	private int level;
	private int attack;
	private int defense;

	public AggressiveWarrior(int level) {
		super();
		this.level = level;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public static class Builder {
		private final int level;
		private int attack;
		private int defense;

		public Builder(int level) {
			super();
			this.level = level;
		}

		Builder attack(int attack) {
			this.attack = attack;
			return this;

		}

		Builder defense(int defense) {
			this.defense = defense;
			return this;

		}

		Warrior build() {
			Warrior w = new AggressiveWarrior(this.level);

			if (this.attack == 0) {
				// default value of the AggressiveWarrior
				w.setAttack(3);
			} else {
				w.setAttack(this.attack);
			}
			if (this.defense == 0) {
				w.setDefense(2);
			} else {
				w.setDefense(this.defense);
			}

			if (w.getAttack() < 0 && w.getLevel() < 0 && w.getDefense() < 0) {
				throw new IllegalStateException(
						"Level must be greater than 0. Attack must be greater than 0. Defense must be greater than 0. ");
			}
			if (w.getAttack() < 0 && w.getLevel() < 0) {

				throw new IllegalStateException("Level must be greater than 0. Attack must be greater than 0. ");
			}

			if (w.getDefense() < 0 && w.getLevel() < 0) {
				throw new IllegalStateException("Level must be greater than 0. Defense must be greater than 0. ");
			}

			if (w.getLevel() < 0) {

				throw new IllegalStateException("Level must be greater than 0. ");

			}
			if (w.getAttack() < 0) {
				throw new IllegalStateException("Attack must be greater than 0. ");
			}
			if (w.getDefense() < 0) {
				throw new IllegalStateException("Defense must be greater than 0. ");
			}

			return w;

		}

	}

	@Override
	public int calculateAttack() {
		return this.attack + this.level*2;
	}

	@Override
	public int calculateDefense() {
		// TODO Auto-generated method stub
		return this.defense + this.level;
	}

	@Override
	public double calculateBoost() {
		
		double d =((double)this.attack/2);
		return d;
	}

	@Override
	public double calculatePower() {
		// TODO Auto-generated method stub
		return  calculateBoost() +calculateAttack() +calculateDefense();
	}
}
