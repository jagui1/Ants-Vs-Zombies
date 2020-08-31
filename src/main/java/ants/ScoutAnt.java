package src.main.java.ants;

import src.main.java.proj4.*;

public class ScoutAnt extends Ant{
	
	public ScoutAnt() {
		super(5, 5, "Scout Ant");
		this.hoverText = "Surveyer of the field, this ant can tell you what's coming";
	}
	
	@Override
	public void attack(Game g){
		//Targets the first zombie in the horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(5);
	}

}
