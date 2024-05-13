package Representation;

public abstract class ANodeInner extends ANode {

	public ANodeInner(int id, String desc) {
		super(id, desc);
		// TODO Auto-generated constructor stub
	}
	
	public abstract ANode chooseNext(); //renvoie le noeud suivant

}
