package rps;

import model.rps.RPSChoice;
import model.rps.RPSHistory;
import model.rps.RPSRound;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RPSHistoryTest {
	@Test
	public void firstEmptyRound() {
		Assert.assertFalse(
				RPSHistory.getInstance().isValidRound(new RPSRound(2)),
				"First empty round should not be valid.");
	}

	@Test
	public void secondEmptyRound() {
		// create a valid round
		RPSRound round = new RPSRound(2);
		round.setRound(RPSChoice.PAPER, RPSChoice.ROCK);
		// add to the history
		RPSHistory.getInstance().addRound(round);
		Assert.assertFalse(
				RPSHistory.getInstance().isValidRound(new RPSRound(2)),
				"Empty round should not be valid.");
	}

	@Test
	public void secondRoundDifferentSize() {
		// create a valid round
		RPSRound round = new RPSRound(2);
		round.setRound(RPSChoice.PAPER, RPSChoice.ROCK);
		// add to the history
		RPSHistory.getInstance().addRound(round);
		Assert.assertFalse(
				RPSHistory.getInstance().isValidRound(new RPSRound(3)),
				"Round of different size should not be valid.");
	}
	
	@Test (expectedExceptions = UnsupportedOperationException.class)
	public void secondRoundDifferentSizeAdding() {
		// create a valid round
		RPSRound round = new RPSRound(2);
		round.setRound(RPSChoice.PAPER, RPSChoice.ROCK);
		// add to the history
		RPSHistory.getInstance().addRound(round);
		// here comes the error
		RPSHistory.getInstance().addRound(new RPSRound(3));
	}

}
