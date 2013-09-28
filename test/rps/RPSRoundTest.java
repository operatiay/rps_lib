package rps;

import model.rps.RPSChoice;
import model.rps.RPSRound;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RPSRoundTest {
	@Test
	public void completeRound() {
		RPSRound round = new RPSRound(2);
		round.setChoiceOfPlayer(0, RPSChoice.PAPER);
		round.setChoiceOfPlayer(1, RPSChoice.ROCK);
		Assert.assertTrue(round.isComplete(),
				"Round meant to contain 2 choices should be complete after they have been set.");
	}

	@Test
	public void incompleteRoundNothingSet() {
		RPSRound round = new RPSRound(2);
		Assert.assertFalse(
				round.isComplete(),
				"Round meant to contain 2 choices should be incomplete without any choices set.");
	}

	@Test
	public void incompleteRoundFirstSet() {
		RPSRound round = new RPSRound(2);
		round.setChoiceOfPlayer(0, RPSChoice.PAPER);
		Assert.assertFalse(
				round.isComplete(),
				"Round meant to contain 2 choices should be incomplete with only first choice set.");
	}

	@Test
	public void incompleteRoundSecondSet() {
		RPSRound round = new RPSRound(2);
		round.setChoiceOfPlayer(1, RPSChoice.PAPER);
		Assert.assertFalse(
				round.isComplete(),
				"Round meant to contain 2 choices should be incomplete with only second choice set.");
	}

	@Test
	public void setRoundWithAllValues() {
		RPSRound round = new RPSRound(2);
		round.setRound(RPSChoice.PAPER, RPSChoice.ROCK);
		Assert.assertTrue(round.isComplete(),
				"Setting round with all values should produce a complete round.");
	}

	@Test
	public void setRoundWithFirstValueOnly() {
		RPSRound round = new RPSRound(2);
		round.setRound(RPSChoice.PAPER, null);
		Assert.assertFalse(round.isComplete(),
				"Setting round with first values should produce a complete round.");
	}
	
	@Test
	public void setRoundWithSecondValueOnly() {
		RPSRound round = new RPSRound(2);
		round.setRound(null, RPSChoice.PAPER);
		Assert.assertFalse(round.isComplete(),
				"Setting round with first values should produce a complete round.");
	}


	@Test(expectedExceptions = UnsupportedOperationException.class)
	public void setRoundWithWrongSize() {
		RPSRound round = new RPSRound(2);
		round.setRound(null, RPSChoice.PAPER, null);
	}

}
