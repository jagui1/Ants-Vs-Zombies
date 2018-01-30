package proj4;

public class CarpenterAnt extends Ant{

	public CarpenterAnt() {
		super(10, 10, "Carpenter Ant");
		this.hoverText = "The Average Joe of the ants, affordable and reliable ";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(10);		
	}


}
