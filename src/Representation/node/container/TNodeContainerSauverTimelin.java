package Representation.node.container;

import Representation.node.ANode;
import Representation.node.ANodeInner;
import Representation.node.TNodeDecision;

public class TNodeContainerSauverTimelin extends ANodeContainer {
	
	private final String START_OF_GAME = "start.of.game";
	private final String MIDLE_OF_GAME = "midle.of.game";
	private final String END_OF_GAME = "end.of.game";

	public TNodeContainerSauverTimelin() {
		ANodeInner start = addNodeDecision(START_OF_GAME, "Début de l'aventure !", null);
		ANodeInner milieu = addNodeDecision(MIDLE_OF_GAME,"Milieu de l'aventure","Aller au milieu de l'aventure");
		ANodeInner fin = addNodeDecision(END_OF_GAME,null,"Aller à la fin de l'aventure");
		
		start.setChoix(new ANode[]{milieu,fin});
		milieu.setChoix(new ANode[] {fin});
		start.startNode();
	}
		
}

