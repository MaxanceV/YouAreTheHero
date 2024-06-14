package Representation.node;

import javax.swing.JFrame;

import Univers.TPlayer;

public final class TNodeChance extends ANodeInner {
	
	public TNodeChance(String id, String desc, String descchoix, String image, String son) {
		super(id, desc, descchoix, image, son);
	}

	@Override
	public void launchNode(TPlayer joueur, JFrame frame) {
		// Afficher la description puis passer au tirage aléatoire : 
		System.out.println(this.getDescription());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		this.chooseNext();
	}

	@Override
	public ENodeType getNodeType() {
		return ENodeType.CHANCE;
	}

}
