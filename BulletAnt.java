package proj4;

public class BulletAnt extends Ant{

	public BulletAnt() {
		super(10, 1, "Bullet Ant");
		this.hoverText = "A born and raised gunslinger, this ant does massive damage ";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(25);
	}


}
