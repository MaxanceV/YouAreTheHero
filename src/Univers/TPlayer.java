package Univers;

import Representation.node.ANode;
import Univers.classe.IClasse;
import Univers.race.ERace;

public class TPlayer extends TPersonnage {
	
	private ANode currentNode;
	private final String test = "test";

	public TPlayer(String nom, IClasse classe, ERace race) {
		super(nom, classe, race);
		this.setCurrentNode(null);
	}
	
	public TPlayer(String nom, IClasse classe, ERace race, ANode node) {
		super(nom, classe, race);
		this.setCurrentNode(node);
	}

	public ANode getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(ANode currentNode) {
		this.currentNode = currentNode;
	}

	

}
