package src.main.java.ants;

import src.main.java.proj4.*;

public class SugarAnt extends Ant{

	public SugarAnt() {
		super(20, 20, "Sugar Ant");
		this.hoverText = "Sugar Ant? More like sugar daddy, recieve additonal food when killing a zombie with this ant";
	}

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		
		//Attacks zombie
		z.takeDamage(10);
		
		//Checks if zombie died
		if(z.getLife() <= 0){
			//If Sugar Ant kills zombie, adds 5 food to game
			g.addFood(5);	
		}
	}


}
