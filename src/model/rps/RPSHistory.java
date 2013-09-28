package model.rps;

import model.abstrct.AHistory;
import model.abstrct.ARound;

public class RPSHistory extends AHistory<ARound<RPSChoice>>{
	
//	private static RPSHistory INSTANCE = new RPSHistory();
	
	private RPSHistory() {
		super();
	}
	
	public static AHistory<ARound<RPSChoice>> getInstance() {
		return new RPSHistory();
	}

}
