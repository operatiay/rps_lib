package model.rps;

import model.abstrct.ARound;

public class RPSRound extends ARound<RPSChoice>{

	public RPSRound(int size) {
		super(size);
	}

	public RPSRound(RPSChoice... choices) {
		super(choices);
	}
	
	

}
