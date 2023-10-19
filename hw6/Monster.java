public class Monster extends GameCharacter{
	private int xP;

	public Monster(String name, int health, int attackPower, int xP){
		super(name, health, attackPower);
		this.xP = xP;
	}	

	public void attack(Player thePlayer){
		thePlayer.takeDamage(attackPower);
	}

	public void takeTurn(Player thePlayer){

	}

	public int getXp(){
		return xP;
	}

	public String toString(){

	}
}