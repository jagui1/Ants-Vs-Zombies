package proj4;

public class InfectedZombie extends Zombie implements Flammable {
    public InfectedZombie() {
	super(20, 15, "Infected Zombie");
    }

    public void attack(Game g) {
	Ant a = g.getColony().elementAt(0);
	a.takeDamage(25, this);
    }
}