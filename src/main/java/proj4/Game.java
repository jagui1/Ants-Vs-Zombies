
package src.main.java.proj4;

import src.main.java.ants.*;

import java.util.Vector;

/**
 * This is the Game.java file posted in the Project4 project
 * description. It contains only the nextFight method. Students
 * must complete the remainder of the Game methods and add the
 * Game instance variables.
 */
public class Game implements GameInterface {

	/******************** constant variables ********************/
	String UNDO =  "Undo Recruit";

    /******************** instance variables ********************/
	int food;
	int roundNumber;
	int armyCounter;
	boolean gameOver;
	Vector<Ant> colony;
	Vector<Zombie> horde;

    /*************** methods declared in GameInterface ****************/
	public Game(){
		//Gives user 100 starting food
		food = 100;
		//Starts on round 1
		roundNumber = 1;
		//Zero Army Ants recruited at start
		armyCounter = 0;
		//Game is not over yet
		gameOver = false;
		//Initializes colony as empty vector of type Ant
		colony = new Vector<Ant>();
		//Initializes horde as empty vector of type Zombie
		horde = new Vector<Zombie>();		
	}


	/**
	 * Checks if the entered Ant Type is available in this game
	 * by checking the Ant Types provided in the getAntTypes() 
	 * method. 
	 *  
	 * @param antType - String of the requested type of an Ant
	 * @return true if Ant exists in this game, false otherwise
	 */
	public boolean isInGame(String antType){
		//Creates array of available Ant Types
		String[] typesOfAnts = getAntTypes();

		//Loops through Ant Types
		for(String s: typesOfAnts){
			//If it matches a type then the Ant Type is available
			if(s.equals(antType)){
				return true;
			}	
		}
		
		return false;
	}
    /**
     * Execute a fight between the first ant in the colony and first
     * zombie in the horde.
     */
    public void nextFight() {
    	if(colony.size() <= 0){
    		
    	}
		Ant a = colony.elementAt(0);
		a.attack(this);
	
		Zombie z = horde.elementAt(0);
		if ((a instanceof LeafcutterAnt) && (z.getLife() <= 0)) {
		    // leafcutters have first strike, so opposing zombie gets no attack
		}
		else {
		    z.attack(this);
		}
	
		// reap all things dead
		boolean keepReaping = true;
		while (keepReaping) {
		    keepReaping = false;
		    for (int i = 0; i < colony.size(); ) {
			a = colony.elementAt(i);
			if (a.getLife() > 0) {
			    i++;
			}
			else {
			    colony.remove(i);
			    if (a instanceof CitronellaAnt) {
				for (Ant a2 : colony) {
				    a2.takeDamage(2);
				} 
				for (Zombie z2: horde) {
				    z2.takeDamage(2);
				}
			    } else if(a instanceof DevilAnt){
			    	if(horde.size() > 0){
			    		horde.remove(0);
			    	}
				}
			    keepReaping = true;
			}
		    }
	
		    for (int i = 0; i < horde.size(); ) {
			z = horde.elementAt(i);
			if (z.getLife() > 0) {
			    i++;
			}
			else {
			    horde.remove(i);
			    food += z.getReward();
			}
		    }
		}
		if (colony.size() == 0 && horde.size() > 0) {
		    gameOver = true;
		}
    }

    /******************** other methods ********************/

    /**
     * Return the current round for the game.
     * @return 1 through 5, inclusive
     */
    public int getRoundNumber() {
		return roundNumber;
	}

    /**
     * Return the amount of food the player's colony currently has.
     * @return food remaining
     */
	public int getFood() {
		return food;
	}

    /**
     * Return a string that lists all of the ants in the player's colony.
     * The list is in order, and has newlines separating ants.
     * @return Multiline description of colony.
     */
	public String getColonyDesc() {
		String colonyStr = "";

		//Checks if the colony is null, or empty
		if(colony != null && false == colony.isEmpty()){		
			//Loops through each Ant in colony
			for(Ant a: colony){
				//Gives a description of each Ant and remaining life
				colonyStr += a.getDesc() + " - remaining life: " + a.getLife() + "\n";
				
			}
		}
		return colonyStr;
	}
	
    /**
     * Return a string that lists all of the zombies in the current
     * invasion The list is in order, and has newlines separating
     * zombies.
     * @return Multiline description of horde.
     */
	public String getHordeDesc() {
		String hordeStr = "";
		
		//Checks if the horde is null, or empty
		if(null != colony && false == horde.isEmpty()){
			//Loops through each Zombie in horde
			for(Zombie z: horde){
				//Gives a description of each Zombie and remaining life
				hordeStr += z.getDesc() + " - remaining life: " + z.getLife() + "\n";
			}
		}		
		return hordeStr;
	}

