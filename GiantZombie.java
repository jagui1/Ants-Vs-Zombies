package proj4;

public class GiantZombie extends Zombie implements Gigantic {
    public GiantZombie() {
	super(40, 20, "Giant Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(35, this);
    }
}