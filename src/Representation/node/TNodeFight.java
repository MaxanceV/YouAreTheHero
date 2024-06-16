package Representation.node;

import javax.swing.JFrame;

import Univers.TPersonnage;
import Univers.TPlayer;

public final class TNodeFight extends ANodeInner {
	private TPersonnage ennemi;

	public TNodeFight(String id, String desc, String descchoix,TPersonnage ennemi) {
		super(id, desc, descchoix);
		this.ennemi = ennemi;
	}

	@Override
	public void setChoix(ANode[] choix) {
		if(choix.length == 1)super.setChoix(choix);
		else {System.out.println("Un seul choix pour les nodes de combat");}
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.FIGHT;
	}
}
