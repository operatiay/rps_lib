package controller;

import model.rps.RPSGame;
import model.rps.strategy.RPSRandomStrategy;

/**
 * Control the flow of the game from here (MVC).
 * Could implement the whole 'UI' via Sysout.
 *
 */
public class RPSController {
	
	public static void main(String[] args) {
		RPSGame game = new RPSGame();
		game.setPlayer2Strategy(new RPSRandomStrategy());
	}
	

}
