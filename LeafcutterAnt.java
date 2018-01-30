package proj4;

public class LeafcutterAnt extends Ant{

	public LeafcutterAnt() {
		super(20, 10, "Leafcutter Ant");
		this.hoverText = "Fights like he'll never lose, upon the killing blow of the zombie do not take the damage that would have been recieved ";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(10);		
	}

}
