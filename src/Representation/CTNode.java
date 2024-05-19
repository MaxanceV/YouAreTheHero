package Representation;

public class CTNode {

	public CTNode() {
		ANodeInner start = new TNodeDecision(0, "Début de l'aventure !", null);
		ANodeInner milieu = new TNodeDecision(1,"Milieu de l'aventure","Aller au milieu de l'aventure");
		ANodeInner fin = new TNodeDecision(2,null,"Aller à la fin de l'aventure");
		
		start.setChoix(new ANode[]{milieu,fin});
		milieu.setChoix(new ANode[] {fin});
		start.startNode();
	}
		
	}
}
