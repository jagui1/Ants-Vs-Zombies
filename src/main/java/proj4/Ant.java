package src.main.java.proj4;

import src.main.java.ants.*;

/**
 * This is the abstract Ant Class that will be used to create 
 * more specific Ants and also outlines everything that the 
 * Ants can do.
 */
public abstract class Ant {

	private int life;
	private int fullHealth;
	private int cost;
	private String desc;
	protected String hoverText;
  
	/**
	 * Creates a new Ant based on the type of the Ant
	 * @param type - String of the Ant type
	 * @return a new instance of an Ant class, null if invalid Ant type
	 */
	public static Ant makeAnt(String type) {
		switch(type){
			case "Army Ant": return new ArmyAnt();
			case "Bullet Ant": return new BulletAnt();
			case "Carpenter Ant": return new CarpenterAnt();
			case "Citronella Ant": return new CitronellaAnt();
			case "Devil Ant": return new DevilAnt();
			case "Fire Ant": return new FireAnt();
			case "Leafcutter Ant": return new LeafcutterAnt();
			case "Pharoh Ant": return new PharohAnt();
			case "Shadow Ant": return new ShadowAnt();
			case "Sugar Ant": return new SugarAnt();
			case "Thief Ant": return new ThiefAnt();
			case "Weaver Ant": return new WeaverAnt();
			case "Scout Ant": return new ScoutAnt();
		}

		return null;	
	}
	/**
	 * Creates an Ant with the entered attributes
	 * 
	 * @param cost - cost of food to recruit the Ant
	 * @param life - amount of health the Ant has
	 * @param desc - String of the type of the Ant
	 */
	protected Ant(int cost, int life, String desc){
		this.life = life;
		this.cost = cost;
		this.desc = desc;
		//Keeps track of the full health of the Ant to reset after rounds
		this.fullHealth = life;
		this.hoverText = "A brave ant in the zombie war"; 
	}
	/**
	 * Resets the Ant's health to full health
	 */
	public void resetHealth(){
		this.life = fullHealth;
	}
	/**
	 * Returns the life of the Ant
	 * 
	 * @return the int value of the Ant's health
	 */
	public int getLife() {
		return life;
	}
	/**
	 * Returns the food cost of the Ant
	 * 
	 * @return the int value of the Ant's cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * Returns the description of the Ant
	 * 
	 * @return String value of Ant Type
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * Returns the description of the Ant
	 * 
	 * @return String value of Ant Type
	 */
	public String getHoverText() {
		return hoverText;
	}
	/**
	 * Subtracts an int amount of health from the Ant
	 * 
	 * @param amount - amount of damage to take
	 */
    public void takeDamage(int amount) {
    	life -= amount;
        }
    /**
     * Subtracts an int amount of health from the Ant
     * 
     * @param amount - amount of damage to take
     * @param z - Zombie to be attacked by Thief Ant
     */
    public void takeDamage(int amount, Zombie z){
    	life -= amount;
    }
    /**
     * Attack method for the Ant to attack a Zombie in 
     * the Game Class
     * 
     * @param g - game that the Ant will be attacking in
     */
    public abstract void attack(Game g);
    /**
     * Main used for unit testing
     * 
     * @param args
     */
    public void setLife(int newLife){
    	life = newLife;
    }
    public static void main(String[] args){
    	//Testing Ant creation
    	System.out.println("Creating Nonexistant Ant: ");
    	Ant a = Ant.makeAnt("Nonexistant Ant");
    	System.out.println("\tCreated Ant = " + a + "\n\tLife: " + a + "\n\tCost: " + a);
    	
    	System.out.println("Creating Army Ant: ");
    	a = Ant.makeAnt("Army Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Bullet Ant: ");
    	a = Ant.makeAnt("Bullet Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Carpenter Ant: ");
    	a = Ant.makeAnt("Carpenter Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Citronella Ant: ");
    	a = Ant.makeAnt("Citronella Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Fire Ant: ");
    	a = Ant.makeAnt("Fire Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Leafcutter Ant: ");
    	a = Ant.makeAnt("Leafcutter Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Pharoh Ant: ");
    	a = Ant.makeAnt("Pharoh Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Sugar Ant: ");
    	a = Ant.makeAnt("Sugar Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Thief Ant: ");
    	a = Ant.makeAnt("Thief Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
    	
    	System.out.println("Creating Weaver Ant: ");
    	a = Ant.makeAnt("Weaver Ant");
    	System.out.println("\tCreated Ant = " + a.getDesc() + "\n\tLife: " + a.getLife() + "\n\tCost: " + a.getCost());
 
    	//Testing damage
    	System.out.println("Inflicting 5 damage on Weaver ant: ");
    	System.out.println("\tWeaver Ant Life = " + a.getLife());
    	a.takeDamage(5);
    	System.out.println("\tWeaver Ant Life = " + a.getLife());
    	System.out.println("Replenishing health: ");
    	a.resetHealth();
    	System.out.println("\tWeaver Ant Life = " + a.getLife());
    }

}
