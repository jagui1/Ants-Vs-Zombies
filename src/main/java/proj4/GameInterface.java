/**
 * File: GameInterface.java
 * Author: J. Tang
 *
 * This file contains the interface that students' submission must
 * implement.
 *
 * DO NOT edit this file.
 * DO NOT submit this file.
 *
 */

package src.main.java.proj4;

public interface GameInterface {
    /**
     * Return the current round for the game.
     * @return 1 through 5, inclusive
     */
    public int getRoundNumber();

    /**
     * Return the amount of food the player's colony currently has.
     * @return food remaining
     */
    public int getFood();

    /**
     * Return a string that lists all of the ants in the player's colony.
     * The list is in order, and has newlines separating ants.
     * @return Multiline description of colony.
     */
    public String getColonyDesc();

    /**
     * Callback invoked when the player attempts to recruit an ant.
     * @param antType Type of ant to recruit
     * @return 1 if the player may recruit the ant, 0 if not. -1 if unable to undo
     */
    public int recruitAnt(String antType);

    /**
     * Read and parse the Zombie String within a zombie file.
     * @param filename File containing Zombie String
     */
    public void readHordeData(String filename);

    /**
     * Return a string that lists all of the zombies in the current
     * invasion The list is in order, and has newlines separating
     * zombies.
     * @return Multiline description of horde.
     */
    public String getHordeDesc();

    /**
     * Execute a fight between the first ant in the colony and first
     * zombie in the horde.
     */
    public void nextFight();

    /**
     * Determine if the invasion is over. If the invasion is over, all
     * remaining ants' health reset to full life.
     * @return true if there are no ants or no zombies remaining.
     */
    public boolean isInvasionOver();

    /**
     * Determine if the game is over or not.
     * @return true if game is over or not.
     */
    public boolean isGameOver();

    /**
     * Return a string that describe how the game ended.  If the
     * player lost, simply return "Game Over", otherwise return the
     * player's score.
     * @return Description of ending condition.
     */
    public String getEndingMessage();

    /**
     * Return an array of all types of ants that may be recruited.
     * This array will be used to construct the recruitment buttons
     * during Recruit phase.
     */
    public String[] getAntTypes();

    /**
     * Return the cost to recruit a particular ant.
     * @param antType Type of ant to recruit.
     * @return Food cost to recruit.
     */
    public int getAntCost(String antType);
    
    /**
     * Return the cost to recruit a particular ant.
     * @param antType Type of ant to recruit.
     * @return Food cost to recruit.
     */
    public String getAntText(String antType);
        
    
}
