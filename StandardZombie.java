package proj4;

public class StandardZombie extends Zombie {
    public StandardZombie() {
	super(10, 10, "Standard Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(10, this);
    }
}