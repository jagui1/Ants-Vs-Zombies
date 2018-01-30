package proj4;

public class FireAnt extends Ant{

	public FireAnt() {
		super(15, 20, "Fire Ant");
		this.hoverText = "He's a supa hot boy, deal double damage whenever the zombies happen to be flammable";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		
		//Checks if zombie is flammable
		if(z instanceof Flammable){
			//Deals double damage to flammable zombies
			z.takeDamage(20);
		} else {
			//Deals regular damage to non-flammable zombies
			z.takeDamage(10);
		}
		
	}

}
