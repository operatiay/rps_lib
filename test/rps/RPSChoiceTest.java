package rps;

import model.rps.RPSChoice;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author andrey
 * 
 */
public class RPSChoiceTest {

	@Test
	public void scissorsLosesAgainstRock() {
		Assert.assertEquals(RPSChoice.SCISSORS.losesAgainst(), RPSChoice.ROCK,
				"Rock should win over Scissors");
	}

	@Test
	public void rockLosesAgainstPaper() {
		Assert.assertEquals(RPSChoice.ROCK.losesAgainst(), RPSChoice.PAPER,
				"Paper should win over Rock");
	}

	@Test
	public void paperLosesAgainstScissors() {
		Assert.assertEquals(RPSChoice.PAPER.losesAgainst(), RPSChoice.SCISSORS,
				"Scissors should win over Paper");
	}

}
