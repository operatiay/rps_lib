package model.rps.strategy;

import model.abstrct.AHistory;
import model.abstrct.ARound;
import model.abstrct.IStrategy;
import model.rps.RPSChoice;

public class RPSUserInputStrategy implements IStrategy<RPSChoice> {

	@Override
	public double getChoiceProbability(RPSChoice choice,
			AHistory<ARound<RPSChoice>> history) {
		// not really necessary, let's assume it's equally distributed
		return 1.0 / RPSChoice.values().length;
	}

	@Override
	public RPSChoice getNextMove(int playerIndex,
			AHistory<ARound<RPSChoice>> history) {
		// TODO get input from the user, wait for the input as long as necessary.
		return null;
	}

	@Override
	public double getScore(int playerIndex, AHistory<ARound<RPSChoice>> history) {
		// user knows what to do
		return 100;
	}

}
