package model.abstrct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * One set of choices made.
 * 
 */
public abstract class ARound<C extends IChoice> {
	List<C> choices;

	/**
	 * Constructor with size alone. Choices have to be set separately.
	 * 
	 * @param size
	 */
	public ARound(int size) {
		this.choices = new ArrayList<C>(size);
		// now fill in with nulls in order to set the size correctly.
		while (this.choices.size() < size) {
			this.choices.add(null);
		}
	}

	/**
	 * Constructor with all choices. Beware of the order.
	 * 
	 * @param choices
	 */
	public ARound(C... choices) {
		this.choices = Arrays.asList(choices);
	}

	/**
	 * Get number of players for this round.
	 * 
	 * @return number of players
	 */
	public int getPlayersCount() {
		return this.choices.size();
	}

	/**
	 * Provide an array of choices. The order of choices should be the order of
	 * players.
	 * 
	 * @param choices
	 */
	public void setRound(C... choices) {
		if (this.choices.size() == choices.length) {
			this.choices = Arrays.asList(choices);
		} else {
			throw new UnsupportedOperationException(
					"Unable to change the size of the round. Was ["
							+ this.choices.size() + "], trying to set ["
							+ choices.length + "]");
		}
	}

	/**
	 * Get choice for the player based on the index. The object should have
	 * already been instantiated.
	 * 
	 * @param playerIndex
	 * @return
	 */
	public C getChoiceOfPlayer(int playerIndex) {
		checkChoices(playerIndex);
		return this.choices.get(playerIndex);
	}

	/**
	 * Set choice for the player based on the index. The object should have
	 * already been instantiated.
	 * 
	 * @param playerIndex
	 * @param choice
	 */
	public void setChoiceOfPlayer(int playerIndex, C choice) {
		checkChoices(playerIndex);
		// able to set
		this.choices.set(playerIndex, choice);
	}

	/**
	 * Verifies that all the choices have been set and that the player with the
	 * index is supported.
	 * 
	 * @param playerIndex
	 */
	public void checkChoices(int playerIndex) {
		if (this.choices == null) {
			throw new UnsupportedOperationException(
					"Unable to work with a not instantiated round");
		}
		if (this.choices.size() < playerIndex) {
			throw new UnsupportedOperationException("Unexpected player index ["
					+ playerIndex + "], round was registered for "
					+ this.choices.size() + " players");
		}

	}

	/**
	 * Verifies, whether all choices have been set (there should be no
	 * {@code null} values).
	 * 
	 * @return
	 */
	public boolean isComplete() {
		for (C choice : this.choices) {
			if (choice == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Score two choices
	 * 
	 * @param choice1
	 * @param choice2
	 * @return {@code 1} if choice1 wins against choice2;<br>
	 *         {@code 0} if noone wins;<br>
	 *         {@code -1} if choice2 wins.
	 */
	public static int scoreTwoChoices(IChoice choice1, IChoice choice2) {
		if (choice2.losesAgainst().equals(choice1)) {
			return 1;
		}
		if (choice1.losesAgainst().equals(choice2)) {
			return -1;
		}
		return 0;
	}

	/**
	 * Get the scores of this round.
	 * 
	 * @return array of scores. result.length = number of players
	 */
	public int[] getScores() {
		int[] scores = new int[this.getPlayersCount()];
		for (int i = 0; i < scores.length; i++) {
			int scoreI = 0;
			for (int j = 0; j < scores.length; j++) {
				if (i != j) {
					scoreI += scoreTwoChoices(this.getChoiceOfPlayer(i),
							this.getChoiceOfPlayer(j));
				}
			}
			scores[i] = scoreI;
		}
		return scores;
	}

}