    /**
     * Callback invoked when the player attempts to recruit an ant.
     * @param antType Type of ant to recruit
     * @return true if the player may recruit the ant, false if not.
     */
	public int recruitAnt(String antType) {
		// Undoes the previous and recruitment if the user enters Undo
		if(antType.equals(UNDO)){
			// Does nothing if there are no ants
			if(colony.size() <= 0){
				return 0;
			}
			// Cannot undo scout ant for competative advantage
			if(colony.get(colony.size() - 1).getDesc().equals("Scout Ant")){
				return -1;
			} else {
				Ant curAnt = colony.get(colony.size() - 1);
				food += curAnt.getCost();
				colony.remove(colony.size() - 1);
				return 1;
			}
		}
		
		//Checks if the Ant is available in this game and buying the ant would not result in negative food
		if(isInGame(antType) && food - getAntCost(antType) >= 0){
			//Creates an Ant of the requested type
			Ant a = Ant.makeAnt(antType);
			
			//Adds to the Army Ant Counter if the created ant is an Army Ant
			if(a instanceof ArmyAnt){
				armyCounter += 1;
			}
			//Adds the Ant to the colony
			colony.add(a);
			//Removes the food used to buy Ant
			removeFood(a.getCost());
			
			//Successfully recruited Ant
			return 1;
			
		}

		return 0;
	}

    /**
     * Read and parse the Zombie String within a zombie file.
     * @param zombieString String containing the Horde data
     */
	public void readHordeData(String zombieString) {
		//Loops through each character in the string
		for (int i = 0; i < zombieString.length(); i++){
			char z = zombieString.charAt(i);
			//Checks if the character is 1-9
			if(Character.isDigit(z)){
				//Creates copies of the previous zombie the entered amount of times
				for(int j = 0; j < Character.getNumericValue(z); j++){
					horde.add(Zombie.makeZombie(zombieString.charAt(i-1)));
				}
			} else {
				//Adds the zombie to the horde if character is not a digit
				horde.add(Zombie.makeZombie(z));
			}
		}
	}



    /**
     * Determine if the invasion is over. If the invasion is over, all
     * remaining ants' health reset to full life.
     * @return true if there are no ants or no zombies remaining.
     */
	public boolean isInvasionOver() {
		//Checks if either the colony or horde is empty
		if(colony.isEmpty() || horde.isEmpty()){
			//If invasion ended, the round advances
			roundNumber += 1;

			//Resets the health of the ants in the colony
			for(Ant a: colony){
				if(a instanceof DevilAnt){
					a.setLife(a.getLife() + 50);
				} else {
					a.resetHealth();
				}
			}
			return true;
		} else {
			//colony and horde both have remaining members
			return false;
		}
	}

    /**
     * Determine if the game is over or not.
     * @return true if game is over or not.
     */
	public boolean isGameOver() {
		//Game ends when there are no ants or food at the beginning of a round
		if(food == 0 && colony.isEmpty()){
			gameOver = true;
		}
		return gameOver;
	}

    /**
     * Return a string that describe how the game ended.  If the
     * player lost, simply return "Game Over", otherwise return the
     * player's score.
     * @return Description of ending condition.
     */
	public String getEndingMessage() {
		//Player wins if horde is empty even if colony is simultaneously empty
		//if(colony.isEmpty() && horde.isEmpty()){
			//return "You win! \nRounds survived: " + roundNumber;
		//Player loses if all Ants are dead
		//}else if(colony.isEmpty()){
			//return "Game Over";
		//Player wins if colony is not empty
		//} else {
			//return "You win! \nRounds Survived: " + roundNumber;
		//}
		return "Game Over \nRounds Survived: " + (roundNumber - 2);
	}

