/**
 * File: Project4.java
 * Driver class that runs the game
 */

package src.main.java.proj4;

import javax.swing.*;

public class Driver {
    public static void main(String args[]) {
	GameInterface game = new Game();

	// Initialize levels
	String[] hordes = {"SZI1", 
					   "GA", 
			           "RS9Z2", 
			           "V1", 
			           "INNV"};

	String zombieString;

	while (!game.isGameOver()) {
		zombieString = hordes[(game.getRoundNumber()-1)%5];

		game.readHordeData(zombieString);

	    new RecruitDialog(game);

	    new InvasionDialog(game);
	}

	JOptionPane.showMessageDialog(null, game.getEndingMessage(), "Ants Versus Zombies", JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
	}
	
}
