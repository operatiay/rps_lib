package model.rps;

import model.abstrct.AHistory;
import model.abstrct.ARound;
import model.abstrct.IStrategy;

public class RPSGame {
	private AHistory<ARound<RPSChoice>> history = RPSHistory.getInstance();
	
	private IStrategy<RPSChoice> player1Strategy;
	private IStrategy<RPSChoice> player2Strategy;
	
	public void setPlayer1Strategy(IStrategy<RPSChoice> strategy) {
		this.player1Strategy = strategy;
	}
	
	public void setPlayer2Strategy(IStrategy<RPSChoice> strategy) {
		this.player2Strategy = strategy;
	}

	/**
	 * Get the choices from the players(strategies) and store them in history.
	 */
	public void playRound() {
		// 2nd player is more probable to be a computer
		RPSChoice player2Choice = this.player2Strategy.getNextMove(1, history);
		// now wait for user input (should happen within the strategy)
		RPSChoice player1Choice = this.player1Strategy.getNextMove(0, history);
		history.addRound(new RPSRound(player1Choice, player2Choice));
	}
	
	/**
	 * Scores for the last round.
	 * @return array of scores. result.length = number of players
	 */
	public int[] getLastScore() {
		return history.getLast().getScores();
	}
}
