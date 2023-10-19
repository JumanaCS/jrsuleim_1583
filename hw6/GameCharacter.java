public class GameCharacter{
	public String name;
	public int health;
	public int attackPower;

	public GameCharacter(String name, int health, int attackPower){
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
	}

	public void takeDamage(int damage){
		if(health - damage > 0)
			health -= damage;

		else if(health - damage <= 0)
			health = 0;
	}

	public String getName(){
		return name;
	}

	public int getAttackPower(){
		return attackPower;
	}

	public int getHealth(){
		return health;
	}

	public String toString(){

	}
}