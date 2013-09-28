package model.rps;

import model.abstrct.IChoice;

/**
 * Rock, Paper, Scissors. <br>
 * Paper wins over Rock; Scissors win over Paper; Rock wins over Scissors.
 * 
 */
public enum RPSChoice implements IChoice {
	ROCK, PAPER, SCISSORS;

	@Override
	public IChoice losesAgainst() {
		// separately handled the case of the last entry, need to return the
		// first entry then
		if (RPSChoice.values()[RPSChoice.values().length - 1]
				.equals(this)) {
			return RPSChoice.values()[0];
		}
		// return the next entry in the list, since it's winning over the
		// previous.
		return RPSChoice.values()[this.ordinal() + 1];
	}

}
