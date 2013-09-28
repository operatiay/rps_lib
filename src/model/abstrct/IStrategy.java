package model.abstrct;

/**
 * Interface for a strategy. What should a strategy be capable of?
 * 
 */
public interface IStrategy<C extends IChoice> {

	/**
	 * What's the probability of current strategy to take this choice based on
	 * history? In most cases one of the choices would get about 100% (1.0), but
	 * it may be possible to have an even distribution between multiple choices.
	 * 
	 * @param choice
	 * @param history
	 * @return
	 */
	double getChoiceProbability(C choice, AHistory<ARound<C>> history);

	/**
	 * Get the choice with the highest probability to win (may be based on the history).
	 * 
	 * @param playerIndex
	 * @param history
	 * @return
	 */
	C getNextMove(int playerIndex, AHistory<ARound<C>> history);

	/**
	 * Measure how good this strategy is covering the choices of the player till
	 * now.
	 * 
	 * @param playerIndex
	 * @param history
	 * @return
	 */
	double getScore(int playerIndex, AHistory<ARound<C>> history);
}
