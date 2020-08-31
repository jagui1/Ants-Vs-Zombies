package src.main.java.ants;

import src.main.java.proj4.*;

import java.util.Random;

/**
 * Shadow Ant is a subclass of Ant to be used in
 * the Ants vs. Zombies game.
 * The shadow Ant has a 33% chance of dodging the Zombie attack
 */
public class ShadowAnt extends Ant{
	private Random r = new Random();
	private float chance;


	public ShadowAnt(){
		super(15, 10, "Shadow Ant");
		this.hoverText = "A quick little bugger, not as powerful as the rest but has a chance to dodge";
	}
	

	@Override
	public void attack(Game g) {
		//Targets first zombie in horde
		Zombie z = g.getHorde().elementAt(0);
		//Attacks zombie
		z.takeDamage(5);	
	}
	
	@Override
    public void takeDamage(int amount){
    	chance = r.nextFloat();

    	if(chance >= .4f){
        	super.takeDamage(amount);
    	} else {
    		super.takeDamage(0);
    	}
    }
	
	@Override
    public void takeDamage(int amount, Zombie z){
    	chance = r.nextFloat();

    	if(chance >= .4f){
        	super.takeDamage(amount);
    	} else {
    		super.takeDamage(0);
    	}
    }

}
