package proj4;

public class ZombieNinja extends Zombie {
    public ZombieNinja() {
	super(10, 5, "Zombie Ninja");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(15, this);
	g.removeFood(5);
    }
}