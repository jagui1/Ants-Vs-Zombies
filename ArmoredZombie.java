package proj4;

public class ArmoredZombie extends Zombie {
    public ArmoredZombie() {
	super(20, 15, "Armored Zombie");
	firstHit = true;
    }

    public void takeDamage(int amount) {
	if (firstHit) {
	    firstHit = false;
	} else {
	    super.takeDamage(amount);
	}
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(10, this);
    }

    boolean firstHit;
}