package src.main.java.ants;

import src.main.java.proj4.*;

public class WeaverAnt extends Ant{

	public WeaverAnt() {
		super(20, 10, "Weaver Ant");
		this.hoverText = "A non conformist, attack the second zombie in line instead of the first";
	}

	@Override
	public void attack(Game g) {
		//Checks if the horde contains more than 1 zombie
		if(g.getHorde().size() > 1){
			//Targets the zombie at the second position
			Zombie z = g.getHorde().elementAt(1);
			//Attacks zombie
			z.takeDamage(15);
		}
		
	}


}
