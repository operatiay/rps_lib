package model.abstrct;

import java.util.ArrayList;
import java.util.List;

public abstract class AHistory<R extends ARound<?>> {
	private List<R> history;

	protected AHistory() {
		this.history = new ArrayList<R>();
	}

	/**
	 * Adds another round to the history
	 * 
	 * @param round
	 */
	public void addRound(R round) {
		if (isValidRound(round)) {
			this.history.add(round);
		} else {
			throw new UnsupportedOperationException(
					"This round seems to be not valid for this game");
		}
	}

	/**
	 * Obtain last entry from the history
	 * 
	 * @return recently added entry or {@code null} if there was nothing added
	 *         yet.
	 */
	public R getLast() {
		if (history.isEmpty()) {
			return null;
		}
		return history.get(history.size() - 1);
	}

	/**
	 * Verifies that the round looks similar to the previously added one(s) and
	 * is complete. First round is always valid (configures the history).
	 * 
	 * @param round
	 * @return
	 */
	public boolean isValidRound(R round) {
		if (history.size() > 0) {
			return (history.get(0).choices.size() == round.choices.size() && round
					.isComplete());
		}
		// for the first time it's ok to accept regardless the size.
		return round.isComplete();
	}
}
