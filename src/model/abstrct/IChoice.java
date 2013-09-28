package model.abstrct;
/**
 * A valid choice for a game
 *
 */
public interface IChoice {
	/**
	 * Which choice should be made to win over this choice
	 * @return winning choice
	 */
	public IChoice losesAgainst();
}
