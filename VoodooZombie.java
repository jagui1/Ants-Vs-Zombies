package proj4;

public class VoodooZombie extends Zombie {
    public VoodooZombie() {
	super(15, 15, "Voodoo Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(10, this);
	if (a.getLife() <= 0) {
	    g.getHorde().add(new StandardZombie());
	}
    }
}