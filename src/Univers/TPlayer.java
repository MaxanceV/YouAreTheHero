package Univers;

import Univers.Enum.ERace;
import Univers.classe.IClasse;

public class TPlayer extends TPersonnage {
	private static final long serialVersionUID = 1L;
	private String currentNode;

	public TPlayer(String nom, IClasse classe, ERace race) {
		super(nom, classe, race);
		this.setCurrentNode(null);
	}
	
	public TPlayer(String nom, IClasse classe, ERace race, String node) {
		super(nom, classe, race);
		this.setCurrentNode(node);
	}

	public String getCurrentNode() {
		return currentNode;
	}

	public void setCurrentNode(String currentNode) {
		this.currentNode = currentNode;
	}

	

}