    /**
     * Return an array of all types of ants that may be recruited.
     * This array will be used to construct the recruitment buttons
     * during Recruit phase.
     */
	public String[] getAntTypes() {
		String[] ants = new String[14];
		ants[0] = "Army Ant";
		ants[1] = "Bullet Ant";
		ants[2] = "Carpenter Ant";
		ants[3] = "Citronella Ant";
		ants[4] = "Devil Ant";
		ants[5] = "Fire Ant";
		ants[6] = "Leafcutter Ant";
		ants[7] = "Pharoh Ant";
		ants[8] = "Shadow Ant";
		ants[9] = "Sugar Ant";
		ants[10] = "Thief Ant";		
		ants[11] = "Weaver Ant";
		ants[12] = "Scout Ant";
		ants[13] = UNDO;
		
		return ants;
	}
    /**
     * Return the cost to recruit a particular ant.
     * @param antType Type of ant to recruit.
     * @return Food cost to recruit.
     */
	public int getAntCost(String type) {
		

		if(type.equals(UNDO)){
			return 0;
		}
		//Checks if the type is available in this game
		if(isInGame(type)){
			//Returns cost of that Ant
	    	return Ant.makeAnt(type).getCost();
		} else {
			//Returns -1 if there was an error and ant is not available
			return -1;
		}

	}
    /**
     * Return the hover text for a particular ant.
     * @param antType Type of ant to hover text.
     * @return String of hover text for that ant.
     */
	public String getAntText(String type) {
		

		if(type.equals(UNDO)){
			return "Undo last recruited ant if you made a mistake or review the scouting report of a Scout Ant";
		}
		//Checks if the type is available in this game
		if(isInGame(type)){
			//Returns cost of that Ant
	    	return Ant.makeAnt(type).getHoverText();
		} else {
			//Returns -1 if there was an error and ant is not available
			return "";
		}

	}
	/**
	 * Returns the amount of Army Ants recruited over this game
	 * 
	 * @return number of recruited Army Ants
	 */
	public int getArmyCounter() {
		return armyCounter;
	}
	/**
	 * Returns the colony being used in this game
	 * 
	 * @return a Vector of type Ant 
	 */
	public Vector<Ant> getColony() {
		return colony;
	}
	/**
	 * Returns the horde being used in this game 
	 * 
	 * @return a Vector of type Zombie
	 */
	public Vector<Zombie> getHorde(){
		return horde;
	}
	/**
	 * Subtracts a set amount of food from the game's total
	 * 
	 * @param i - amount of food to remove
	 */
	public void removeFood(int i) {
		food -= i;
		
	}
	/**
	 * Adds a set amount of food to the game's total
	 * 
	 * @param i - amount of food to add
	 */
	public void addFood(int i){
		food += i;
	}
	/**
	 * Main function used for unit testing
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		Game g = new Game();
		System.out.println("Recruiting 'Fire Ant'...");
		g.recruitAnt("Weaver Ant");
		System.out.println("Current Colony: \n" + g.getColonyDesc());
		System.out.println("Cur capacity: " + g.getHorde().size());

		/*
		//Testing construction
		System.out.println("Constructing new game, default constructor...");
		System.out.println("Created Game: " + "\n" +
				            "\tRound: " + g.getRoundNumber() + "\n" + 
				            "\tArmy Counter: " + g.getArmyCounter() + "\n" + 
				            "\tGame Over: " + g.isGameOver());
		
		//Testing food methods
		System.out.println("Current Food: " + g.getFood());
		System.out.println("Adding 5 food...");
		g.addFood(5);
		System.out.println("Current Food: " + g.getFood());
		System.out.println("Subtracting 6 food...");
		g.removeFood(6);
		System.out.println("Current Food: " + g.getFood());
		
		//Testing getAntTypes()
		String[] antTypes = g.getAntTypes();
		System.out.println("Getting Ant Types: ");
		for(String s: antTypes){
			System.out.println("\t" + s);
		}
		
		//Testing isInGame()
		System.out.println("Is 'Fire Ant' in this game: " + g.isInGame("Fire Ant"));
		System.out.println("Is 'Nonexistant Ant' in this game: " + g.isInGame("Nonexistant Ant"));
		
		//Testing getAntCost()
		System.out.println("Get Ant Cost 'Carpenter Ant': " + g.getAntCost("Fire Ant"));
		System.out.println("Get Ant Cost 'Nonexistant Ant': " + g.getAntCost("Nonexistant Ant"));
		
		*/
		
		//Testing recruit and getColonyDesc()
/*		System.out.println("Recruiting 'Fire Ant'...");
		g.recruitAnt("Fire Ant");
		System.out.println("Current Colony: \n" + g.getColonyDesc());
		
		System.out.println("Recruiting 'Pharoh Ant'...");
		g.recruitAnt("Pharoh Ant");
		System.out.println("Current Colony: \n" + g.getColonyDesc());
		
		System.out.println("Recruiting 'Nonexistant Ant'...");
		g.recruitAnt("Nonexistant Ant");
		System.out.println("Current Colony: \n" + g.getColonyDesc());
		
		System.out.println("Attempting undo last Ant...");
		g.recruitAnt("Undo Recruit");
		System.out.println("Current Colony: \n" + g.getColonyDesc());

*/
	}


}