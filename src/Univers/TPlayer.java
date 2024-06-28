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

	@Override
	public boolean equals(Object obj) {
	    if (!super.equals(obj)) {
	        return false;  // vérifie d'abord l'égalité de la classe parente
	    }
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    TPlayer other = (TPlayer) obj;
	    return currentNode == null ? other.currentNode == null : currentNode.equals(other.currentNode);
	}
	
	@Override
	public String toString() {
	    return "TPlayer{" +
	           "currentNode='" + currentNode + '\'' +
	           ", " + super.toString().substring(super.toString().indexOf("{") + 1);
	}
	
}
