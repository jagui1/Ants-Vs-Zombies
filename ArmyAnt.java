package proj4;

public class ArmyAnt extends Ant{
	
	public ArmyAnt() {
		super(35, 30, "Army Ant");
		this.hoverText = "A powerful ant in numbers, recieves 5 bonus attack for each Army Ant recruited";
	}

	@Override
	public void attack(Game g) {
		//Targets the first zombie in the horde
		Zombie z = g.getHorde().elementAt(0);
		
		//Army Ants deal 5 extra damage for each Army Ant recruited
		int bonusDamage = 5 * g.getArmyCounter();
		//Attacks zombie
		z.takeDamage(10 + bonusDamage);	
	}


}
