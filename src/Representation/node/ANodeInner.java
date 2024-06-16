package Representation.node;

public abstract class ANodeInner extends ANode {
	// Dispose d'une liste des ID des prochains noeuds. Les enfants d'InnerNode, decision et chance iront chercher
	// la description des choix dans le tableau des Nodes pour les proposer au joueur. 
	private ANode[] choix;
	
	public ANode[] getChoix() {
		return choix;
	}

	public void setChoix(ANode[] choix) {
		this.choix = choix;
	}

	public ANodeInner(String id, String desc, String descchoix) {
		super(id, desc, descchoix);
	}
}