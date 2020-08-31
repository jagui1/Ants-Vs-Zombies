package src.main.java.zombies;

import src.main.java.proj4.*;
import src.main.java.modifiers.*;

public class InfectedZombie extends Zombie implements Flammable {
    public InfectedZombie() {
	super(20, 15, "Infected Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(25, this);
    }
}