package proj4;

public class PharohAnt extends Ant{

	public PharohAnt() {
		super(15, 10, "Pharoh Ant");
		this.hoverText = "Cursed long ago deep in the pyramids, possesses the ability to deal triple damage to giant zombies";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		
		//Checks if zombie is considered gigantic
		if(z instanceof Gigantic){
			//Deals triple damage if zombie is gigantic
			z.takeDamage(30);
		} else {
			//Deals normal damage to non-gigantic zombies
			z.takeDamage(10);		
		}
	}


}
