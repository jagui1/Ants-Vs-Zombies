/**
 * File: Project4.java
 * Driver class that runs the game
 */

package src.main.java.proj4;

import java.io.*;
import javax.swing.*;

public class Driver {
    public static void main(String args[]) {
	GameInterface game = new Game();

	// Initialize levels
	String[] hordes = {"../../../resources/horde_1.data", 
			"../../../resources/horde_2.data", 
			"../../../resources/horde_3.data", 
			"../../../resources/horde_4.data", 
			"../../../resources/horde_5.data"};

	String lastFilename;

	while (!game.isGameOver()) {
		lastFilename = hordes[(game.getRoundNumber()-1)%5];

		game.readHordeFile(lastFilename);

	    new RecruitDialog(game);

	    new InvasionDialog(game);
	}

	JOptionPane.showMessageDialog(null, game.getEndingMessage(), "Ants Versus Zombies", JOptionPane.INFORMATION_MESSAGE);
	System.exit(0);
    }
}
