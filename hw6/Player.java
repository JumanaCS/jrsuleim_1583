public class Player extends GameCharacter{
	private int mana;

	public Player(String name, int health, int attackPower, int mana){
		super(name, health, attackPower);
		this.mana = mana;
	}	

	public void attack(Monster theMonster){
		monster.takedamage(attackPower);
	}

	public void castSpell(Monster theMonster){

	}

	public void chargeMana(){

	}

	public void takeTurn(Monster theMonster){

	}

	public int getMana(){
		return mana;
	}

	public String toString(){

	}


}