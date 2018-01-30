package proj4;

public class RadioactiveZombie extends Zombie implements Gigantic, Flammable {
    public RadioactiveZombie() {
	super(70, 25, "Radioactive Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(5, this);
	java.util.Vector<Zombie> horde = g.getHorde();
	if (horde.size() > 1) {
	    horde.elementAt(1).takeDamage(5);
	}
    }
}