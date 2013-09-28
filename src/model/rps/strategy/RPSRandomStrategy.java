package model.rps.strategy;

import java.util.Random;

import model.abstrct.AHistory;
import model.abstrct.ARound;
import model.abstrct.IStrategy;
import model.rps.RPSChoice;

public class RPSRandomStrategy implements IStrategy<RPSChoice> {

	@Override
	public double getChoiceProbability(RPSChoice choice,
			AHistory<ARound<RPSChoice>> history) {
		// probability is always 1 / n
		return 1.0 / RPSChoice.values().length;
	}

	@Override
	public RPSChoice getNextMove(int playerIndex,
			AHistory<ARound<RPSChoice>> history) {
		Random random = new Random();
		int choiceIndex = random.nextInt(RPSChoice.values().length);
		return RPSChoice.values()[choiceIndex];
	}

	@Override
	public double getScore(int playerIndex, AHistory<ARound<RPSChoice>> history) {
		// TODO probably some day there'll be some logic around it
		return 1;
	}

}
