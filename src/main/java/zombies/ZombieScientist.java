package src.main.java.zombies;

import src.main.java.proj4.*;

public class ZombieScientist extends Zombie {
    public ZombieScientist() {
	super(5, 5, "Zombie Scientist");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(5, this);
    }
}