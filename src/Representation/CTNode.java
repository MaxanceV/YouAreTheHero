package Representation;

import java.util.HashMap;

public class CTNode {
	
	private static HashMap<ANode, ANode[]> graphOfGame = new HashMap<>();
	
	public static HashMap<ANode, ANode[]> getGraphOfGame() {
		return graphOfGame;
	}

	public CTNode() {
		ANode start = new TNodeDecision(0, null);
		ANode milieu = new TNodeDecision(1,null);
		ANode fin = new TNodeDecision(2,null);
		
		graphOfGame.put(start, new ANode[] {milieu, fin});
		
		
		
		
	}
}
