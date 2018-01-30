package proj4;

public class DevilAnt extends Ant{
	
	protected DevilAnt() {
		super(100, 666, "Devil Ant");
		this.hoverText = "Rule all the hills in the valley, overpower the zombies with health while you slowly take them out";
		
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(2);
		
	}
	
}
