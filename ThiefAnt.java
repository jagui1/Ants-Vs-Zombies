package proj4;

public class ThiefAnt extends Ant{

	public ThiefAnt() {
		super(15, 25, "Thief Ant");
		this.hoverText = "A shifty looking ant, instead of a set damage deal half the damage taken";
	}

	@Override
	public void attack(Game g) {
		//Thief Ant does not attack during its attack turn
		
	}
	
	@Override
    public void takeDamage(int amount, Zombie z){
		//Takes the damage given by its opponent
    	super.takeDamage(amount);
    	//Attacks the Zombie with half the damage taken
    	//Integer division rounds down
    	z.takeDamage(amount / 2);
    }


}