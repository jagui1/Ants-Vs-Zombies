package proj4;

public class CitronellaAnt extends Ant{

	public CitronellaAnt() {
		super(25, 20, "Citronella Ant");
		this.hoverText = "An ant with an explosive personality, upon death deal slight damage to all remaining zombies";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(10);		
	}

}
